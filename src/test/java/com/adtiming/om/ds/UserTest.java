package com.adtiming.om.ds;

import com.adtiming.om.ds.dto.UserDTO;
import com.adtiming.om.ds.model.*;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ruandianbo on 20-2-13.
 */
public class UserTest extends BaseCommonTests {

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/delete")
                .param("userId", "34").param("roleId", "20"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetSelectUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/select/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("test");
        userDTO.setEmail("test@test.com");
        userDTO.setPublisherId(10);
        userDTO.setRoleId(2);
        this.doPost("/user/create", userDTO);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UmUser umUser = new UmUser();
        umUser.setId(18);
        umUser.setName("test1");
        umUser.setEmail("testsss@test.com");
        umUser.setRoleId(30);
        this.doPost("/user/update", umUser);
    }

    @Test
    public void testGetUserApp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/app/get")
                .param("userId", "1").param("pubAppId", "10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetUserApps() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/app/list")
                .param("userId", "1").param("pubAppId", "132"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateUserApp() throws Exception {
        UmUserApp umUserApp = new UmUserApp();
        umUserApp.setUserId(1);
        umUserApp.setPubAppId(100);
        this.doPost("/user/app/create", umUserApp);
    }

    @Test
    public void testDeleteUserApp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/app/delete")
                .param("userId", "1")
                .param("pubAppId", "100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/user_role/get")
                .param("userId", "1").param("roleId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetUserRoles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/user_role/list").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateUserRole() throws Exception {
        UmUserRole umUserRole = new UmUserRole();
        umUserRole.setUserId(1);
        umUserRole.setRoleId(2);
        this.doPost("/user/user_role/create", umUserRole);
    }

    @Test
    public void testDeleteUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/user_role/delete")
                .param("userId", "1")
                .param("roleId", "2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/get")
                .param("roleId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetRoles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateRole() throws Exception {
        UmRole umRole = new UmRole();
        umRole.setName("test1");
        umRole.setAppRole(0);
        umRole.setUserRole(0);
        umRole.setDescn("test");
        umRole.setOrganizationRole(0);
        this.doPost("/user/role/create", umRole);
    }

    @Test
    public void testUpdateRole() throws Exception {
        UmRole umRole = new UmRole();
        umRole.setId(4);
        umRole.setName("test1");
        umRole.setAppRole(1);
        umRole.setUserRole(0);
        umRole.setDescn("test1");
        umRole.setOrganizationRole(0);
        this.doPost("/user/role/update", umRole);
    }

    @Test
    public void testDeleteRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/delete")
                .param("roleId", "4"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetRolePermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/permission/get")
                .param("roleId", "1")
                .param("permissionId", "10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testCreateRolePermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/permission/create")
                .param("roleId", "20")
                .param("permissionName", "report_builder")
                .param("permissionType", "edit"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testDeleteRolePermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/permission/delete")
                .param("roleId", "20")
                .param("permissionName", "report_builder")
                .param("permissionType", "edit"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testGetUserPermissions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/permission/list")
                .param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
                .andDo(print())
                .andReturn();
    }
}
