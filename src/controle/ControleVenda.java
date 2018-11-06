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
import modelo.ModeloVenda;

public class ControleVenda {

    int codProduto, codCliente;
    ConectaBanco connVenda = new ConectaBanco();

    public void AdicionaItem(ModeloVenda mod) {
        AchaCodProduto(mod.getNomeProduto());
        connVenda.conexao();
        try {
            PreparedStatement pst = connVenda.conn.prepareStatement("insert into itens_venda_produto (id_venda, id_produto, quantidade_produto) values (?,?,?)");
            pst.setInt(1, mod.getIdvenda());
            pst.setInt(2, codProduto);
            pst.setInt(3, mod.getQuantidadedoItem());
            pst.execute();

            // baixa estoque
            int qtdEstoque = 0, resultado = 0;
            connVenda.executaSQL("select * from produto where nome_produto='" + mod.getNomeProduto() + "'");
            connVenda.rs.first();
            qtdEstoque = connVenda.rs.getInt("quantidade");
            resultado = qtdEstoque - mod.getQuantidadedoItem();
            pst = connVenda.conn.prepareStatement("update produto set quantidade=? where nome_produto=?");
            pst.setInt(1, resultado);
            pst.setString(2, mod.getNomeProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "produto adicionado!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Produto!! \n ERRO:  " + ex);
        }
        //connVenda.desconecta();

    }

    public void AchaCodProduto(String nome) {
        connVenda.conexao();

        try {
            connVenda.executaSQL("select * from produto where nome_produto ='" + nome + "'");
            connVenda.rs.first();
            codProduto = connVenda.rs.getInt("id_produto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Codigo!! \n ERRO:  " + ex);
        }

        connVenda.desconecta();

    }

    public void FechaVenda(ModeloVenda mod) {
        AchaCodCliente(mod.getNomeCliente());
        connVenda.conexao();

        try {
            PreparedStatement pst = connVenda.conn.prepareStatement("update venda set data_venda=?, valor_venda=?, id_cliente=?, tipo_pagamento =? where id_venda= ?");
            pst.setString(1, mod.getData());
            pst.setFloat(2, mod.getValorVenda());
            pst.setInt(3, codCliente);
            pst.setString(4, mod.getPagamento());
            pst.setInt(5, mod.getIdvenda());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda Finalizada com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Finalizar Venda !! \n ERRO:  " + ex);
        }
    }

    public void AchaCodCliente(String nome) {
        connVenda.conexao();

        try {
            connVenda.executaSQL("select * from clientes where nome_cliente='" + nome + "'");
            connVenda.rs.first();
            codCliente = connVenda.rs.getInt("id_cliente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Codigo!! \n ERRO:  " + ex);
        }

    }

    public void CancelaVenda() {
        connVenda.conexao();
        PreparedStatement pst;
        connVenda.executaSQL("select * from venda inner join itens_venda_produto on venda.id_venda= itens_venda_produto.id_venda inner join produto on itens_venda_produto.id_produto=produto.id_produto where venda.valor_venda=0");

        try {
            connVenda.rs.first();
            do {
                int qtdProduto = connVenda.rs.getInt("quantidade");
                int qtdVendida = connVenda.rs.getInt("quantidade_produto");
                int soma = qtdProduto + qtdVendida;
                pst = connVenda.conn.prepareStatement("update produto set quantidade = ? where id_produto = ?");
                pst.setInt(1, soma);
                pst.setInt(2, connVenda.rs.getInt("id_produto"));
                pst.execute();
                pst = connVenda.conn.prepareStatement("delete from itens_venda_produto where id_venda =?");
                pst.setInt(1, connVenda.rs.getInt("id_venda"));
                pst.execute();
            } while (connVenda.rs.next());
            pst = connVenda.conn.prepareStatement("delete from venda where valor_venda =? ");
            pst.setInt(1, 0);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cancelar Venda!!\n ERRO:  " + ex);
        }
        connVenda.desconecta();

    }

}
