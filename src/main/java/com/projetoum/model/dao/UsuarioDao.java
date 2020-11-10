package com.projetoum.model.dao;

import javax.persistence.EntityManager;

import com.projetoum.model.modells.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer >{

	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

	
	

}
