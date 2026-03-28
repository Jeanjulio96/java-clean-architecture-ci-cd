package com.minhaempresa.java_clean_architecture_ci_cd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.minhaempresa.java_clean_architecture_ci_cd.entity.Ativo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AtivoDAOImpl implements AtivoDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ativo salvar(Ativo ativo) {
		em.persist(ativo);
		return null;
	}

	@Override
	public List<Ativo> listar() {
		return em.createQuery("from Ativo", Ativo.class).getResultList();
	}
	
	

}
