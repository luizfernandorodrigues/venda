/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloTelefone;

/**
 *
 * @author jmtis
 */
public class ControlaTelefone {

    ConectaBanco connTelefone = new ConectaBanco();

    public void InserirTelefone(ModeloTelefone mod) {
        connTelefone.conexao();

        try {
            PreparedStatement pst = connTelefone.conn.prepareStatement("insert into telefone (numero_tel) values (?)");
            pst.setString(1, mod.getNumeroTel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Registro!! \n ERRO:  " + ex);
        }
        connTelefone.desconecta();
    }

    public void Editar(ModeloTelefone mod) {
        connTelefone.conexao();

        try {
            PreparedStatement pst = connTelefone.conn.prepareStatement("update telefone set numero_tel = ? where id_telefone = ? ");
            pst.setString(1, mod.getNumeroTel());
            pst.setInt(2, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Registro !!\n ERRO:  " + ex);
        }

        connTelefone.desconecta();
    }

    public void Excluir(ModeloTelefone mod) {
        connTelefone.conexao();
        try {
            PreparedStatement pst = connTelefone.conn.prepareCall("delete from telefone where id_telefone=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Registro!! \n ERRO:  " + ex);
        }
    }

}
