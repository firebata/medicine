package com.cnfwsy.interfaces.controller;

import com.cnfwsy.core.constant.ReturnCodeConstant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by zhangjh on 16/6/4.
 */
public class ComCompanyControllerTest extends AbstractContextControllerTests {
    //    @Autowired
//    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        String requestBody = "{ \"name\":\"广州壳普软件有限公司\"}";
        mockMvc.perform(post("/comCompany")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.header.rtn_code").value(ReturnCodeConstant.SUCESS.getCode()));
    }

    @Test
    public void queryByBusinessKey() throws Exception {
//        String requestBody = "{\"companyId\":26247846364673}";
        mockMvc.perform(get("/comCompany/26247846364673")
                .contentType(MediaType.ALL_VALUE)/*.content(requestBody)*/
                .accept(MediaType.ALL_VALUE)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.header.rtn_code").value(ReturnCodeConstant.SUCESS.getCode()));
    }

    @Test
    public void deleteByBusinessKey() throws Exception {
        mockMvc.perform(delete("/comCompany/26247880482049")
                .contentType(MediaType.ALL_VALUE)/*.content(requestBody)*/
                .accept(MediaType.ALL_VALUE)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.header.rtn_code").value(ReturnCodeConstant.SUCESS.getCode()));
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

}