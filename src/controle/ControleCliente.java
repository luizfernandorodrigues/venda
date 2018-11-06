/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;

/**
 *
 * @author jmtis
 */
public class ControleCliente {

    ConectaBanco ConnCliente = new ConectaBanco();
    ModeloCliente mod = new ModeloCliente();
    int codBairro, codCidade, codEstado;
    String bairro, cidade, telefone;

    public void SalvarCliente(ModeloCliente mod) {
        AchaCidade(mod.getCidade());
        AchaEstado(mod.getEstado());
        try {
            ConnCliente.conexao();
            PreparedStatement pst = ConnCliente.conn.prepareStatement("insert into clientes (nome_cliente,endereco_cliente,rg_cliente,cpf_cliente,bairro_cliente,id_cidade,id_estado,telefone_clientes) values (?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getRg());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, codCidade);
            pst.setInt(7, codEstado);
            pst.setString(8, mod.getTelefone());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados Gravados Com Sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar os Dados \n ERRO:  " + ex);

        }
        ConnCliente.desconecta();

    }

    public void ExcluirCliente(ModeloCliente mod) {
        ConnCliente.conexao();

        try {
            PreparedStatement pst = ConnCliente.conn.prepareStatement("delete from clientes where id_cliente=?");

            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Registro!! \n ERRO:  " + ex);
        }

    }

    // metodo para editar o cliente
    public void Altera(ModeloCliente mod) {
        AchaCidade(mod.getCidade());
        AchaEstado(mod.getEstado());
        ConnCliente.conexao();

        try {

            PreparedStatement pst = ConnCliente.conn.prepareStatement("update clientes set nome_cliente=?, endereco_cliente=?, rg_cliente=?, cpf_cliente=?, bairro_cliente=?, id_cidade=?, id_estado=?, telefone_clientes=? where id_cliente=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getRg());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, codCidade);
            pst.setInt(7, codEstado);
            pst.setString(8, mod.getTelefone());
            pst.setInt(9, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Altera os Registros!! \n ERRO:  " + ex);
        }
        ConnCliente.desconecta();

    }

    public void AchaCidade(String cidade) {
        ConnCliente.conexao();

        try {
            ConnCliente.executaSQL("select * from cidade where nome_cidade ='" + cidade + "'");
            ConnCliente.rs.first();
            codCidade = ConnCliente.rs.getInt("id_cidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Buscar o Código da Cidade!!\n ERRO:  " + ex);
        }
    }

    public void AchaEstado(String estado) {
        ConnCliente.conexao();

        try {
            ConnCliente.executaSQL("Select * from estado where sigla_estado ='" + estado + "'");
            ConnCliente.rs.first();
            codEstado = ConnCliente.rs.getInt("id_estado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Buscar o Código do Estado !!\n ERRO:   " + ex);
        }
    }

}
