package telas;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import javax.swing.*;


public class Tela1 {

	
	private JFrame frameTelaLogin;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JButton btnConfirmar;
	private JComboBox<String> campoOrganizacao;

	public JFrame getFrame() {
		return frameTelaLogin;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 window = new Tela1();
					window.frameTelaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Tela1() {
		initialize();
	}

	private void initialize() {

		Aviso aviso = new Aviso();
	
//Criando o frame	
		frameTelaLogin = new JFrame();
		frameTelaLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frameTelaLogin.setBackground(new Color(255, 255, 255));
		frameTelaLogin.setBounds(100, 100, 350, 400);
		frameTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTelaLogin.getContentPane().setLayout(null);
		frameTelaLogin.setTitle("Cadastro");

//Texto "Nome"		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(50, 46, 65, 23);
		labelNome.setForeground(new Color(0, 0, 0));
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelNome.setBackground(null);
		frameTelaLogin.getContentPane().add(labelNome);
			
//Caixa de texto "Nome"		
		campoNome = new JTextField();
		campoNome.setBounds(50, 74, 225, 23);
		campoNome.setToolTipText("");
		campoNome.setForeground(new Color(0, 0, 0));
		frameTelaLogin.getContentPane().add(campoNome);
		campoNome.setColumns(10);

//Texto "Cpf"
		JLabel labelNick = new JLabel("Cpf:");
		labelNick.setBounds(50, 138, 42, 25);
		labelNick.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frameTelaLogin.getContentPane().add(labelNick);

//Caixa de texto "Cpf"
		campoCpf = new JTextField();
		campoCpf.setBounds(50, 164, 225, 23);
		frameTelaLogin.getContentPane().add(campoCpf);

//Botão "Confirmar"
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBounds(100, 265, 129, 34);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConfirmar.setBackground(Color.decode("#dcdcdc"));

//Ação do Botão
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verificando se os campos estão preenchidos
				if (campoNome.getText().equals("") || campoCpf.getText().equals("")) {
					aviso.avisoErro("Preencha todos os campos");
		            return;

		        }

				if(campoNome.getText().equals("123") && campoCpf.getText().equals("123")) {
					aviso.avisoSucesso("Entrou como administrador");
					GerenciadorEstados.telaProdutos = new TelaProdutos();
					frameTelaLogin.dispose();
					GerenciadorEstados.telaProdutos.getFrame().setVisible(true);

				} else{
					aviso.avisoSucesso("Entrou como usuario");
					GerenciadorEstados.telaTabela = new TelaTabela(GerenciadorEstados.listaProdutos);
					frameTelaLogin.dispose();
					GerenciadorEstados.telaTabela.getFrame().setVisible(true);

				}
		        campoCpf.setText("");
		        campoNome.setText("");
							
			}
		});
		
		frameTelaLogin.getContentPane().add(btnConfirmar);
		
	}
}
