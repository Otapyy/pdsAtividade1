package telas;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaTabela {
    private JFrame frame;
    private JTable tabela;
    private DefaultTableModel model;
    private JScrollPane scrollTabela;
    
    public JFrame getFrame() {
        return frame;
    }

    public TelaTabela(ArrayList<Usuario> lista, boolean modoEscuro) {
        initialize(lista, modoEscuro);
    }

    private void initialize(ArrayList<Usuario> lista, boolean modoEscuro) {
        frame = new JFrame("Tabela de Cadastros");
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        String[] colunas = {"Nome", "Cpf"};

        model = new DefaultTableModel(colunas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };





        for (Usuario c : lista) {
            Object[] linha = {c.getNome(), c.getCpf()};
            model.addRow(linha);
        }

        tabela = new JTable(model);
        tabela.setBackground(new Color(0, 0, 0));
        scrollTabela = new JScrollPane(tabela);
        frame.getContentPane().add(scrollTabela, BorderLayout.CENTER);
        frame.setVisible(true);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = tabela.rowAtPoint(e.getPoint());
                int coluna = tabela.columnAtPoint(e.getPoint());

                if (linha >= 0 && coluna >= 0) {
                    Object valor = tabela.getValueAt(linha, coluna);
                    System.out.println("Clique na célula: (" + linha + ", " + coluna + ") = " + valor);
                }
            }
        });

    }


    
    public void aplicarTema(boolean modoEscuro) {
        Tema.aplicarTemaTabela(tabela, frame, scrollTabela, modoEscuro);
    }

    public void atualizarTabela() {
        model.setRowCount(0);  
        for (Usuario c : GerenciadorEstados.listaJogadores) {
            Object[] linha = {c.getNome(), c.getCpf()};
            model.addRow(linha);
        }
    }
    
}