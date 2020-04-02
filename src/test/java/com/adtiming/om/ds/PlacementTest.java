package com.adtiming.om.ds;

import com.adtiming.om.ds.dto.AdvertisementType;
import com.adtiming.om.ds.model.OmPlacementCountry;
import com.adtiming.om.ds.model.OmPlacementScene;
import com.adtiming.om.ds.model.OmPlacementWithBLOBs;
import com.adtiming.om.ds.service.PlacementService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Placement test
 *
 * @author dianbo ruan
 */
public class PlacementTest extends BaseCommonTests {

    @Autowired
    PlacementService placementService;

    @Test
    public void testPlacementList() {
        Byte[] types = new Byte[]{0};
        log.info(JSONObject.toJSONString(placementService.getPlacements(100, types)));
    }

    @Test
    public void testGetPlacementList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/placement/list")
                .param("pubAppId", "117"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testGetSelectPlacementList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/placement/select/list").param("pubAppId", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testGetPlacement() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/placement/get").param("placementId", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testCreatePlacement() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        OmPlacementWithBLOBs omPlacementWithBLOBs = new OmPlacementWithBLOBs();
        omPlacementWithBLOBs.setName("test_scene");
        omPlacementWithBLOBs.setAdType((byte)AdvertisementType.Banner.ordinal());
        mockMvc.perform(MockMvcRequestBuilders.post("/placement/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(omPlacementWithBLOBs)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testUpdatePlacement() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        OmPlacementWithBLOBs omPlacementWithBLOBs = new OmPlacementWithBLOBs();
        omPlacementWithBLOBs.setId(108);
        omPlacementWithBLOBs.setName("test21");
        omPlacementWithBLOBs.setPubAppId(100);
        omPlacementWithBLOBs.setPublisherId(1);
        omPlacementWithBLOBs.setAdType((byte)AdvertisementType.Banner.ordinal());
        mockMvc.perform(MockMvcRequestBuilders.post("/placement/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(omPlacementWithBLOBs)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testGetPlacementSceneList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/placement/scenes").param("placementId", "108"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testCreatePlacementScene() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        OmPlacementScene omPlacementScene = new OmPlacementScene();
        omPlacementScene.setName("test");
        omPlacementScene.setPlacementId(108);
        mockMvc.perform(MockMvcRequestBuilders.post("/placement/scene/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(omPlacementScene)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testUpdatePlacementScene() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        OmPlacementScene omPlacementScene = new OmPlacementScene();
        omPlacementScene.setId(100);
        omPlacementScene.setName("test_i");
        omPlacementScene.setPlacementId(108);
        mockMvc.perform(MockMvcRequestBuilders.post("/placement/scene/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(omPlacementScene)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testGetPlacementCountryList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/placement/country/list").param("placementId", "100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreatePlacementCountry() throws Exception {
        OmPlacementCountry omPlacementCountry = new OmPlacementCountry();
        omPlacementCountry.setPlacementId(100);
        omPlacementCountry.setCountry("CHN");
        this.doPost("/placement/country/create", omPlacementCountry);
    }

    @Test
    public void testUpdatePlacementCountry() throws Exception {
        OmPlacementCountry omPlacementCountry = new OmPlacementCountry();
        omPlacementCountry.setId(100);
        omPlacementCountry.setPlacementId(100);
        omPlacementCountry.setCountry("USA");
        this.doPost("/placement/country/update", omPlacementCountry);
    }
}
