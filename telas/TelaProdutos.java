package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaProdutos {
    private JFrame frame;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JButton btnConfirmar;
    private JTable tabela;
    private DefaultTableModel model;
    private JScrollPane scrollTabela;

    public JFrame getFrame() {
        return frame;
    }

    public TelaProdutos() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cadastro de produtos");
        frame.setBackground(new Color(0, 0, 0));
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Usando layout absoluto para setBounds funcionar
        frame.getContentPane().setLayout(null);

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

        // Texto "Nome"
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(270, 46, 65, 23);
        labelNome.setForeground(new Color(0, 0, 0));
        labelNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
        frame.getContentPane().add(labelNome);

        // Campo "Nome"
        campoNome = new JTextField();
        campoNome.setBounds(270, 74, 190, 23);
        campoNome.setForeground(new Color(0, 0, 0));
        frame.getContentPane().add(campoNome);
        campoNome.setColumns(10);

        // Texto "valor"
        JLabel labelNick = new JLabel("Valor:");
        labelNick.setBounds(270, 138, 60, 25);
        labelNick.setFont(new Font("Tahoma", Font.PLAIN, 19));
        frame.getContentPane().add(labelNick);

        // Campo "valor"
        campoCpf = new JTextField();
        campoCpf.setBounds(270, 164, 190, 23);
        frame.getContentPane().add(campoCpf);

        // Botão "Confirmar"
        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.setBounds(128, 265, 129, 34);
        btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnConfirmar.setBackground(Color.decode("#dcdcdc"));
        frame.getContentPane().add(btnConfirmar);

        String[] colunas = {"Produto", "Valor"};
        model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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

    }
}