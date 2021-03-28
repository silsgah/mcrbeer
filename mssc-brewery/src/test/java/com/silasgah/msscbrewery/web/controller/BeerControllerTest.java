package com.silasgah.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silasgah.msscbrewery.service.BeerService;
import com.silasgah.msscbrewery.web.model.BeerDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setup(){
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                           .beerName("Silas")
                           .beerStyle("Golden")
                           .upc(244443233L)
                           .build();
    }
    @Test
    public void getbeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void handlePost() throws Exception{
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto saveDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New sample").build();

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.savedNewBeer(any())).willReturn(saveDto);
        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception{
        BeerDto beerDto = validBeer;
        beerDto.setId((null));
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
        then(beerService).should().updateBeer(any(), any());
    }

}