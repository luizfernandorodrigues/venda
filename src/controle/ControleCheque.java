/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCheque;

/**
 *
 * @author luizf
 */
public class ControleCheque {

    ConectaBanco connCheque = new ConectaBanco();
    ModeloCheque mod = new ModeloCheque();
    Utilitarios util = new Utilitarios();
    int codCli = 0;

    public void inserir(ModeloCheque mod) {
        connCheque.conexao();
        codCli = util.achaCliente(mod.getIdCliente());
        try {
            PreparedStatement pst = connCheque.conn.prepareStatement("INSERT INTO CHEQUE (NUMERO_CHEQUE,STATUS_CHEQUE,ID_CLIENTE,VALOR_CHEQUE,"
                    + "NOME_TERCEIRO,OBSERVACOES_CHEQUE,VENCIMENTO_CHEQUE,BANCO_CHEQUE,AGENCIA_CHEQUE,CONTA_CHEQUE,EMISSAO) VALUES(?,?,?,?,?,"
                    + "?,?,?,?,?,?)");
            pst.setInt(1, mod.getNumeroCheque());
            pst.setString(2, mod.getStatusCheque());
            pst.setInt(3, codCli);
            pst.setDouble(4, mod.getValorCheque());
            pst.setString(5, mod.getNomeTerceiro());
            pst.setString(6, mod.getObservacaoCheuque());
            pst.setString(7, mod.getVencimentoCheque());
            pst.setString(8, mod.getBancoCheque());
            pst.setString(9, mod.getAgenciaCheque());
            pst.setString(10, mod.getContaCheque());
            pst.setString(11, mod.getEmissaoCheque());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Gravado Com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivel Gravar o Registro!\n" + ex);

        }
        connCheque.desconecta();
    }

    public void excluirCheque(ModeloCheque mod) {
        connCheque.conexao();
        try {
            PreparedStatement pst = connCheque.conn.prepareStatement("DELETE FROM CHEQUE WHERE ID_CHEQUE = ?");
            pst.setInt(1, mod.getIdCheque());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Excluido Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Excluir o Registro!!\n" + ex);
        }
        connCheque.desconecta();
    }

    public void alterar(ModeloCheque mod) {
        connCheque.conexao();
        codCli = util.achaCliente(mod.getIdCliente());

        try {
            PreparedStatement pst = connCheque.conn.prepareStatement("UPDATE CHEQUE SET NUMERO_CHEQUE=?, STATUS_CHEQUE=?, ID_CLIENTE=?, VALOR_CHEQUE=?,"
                    + " NOME_TERCEIRO=?, OBSERVACOES_CHEQUE=?, VENCIMENTO_CHEQUE=?, BANCO_CHEQUE=?, AGENCIA_CHEQUE=?, CONTA_CHEQUE=? WHERE ID_CHEQUE=?");
            pst.setInt(1, mod.getNumeroCheque());
            pst.setString(2, mod.getStatusCheque());
            pst.setInt(3, codCli);
            pst.setDouble(4, mod.getValorCheque());
            pst.setString(5, mod.getNomeTerceiro());
            pst.setString(6, mod.getObservacaoCheuque());
            pst.setString(7, mod.getVencimentoCheque());
            pst.setString(8, mod.getBancoCheque());
            pst.setString(9, mod.getAgenciaCheque());
            pst.setString(10, mod.getContaCheque());
            pst.setInt(11, mod.getIdCheque());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Alterar o Registro!!\n" + ex);
        }
        connCheque.desconecta();
    }
}
