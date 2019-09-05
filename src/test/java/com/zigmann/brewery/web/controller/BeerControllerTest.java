package com.zigmann.brewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zigmann.brewery.services.BeerService;
import com.zigmann.brewery.web.model.BeerDto;
import jdk.jshell.Snippet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private BeerDto validBeer;

    @Before
    public void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer")
                .beerStyle("Super")
                .upc(123L)
                .build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + validBeer.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is(validBeer.getBeerName())));
    }

    @Test
    public void handlePost() throws Exception {
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto saveBeerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(saveBeerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception {
        BeerDto beerDto = validBeer;

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson)
        ).andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }
}