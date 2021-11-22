package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.representations.CriptomonedaRepresentation;
import ar.edu.undef.fie.criptoboot.services.CriptomonedaService;
import ar.edu.undef.fie.criptoboot.services.CriptomonedaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.litesoftwares.coingecko.domain.Coins.CoinMarkets;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import retrofit2.Response;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriptomonedaControllerTest {
/*
    private CriptomonedaService criptomonedaService;

    private CriptomonedaServiceImpl criptomonedaServiceImpl;

    @Test
    @DisplayName("Dado: un request de getCriptomonedas, Cuando: se invoca al método getCriptomonedas , Entonces: se devuelve una lista de CoinMarkets  ")
    void getCriptomonedas() throws Exception{
        //Given
        CriptomonedaController criptomonedaController = new CriptomonedaController(criptomonedaService);
        System.out.println(criptomonedaController.getCriptomonedas());
        //When
        ResponseEntity<List<CriptomonedaRepresentation>> lista = criptomonedaController.getCriptomonedas();
        System.out.println(lista);
        //Then
        Assertions.assertNotNull(lista);
    }*/
/*
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCriptomonedasTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/criptomonedas").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        String resultContext = result.getResponse().getContentAsString();

        Response response = objectMapper.readValue(resultContext, Response.class);
        
        Assertions.assertTrue(response.isSuccessful() == Boolean.TRUE);


    }


*/


}