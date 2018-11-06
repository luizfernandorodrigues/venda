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
import modelo.ModeloProduto;

public class ControleProduto {

    ModeloProduto mod = new ModeloProduto();
    ConectaBanco connProduto = new ConectaBanco();
    ConectaBanco connFornecedor = new ConectaBanco();
    int codFornecedor;
    String nomeFornecedor;

    public void Salvar(ModeloProduto mod) {
        buscaCodigo(mod.getFornecedor());
        connProduto.conexao();

        try {
            PreparedStatement pst = connProduto.conn.prepareStatement("insert into produto (nome_produto, preco_compra, preco_venda, quantidade, id_fornecedor)values (?,?,?,?,?)");
            pst.setString(1, mod.getProduto());
            pst.setFloat(2, mod.getPrecoCompra());
            pst.setFloat(3, mod.getPrecoVenda());
            pst.setInt(4, mod.getQuantidade());
            pst.setInt(5, codFornecedor);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar os Dados!! \n ERRO:  " + ex);
        }

    }

    public void Editar(ModeloProduto mod) {
        buscaCodigo(mod.getFornecedor());
        connProduto.conexao();
        try {
            PreparedStatement pst = connProduto.conn.prepareStatement("update produto set nome_produto=?, preco_compra=?, preco_venda=?, quantidade=?, id_fornecedor=? where id_produto=? ");
            pst.setString(1, mod.getProduto());
            pst.setFloat(2, mod.getPrecoCompra());
            pst.setFloat(3, mod.getPrecoVenda());
            pst.setInt(4, mod.getQuantidade());
            pst.setInt(5, codFornecedor);
            pst.setInt(6, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Alteração de Dados!!\n ERRO:  " + ex);
        }
        connProduto.desconecta();
    }

    public void Excluir(ModeloProduto mod) {
        connProduto.conexao();
        try {
            PreparedStatement pst = connProduto.conn.prepareStatement("delete from produto where id_produto= ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Exclusão do Registro!! \n ERRO:  " + ex);
        }

        connProduto.desconecta();

    }

    public void buscaCodigo(String nome) {
        connProduto.conexao();

        try {
            connProduto.executaSQL("select * from fornecedores where nome_fornecedor='" + nome + "'");
            connProduto.rs.first();
            codFornecedor = connProduto.rs.getInt("id_fornecedor");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Busca o Código do Fornecedor!!\n ERRO: " + ex);
        }
        connProduto.desconecta();
    }

    public ModeloProduto buscaProduto(ModeloProduto modelo) {
        connProduto.conexao();

        try {
            connProduto.executaSQL("select * from produto where nome_produto like '%" + modelo.getPesquisa() + "%'");
            connProduto.rs.first();
            buscaFornecedor(connProduto.rs.getInt("id_fornecedor"));
            mod.setId(connProduto.rs.getInt("id_produto"));
            mod.setProduto(connProduto.rs.getString("nome_produto"));
            mod.setPrecoCompra(connProduto.rs.getFloat("preco_compra"));
            mod.setPrecoVenda(connProduto.rs.getFloat("preco_venda"));
            mod.setQuantidade(connProduto.rs.getInt("quantidade"));
            mod.setFornecedor(nomeFornecedor);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto!! \n ERRO:  " + ex);
        }
        connProduto.desconecta();
        return mod;
    }

    public void buscaFornecedor(int cod) {
        connFornecedor.conexao();

        try {
            connFornecedor.executaSQL("select * from fornecedores where id_fornecedor =" + cod + "");
            connFornecedor.rs.first();
            nomeFornecedor = connFornecedor.rs.getString("nome_fornecedor");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Nome do Fornecedor!!\n ERRO:  " + ex);
        }

    }

}
