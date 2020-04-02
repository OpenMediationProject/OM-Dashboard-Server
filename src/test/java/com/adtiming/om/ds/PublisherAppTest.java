package com.adtiming.om.ds;

import com.adtiming.om.ds.dto.PublisherAppDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmPublisherApp;
import com.adtiming.om.ds.service.PublisherAppService;
import com.adtiming.om.ds.web.PublisherAppController;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Publisher app test
 *
 * @author dianbo ruan
 */
public class PublisherAppTest extends BaseCommonTests {

    @Autowired
    private PublisherAppService publisherAppService;

    @Autowired
    private PublisherAppController publisherAppController;

    @Test
    public void testGetPublisherApps() {
        List<OmPublisherApp> publisherApps = this.publisherAppService.getPublisherApps();
        log.info(JSONObject.toJSON(publisherApps));
        Response response = publisherAppController.getPublisherApps();
        log.info(response);
    }

    @Test
    public void testCreatePublisherApp() {
        OmPublisherApp omPublisherApp = new OmPublisherApp();
        omPublisherApp.setAppId("test app");
        omPublisherApp.setAppName("test app");
        Response response = this.publisherAppService.createPublisherApp(omPublisherApp);
        log.info(response);
    }

    @Test
    public void testUpdatePublisherApp() {
        PublisherAppDTO publisherAppDTO = new PublisherAppDTO();
        publisherAppDTO.setId(100);
        publisherAppDTO.setAppId("test");
        publisherAppDTO.setAppName("test1");
        Response response = this.publisherAppService.updatePublisherApp(publisherAppDTO);
        log.info(response);
    }

    @Test
    public void testGetPublisherAppsSortByRevenue() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/publisher/app/sort_list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testGetApp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/get")
                .param("appId", "989673964"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testUpdatePublisherAppsInfo() {
        this.publisherAppService.updatePublisherAppInfo();
    }
}
