package com.projetoum.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

public abstract class GenericDao<T, ID extends Serializable> {
	
	private EntityManager entityManager;
	
	private final Class<T> classePersistencia;
	
	@SuppressWarnings("unchecked")
	public GenericDao(EntityManager entityManager) {
	this.entityManager = entityManager;
	this.classePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(T entity) {
		this.getEntityManager().persist(entity);
	}
	
	public void update(T entity) {
		this.getEntityManager().merge(entity);
	}

	public void remove(T entity) {
		this.getEntityManager().remove(entity);
	}
	
	public T findById (ID id) {
		return this.getEntityManager().find(getClassePersistencia(), id);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getClassePersistencia() {
		return classePersistencia;
	}
	
}
