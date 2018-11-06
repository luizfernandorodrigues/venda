/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.ModeloRelatorioCliente;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luizf
 */
public class ControleRelatorioCliente {

    ConectaBanco connRelatorio = new ConectaBanco();
    ModeloRelatorioCliente mod = new ModeloRelatorioCliente();

    public void RelatorioCliente(ModeloRelatorioCliente mod) {
        connRelatorio.conexao();
        try {
            String sql = "select * from clientes"
                    + " inner join cidade on clientes.id_cidade = cidade.id_cidade"
                    + " inner join estado on cidade.id_estado = estado.id_estado"
                    + " where nome_cliente like '%" + mod.getNomeCliente() + "%'"
                    + " and cidade.nome_cidade like '%" + mod.getNomeCidade() + "%'";

            connRelatorio.executaSQL(sql);
            JRResultSetDataSource jrRs = new JRResultSetDataSource(connRelatorio.rs);
            HashMap parametro = new HashMap();
            parametro.put("nome", mod.getNomeCliente());
            JasperPrint relatorio = JasperFillManager.fillReport("ireport\\RelatorioCliente.jasper", parametro, jrRs);
            JasperViewer.viewReport(relatorio, false);
        } catch (Exception ex) {
            JOptionPane.showInputDialog("ERRO\n" + ex);

        }
    }
}
