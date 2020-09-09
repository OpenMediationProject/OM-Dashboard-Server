// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmPublisherAppMapper;
import com.adtiming.om.ds.dao.OmPublisherMapper;
import com.adtiming.om.ds.dao.UmUserAppMapper;
import com.adtiming.om.ds.dao.UmUserRoleMapper;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.model.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Common info for services
 *
 * @author dianbo ruan
 */
public class BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    protected OmPublisherAppMapper omPublisherAppMapper;

    @Autowired
    protected CacheService cacheService;

    @Resource
    protected UmUserAppMapper umUserAppMapper;

    @Resource
    protected OmPublisherMapper omPublisherMapper;

    @Resource
    protected UmUserRoleMapper umUserRoleMapper;

    public UmUser getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        UmUser currentUser = null;
        if (subject.getPrincipal() != null) {
            currentUser = (UmUser) subject.getPrincipals().getPrimaryPrincipal();
        }
        log.info("Current user {} publisher id {} role id {}", currentUser.getId(), currentUser.getPublisherId(), currentUser.getRoleId());
        return currentUser;
    }

    public Integer getCurrentPublisherId() {
        return this.getCurrentUser().getPublisherId();
    }

    public List<Integer> getAppIdsOfCurrentUser() {
        UmUser umUser = this.getCurrentUser();
        List<Integer> publisherAppIds = new ArrayList<>();
        if (umUser.getRoleId() == RoleType.ADMINISTRATOR.getId() || umUser.getRoleId() == RoleType.ORGANIZATION_OWNER.getId()) {
            List<Integer> userPublisherIds = new ArrayList<>();
            userPublisherIds.add(umUser.getPublisherId());
            publisherAppIds = this.getPublisherAppIds(userPublisherIds, NormalStatus.Active);
        } else {
            List<UmUserApp> umUserApps = this.getUserApps(umUser.getId(), null);
            if (!CollectionUtils.isEmpty(umUserApps)) {
                for (UmUserApp umUserApp : umUserApps) {
                    publisherAppIds.add(umUserApp.getPubAppId());
                }
            }
        }
        if (CollectionUtils.isEmpty(publisherAppIds)) {
            publisherAppIds.add(0);
        }
        return publisherAppIds;
    }

    /**
     * Get all user app relations
     *
     * @param userId
     * @param pubAppId
     */
    public List<UmUserApp> getUserApps(Integer userId, Integer pubAppId) {
        UmUserAppCriteria umUserAppCriteria = new UmUserAppCriteria();
        UmUserAppCriteria.Criteria criteria = umUserAppCriteria.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        umUserAppCriteria.setOrderByClause(" create_time desc ");
        return this.umUserAppMapper.select(umUserAppCriteria);
    }

    /**
     * Get all user roles
     *
     * @param userId
     */
    public List<UmUserRole> getUserRoles(Integer userId) {
        return this.getUserRoles(userId, null);
    }

    /**
     * Get user roles
     *
     * @param userId
     * @param pubId
     */
    public List<UmUserRole> getUserRoles(Integer userId, Integer pubId) {
        UmUserRoleCriteria umUserAppCriteria = new UmUserRoleCriteria();
        UmUserRoleCriteria.Criteria criteria = umUserAppCriteria.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (pubId != null) {
            criteria.andPubIdEqualTo(pubId);
        }
        return this.umUserRoleMapper.select(umUserAppCriteria);
    }

    public Set<Integer> getPublisherOwnerIds() {
        Set<Integer> publisherCreatorIds = new HashSet<>();
        List<OmPublisher> publishers = this.omPublisherMapper.select(new OmPublisherCriteria());
        publishers.forEach(publisher -> {
            publisherCreatorIds.add(publisher.getOwnerUserId());
        });
        return publisherCreatorIds;
    }

    /**
     * Select publisher apps
     *
     * @param publisherIds
     * @param status
     */
    public List<OmPublisherApp> getPublisherApps(List<Integer> publisherIds, NormalStatus status) {
        OmPublisherAppCriteria omPublisherAppCriteria = new OmPublisherAppCriteria();
        OmPublisherAppCriteria.Criteria criteria = omPublisherAppCriteria.createCriteria();
        if (publisherIds != null && publisherIds.size() > 0) {
            criteria.andPublisherIdIn(publisherIds);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        return omPublisherAppMapper.select(omPublisherAppCriteria);
    }

    /**
     * Select publisher app ids
     *
     * @param publisherIds
     * @param status
     */
    public List<Integer> getPublisherAppIds(List<Integer> publisherIds, NormalStatus status) {
        List<Integer> publisherAppIds = new ArrayList<>();
        List<OmPublisherApp> omPublisherApps = this.getPublisherApps(publisherIds, status);
        omPublisherApps.forEach(omPublisherApp -> {
            publisherAppIds.add(omPublisherApp.getId());
        });
        return publisherAppIds;
    }
}
