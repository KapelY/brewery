package com.zigmann.brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zigmann.brewery.services.BeerService;
import com.zigmann.brewery.services.BeerServiceImpl;
import com.zigmann.brewery.web.model.BeerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
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
    public void setUp() throws Exception {
        validBeer = BeerDto.builder().id(UUID.randomUUID()).beerName("Name11").build();
        beerService = mock(BeerServiceImpl.class);
        given(beerService
                .getBeerById(any(UUID.class)))
                .willReturn(validBeer);
    }

    @Test
    public void getBeer() throws Exception {

//        System.out.println(beerService.getBeerById(any(UUID.class)));
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/v1/beer/" + validBeer.getId().toString())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
//                .andExpect(jsonPath("$.beerName", is(validBeer.getBeerName())));

    }

    @Test
    public void handlePost() throws Exception {
//        BeerDto beerDto = validBeer;
//        beerDto.setId(null);
//        BeerDto saveBeerDto = BeerDto.builder()
//                .id(UUID.randomUUID())
//                .beerName("New Beer")
//                .build();
//        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//        given(beerService.saveNewBeer(any())).willReturn(saveBeerDto);
//
//        mockMvc.perform(post("/api/v1/beer/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(beerDtoJson))
//                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception {
//        BeerDto beerDto = validBeer;
//
//        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
//
//        mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(beerDtoJson)
//        ).andExpect(status().isNoContent());

//        then(beerService).should().updateBeerById(any(), any());
    }
}
