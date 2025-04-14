package pharmacy.app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MedicinesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateMedicine() throws Exception {
        // Дано
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/medicines");
        post.contentType(MediaType.APPLICATION_JSON);
        post.content("""
                {
                    "name" : "Аспирин",
                    "cost": 5
                }""");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedName = MockMvcResultMatchers.jsonPath("$.name").value("Аспирин");
        ResultMatcher expectedCost = MockMvcResultMatchers.jsonPath("$.cost").value(5);

        // Действие
        ResultActions actual = mockMvc.perform(post);

        // Проверка
        actual.andExpect(expectedStatus)
                .andExpect(expectedName)
                .andExpect(expectedCost);

    }
}