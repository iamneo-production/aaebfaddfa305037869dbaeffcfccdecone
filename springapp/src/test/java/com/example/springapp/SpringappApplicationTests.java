package com.example.springapp;


import com.example.springapp.model.MenuItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    
    @Test
    public void testAddMenuItemApi() throws Exception {
        // Uncomment the lines below and add your test logic:
        MenuItem menuItemToAdd = new MenuItem(1, "Item 1", 10.0f, 5, "Description 1");
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(menuItemToAdd)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testDeleteMenuItemApi() throws Exception {
        // Uncomment the lines below and add your test logic:
        int menuItemId = 1;
        mockMvc.perform(MockMvcRequestBuilders.delete("/{id}", menuItemId))
                .andExpect(status().isOk());
    }


}
