package com.cnfwsy.interfaces.controller;

import com.cnfwsy.core.constant.ReturnCodeConstant;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by zhangjh on 16/6/5.
 */
public class ComPositionControllerTest extends AbstractContextControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void create() throws Exception {
        String requestBody = "{ \"name\":\"java软件工程师\"}";
        mockMvc.perform(post("/comPosition")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.header.rtn_code").value(ReturnCodeConstant.SUCESS.getCode()));
    }

    @Test
    public void queryByBusinessKey() throws Exception {

    }

    @Test
    public void deleteByBusinessKey() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

}