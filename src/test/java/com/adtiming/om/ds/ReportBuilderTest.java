package com.adtiming.om.ds;

import com.adtiming.om.ds.dto.ReportBuilderDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ruandianbo on 20-2-27.
 */
public class ReportBuilderTest extends BaseCommonTests {

    @Test
    public void testCreateReport() throws Exception {
        ReportBuilderDTO reportBuilderDTO = new ReportBuilderDTO();
        reportBuilderDTO.setName("test2");
        reportBuilderDTO.setDataSource((byte)1);
        reportBuilderDTO.setSchedule(7);
        reportBuilderDTO.setRecipients("test@test.com");
        this.doPost("/report/builder/create", reportBuilderDTO);
    }

    @Test
    public void testUpdateReportBuilder() throws Exception {
        ReportBuilderDTO reportBuilderDTO = new ReportBuilderDTO();
        reportBuilderDTO.setId(100);
        reportBuilderDTO.setName("test");
        reportBuilderDTO.setDataSource((byte)1);
        reportBuilderDTO.setSchedule(7);
        reportBuilderDTO.setRecipients("test@test.com");
        Integer[] instanceArr = new Integer[]{1,2,3,4};
        reportBuilderDTO.setCondInstanceList(instanceArr);
        reportBuilderDTO.setCondCountryList(new String[]{"CH","US"});
        reportBuilderDTO.setCondAdnList(new Integer[]{1,2,3});
        reportBuilderDTO.setMetrics(new String[]{"impr", "click"});
        reportBuilderDTO.setDimensions(new String[]{"day", "publisherId"});
        this.doPost("/report/builder/update", reportBuilderDTO);
    }

    @Test
    public void testGetReportBuilders() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/report/builders"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testUpdateReportBuilderStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/report/builder/status/update")
                .param("id", "101").param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testDeleteReportBuilder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/report/builder/delete")
                .param("id", "101"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }
}
