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
import modelo.ModeloBairro;

public class ControleBairro {

    ConectaBanco connBairro = new ConectaBanco();
    ConectaBanco connCidade = new ConectaBanco();
    int codCidade;
    String cidade;

    public void InserirBairro(ModeloBairro mod) {

        connBairro.conexao();
        try {
            PreparedStatement pst = connBairro.conn.prepareStatement("insert into bairro (nome, id_cidade) values (?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getId_cidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar Registro!! \n ERRO:  " + ex);
        }

        connBairro.desconecta();
    }

    public void Editar(ModeloBairro mod) {
        try {
            connBairro.conexao();
            PreparedStatement pst = connBairro.conn.prepareStatement("update bairro set nome = ?, id_cidade = ? where id_bairro = ?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getId_cidade());
            pst.setInt(3, mod.getId_bairro());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Registro!!\n ERRO:  " + ex);
        }

        connBairro.desconecta();

    }

    public void ExcluiBairro(ModeloBairro mod) {
        try {
            connBairro.conexao();
            PreparedStatement pst = connBairro.conn.prepareStatement("delete from bairro where id_bairro = ?");
            pst.setInt(1, mod.getId_bairro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir o Registro !! \n ERRO:  " + ex);
        }

        connBairro.desconecta();
    }

}
