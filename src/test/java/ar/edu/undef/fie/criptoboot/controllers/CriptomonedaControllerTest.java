package ar.edu.undef.fie.criptoboot.controllers;

import ar.edu.undef.fie.criptoboot.services.CriptomonedaService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
class CriptomonedaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CriptomonedaService criptomonedaService;

    @InjectMocks
    private CriptomonedaController criptomonedaController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(criptomonedaController)
                .build();
    }

    @Test
    public void getCriptomonedas() throws Exception {
        String uri = "/criptomonedas/";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        /*
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productlist = super.mapFromJson(content, Product[].class);
        assertTrue(productlist.length > 0);*/
    }





}