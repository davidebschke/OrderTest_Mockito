package de.neuefische.cgnjava222.ordersystem.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class OrderIntegrationTest {

    @Autowired
    MockMvc mockMvc;


@Test
@DirtiesContext
    void addOrder() throws Exception {
        mockMvc.perform(
                        post("/api/orders/42")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        [2,3]
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("""
                        """));
        mockMvc
                .perform(get("/api/orders/42")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"id":42,"products":[{"id":2,"name":"Banane"},{"id":3,"name":"Zitrone"}]}
                        """));

    }



}
