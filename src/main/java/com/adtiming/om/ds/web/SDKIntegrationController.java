// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.DevAppTestResult;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmDevApp;
import com.adtiming.om.ds.model.OmDevDevice;
import com.adtiming.om.ds.service.SDKIntegrationService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * SDK integration interface
 *
 * @author dianbo ruan
 */
@RestController
public class SDKIntegrationController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private SDKIntegrationService sdkIntegrationService;

    /**
     * Create develop app when not existed,
     *
     * @param pubAppId
     * @see OmDevApp
     */
    @RequestMapping(value = "/sdk/dev_app/get", method = RequestMethod.GET)
    public Response getDevApp(Integer pubAppId) {
        return this.sdkIntegrationService.getDevApp(pubAppId);
    }

    /**
     * Get adnetwork in use
     */
    @RequestMapping(value = "/sdk/adnetworks", method = RequestMethod.GET)
    public Response getAdNetworks(Integer pubAppId) {
        if (pubAppId == null || pubAppId <= 0) {
            log.error("Get test adnetwoks parameter pubAppId must not null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.getAdNetWorks(pubAppId);
    }

    /**
     * Get placements by adnId and pubAppId
     *
     * @param adnId
     * @param pubAppId
     */
    @RequestMapping(value = "/sdk/adnetwork/placements", method = RequestMethod.GET)
    public Response getAdNetworkPlacements(Integer adnId, Integer pubAppId) {
        if (pubAppId == null || pubAppId <= 0 || adnId == null || adnId <= 0) {
            log.error("Get test adnetwoks' placement parameter pubAppId or adnId must not null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.getAdNetworkPlacements(adnId, pubAppId);
    }

    /**
     * Update develop app's test result
     *
     * @param devAppId
     * @param devResult
     */
    @RequestMapping(value = "/sdk/dev_app/dev_result/update", method = RequestMethod.GET)
    public Response updateDevAppTestResult(Integer devAppId, Integer devResult) {
        DevAppTestResult testResult = DevAppTestResult.getDevAppTestResult(devResult);
        if (devAppId == null || devAppId <= 0 || (!DevAppTestResult.Success.equals(testResult)
                && !DevAppTestResult.Fail.equals(testResult))) {
            log.error("Update develop app {} test result {}, parameter error!", devAppId, devResult);
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.updateDevResult(devAppId, testResult);
    }

    /**
     * Create develop app when not existed,
     *
     * @param omDevApp
     * @see OmDevApp
     */
    @RequestMapping(value = "/sdk/dev_app/create", method = RequestMethod.POST)
    public Response createDevApp(@RequestBody OmDevApp omDevApp) {
        if (omDevApp.getAdnId() == null || omDevApp.getAdnId() <= 0
                || omDevApp.getPubAppId() == null || omDevApp.getPubAppId() <= 0) {
            log.error("Create DevApp parameter pubAppId must not null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.createDevApp(omDevApp);
    }

    /**
     * Get develop devices
     *
     * @param publisherId
     * @param status
     */
    @RequestMapping(value = "/sdk/devices", method = RequestMethod.GET)
    public Response getDevDevices(Integer publisherId, Byte status) {
        try {
            List<OmDevDevice> devDevices = sdkIntegrationService.getDevDevices(publisherId, status);
            return Response.buildSuccess(devDevices);
        } catch (Exception e) {
            log.error("Get develop devices error", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create develop device
     *
     * @param devDevice
     * @see OmDevDevice
     */
    @RequestMapping(value = "/sdk/device/create", method = RequestMethod.POST)
    public Response createDevDevice(@RequestBody OmDevDevice devDevice) {
        if (StringUtils.isBlank(devDevice.getDeviceId()) || StringUtils.isBlank(devDevice.getDeviceName())) {
            log.error("Create develop device parameter error {}", JSONObject.toJSONString(devDevice));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.createDevDevice(devDevice);
    }

    /**
     * Get develop devices
     *
     * @param devDevice
     * @see OmDevDevice
     */
    @RequestMapping(value = "/sdk/device/update", method = RequestMethod.POST)
    public Response updateDevDevice(@RequestBody OmDevDevice devDevice) {
        if (devDevice.getId() == null || devDevice.getId() <= 0) {
            log.error("Update develop device id must not null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.updateDevDevice(devDevice);
    }

    /**
     * Get develop devices
     *
     * @param id
     */
    @RequestMapping(value = "/sdk/device/delete", method = RequestMethod.GET)
    public Response deleteDevDevice(Integer id) {
        if (id == null || id <= 0) {
            log.error("Update develop device id must not null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.sdkIntegrationService.deleteDevDevice(id);
    }
}
