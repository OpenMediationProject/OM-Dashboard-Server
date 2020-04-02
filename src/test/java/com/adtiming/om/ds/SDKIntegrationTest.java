package com.adtiming.om.ds;

import com.adtiming.om.ds.model.OmDevApp;
import com.adtiming.om.ds.model.OmDevDevice;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ruandianbo on 20-2-26.
 */
public class SDKIntegrationTest extends BaseCommonTests {

    @Test
    public void testSelectDevApp() throws Exception {
        OmDevApp devApp = new OmDevApp();
        devApp.setAdnId(1);
        devApp.setPubAppId(117);
        this.doPost("/sdk/dev_app/create", devApp);
    }

    @Test
    public void testGetTestAdNetworks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sdk/adnetworks")
                .param("pubAppId", "117"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetAdNetworkPlacements() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sdk/adnetwork/placements")
                .param("pubAppId", "139")
                .param("adnId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testUpdateDevAppTestResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sdk/dev_app/test_result/update")
                .param("devAppId", "100")
                .param("devAppTestResult", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateDevDevice() throws Exception {
        OmDevDevice devDevice = new OmDevDevice();
        devDevice.setDeviceId("test");
        devDevice.setDeviceName("test");
        this.doPost("/sdk/device/create", devDevice);
    }

    @Test
    public void testUpdateDevDevice() throws Exception {
        OmDevDevice devDevice = new OmDevDevice();
        devDevice.setId(100);
        devDevice.setDeviceId("test1");
        devDevice.setDeviceName("test1");
        this.doPost("/sdk/device/update", devDevice);
    }

    @Test
    public void testGetDevices() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sdk/devices")
                .param("publisherId", "10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }
}
