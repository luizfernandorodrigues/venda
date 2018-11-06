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
import modelo.ModeloPais;

/**
 *
 * @author luizf
 */
public class ControlePais {

    ConectaBanco ConnPais = new ConectaBanco();
    ModeloPais mod = new ModeloPais();

    public void Salvar(ModeloPais mod) {
        ConnPais.conexao();
        try {
            PreparedStatement pst = ConnPais.conn.prepareStatement("insert into pais (nome_pais, codigo_pais) values (?,?)");
            pst.setString(1, mod.getNomePais());
            pst.setInt(2, mod.getCodigoPais());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Gravar o Registro!\n" + ex);
        }
        ConnPais.desconecta();
    }

    public void Alterar(ModeloPais mod) {
        ConnPais.conexao();
        try {
            PreparedStatement pst = ConnPais.conn.prepareStatement("update pais set nome_pais=?, codigo_pais=? where id_pais=?");
            pst.setString(1, mod.getNomePais());
            pst.setInt(2, mod.getCodigoPais());
            pst.setInt(3, mod.getId_pais());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar o Registro!\n" + ex);
        }
    }

}
