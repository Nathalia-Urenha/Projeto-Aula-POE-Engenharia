package com.projetoum.view.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projetoum.main.Login;
import com.projetoum.view.usuario.TabelaUsuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1732579980954071214L;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmLogout;
	private JPanel contentPane;
	
	private Login login;
	private JMenu mnSair;
	private JMenuItem mntmSairSistema;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public Menu(Login login) {
		this.login = login;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 443);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmUsuario = new JMenuItem("Usu\u00E1rio");
		
		mnArquivo.add(mntmUsuario);
		
		mntmLogout = new JMenuItem("Logout");
		
		mnArquivo.add(mntmLogout);
		
		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		mntmSairSistema = new JMenuItem("Sair do sistema");
		
		mnSair.add(mntmSairSistema);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 742, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	private void createEvents() {
		////////////ACTION LISTENER///////////////
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaUsuario tabelaUsuario = new TabelaUsuario();
				contentPane.add(tabelaUsuario);
				tabelaUsuario.setVisible(true);
			}
		});
		
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		
		mntmSairSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
