package com.adtiming.om.ds;

import com.adtiming.om.ds.model.OmAdnetworkApp;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AdNetwork test
 *
 * @author dianbo ruan
 */
public class AdNetWorkTest extends BaseCommonTests {

    @Test
    public void testGetAdNetWorkPlacementInstances() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/adnetwork/placement/instances")
                .param("pubAppId", "10")
                .param("placementId", "100")
                .param("instanceId", "112"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testGetSelectAdNetWorks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/adnetwork/select/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testGetAdNetWorks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/adnetwork/list").param("pubAppId", "117"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testGetAdNetWorkApp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/adnetwork/app/get").param("pubAppId", "130"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testUpdateAdNetWorkAppStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/adnetwork/app/status/update")
                .param("adNetworkAppId", "130")
                .param("status", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testCreateAdNetwork() throws Exception {
        OmAdnetworkApp omAdnetworkApp = new OmAdnetworkApp();
        omAdnetworkApp.setPubAppId(100);
        omAdnetworkApp.setAdnId(1);
        omAdnetworkApp.setClientId("test");
        omAdnetworkApp.setAdnAppKey("test");
        omAdnetworkApp.setRefreshToken("test");
        this.doPost("/adnetwork/app/create", omAdnetworkApp);
    }

    @Test
    public void testUpdateAdNetwork() throws Exception {
        OmAdnetworkApp omAdnetworkApp = new OmAdnetworkApp();
        omAdnetworkApp.setId(130);
        omAdnetworkApp.setPubAppId(100);
        omAdnetworkApp.setAdnId(1);
        omAdnetworkApp.setClientId("test1");
        omAdnetworkApp.setAdnAppKey("test1");
        omAdnetworkApp.setRefreshToken("test1");
        this.doPost("/adnetwork/app/update", omAdnetworkApp);
    }
}
