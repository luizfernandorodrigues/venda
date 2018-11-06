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
import modelo.ModeloBaixaTitulo;

/**
 *
 * @author jmtis
 */
public class ControleBaixaTitulo {

    ConectaBanco connBaixa = new ConectaBanco();

    public ModeloBaixaTitulo BuscaParcela(ModeloBaixaTitulo mod) {
        connBaixa.conexao();

        try {
            connBaixa.executaSQL("select * from parcela_venda where id_parcela_venda=" + mod.getCodParcela());
            connBaixa.rs.first();
            mod.setCodParcela(connBaixa.rs.getInt("id_parcela_venda"));
            mod.setCodVenda(connBaixa.rs.getInt("cod_venda"));
            mod.setDataVencimento(connBaixa.rs.getString("data_parcela_venda"));
            mod.setValorVenda(connBaixa.rs.getFloat("valor_parcela"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Carregar o Registro!\n ERRO:  " + ex);
        }
        return mod;

    }

    public void BaixarParcela(ModeloBaixaTitulo mod) {
        connBaixa.conexao();
        connBaixa.executaSQL("select * from parcela_venda where id_parcela_venda=" + mod.getCodParcela() + " and estado='PG'");
        try {
            if (connBaixa.rs.first()) {
                JOptionPane.showMessageDialog(null, "Parcela Esta Quitada!!");

            } else {

                try {
                    PreparedStatement pst = connBaixa.conn.prepareStatement("update parcela_venda set estado=? where id_parcela_venda=?");
                    pst.setString(1, "PG");
                    pst.setInt(2, mod.getCodParcela());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Parcela Baixada com Sucesso!!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Baixar Parcela!!\n ERRO:  " + ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleBaixaTitulo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
