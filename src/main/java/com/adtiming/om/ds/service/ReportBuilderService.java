// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmReportBuilderMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmReportBuilderCriteria;
import com.adtiming.om.ds.model.OmReportBuilderWithBLOBs;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Report builder manager
 *
 * @author dianbo ruan
 */
@Service
public class ReportBuilderService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private OmReportBuilderMapper omReportBuilderMapper;

    public List<OmReportBuilderWithBLOBs> getReportBuilders(Integer publisherId) {
        OmReportBuilderCriteria reportBuilderCriteria = new OmReportBuilderCriteria();
        OmReportBuilderCriteria.Criteria criteria = reportBuilderCriteria.createCriteria();
        if (publisherId != null) {
            criteria.andPublisherIdEqualTo(publisherId);
        }
        criteria.andPublisherIdIn(this.getPublisherIdsOfCurrentUser());
        return this.omReportBuilderMapper.selectWithBLOBs(reportBuilderCriteria);
    }

    public Response createReportBuilder(OmReportBuilderWithBLOBs reportBuilder) {
        try {
            reportBuilder.setLastmodify(new Date());
            reportBuilder.setCreateTime(new Date());
            if (reportBuilder.getPublisherId() == null) {
                reportBuilder.setPublisherId(this.getCurrentUser().getPublisherId());
            }
            if (reportBuilder.getCreatorId() == null) {
                reportBuilder.setCreatorId(this.getCurrentUser().getId());
            }
            int result = this.omReportBuilderMapper.insertSelective(reportBuilder);
            if (result > 0) {
                log.info("Create report builder {} successfully.", JSONObject.toJSONString(reportBuilder));
                return Response.buildSuccess(reportBuilder);
            } else {
                throw new RuntimeException("Create report builder failed " + JSONObject.toJSONString(reportBuilder));
            }
        } catch (Exception e) {
            log.error("Create report builder {} error:", JSONObject.toJSONString(reportBuilder), e);
        }
        return Response.RES_FAILED;
    }

    public Response updateReportBuilder(OmReportBuilderWithBLOBs reportBuilder) {
        try {
            reportBuilder.setLastmodify(new Date());
            int result = this.omReportBuilderMapper.updateByPrimaryKeySelective(reportBuilder);
            if (result > 0) {
                log.info("Update report builder {} successfully.", JSONObject.toJSONString(reportBuilder));
                return Response.buildSuccess(reportBuilder);
            } else {
                throw new RuntimeException("Update report builder failed " + JSONObject.toJSONString(reportBuilder));
            }
        } catch (Exception e) {
            log.error("Update report builder {} error:", JSONObject.toJSONString(reportBuilder), e);
        }
        return Response.RES_FAILED;
    }

    public Response updateReportBuilderStatus(Integer id, SwitchStatus status) {
        try {
            OmReportBuilderWithBLOBs omReportBuilder = this.omReportBuilderMapper.selectByPrimaryKey(id);
            if (omReportBuilder == null) {
                throw new RuntimeException("Report builder id does not existed!" + id);
            }
            omReportBuilder.setStatus(status.ordinal());
            omReportBuilder.setLastmodify(new Date());
            int result = this.omReportBuilderMapper.updateByPrimaryKeySelective(omReportBuilder);
            if (result > 0) {
                log.info("Update report builder {} status successfully.", id, status);
                return Response.buildSuccess(id);
            } else {
                throw new RuntimeException("Delete report builder id " + id + "status " + status + " failed");
            }
        } catch (Exception e) {
            log.error("Delete report builder {} status {} error:", id, status, e);
        }
        return Response.RES_FAILED;
    }

    public Response deleteReportBuilder(Integer id) {
        try {
            int result = this.omReportBuilderMapper.deleteByPrimaryKey(id);
            if (result > 0) {
                log.info("Delete report builder {} successfully.", id);
                return Response.buildSuccess(id);
            } else {
                throw new RuntimeException("Delete report builder failed " + id);
            }
        } catch (Exception e) {
            log.error("Delete report builder {} error:", id, e);
        }
        return Response.RES_FAILED;
    }
}
