package com.adtiming.om.ds;

import com.adtiming.om.ds.model.OmPlacementRule;
import com.adtiming.om.ds.model.OmPlacementRuleInstance;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.jar.JarEntry;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Mediation test
 *
 * @author dianbo ruan
 */
public class MediationTest extends BaseCommonTests{

    @Test
    public void testGetSegment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/get")
                .param("ruleId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testGetPlacementInstances() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/instance/list")
                .param("pubAppId", "117")
                .param("ruleId", "6")
                .param("placementId", "119"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testUpdateRuleInstancePriority() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/instance/update_priority")
                .param("ruleInstanceId", "1")
                .param("priority", "2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetRuleList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/list")
                .param("pubAppId", "117")
                .param("placementId", "119"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreatePlacementRule() throws Exception {
        OmPlacementRule omPlacementRule = new OmPlacementRule();
        omPlacementRule.setName("test");
        omPlacementRule.setPubAppId(117);
        omPlacementRule.setPlacementId(119);
        omPlacementRule.setPublisherId(10);
        this.doPost("/mediation/segment/rule/create", omPlacementRule);
    }

    @Test
    public void testUpdatePlacementRule() throws Exception {
        OmPlacementRule omPlacementRule = new OmPlacementRule();
        omPlacementRule.setId(4);
        omPlacementRule.setPubAppId(117);
        omPlacementRule.setPlacementId(119);
        this.doPost("/mediation/segment/rule/update", omPlacementRule);
    }

    @Test
    public void testDeletePlacementRule() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/rule/delete")
                .param("ruleId", "2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetRuleInstanceList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/instances").param("ruleId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreatePlacementRuleInstance() throws Exception {
        OmPlacementRuleInstance omPlacementRuleInstance = new OmPlacementRuleInstance();
        omPlacementRuleInstance.setAdnId(1);
        omPlacementRuleInstance.setRuleId(33);
        omPlacementRuleInstance.setInstanceId(390);
        this.doPost("/mediation/segment/rule/instance/create", omPlacementRuleInstance);
    }

    @Test
    public void testUpdatePlacementRuleInstance() throws Exception {
        OmPlacementRuleInstance omPlacementRuleInstance = new OmPlacementRuleInstance();
        omPlacementRuleInstance.setId(1);
        omPlacementRuleInstance.setAdnId(2);
        omPlacementRuleInstance.setRuleId(1);
        this.doPost("/mediation/segment/rule/instance/update", omPlacementRuleInstance);
    }

    @Test
    public void testDeleteRuleInstance() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/rule/instance/delete")
                .param("ruleId", "6")
                .param("instanceId", "211"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"));
    }

    @Test
    public void testSegmentResortPriority() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mediation/segment/resort/priority")
                .param("placementRuleInstanceIds", "138,139,136,137"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

}
