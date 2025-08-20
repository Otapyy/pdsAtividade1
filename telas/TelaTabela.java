package telas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaTabela {
    private JFrame frame;
    private JTable tabela;
    private JTextArea infoProduto;
    private DefaultTableModel model;
    private JScrollPane scrollTabela;

    public JFrame getFrame() {
        return frame;
    }

    public TelaTabela(ArrayList<Produto> lista) {
        initialize(lista);
    }

    private void initialize(ArrayList<Produto> lista) {
        frame = new JFrame("Loja");
        frame.setBackground(new Color(20, 0, 0));
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#dcdcdc"));
        frame.setJMenuBar(menuBar);

        JMenu menuSair = new JMenu("sair");
        menuBar.add(menuSair);

        JMenuItem itemSair = new JMenuItem("sair");
        menuSair.add(itemSair);

        itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tela1 tela1 = new Tela1();
                tela1.getFrame().setVisible(true);
                frame.dispose();
            }
        });

        // Modelo da tabela
        String[] colunas = {"Produto", "Valor"};
        model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Produto c : lista) {
            Object[] linha = {c.getNome(), c.getValor()};
            model.addRow(linha);
        }

        tabela = new JTable(model);
        tabela.setBackground(new Color(0, 0, 0));

        scrollTabela = new JScrollPane(tabela);

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setOpaque(false);

        int larguraMetade = frame.getWidth() / 2;
        int altura = frame.getHeight();
        scrollTabela.setPreferredSize(new Dimension(larguraMetade, altura));

        painelCentral.add(scrollTabela, BorderLayout.WEST);

        JPanel preenchimento = new JPanel();
        preenchimento.setOpaque(false);
        painelCentral.add(preenchimento, BorderLayout.CENTER);

        frame.getContentPane().add(painelCentral, BorderLayout.CENTER);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int novaLarguraMetade = frame.getContentPane().getWidth() / 2;
                int novaAltura = frame.getContentPane().getHeight();
                scrollTabela.setPreferredSize(new Dimension(novaLarguraMetade, novaAltura));
                painelCentral.revalidate();
            }
        });

        // Listeners de interação
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

        frame.setVisible(true);
    }

    public void atualizarTabela() {
        model.setRowCount(0);
        for (Produto c : GerenciadorEstados.listaProdutos) {
            Object[] linha = {c.getNome(), c.getValor()};
            model.addRow(linha);
        }
    }
}
