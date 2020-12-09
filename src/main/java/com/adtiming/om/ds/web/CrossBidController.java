// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.CrossBidService;
import com.adtiming.om.ds.service.ReportService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ruandianbo
 * @date 20-9-24
 */
@RestController
public class CrossBidController extends BaseController {

    private static final Logger log = LogManager.getLogger();

    @Resource
    ReportService reportService;

    @Resource
    CrossBidService crossBidService;

    @RequestMapping(value = "/cross/bid/get_select_apps", method = RequestMethod.GET)
    public Response getPromoteSelectApps() {
        try {
            return Response.buildSuccess(crossBidService.getPromoteSelectApps());
        } catch (Exception e) {
            log.error("Get promote select apps error:", e);
            return Response.build(Response.CODE_RES_FAILED, Response.STATUS_DISABLE, e.getMessage());
        }
    }

    @RequestMapping(value = "/cross/bid/get_campaign", method = RequestMethod.GET)
    public Response getCampaign(Integer campaignId) {
        try {
            if (campaignId == null || campaignId <= 0) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Campaign id is not valid!");
            }
            return Response.buildSuccess(crossBidService.getCampaign(campaignId));
        } catch (Exception e) {
            log.error("Get campaign error:", e);
            return Response.build(Response.CODE_RES_FAILED, Response.STATUS_DISABLE, e.getMessage());
        }
    }

    @RequestMapping(value = "/cross/bid/get_campaigns", method = RequestMethod.GET)
    public Response getCampaigns() {
        try {
            List<JSONObject> results = new ArrayList<>();
            Map<Integer, StatCp> crossBidCampaignReportMap = this.getCrossBidCampaignReportMap();
            List<CpCampaign> cpCampaigns = this.crossBidService.getCampaigns();
            for (CpCampaign cpCampaign : cpCampaigns){
                JSONObject result = (JSONObject) JSONObject.toJSON(cpCampaign);
                StatCp statCp = crossBidCampaignReportMap.get(cpCampaign.getId());
                if (statCp != null){
                    result.put("click", statCp.getClick());
                    result.put("impression", statCp.getImpr());
                    result.put("imprCost", statCp.getWinPrice());
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get campaigns error:", e);
        }
        return Response.RES_FAILED;
    }

    private Map<Integer, StatCp> getCrossBidCampaignReportMap(){
        try {
            Map<Integer, StatCp> resultMap = new HashMap<>();
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            Date dateBegin = DateUtils.addDays(new Date(), -8);
            Date dateEnd = DateUtils.addDays(dateBegin, 7);
            reportConditionDTO.setDimension(new String[]{"campaignId"});
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(dateBegin));
            reportConditionDTO.setDateEnd(Util.getYYYYMMDD(dateEnd));
            List<StatCp> statCpList = reportService.getCrossBidReport(reportConditionDTO);
            statCpList.forEach(statCp -> resultMap.put(statCp.getCampaignId(), statCp));
            return resultMap;
        } catch (Exception e){
            log.error("Get cross bid campaign report map failed!", e);
        }
        return new HashMap<>();
    }

    @RequestMapping(value = "/cross/bid/create_campaign", method = RequestMethod.POST)
    public Response createCampaign(@RequestBody CpCampaign campaign) {
        try {
            if (StringUtils.isEmpty(campaign.getAppId())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "App id is null!");
            }
            if (StringUtils.isEmpty(campaign.getName())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "App name is null!");
            }
            this.crossBidService.createCampaign(campaign);
            return Response.build();
        } catch (Exception e) {
            log.error("Create campaign {} error:", JSONObject.toJSONString(campaign), e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/update_campaign", method = RequestMethod.POST)
    public Response updateCampaign(@RequestBody CpCampaign campaign) {
        try {
            if (campaign.getId() == null) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Id is null!");
            }
            this.crossBidService.updateCampaign(campaign);
            return Response.build();
        } catch (Exception e) {
            log.error("Update campaign {} error:", JSONObject.toJSONString(campaign), e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/update_campaign_status", method = RequestMethod.GET)
    public Response updateCampaignStatus(Integer campaignId, Integer status) {
        try {
            if (campaignId == null) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Id is null!");
            }
            if (status == null || status < 0 || status > NormalStatus.Deleted.ordinal()) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Status is novalid!");
            }
            this.crossBidService.updateCampaignStatus(campaignId, NormalStatus.getStatus(status));
            return Response.build();
        } catch (Exception e) {
            log.error("Update campaign {} status {} error:", campaignId, status, e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/get_creative", method = RequestMethod.GET)
    public Response getCreative(Integer creativeId) {
        try {
            return Response.buildSuccess(crossBidService.getCreative(creativeId));
        } catch (Exception e) {
            log.error("Get creative error:", e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/get_creatives", method = RequestMethod.GET)
    public Response getCreatives() {
        try {
            return Response.buildSuccess(crossBidService.getCreatives());
        } catch (Exception e) {
            log.error("Get creatives error:", e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/create_creative", method = RequestMethod.POST)
    public Response createCreative(@RequestBody CpCreative creative) {
        try {
            if (StringUtils.isEmpty(creative.getCampaignId())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Campaign id is null!");
            }
            if (StringUtils.isEmpty(creative.getName())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Creative name is null!");
            }
            this.crossBidService.createCreative(creative);
            return Response.build();
        } catch (Exception e) {
            log.error("Create creative {} error:", JSONObject.toJSONString(creative), e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/get_material", method = RequestMethod.GET)
    public Response getMaterial(Integer materialId) {
        try {
            return Response.buildSuccess(crossBidService.getMaterial(materialId));
        } catch (Exception e) {
            log.error("Get material error:", e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/get_materials", method = RequestMethod.GET)
    public Response getMaterials(String appId) {
        try {
            return Response.buildSuccess(crossBidService.getMaterials(appId));
        } catch (Exception e) {
            log.error("Get materials error:", e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/create_material", method = RequestMethod.POST)
    public Response createMaterial(@RequestBody CpMaterial material) {
        try {
            if (StringUtils.isEmpty(material.getName())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Material name is null!");
            }
            if (StringUtils.isEmpty(material.getAppId())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "App id is null!");
            }
            if (StringUtils.isEmpty(material.getUrl())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Url is null!");
            }
            if (StringUtils.isEmpty(material.getMd5sum())) {
                return Response.failure(Response.CODE_PARAMETER_INVALID, "Md5sum is null!");
            }
            return Response.buildSuccess(this.crossBidService.createMaterial(material));
        } catch (Exception e) {
            log.error("Create material {} error:", JSONObject.toJSONString(material), e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping(value = "/cross/bid/get_templates", method = RequestMethod.GET)
    public Response getCpTemplateList() {
        try {
            return Response.buildSuccess(crossBidService.getCpTemplateList());
        } catch (Exception e) {
            log.error("Get template list error:", e);
        }
        return Response.RES_FAILED;
    }

    @RequestMapping("/cross/bid/file_upload")
    @ResponseBody
    public Response doUpload(Part file) {
        try {
            if (file == null) {
                return Response.build(Response.CODE_PARAMETER_INVALID, Response.STATUS_DISABLE, "Upload file is null");
            }
            Matcher m = Pattern.compile("^(image|video)/(.+)").matcher(file.getContentType());
            if (!m.find()) {
                return Response.build(Response.CODE_PARAMETER_INVALID, Response.STATUS_DISABLE, "Not support file format");
            }
            String md5File = null;
            try (InputStream in = file.getInputStream()) {
                byte[] buf = new byte[(int) file.getSize()];
                IOUtils.readFully(in, buf);
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                BigInteger bi = new BigInteger(1, md5.digest(buf));
                md5File = org.apache.commons.lang.StringUtils.leftPad(bi.toString(16), 32, '0');
            } catch (NoSuchAlgorithmException e) {
                log.error("Build md5 error:", e);
            }

            if (StringUtils.isEmpty(md5File)) {
                return Response.failure(Response.CODE_DATA_INCOMPLETE, "Build md5 error");
            }

            String path;
            List<OmUpload> uploadList = this.crossBidService.getUploads(md5File);
            long fileSize = 0L;
            if (uploadList.isEmpty()) {
                LocalDate date = LocalDate.now(ZoneId.of("UTC+8"));
                String ymd = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date);
                path = String.format("cp/%s/%s.%s", ymd, md5File, m.group(2));
                File dst = new File("cp_upload", path);
                File dst_dir = dst.getParentFile();
                FileUtils.forceMkdir(dst_dir);
                FileUtils.copyInputStreamToFile(file.getInputStream(), dst);
                fileSize = file.getSize();
                OmUpload upload = new OmUpload();
                upload.setMd5File(md5File);
                upload.setPath(path);
                this.crossBidService.addUpload(upload);
            } else {
                path = uploadList.get(0).getPath();
            }
            file.delete();
            JSONObject result = new JSONObject();
            result.put("path", "/upload/" + path);
            result.put("md5sum", md5File);
            result.put("size", fileSize);
            return Response.buildSuccess(result);
        } catch (Exception e) {
            log.error("Upload file error:", e);
        }
        return Response.RES_FAILED;
    }
}
