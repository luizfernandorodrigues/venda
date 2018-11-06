/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.ModeloCheque;

/**
 *
 * @author luizf
 */
public class Utilitarios {

    ModeloCheque mod = new ModeloCheque();
    ConectaBanco connUtil = new ConectaBanco();

    public void Icone(JFrame jf) {
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jmti.jpg")));
    }

    public int achaCliente(String cliente) {
        int codCliente = 0;
        connUtil.conexao();

        try {
            connUtil.executaSQL("SELECT * FROM CLIENTES WHERE CPF_CLIENTE = '" + cliente + "'");
            connUtil.rs.first();
            codCliente = connUtil.rs.getInt("id_cliente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar o codigo do cliente!\n" + ex);
        }
        return codCliente;

    }

    public void limparTodosCampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setValue("");
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText("");
            } else if (component instanceof JTextArea) {
                JTextArea field = (JTextArea) component;
                field.setText("");
            } else if (component instanceof Container) {
                limparTodosCampos((Container) component);
            }

        }
    }

    public void carregaDataAtual(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date hoje = new Date();
                field.setText(df.format(hoje));
            } else if (component instanceof Container) {
                carregaDataAtual((Container) component);
            }
        }

    }

    public void desabilitaCampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setEnabled(false);
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setEnabled(false);
            } else if (component instanceof JComboBox) {
                JComboBox combo = (JComboBox) component;
                combo.setEnabled(false);
            } else if (component instanceof JTextArea) {
                JTextArea field = (JTextArea) component;
                field.setEnabled(false);
            } else if (component instanceof Container) {
                desabilitaCampos((Container) component);
            }
        }
    }

    public void habilitaCampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setEnabled(true);
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setEnabled(true);
            } else if (component instanceof JComboBox) {
                JComboBox combo = (JComboBox) component;
                combo.setEnabled(true);
            } else if (component instanceof JTextArea) {
                JTextArea field = (JTextArea) component;
                field.setEnabled(true);
            } else if (component instanceof Container) {
                habilitaCampos((Container) component);
            }
        }
    }
}
