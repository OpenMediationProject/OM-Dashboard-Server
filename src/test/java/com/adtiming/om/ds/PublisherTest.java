package com.adtiming.om.ds;

import com.adtiming.om.ds.model.OmPublisher;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Publisher test
 *
 * @author dianbo ruan
 */
public class PublisherTest extends BaseCommonTests {

    @Test
    public void testGetPublisherList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/publisher/list").param("userId", "73"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetSelectPublisherList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/publisher/select/list").param("userId", "79"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreatePublisher() throws Exception {
        OmPublisher omPublisher = new OmPublisher();
        omPublisher.setName("test91");
        omPublisher.setOwnerUserId(1);
        omPublisher.setEmail("test91@test.com");
        omPublisher.setPhone("13588797909");
        this.doPost("/publisher/create", omPublisher);
    }

    @Test
    public void testUpdatePublisher() throws Exception {
        OmPublisher omPublisher = new OmPublisher();
        omPublisher.setId(101);
        omPublisher.setName("test1");
        omPublisher.setOwnerUserId(1);
        this.doPost("/publisher/update", omPublisher);
    }
}
