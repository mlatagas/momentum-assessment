package com.momentum.active.activeshoppe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableList;
import com.momentum.active.activeshoppe.model.Product;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import com.momentum.active.activeshoppe.service.impl.ActiveShoppeServiceImpl;
import lombok.val;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.momentum.active.activeshoppe.ActiveShoppeUtil.getFakeProduct;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ActiveShoppeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ActiveShoppeService activeShoppeService = Mockito.mock(ActiveShoppeServiceImpl.class);
    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    void getAllProducts() throws Exception {
        when(activeShoppeService.getAllProducts()).thenReturn(ImmutableList.of(getFakeProduct(1,"Fake Prod",100)));
        this.mockMvc.perform(get("/v1/products")).andExpect(status().isOk());
    }

}