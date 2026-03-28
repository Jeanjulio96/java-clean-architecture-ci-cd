package com.minhaempresa.java_clean_architecture_ci_cd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;
import com.minhaempresa.java_clean_architecture_ci_cd.facade.AtivoFacade;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    private AtivoFacade facade;

    @PostMapping
    public AtivoDTO criar(@RequestBody AtivoDTO dto) {
        return facade.criar(dto);
    }

    @GetMapping
    public List<AtivoDTO> listar() {
        return facade.listar();
    }
}