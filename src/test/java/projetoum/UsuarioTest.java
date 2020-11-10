package projetoum;

import org.junit.Test;

import com.projetoum.model.modells.Usuario;
import com.projetoum.model.service.UsuarioService;

public class UsuarioTest {
	
	//@Test(expected = Exception.class)
	public void salvarUsuarioBancoDadosTeste() {
      
		//salvou um usuario
		Usuario usuario = new Usuario();
		
		//usuario.setId(2);
		usuario.setUsername("Nathalia Urenha");
		usuario.setPassword("123456");
		usuario.setEmail("naty.urenha@gmail.com");
		usuario.setAtivo(false);
		usuario.setAdm(false);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.save(usuario);
		
		System.out.println("Gravando usuário no banco de dados");
		
		//assertTrue(true);
		
	}

	//alterou um usuário
	@Test(expected = Exception.class)
	public void alterarUsuarioBancoDadosTeste() {
      
		Usuario usuario = new Usuario();
				
		usuario.setId(1);
		
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuario = usuarioService.findById(usuario.getId());
		
		System.out.println(usuario.toString());
		
		usuario.setEmail("naty.urenha@gmail.com");
		
		usuarioService.update(usuario);
		
		System.out.println("Ateração usuário no banco de dados");
		
		//assertTrue(true);
		
		
	}
	

	//Buscar um usuário
	@Test(expected = Exception.class)
	public void buscarUsuarioBancoDadosTeste() {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(1);
		
		UsuarioService usuarioService = new UsuarioService();
		
		//busca o usuario com id 1
		usuario = usuarioService.findById(usuario.getId());
		
		System.out.println(usuario.toString());
		
		
	}
	
	//Remover um usuario
	@Test(expected = Exception.class)
	public void removerUsuarioBancoDadosTeste() {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(1);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.remover(usuario);
		
		System.out.println("Removido do banco de dados");
		
		
	}


}
