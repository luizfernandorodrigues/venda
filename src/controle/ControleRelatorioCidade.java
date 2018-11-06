/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.ModeloRelatorioCidade;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luizf
 */
public class ControleRelatorioCidade {

    ConectaBanco connRelatorioCidade = new ConectaBanco();
    ModeloRelatorioCidade mod = new ModeloRelatorioCidade();

    public void GeraRelatorioCidade(ModeloRelatorioCidade mod) {
        connRelatorioCidade.conexao();
        try {
            String sql = "SELECT * FROM CIDADE"
                    + " INNER JOIN ESTADO"
                    + " ON CIDADE.ID_ESTADO=ESTADO.ID_ESTADO"
                    + " WHERE ESTADO.SIGLA_ESTADO LIKE '%" + mod.getUfestado() + "%'"
                    + " AND CIDADE.NOME_CIDADE LIKE '%" + mod.getCidade() + "%'"
                    + " AND ESTADO.NOME LIKE '%" + mod.getEstado() + "%'";

            connRelatorioCidade.executaSQL(sql);
            JRResultSetDataSource jrRs = new JRResultSetDataSource(connRelatorioCidade.rs);
            HashMap parametro = new HashMap();
            parametro.put("nome", mod.getUfestado());
            JasperPrint relatorio = JasperFillManager.fillReport("ireport\\ReelatoriodeCidade.jasper", parametro, jrRs);
            JasperViewer.viewReport(relatorio, false);
        } catch (Exception ex) {
            JOptionPane.showInputDialog("ERRO\n" + ex);

        }
    }
}
