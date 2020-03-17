package com.giffgaff.ims.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
public class RawMaterialsMgmtControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RawMaterialsMgmtController()).build();
    }

    @Test
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("/productSpecs"))
                .andExpect(status().isOk())
                .andExpect(view().name("productSpecs"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
