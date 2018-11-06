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
import modelo.ModeloLogin;

/**
 *
 * @author jmtis
 */
public class ControleLogin {

    ConectaBanco connLogin = new ConectaBanco();
    ModeloLogin mod = new ModeloLogin();

    public void Salvar(ModeloLogin mod) {
        connLogin.conexao();
        try {
            PreparedStatement pst = connLogin.conn.prepareStatement("insert into login (nome_login,senha,permissao,login)values(?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSenha());
            pst.setString(3, mod.getPermissao());
            pst.setString(4, mod.getLogin());
            pst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Registro !! \n ERRO:  " + ex);
        }

        connLogin.desconecta();

    }

    public void Excluir(ModeloLogin mod) {
        connLogin.conexao();
        try {
            PreparedStatement pst = connLogin.conn.prepareStatement("delete from login where id_login = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados!! \n ERRO:  " + ex);
        }
        connLogin.desconecta();
    }

    public ModeloLogin Primeiro() {
        connLogin.conexao();

        try {
            connLogin.executaSQL("select * from login");
            connLogin.rs.first();
            mod.setId(connLogin.rs.getInt("id_login"));
            mod.setLogin(connLogin.rs.getString("login"));
            mod.setNome(connLogin.rs.getString("nome_login"));
            mod.setPermissao(connLogin.rs.getString("permissao"));
            mod.setSenha(connLogin.rs.getString("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Primeiro Registro!!");
        }
        //connLogin.desconecta();
        return mod;

    }

    public ModeloLogin Ultimo() {
        connLogin.conexao();

        try {
            connLogin.executaSQL("select * from login");
            connLogin.rs.last();
            mod.setId(connLogin.rs.getInt("id_login"));
            mod.setLogin(connLogin.rs.getString("login"));
            mod.setNome(connLogin.rs.getString("nome_login"));
            mod.setPermissao(connLogin.rs.getString("permissao"));
            mod.setSenha(connLogin.rs.getString("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ultimo Registro!!");
        }
        //connLogin.desconecta();
        return mod;

    }

    public ModeloLogin Proximo() {
        //connLogin.conexao();

        try {
            //connLogin.executaSQL("select * from login");
            connLogin.rs.next();
            mod.setId(connLogin.rs.getInt("id_login"));
            mod.setLogin(connLogin.rs.getString("login"));
            mod.setNome(connLogin.rs.getString("nome_login"));
            mod.setPermissao(connLogin.rs.getString("permissao"));
            mod.setSenha(connLogin.rs.getString("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ultimo Registro!!");
        }
        //connLogin.desconecta();
        return mod;

    }

    public ModeloLogin Anterior() {
        connLogin.conexao();

        try {
            // connLogin.executaSQL("select * from login");
            connLogin.rs.previous();
            mod.setId(connLogin.rs.getInt("id_login"));
            mod.setLogin(connLogin.rs.getString("login"));
            mod.setNome(connLogin.rs.getString("nome_login"));
            mod.setPermissao(connLogin.rs.getString("permissao"));
            mod.setSenha(connLogin.rs.getString("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Primeiro Registro!!");
        }
        //connLogin.desconecta();
        return mod;

    }
    public void Editar (ModeloLogin mod){
        connLogin.conexao();
        try {
            PreparedStatement pst = connLogin.conn.prepareStatement("update login set nome_login=?, senha=?, permissao=?, login=? where id_login =? ");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSenha());
            pst.setString(3, mod.getPermissao());
            pst.setString(4, mod.getLogin());
            pst.setInt(5, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na Alteração dos Dados!!\n ERRO:  " + ex);
        }
    }
}
