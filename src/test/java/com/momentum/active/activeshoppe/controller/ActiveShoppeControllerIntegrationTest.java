package com.momentum.active.activeshoppe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ActiveShoppeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ActiveShoppeService activeShoppeService;
    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    void getAllProducts() throws Exception {
        this.mockMvc.perform(get("/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Hatlam"));
    }
    //TODO add more integration tests

}