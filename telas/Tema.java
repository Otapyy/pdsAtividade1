package telas;

import java.awt.Color;
import javax.swing.*;

public class Tema {
	
//Variavel para manter a consistencia entre tema escuro e claro nas telas	
	public static boolean modoEscuro = false;

//Metodo para aplicar o tema claro 
	public static void aplicarTemaClaro(JFrame frame, JMenuBar menuBar, JMenu menuTema, JMenu menuInfo, JMenuItem itemDark, JMenuItem itemLight, JTextField campoNome, JTextField campoNick,
			JButton btnConfirmar, JLabel labelNick, JLabel labelNome, JMenuItem itemTabela) {
        frame.getContentPane().setBackground(Color.decode("#ffffff"));

        menuBar.setBackground(Color.decode("#dcdcdc"));

        menuTema.setForeground(Color.decode("#000000"));
        menuInfo.setForeground(Color.decode("#000000"));

        itemDark.setBackground(Color.decode("#dcdcdc"));
        itemDark.setForeground(Color.decode("#000000"));

        itemLight.setBackground(Color.decode("#dcdcdc"));
        itemLight.setForeground(Color.decode("#000000"));
        
        campoNome.setBackground(Color.decode("#ffffff"));
        campoNome.setForeground(Color.decode("#000000"));
        
        campoNick.setBackground(Color.decode("#ffffff"));
        campoNick.setForeground(Color.decode("#000000"));
        
        btnConfirmar.setBackground(Color.decode("#dcdcdc"));
        btnConfirmar.setForeground(Color.decode("#000000"));
        
        labelNick.setForeground(Color.decode("#000000"));
        
        labelNome.setForeground(Color.decode("#000000"));

        itemTabela.setBackground(Color.decode("#dcdcdc"));
        itemTabela.setForeground(Color.decode("#000000"));
        
    }

//Metodo para aplicar o tema escuro
    public static void aplicarTemaEscuro(JFrame frame, JMenuBar menuBar, JMenu menuTema, JMenu menuInfo, JMenuItem itemDark, JMenuItem itemLight, JTextField campoNome, JTextField campoNick,
			JButton btnConfirmar, JLabel labelNick, JLabel labelNome, JMenuItem itemTabela) {
        frame.getContentPane().setBackground(Color.decode("#0f0f0f"));

        menuBar.setBackground(Color.decode("#272727"));
        
        menuTema.setForeground(Color.decode("#f1f1db"));
        menuInfo.setForeground(Color.decode("#f1f1db"));

        itemDark.setBackground(Color.decode("#272727"));
        itemDark.setForeground(Color.decode("#f1f1db"));
        
        itemLight.setBackground(Color.decode("#272727"));
        itemLight.setForeground(Color.decode("#f1f1db"));
        
        campoNome.setBackground(Color.decode("#272727"));
        campoNome.setForeground(Color.decode("#f1f1db"));
        
        campoNick.setBackground(Color.decode("#272727"));
        campoNick.setForeground(Color.decode("#f1f1db"));
        
        btnConfirmar.setBackground(Color.decode("#272727"));
        btnConfirmar.setForeground(Color.decode("#f1f1db"));
        
        labelNick.setForeground(Color.decode("#f1f1db"));
        
        labelNome.setForeground(Color.decode("#f1f1db"));

        itemTabela.setBackground(Color.decode("#272727"));
        itemTabela.setForeground(Color.decode("#f1f1db"));
        	 		
	}
    
  //Metodo para aplicar o tema na tela de tabelas
    public static void aplicarTemaTabela(JTable tabela, JFrame frame, JScrollPane scrollTabela, boolean modoEscuro) {
        if (modoEscuro) {
        	frame.getContentPane().setBackground(Color.decode("#0f0f0f"));
            tabela.setBackground(Color.decode("#272727"));
            tabela.setForeground(Color.decode("#f1f1db"));
            tabela.getTableHeader().setBackground(Color.decode("#272727"));
            tabela.getTableHeader().setForeground(Color.decode("#f1f1db"));
            tabela.setGridColor(Color.decode("#f1f1db"));
            scrollTabela.getViewport().setBackground(Color.decode("#0f0f0f"));
            scrollTabela.setBackground(Color.decode("#0f0f0f"));
            return;
        } 
            frame.getContentPane().setBackground(Color.decode("#ffffff"));
            tabela.setBackground(Color.decode("#ffffff"));
            tabela.setForeground(Color.decode("#000000"));
            tabela.getTableHeader().setBackground(Color.decode("#dcdcdc"));
            tabela.getTableHeader().setForeground(Color.decode("#000000"));
            tabela.setGridColor(Color.decode("#000000"));
            scrollTabela.getViewport().setBackground(Color.decode("#ffffff"));
            scrollTabela.setBackground(Color.decode("#ffffff"));
        
    }
    
    
    
}
	
	
