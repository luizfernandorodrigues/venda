/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloFornecedor;

/**
 *
 * @author jmtis
 */
public class ControleFornecedor {

    ConectaBanco ConnFornecedor = new ConectaBanco();
    ModeloFornecedor mod = new ModeloFornecedor();
    String bairro, cidade, telefone;
    int codigoCidade, codigoEstado;

    public void Salvar(ModeloFornecedor mod) {
        AchaCidade(mod.getCodigoCidade());
        AchaEstado(mod.getCodigoEstado());
        ConnFornecedor.conexao();
        try {
            PreparedStatement pst = ConnFornecedor.conn.prepareStatement("insert into fornecedores (nome_fornecedor, endereco_fornecedor, cnpj_fornecedor, telefone_fornecedor, id_cidade, id_estado, bairro_fornecedor) values (?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getCnpj());
            pst.setString(4, mod.getTelefone());
            pst.setInt(5, codigoCidade);
            pst.setInt(6, codigoEstado);
            pst.setString(7, mod.getBairro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Salvos Com Sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar Dados!! \n ERRO:  " + ex);
        }
        ConnFornecedor.desconecta();
    }

    public void Excluir(ModeloFornecedor mod) {
        ConnFornecedor.conexao();
        try {
            PreparedStatement pst = ConnFornecedor.conn.prepareStatement("delete from fornecedores where id_fornecedor = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir o Registro\n ERRO:  " + ex);
        }
        ConnFornecedor.desconecta();

    }

    public void Alterar(ModeloFornecedor mod) {
        AchaCidade(mod.getCodigoCidade());
        AchaEstado(mod.getCodigoEstado());
        ConnFornecedor.conexao();
        try {
            PreparedStatement pst = ConnFornecedor.conn.prepareStatement("update fornecedores set nome_fornecedor=?, endereco_fornecedor=?, cnpj_fornecedor=?,"
                    + " telefone_fornecedor=?, id_cidade=?, id_estado=?, bairro_fornecedor=? where id_fornecedor=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getCnpj());
            pst.setString(4, mod.getTelefone());
            pst.setInt(5, codigoCidade);
            pst.setInt(6, codigoEstado);
            pst.setString(7, mod.getBairro());
            pst.setInt(8, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso !!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar o Registro\n ERRO:  " + ex);
        }
        ConnFornecedor.desconecta();
    }

    public void AchaCidade(String cidade) {
        ConnFornecedor.conexao();

        try {
            ConnFornecedor.executaSQL("select * from cidade where nome_cidade='" + cidade + "'");
            ConnFornecedor.rs.first();
            codigoCidade = ConnFornecedor.rs.getInt("id_cidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar o codigo da cidade! \n ERRO: " + ex);
        }
        ConnFornecedor.desconecta();
    }

    public void AchaEstado(String estado) {
        ConnFornecedor.conexao();

        try {
            ConnFornecedor.executaSQL("select * from estado where sigla_estado='" + estado + "'");
            ConnFornecedor.rs.first();
            codigoEstado = ConnFornecedor.rs.getInt("id_estado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar o codigo do estado! \n ERRO: " + ex);
        }
        ConnFornecedor.desconecta();
    }

}
