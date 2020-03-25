package com.adtiming.om.ds;

import com.adtiming.om.ds.model.OmInstanceCountry;
import com.adtiming.om.ds.model.OmInstanceWithBLOBs;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Instance test
 *
 * @author dianbo ruan
 */
public class InstanceTest extends BaseCommonTests {

    @Test
    public void testGetPlacementInstances() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/instance/list")
                .param("pubAppId", "117")
                .param("adNetworkId", "3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testGetPlacementInstance() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/instance/get")
                .param("instanceId", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testUpdatePlacementInstanceStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/instance/update/status")
                .param("instanceId", "210")
                .param("status", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testCreatePlacementInstance() throws Exception {
        OmInstanceWithBLOBs omInstanceWithBLOBs = new OmInstanceWithBLOBs();
        omInstanceWithBLOBs.setName("test");
        omInstanceWithBLOBs.setPubAppId(100);
        omInstanceWithBLOBs.setPlacementId(100);
        omInstanceWithBLOBs.setAdnId(1);
        this.doPost("/instance/create", omInstanceWithBLOBs);
    }

    @Test
    public void testUpdatePlacementInstance() throws Exception {
        OmInstanceWithBLOBs omInstanceWithBLOBs = new OmInstanceWithBLOBs();
        omInstanceWithBLOBs.setId(196);
        omInstanceWithBLOBs.setName("test2");
        omInstanceWithBLOBs.setPubAppId(100);
        omInstanceWithBLOBs.setPlacementId(100);
        omInstanceWithBLOBs.setAdnId(1);
        omInstanceWithBLOBs.setHbStatus((byte)1);
        this.doPost("/instance/update", omInstanceWithBLOBs);
    }

    @Test
    public void testGetInstanceCountryList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/instance/country/list").param("instanceId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateInstanceCountry() throws Exception {
        OmInstanceCountry omInstanceCountry = new OmInstanceCountry();
        omInstanceCountry.setInstanceId(1);
        omInstanceCountry.setPlacementId(100);
        omInstanceCountry.setAdnId((byte)1);
        omInstanceCountry.setCountry("CHN");
        this.doPost("/instance/country/create", omInstanceCountry);
    }

    @Test
    public void testUpdatePlacementInstanceCountry() throws Exception {
        OmInstanceCountry omInstanceCountry = new OmInstanceCountry();
        omInstanceCountry.setId(1000);
        omInstanceCountry.setInstanceId(1);
        omInstanceCountry.setPlacementId(100);
        omInstanceCountry.setAdnId((byte)1);
        omInstanceCountry.setCountry("USA");
        this.doPost("/instance/country/update", omInstanceCountry);
    }
}
