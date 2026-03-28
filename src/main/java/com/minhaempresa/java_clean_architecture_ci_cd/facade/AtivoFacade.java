package com.minhaempresa.java_clean_architecture_ci_cd.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;
import com.minhaempresa.java_clean_architecture_ci_cd.service.AtivoService;

@Component
public class AtivoFacade {

    @Autowired
    private AtivoService service;

    public AtivoDTO criar(AtivoDTO dto) {
        return service.criar(dto);
    }

    public List<AtivoDTO> listar() { // ✔️ adicionar isso
        return service.listar();
    }
}