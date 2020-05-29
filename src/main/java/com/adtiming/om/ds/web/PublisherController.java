// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmPublisher;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.service.AccountService;
import com.adtiming.om.ds.service.PublisherService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Publisher interface
 *
 * @author dianbo ruan
 */
@RestController
public class PublisherController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private PublisherService publisherService;

    @Resource
    private AccountService accountService;

    /**
     * Get current user's publisher
     */
    @RequestMapping(value = "/publisher/get", method = RequestMethod.GET)
    public Response getPublisher() {
        Integer publisherId = this.publisherService.getCurrentUser().getPublisherId();
        OmPublisher publisher = this.publisherService.getPublisher(publisherId);
        if (publisher == null) {
            log.error("Publisher id {} does not existed!", publisherId);
            return Response.RES_DATA_DOES_NOT_EXISTED;
        }
        return Response.buildSuccess(publisher);
    }

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

    @RequestMapping(value = "/publisher/account/select/list", method = RequestMethod.GET)
    public Response getSelectAccounts(Integer adnId) {
        List<ReportAdnetworkAccount> accounts = accountService.getAccounts(adnId);
        JSONArray results = new JSONArray();
        accounts.forEach(account -> {
            JSONObject result = new JSONObject();
            result.put("id", account.getId());
            result.put("name", account.getAdnAccountName());
            results.add(result);
        });
        return Response.buildSuccess(results);
    }

    @RequestMapping(value = "/publisher/account/list", method = RequestMethod.GET)
    public Response getAccounts(Integer adnId) {
        List<ReportAdnetworkAccount> accounts = accountService.getAccounts(adnId);
        return Response.buildSuccess(accounts);
    }

    /**
     * Create a new publisher account
     *
     * @see ReportAdnetworkAccount
     */
    @RequestMapping(value = "/publisher/account/create", method = RequestMethod.POST)
    public Response createAccount(@RequestBody ReportAdnetworkAccount account) {
        if (account.getAdnId() == null || account.getAdnAccountId() == null || account.getAuthType() == null) {
            log.warn("Adn id and account id can not be null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.accountService.createAccount(account);
    }

    /**
     * Update a new publisher account
     *
     * @see ReportAdnetworkAccount
     */
    @RequestMapping(value = "/publisher/account/update", method = RequestMethod.POST)
    public Response updateAccount(@RequestBody ReportAdnetworkAccount account) {
        if (account.getId() == null || account.getAdnId() == null || account.getAdnAccountId() == null) {
            log.warn("Id and Adn id and account id can not be null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.accountService.updateAccount(account);
    }

    /**
     * Update a new publisher account
     *
     * @see ReportAdnetworkAccount
     */
    @RequestMapping(value = "/publisher/account/delete", method = RequestMethod.GET)
    public Response updateAccount(Integer accountId) {
        if (accountId == null) {
            log.warn("Account id can not be null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.accountService.deleteAccount(accountId);
    }
}
