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
import modelo.ModeloParcela;

/**
 *
 * @author jmtis
 */
public class ControleParcela {

    ConectaBanco connParcela = new ConectaBanco();
    ModeloParcela mod = new ModeloParcela();

    public void SalvarParcela(ModeloParcela mod) {
        connParcela.conexao();
        try {
            PreparedStatement pst = connParcela.conn.prepareStatement("insert into parcela_venda (cod_venda,valor_venda,valor_total,valor_parcela,numero_parcela,data_parcela_venda)values(?,?,?,?,?,?)");
            pst.setInt(1, mod.getCodigo());
            pst.setFloat(2, mod.getValorVenda());
            pst.setFloat(3, mod.getValorTotal());
            pst.setFloat(4, mod.getValorParcela());
            pst.setInt(5, mod.getNumeroParcela());
            pst.setString(6, mod.getDataVencimento());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar Parcelas!!\n ERRO:  " + ex);
        }

    }

}
