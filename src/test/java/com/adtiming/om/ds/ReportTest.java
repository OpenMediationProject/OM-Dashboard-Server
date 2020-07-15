package com.adtiming.om.ds;

import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.service.FieldNameService;
import com.adtiming.om.ds.service.ReportService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ruandianbo on 20-2-18.
 */
public class ReportTest extends BaseCommonTests {

    @Autowired
    ReportService reportService;

    @Autowired
    FieldNameService fieldNameService;

    @Test
    public void testGetDashboardHeadRevenues() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/report/dashboard/head/revenues")
                .param("pubAppId", "119"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetDashboardRegionRevenues() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/report/dashboard/regions/revenues")
                .param("pubAppId", "119"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetReportList() throws Exception {
        fieldNameService.initIdName();
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin("2020-02-20");
        reportConditionDTO.setDateEnd("2020-03-03");
        Integer[] publisherIds = new Integer[]{10, 1};
        reportConditionDTO.setPublisherId(publisherIds);
        String[] dimensions = new String[]{"day", "publisherId", "placementId", "instanceId", "pubAppId"};
        String[] types = new String[]{"dau","lr","api"};
        reportConditionDTO.setDimension(dimensions);
        reportConditionDTO.setType(types);
        this.doPost("/report/list", reportConditionDTO);
    }

    @Test
    public void testGetAdNetworkSummary() throws Exception {
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin("2020-02-17");
        reportConditionDTO.setDateEnd("2020-02-24");
        Integer[] publisherIds = new Integer[]{10};
        reportConditionDTO.setPublisherId(publisherIds);
        String[] dimensions = new String[]{"publisherId", "day"};
        reportConditionDTO.setDimension(dimensions);
        this.doPost("/report/adnetwork/list", reportConditionDTO);
    }

    @Test
    public void testGetDauSummary() throws Exception {
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin("2020-02-15");
        reportConditionDTO.setDateEnd("2020-02-22");
        Integer[] publisherIds = new Integer[]{1, 2};
        reportConditionDTO.setPublisherId(publisherIds);
        String[] dimensions = new String[]{"publisherId"};
        reportConditionDTO.setDimension(dimensions);
        this.doPost("/report/dau/list", reportConditionDTO);
    }

    @Test
    public void testGetLRSummary() throws Exception {
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin("2020-02-20");
        reportConditionDTO.setDateEnd("2020-02-20");
        Integer[] publisherIds = new Integer[]{0};
        reportConditionDTO.setPublisherId(publisherIds);
        String[] dimensions = new String[]{"day","publisherId"};
        reportConditionDTO.setDimension(dimensions);
        this.doPost("/report/lr/list", reportConditionDTO);
    }
}
