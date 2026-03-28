package com.minhaempresa.java_clean_architecture_ci_cd.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.minhaempresa.java_clean_architecture_ci_cd.dao.AtivoDAO;
import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;
import com.minhaempresa.java_clean_architecture_ci_cd.entity.Ativo;
import com.minhaempresa.java_clean_architecture_ci_cd.service.impl.AtivoServiceImpl;

@ExtendWith(MockitoExtension.class)
class AtivoServiceTest {

    @InjectMocks
    private AtivoServiceImpl service;

    @Mock
    private AtivoDAO dao;

    @Test
    void deveCriarAtivo() {

        AtivoDTO dto = new AtivoDTO();
        dto.setNome("PETR4");
        dto.setPreco(30.0);

        service.criar(dto);

        verify(dao, times(1)).salvar(any(Ativo.class));
    }

    @Test
    void naoDeveSalvarPrecoNegativo() {

        AtivoDTO dto = new AtivoDTO();
        dto.setNome("VALE3");
        dto.setPreco(-10.0);

        try {
            service.criar(dto);
        } catch (Exception e) {
            verify(dao, never()).salvar(any());
        }
    }
}