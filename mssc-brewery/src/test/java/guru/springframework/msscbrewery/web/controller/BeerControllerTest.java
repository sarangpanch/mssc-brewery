package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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

    BeerDto validBeerDto;

    @BeforeEach
    void setUp() {
        validBeerDto = BeerDto.builder().id(UUID.randomUUID())
                .beerName("Stella")
                .beerStyle("yale beer")
                .upc(4556L)
                .build();
    }

    @Test
    void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeerDto);

        mockMvc.perform(get("/api/v1/beer/" + validBeerDto.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeerDto.getId().toString())))
                .andExpect(jsonPath("$.beerName", is(validBeerDto.getBeerName())));
    }

    @Test
    void handlePost() throws Exception {

        BeerDto beerDto = validBeerDto;
        beerDto.setId(null);
        BeerDto savedBeer = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();

        String objectJson = objectMapper.writeValueAsString(beerDto);
        given(beerService.saveBeerDto(any(BeerDto.class))).willReturn(savedBeer);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectJson))
                .andExpect(status().isCreated());
    }

    @Test
    void handlePut() throws JsonProcessingException {
    }

    @Test
    void deleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/" + UUID.randomUUID().toString())).andExpect(status().isNoContent());
    }
}