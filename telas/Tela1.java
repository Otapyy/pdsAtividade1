package telas;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import javax.swing.*;


public class Tela1 {

	
	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JButton btnConfirmar;
	private JComboBox<String> campoOrganizacao;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 window = new Tela1();
					window.frame.setVisible(true);
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
	
//Criando o frame	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 400, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Cadastro");

//Texto "Nome"		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(66, 46, 65, 23);
		labelNome.setForeground(new Color(0, 0, 0));
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelNome.setBackground(null);
		frame.getContentPane().add(labelNome);
			
//Caixa de texto "Nome"		
		campoNome = new JTextField();
		campoNome.setBounds(66, 74, 255, 23);
		campoNome.setToolTipText("");
		campoNome.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(campoNome);
		campoNome.setColumns(10);

//Texto "Cpf"
		JLabel labelNick = new JLabel("Cpf:");
		labelNick.setBounds(66, 138, 42, 25);
		labelNick.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(labelNick);

//Caixa de texto "Cpf"
		campoCpf = new JTextField();
		campoCpf.setBounds(66, 164, 255, 23);
		frame.getContentPane().add(campoCpf);

//Texto "Erro ou Acerto"
		JLabel labelErroAcerto = new JLabel("");
		labelErroAcerto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelErroAcerto.setBounds(87, 251, 206, 25);
		frame.getContentPane().add(labelErroAcerto);

//Botão "Confirmar"
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBounds(128, 265, 129, 34);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConfirmar.setBackground(Color.decode("#dcdcdc"));

//Criando a barra de menu		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.decode("#dcdcdc"));
		
//Criando os menus		
        JMenu menuTema = new JMenu("Tema");
         
        JMenu menuInfo = new JMenu("Info");
        
//Criando os itens do menu "Info"               
        JMenuItem itemTabela = new JMenuItem("Tabela");
        
//Criando os itens do menu "Tema"         
        JMenuItem itemDark = new JMenuItem("Escuro");
        JMenuItem itemLight = new JMenuItem("Claro");
        
//Adicionando no frame o MenuBar        
        frame.setJMenuBar(menuBar);
        
//Adicionando no MenuBar os Menus          
        menuBar.add(menuTema);
        menuBar.add(menuInfo);
        
//Adicionando no Menu "Tema" os itens        
        menuTema.add(itemDark);
        menuTema.add(itemLight);

//Adicionando no Menu "Info" os itens 
        menuInfo.add(itemTabela);
        
        
				
       
//seta o modo escuro
        itemDark.addActionListener(e -> {
        	Tema.modoEscuro = true;
        	Tema.aplicarTemaEscuro(frame, menuBar, menuTema, menuInfo, itemDark, itemLight, campoNome, campoCpf, btnConfirmar, labelNick, labelNome, itemTabela);
           
        	if (GerenciadorEstados.telaTabela != null) {
                GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);
            }
           
        });

//seta o modo claro
        itemLight.addActionListener(e -> {
        	Tema.modoEscuro = false;
        	Tema.aplicarTemaClaro(frame, menuBar, menuTema, menuInfo, itemDark, itemLight, campoNome, campoCpf, btnConfirmar, labelNick, labelNome, itemTabela);
            
        	if (GerenciadorEstados.telaTabela != null) {
                GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);
            }
        	
         });

        itemTabela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (GerenciadorEstados.listaJogadores.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhum cadastro encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (GerenciadorEstados.telaTabela == null) {
                    GerenciadorEstados.telaTabela = new TelaTabela(GerenciadorEstados.listaJogadores, Tema.modoEscuro);
                    GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);
                    return;
                } 
                GerenciadorEstados.telaTabela.getFrame().setVisible(true);
                GerenciadorEstados.telaTabela.atualizarTabela();
                GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);
                
            }
        });

        

//Ação do Botão
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verificando se os campos estão preenchidos
				if (campoNome.getText().equals("") || campoCpf.getText().equals("")) {
		            labelErroAcerto.setText("Preencha todos os campos!");
		            labelErroAcerto.setForeground(Color.decode("#ff3333"));
					labelErroAcerto.setBounds(100, 221, 206, 25);
		            return;
		        }

				if(campoNome.getText().equals("abc") && campoCpf.getText().equals("123")) {
					labelErroAcerto.setText("Entrou como adm!");
					labelErroAcerto.setForeground(Color.decode("#008080"));
					labelErroAcerto.setBounds(130, 221, 206, 25);

				} else{
					labelErroAcerto.setText("Entrou como usuario!");
					labelErroAcerto.setForeground(Color.decode("#008080"));
					labelErroAcerto.setBounds(120, 221, 206, 25);
					if (GerenciadorEstados.telaTabela == null) {
						GerenciadorEstados.telaTabela = new TelaTabela(GerenciadorEstados.listaJogadores, Tema.modoEscuro);
						GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);
						frame.dispose();
						return;
					}
					GerenciadorEstados.telaTabela.getFrame().setVisible(true);
					GerenciadorEstados.telaTabela.atualizarTabela();
					GerenciadorEstados.telaTabela.aplicarTema(Tema.modoEscuro);

				}
		        campoCpf.setText("");
		        campoNome.setText("");
							
			}
		});
		
		frame.getContentPane().add(btnConfirmar);
		
	}
}
