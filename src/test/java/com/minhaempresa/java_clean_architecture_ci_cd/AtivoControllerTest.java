package com.minhaempresa.java_clean_architecture_ci_cd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import com.minhaempresa.java_clean_architecture_ci_cd.controller.AtivoController;
import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;
import com.minhaempresa.java_clean_architecture_ci_cd.facade.AtivoFacade;

@WebMvcTest(AtivoController.class)
class AtivoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtivoFacade facade;

    @Test
    void deveRetornar200() throws Exception {
        mockMvc.perform(get("/ativos"))
               .andExpect(status().isOk());
    }
    
    @GetMapping
    public List<AtivoDTO> listar() {
        return facade.listar(); // ❌ método não existe
    }
    
}
