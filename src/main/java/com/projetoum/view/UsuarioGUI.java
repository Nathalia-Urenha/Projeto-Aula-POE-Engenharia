package com.projetoum.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projetoum.estrutura.util.VariaveisProjeto;
import com.projetoum.model.modells.Usuario;
import com.projetoum.model.service.UsuarioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UsuarioGUI extends JFrame {

	
	private static final long serialVersionUID = 1867371822121507791L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JButton btnInluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JRadioButton rdbtnAtivo;
	private JRadioButton rdbtnAdmin;
	private JButton btnSair;
	private JPasswordField passwordFieldSenha;
	private JLabel lblCodigo;
	private JTextField textFieldCodigo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGUI() {
		setTitle("Cadastro de Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		
		rdbtnAtivo = new JRadioButton("Ativo");
		
		rdbtnAdmin = new JRadioButton("Admin");
		
		btnInluir = new JButton("Incluir");
		
		btnAlterar = new JButton("Alterar");
		
		
		btnExcluir = new JButton("Excluir");
		
		
		btnSair = new JButton("Sair");
		
		passwordFieldSenha = new JPasswordField();
		
		lblCodigo = new JLabel("C\u00F3digo: ");
		
		textFieldCodigo = new JTextField();
		
		textFieldCodigo.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCodigo)
						.addComponent(lblSenha)
						.addComponent(lblEmail)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnInluir)
								.addGap(18)
								.addComponent(btnAlterar)
								.addGap(18)
								.addComponent(btnExcluir)
								.addGap(18)
								.addComponent(btnSair))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(rdbtnAtivo)
								.addGap(18)
								.addComponent(rdbtnAdmin))
							.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
							.addComponent(passwordFieldSenha))
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(231, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAtivo)
						.addComponent(rdbtnAdmin))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void createEvents() {
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharUsuario();
			}
		});
		
		btnInluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirUsuario();
			}
			
		});	
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
			
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		
		textFieldCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarUsuario();
			}
		});
	}
	
	private void incluirUsuario() {
		Usuario usuario = pegarDadosUsuario();

		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.save(usuario);
		
	}
	
	
	protected void excluirUsuario() {
		Usuario usuario = pegarDadosUsuario();
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.delete(usuario);
		
	}
	
	protected void alterarUsuario() {
	    Usuario usuario = pegarDadosUsuario();
	    
	    UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.update(usuario);
	}
	
	private void fecharUsuario() {
		dispose();
	}
	
	
	  private void buscarUsuario() { Usuario usuario = new Usuario();
	  
	  if (VariaveisProjeto.digitacaoCampo(textFieldCodigo.getText())){
	  textFieldCodigo.requestFocus(); return; }
	  
	  Integer id = Integer.valueOf(textFieldCodigo.getText());
	  
	  UsuarioService usuarioService = new UsuarioService();
	  
	  usuario = usuarioService.findById(id);
	  
	  textFieldNome.setText(usuario.getUsername());
	  textFieldEmail.setText(usuario.getEmail());
	  passwordFieldSenha.setText(usuario.getPassword());
	  
	  if (usuario.isAdmin()) rdbtnAdmin.setSelected(true);
	  
	  if ( usuario.isAtivo()) rdbtnAtivo.setSelected(true); }
	 
	
	
	
	@SuppressWarnings("deprecation")
	public Usuario pegarDadosUsuario() {
		Usuario usuario = new Usuario();
		
		if (!"".equals(textFieldCodigo.getText())){
			usuario.setId( Integer.valueOf(textFieldCodigo.getText()));
		}
		
		usuario.setUsername(textFieldNome.getText());
		usuario.setEmail(textFieldEmail.getText());
		usuario.setPassword(passwordFieldSenha.getText());
		
		if (rdbtnAtivo.isSelected()) {
			usuario.setAtivo(true);
		} else  {
			usuario.setAtivo(false);
		}
		
		if (rdbtnAdmin.isSelected()) {
			usuario.setAdmin(true);
		} else {
			usuario.setAdmin(false);
		}
		
		
		return usuario;
		
	}
}
