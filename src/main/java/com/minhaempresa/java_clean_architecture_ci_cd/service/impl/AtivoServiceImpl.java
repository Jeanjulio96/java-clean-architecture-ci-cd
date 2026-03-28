package com.minhaempresa.java_clean_architecture_ci_cd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minhaempresa.java_clean_architecture_ci_cd.dao.AtivoDAO;
import com.minhaempresa.java_clean_architecture_ci_cd.dto.AtivoDTO;
import com.minhaempresa.java_clean_architecture_ci_cd.entity.Ativo;
import com.minhaempresa.java_clean_architecture_ci_cd.service.AtivoService;

@Service
public class AtivoServiceImpl implements AtivoService {

    @Autowired
    private AtivoDAO dao;

    @Override
    @Transactional // ✅ AQUI
    public AtivoDTO criar(AtivoDTO dto) {

        if (dto.getPreco() <= 0) {
            throw new RuntimeException("Preco invalido");
        }

        Ativo ativo = new Ativo();
        ativo.setNome(dto.getNome());
        ativo.setPreco(dto.getPreco());

        dao.salvar(ativo);

        return dto;
    }
    
    @Override
    public List<AtivoDTO> listar() {
        return dao.listar().stream().map(a -> {
            AtivoDTO dto = new AtivoDTO();
            dto.setNome(a.getNome());
            dto.setPreco(a.getPreco());
            return dto;
        }).toList();
    }
}