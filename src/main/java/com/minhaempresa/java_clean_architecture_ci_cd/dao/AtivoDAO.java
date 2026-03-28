package com.minhaempresa.java_clean_architecture_ci_cd.dao;

import java.util.List;

import com.minhaempresa.java_clean_architecture_ci_cd.entity.Ativo;

public interface AtivoDAO {
	
	Ativo salvar(Ativo ativo);
	List<Ativo> listar();

}
