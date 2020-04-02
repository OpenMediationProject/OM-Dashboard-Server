// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmPublisher;
import com.adtiming.om.ds.service.PublisherService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Publisher interface
 *
 * @author dianbo ruan
 */
@RestController
public class PublisherController extends BaseController {

    @Autowired
    private PublisherService publisherService;

    /**
     * Get all publishers
     */
    @RequestMapping(value = "/publisher/list", method = RequestMethod.GET)
    public Response getPublishers(Integer userId) {
        return this.publisherService.getPublishers(userId, null);
    }

    /**
     * Get all publisher by owner user id
     */
    @RequestMapping(value = "/publisher/select/list", method = RequestMethod.GET)
    public Response getPublisherSelectList(Integer userId) {
        return this.publisherService.getPublishers(userId, SwitchStatus.ON);
    }

    /**
     * Create a new publisher, related to current user
     *
     * @see OmPublisher
     */
    @RequestMapping(value = "/publisher/create", method = RequestMethod.POST)
    public Response createPublisher(@RequestBody OmPublisher omPublisher) {
        if (omPublisher.getName() == null || omPublisher.getEmail() == null || omPublisher.getPhone() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.publisherService.createPublisher(omPublisher);
    }

    /**
     * Update publisher information
     *
     * @see OmPublisher
     */
    @RequestMapping(value = "/publisher/update", method = RequestMethod.POST)
    public Response updatePublisher(@RequestBody OmPublisher omPublisher) {
        if (omPublisher.getId() == null || omPublisher.getId() == 0) {
            log.error("Update publisher {} id is not valid", JSONObject.toJSONString(omPublisher));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.publisherService.updatePublisher(omPublisher);
    }
}
