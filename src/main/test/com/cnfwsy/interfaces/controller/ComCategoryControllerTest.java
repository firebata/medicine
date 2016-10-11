package com.cnfwsy.interfaces.controller;

import com.cnfwsy.core.constant.ReturnCodeConstant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by zhangjh on 16/6/4.
 */
//XML风格
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:conf/applicationContext.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:conf/spring-mvc.xml")
})
public class ComCategoryControllerTest extends AbstractContextControllerTests{
//    @Autowired
//    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
//        ComCategoryController userController = new ComCategoryController();
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        String requestBody = "{\"id\":1, \"name\":\"zhang\"}";
        mockMvc.perform(post("/comCategory")
                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.header.rtn_code").value(ReturnCodeConstant.SUCESS.getCode()  ));
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
          //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
    }

}