package com.minhaempresa.java_clean_architecture_ci_cd.service;

import java.util.List;

import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;

public interface AtivoService {

    AtivoDTO criar(AtivoDTO dto);
    List<AtivoDTO> listar();
}