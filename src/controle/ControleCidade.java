/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCidade;

/**
 *
 * @author jmtis
 */
public class ControleCidade {

    ConectaBanco connCidade = new ConectaBanco();

    public void InserirCidade(ModeloCidade mod) {
        connCidade.conexao();
        try {
            PreparedStatement pst = connCidade.conn.prepareStatement("insert into cidade (nome_cidade, id_estado) values (?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar os Dados !\n ERRO: " + ex);
        }

        connCidade.desconecta();

    }

    public void ExcluiCidade(ModeloCidade mod) {
        connCidade.conexao();
        try {
            
            PreparedStatement pst = connCidade.conn.prepareStatement("delete from cidade where id_cidade = ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir o Registro !!\n ERRO: " + ex);
        }
        
        connCidade.desconecta();

    }
    
    public void AlteraCidade( ModeloCidade mod){
       
        try {
             connCidade.conexao();
            PreparedStatement pst = connCidade.conn.prepareStatement("update cidade set nome_cidade = ?, id_estado = ? where id_cidade = ?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso !!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar o Registro !!\n ERRO: " + ex);
            
            connCidade.desconecta();
        }
    }

}
