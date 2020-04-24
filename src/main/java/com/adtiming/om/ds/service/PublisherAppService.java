// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.PublisherAppDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmPublisherApp;
import com.adtiming.om.ds.model.OmPublisherAppCriteria;
import com.adtiming.om.ds.model.UmUserApp;
import com.adtiming.om.ds.util.HttpConnMgr;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Publisher Manager
 *
 * @author dianbo ruan
 */
@Service
public class PublisherAppService extends BaseService {

    private static final String APP_UPDATE_URL = "http://adtimingapi.com/om/app?id=%s";

    @Autowired
    private PlacementService placementService;

    /**
     * Update publisher app's info from app store every day
     */
    @Scheduled(cron = "0 30 4 * * *")
    public void updatePublisherAppInfo() {
        List<OmPublisherApp> omPublisherApps = this.getPublisherApps(null, NormalStatus.ACTIVE);
        for (OmPublisherApp omPublisherApp : omPublisherApps) {
            try {
                boolean result = this.updatePublisherAppInfo(omPublisherApp);
                if (result) {
                    this.omPublisherAppMapper.updateByPrimaryKeySelective(omPublisherApp);
                }
            } catch (Exception e) {
                log.error("Update publisher app info {} error:", JSONObject.toJSON(omPublisherApp));
            }
        }
    }

    /**
     * Select all publisher apps
     *
     * @return publisherApps
     */
    public List<OmPublisherApp> getPublisherApps() {
        return this.getPublisherApps(null, null, null);
    }

    /**
     * Select publisher apps
     *
     * @param pubAppIds
     * @return publisherApps
     */
    public List<OmPublisherApp> getPublisherApps(List<Integer> pubAppIds) {
        return this.getPublisherApps(pubAppIds, null, null);
    }

    /**
     * Select publisher app map
     *
     * @param pubAppIds
     * @return publisherApps
     */
    public Map<Integer, OmPublisherApp> getPublisherAppMap(List<Integer> pubAppIds) {
        List<OmPublisherApp> publisherApps = this.getPublisherApps(pubAppIds, null, null);
        Map<Integer, OmPublisherApp> publisherAppMap = new HashMap<>();
        publisherApps.forEach(publisherApp -> {
            publisherAppMap.put(publisherApp.getId(), publisherApp);
        });
        return publisherAppMap;
    }

    /**
     * Select all publisher apps from database which related to current user
     *
     * @param pubAppIds
     * @param status
     * @return publisherApps
     */
    public List<OmPublisherApp> getPublisherApps(List<Integer> pubAppIds, NormalStatus status, List<Integer> userPublisherIds) {
        OmPublisherAppCriteria omPublisherAppCriteria = new OmPublisherAppCriteria();
        OmPublisherAppCriteria.Criteria criteria = omPublisherAppCriteria.createCriteria();
        if (!CollectionUtils.isEmpty(pubAppIds)) {
            criteria.andIdIn(pubAppIds);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        if (!CollectionUtils.isEmpty(userPublisherIds)) {
            criteria.andPublisherIdIn(userPublisherIds);
        }
        criteria.andIdIn(this.getAppIdsOfCurrentUser());
        criteria.andPublisherIdIn(this.getPublisherIdsOfCurrentUser());
        omPublisherAppCriteria.setOrderByClause(" id desc ");
        List<OmPublisherApp> publisherApps = this.omPublisherAppMapper.select(omPublisherAppCriteria);
        log.info("Get publisher apps size: {}", publisherApps.size());
        return publisherApps;
    }

    /**
     * Select all publisher apps from database which related to current user
     *
     * @return publisherApps
     */
    public List<OmPublisherApp> getPublisherAppsSortByRevenue(NormalStatus status) {
        List<OmPublisherApp> publisherApps = this.getPublisherApps(null, status, null);
        this.sortPublisherAppByRevenue(publisherApps);
        return publisherApps;
    }

    /**
     * Sort publisher app by revenue
     *
     * @param publisherApps
     */
    private void sortPublisherAppByRevenue(List<OmPublisherApp> publisherApps) {
        try {
            if (CollectionUtils.isEmpty(publisherApps)) {
                return;
            }
            Map<Integer, Double> publisherAppRevenueMap = this.cacheService.getPublisherAppRevenueMap();
            if (CollectionUtils.isEmpty(publisherAppRevenueMap)) {
                return;
            }
            publisherApps.sort((publisherApp1, publisherApp2) -> {
                Double revenue1 = publisherAppRevenueMap.get(publisherApp1.getId());
                if (revenue1 == null) {
                    revenue1 = 0D;
                }
                Double revenue2 = publisherAppRevenueMap.get(publisherApp2.getId());
                if (revenue2 == null) {
                    revenue2 = 0D;
                }
                return (int) (revenue2 - revenue1);
            });
        } catch (Exception e) {
            log.error("Sort placement by revenue error:", e);
        }
    }

    /**
     * Build publisher app's database object @see OmPublisherApp, and insert into database
     *
     * @param omPublisherApp
     */
    @Transactional
    public Response createPublisherApp(OmPublisherApp omPublisherApp) {
        try {
            omPublisherApp.setAppKey(Util.buildAppKey());
            if (omPublisherApp.getPublisherId() == null || omPublisherApp.getPublisherId() <= 0) {
                Integer publisherId = this.getCurrentUser().getPublisherId();
                if (publisherId == null) {
                    throw new RuntimeException("There is no publisher with current user" + JSONObject.toJSON(this.getCurrentUser()));
                }
                omPublisherApp.setPublisherId(publisherId);
            }
            omPublisherApp.setStatus((byte) NormalStatus.ACTIVE.ordinal());
            omPublisherApp.setCreateTime(new Date());
            omPublisherApp.setLastmodify(new Date());
            int id = this.omPublisherAppMapper.insertSelective(omPublisherApp);
            if (id > 0) {
                log.info("create publisher app {} successfully", JSONObject.toJSONString(omPublisherApp));
                UmUserApp userApp = new UmUserApp();
                userApp.setUserId(this.getCurrentUser().getId());
                userApp.setPubAppId(omPublisherApp.getId());
                int result = this.umUserAppMapper.insertSelective(userApp);
                if (result > 0) {
                    log.info("Create user app {} success", JSONObject.toJSONString(userApp));
                    this.placementService.createDefaultPlacement(omPublisherApp);
                    return Response.buildSuccess(omPublisherApp);
                } else {
                    throw new RuntimeException("Create user app failed" + JSONObject.toJSONString(userApp));
                }
            } else {
                throw new RuntimeException("update publisher app failed" + JSONObject.toJSONString(omPublisherApp));
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("create publisher app error {} ", JSONObject.toJSONString(omPublisherApp), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Update publisher app's info
     *
     * @param publisherAppDTO
     */
    public Response updatePublisherApp(PublisherAppDTO publisherAppDTO) {
        try {
            OmPublisherApp omPublisherApp = this.omPublisherAppMapper.selectByPrimaryKey(publisherAppDTO.getId());
            if (omPublisherApp == null) {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            omPublisherApp.setAppId(publisherAppDTO.getAppId());
            omPublisherApp.setAppName(publisherAppDTO.getAppName());
            if (publisherAppDTO.getStatus() != null) {
                omPublisherApp.setStatus(publisherAppDTO.getStatus());
            }
            if (publisherAppDTO.getDebugStatus() != null) {
                omPublisherApp.setDebugStatus(publisherAppDTO.getDebugStatus());
            }
            omPublisherApp.setLastmodify(new Date());
            int result = this.omPublisherAppMapper.updateByPrimaryKeySelective(omPublisherApp);
            if (result == 1) {
                log.info("update publisher app {} successfully", JSONObject.toJSONString(publisherAppDTO));
                return Response.build();
            }
        } catch (Exception e) {
            log.error("updatePublisherApp error {}", JSONObject.toJSONString(publisherAppDTO), e);
        }
        log.info("update publisher app {} failed", JSONObject.toJSONString(publisherAppDTO));
        return Response.RES_FAILED;
    }

    /**
     * Update publisher app's info from app store
     *
     * @param omPublisherApp
     */
    public boolean updatePublisherAppInfo(OmPublisherApp omPublisherApp) {
        try {
            String updateUrl = String.format(APP_UPDATE_URL, omPublisherApp.getAppId());
            HttpGet httpGet = new HttpGet(updateUrl);
            HttpResponse response = HttpConnMgr.getHttpClient().execute(httpGet);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                log.error(updateUrl + " execute get code {}", response.getStatusLine());
                return false;
            }
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject resultJson = JSONObject.parseObject(result);
            if (resultJson.containsKey("code") && resultJson.getIntValue("code") == 0) {
                JSONObject appInfoJson = resultJson.getJSONObject("data");
                if (appInfoJson.containsKey("plat")) {
                    omPublisherApp.setPlat(appInfoJson.getByte("plat"));
                }
                if (appInfoJson.containsKey("name")) {
                    omPublisherApp.setAppName(appInfoJson.getString("name"));
                }
                if (appInfoJson.containsKey("icon")) {
                    omPublisherApp.setIcon(appInfoJson.getString("icon"));
                }
                if (appInfoJson.containsKey("category")) {
                    omPublisherApp.setCategory(appInfoJson.getString("category"));
                }
                if (appInfoJson.containsKey("category_id")) {
                    omPublisherApp.setCategoryId(appInfoJson.getInteger("category_id"));
                }
                if (appInfoJson.containsKey("subcategory_id")) {
                    omPublisherApp.setSubCategoryId(appInfoJson.getInteger("subcategory_id"));
                }
                if (appInfoJson.containsKey("preview_url")) {
                    omPublisherApp.setPreviewUrl(appInfoJson.getString("preview_url"));
                }
                if (appInfoJson.containsKey("developer")) {
                    omPublisherApp.setDeveloper(appInfoJson.getString("developer"));
                }
                if (appInfoJson.containsKey("os_require")) {
                    omPublisherApp.setOsRequire(appInfoJson.getString("os_require"));
                }
                if (appInfoJson.containsKey("country")) {
                    omPublisherApp.setCountry(appInfoJson.getString("country"));
                }
                if (appInfoJson.containsKey("available_countries")) {
                    omPublisherApp.setAvailableCountries(appInfoJson.getString("available_countries"));
                }
                if (appInfoJson.containsKey("descn")) {
                    String description = appInfoJson.getString("descn");
                    if (description.length() < 1999) {
                        omPublisherApp.setDescn(appInfoJson.getString("descn"));
                    } else {
                        omPublisherApp.setDescn(appInfoJson.getString("descn").substring(0, 1999));
                    }
                }
                return true;
            } else {
                log.info("Update app {} failed url {}", result, updateUrl);
            }
        } catch (Exception e) {
            log.error("Update publisher app {} error:", JSONObject.toJSONString(omPublisherApp), e);
        }
        return false;
    }
}

