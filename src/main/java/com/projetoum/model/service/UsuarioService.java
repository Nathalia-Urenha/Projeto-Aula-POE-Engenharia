package com.projetoum.model.service;

import javax.persistence.EntityTransaction;

import com.projetoum.estrutura.util.VariaveisProjeto;
import com.projetoum.model.dao.UsuarioDao;
import com.projetoum.model.modells.Usuario;

public class UsuarioService extends ConexaoBancoService {
	
	private UsuarioDao usuarioDao;
		
	public UsuarioService() {
		this.usuarioDao = new UsuarioDao(this.getEntityManager());
	}
	//salvar
	public Integer save(Usuario usuario) {
		
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		if ( validarDigitacao(usuario) == VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				
				trx.begin();
				this.getUsuarioDao().save(usuario);
				trx.commit();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
				
			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}
	
	//atualizar
	public Integer update(Usuario usuario) {
		
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		if ( validarDigitacao(usuario) == VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				
				trx.begin();
				this.getUsuarioDao().update(usuario);
				trx.commit();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
				
			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}
	
	
	//Buscar
	public Usuario findById(Integer id) {
		return this.getUsuarioDao().findById(id);
	}
	
	
	//remover
	public Integer remover(Usuario usuario) {
		
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		if ( validarDigitacao(usuario) == VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				
				trx.begin();
				this.getUsuarioDao().remove(usuario);
				trx.commit();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
				
			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}

	
	
	
	public Integer validarDigitacao(Usuario usuario) {
		
		if ( VariaveisProjeto.digitacaoCampo(usuario.getUsername())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		
		return VariaveisProjeto.DIGITACAO_OK;
	}
	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

}
