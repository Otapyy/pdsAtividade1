package telas;

import javax.swing.*;

public class Aviso {

    public void avisoSucesso(String textoMsg){
        JOptionPane.showMessageDialog(null, textoMsg, "Login concluido", JOptionPane.INFORMATION_MESSAGE);

    }

    public void avisoErro(String textoMsg){
        JOptionPane.showMessageDialog(null, textoMsg, "Falha no Login", JOptionPane.ERROR_MESSAGE);

    }


}
