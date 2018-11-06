package visao;

import controle.ConectaBanco;
import controle.ModeloTabela;
import controle.Utilitarios;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class PesquisaVenda extends javax.swing.JFrame {

    ConectaBanco connPesquisa = new ConectaBanco();
    Utilitarios util = new Utilitarios();

    public PesquisaVenda() {
        initComponents();
        util.Icone(this);
        try {
            MaskFormatter form = new MaskFormatter("##/##/####");
            txtfData.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro de Mascara !! \n ERRO:  " + ex);
        }
    }

    public void PreencherTablea(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"CÓDIGO", "DATA", "VALOR", "CLIENTE"};
        connPesquisa.conexao();

        connPesquisa.executaSQL(sql);
        try {
            connPesquisa.rs.first();
            do {
                dados.add(new Object[]{connPesquisa.rs.getInt("id_venda"), connPesquisa.rs.getString("data_venda"), connPesquisa.rs.getFloat("valor_venda"), connPesquisa.rs.getString("nome_cliente")});
            } while (connPesquisa.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Contem Venda Cadastrada no Banco de Dados  !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblvendas.setModel(modelo);
        tblvendas.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblvendas.getColumnModel().getColumn(0).setResizable(false);
        tblvendas.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblvendas.getColumnModel().getColumn(1).setResizable(false);
        tblvendas.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblvendas.getColumnModel().getColumn(2).setResizable(false);
        tblvendas.getColumnModel().getColumn(3).setPreferredWidth(308);
        tblvendas.getColumnModel().getColumn(3).setResizable(false);
        tblvendas.getTableHeader().setResizingAllowed(false);
        tblvendas.setAutoResizeMode(tblvendas.AUTO_RESIZE_OFF);
        tblvendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void PreencherTabelaDetalhes(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"PRODUTO", "QUANTIDADE"};
        connPesquisa.conexao();

        connPesquisa.executaSQL(sql);
        try {
            connPesquisa.rs.first();
            do {
                dados.add(new Object[]{connPesquisa.rs.getString("nome_produto"), connPesquisa.rs.getInt("quantidade_produto")});
            } while (connPesquisa.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "erro ao carregar itens !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblDetalhes.setModel(modelo);
        tblDetalhes.getColumnModel().getColumn(0).setPreferredWidth(300);
        tblDetalhes.getColumnModel().getColumn(0).setResizable(false);
        tblDetalhes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblDetalhes.getColumnModel().getColumn(1).setResizable(false);
        tblDetalhes.getTableHeader().setResizingAllowed(false);
        tblDetalhes.setAutoResizeMode(tblDetalhes.AUTO_RESIZE_OFF);
        tblDetalhes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDataVenda = new javax.swing.JLabel();
        txtfData = new javax.swing.JFormattedTextField();
        btnPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblvendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalhes = new javax.swing.JTable();
        lblVendasRealizadas = new javax.swing.JLabel();
        lblDetalhesVenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Pesquisa Venda");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDataVenda.setText("Data da Venda:");

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        tblvendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblvendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblvendas);

        tblDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDetalhes);

        lblVendasRealizadas.setText("Vendas Realizadas");

        lblDetalhesVenda.setText("Detalhes da Venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDataVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnPesquisa))
                            .addComponent(lblVendasRealizadas)
                            .addComponent(lblDetalhesVenda))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataVenda)
                    .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVendasRealizadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDetalhesVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        PreencherTablea("select * from venda inner join clientes on venda.id_cliente=clientes.id_cliente where data_venda='" + txtfData.getText() + "'");
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void tblvendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvendasMouseClicked
        int cod = (int) tblvendas.getValueAt(tblvendas.getSelectedRow(), 0);
        PreencherTabelaDetalhes("select * from venda inner join itens_venda_produto on venda.id_venda=itens_venda_produto.id_venda inner join produto on itens_venda_produto.id_produto=produto.id_produto where venda.id_venda=" + cod);

    }//GEN-LAST:event_tblvendasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblDetalhesVenda;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVendasRealizadas;
    private javax.swing.JTable tblDetalhes;
    private javax.swing.JTable tblvendas;
    private javax.swing.JFormattedTextField txtfData;
    // End of variables declaration//GEN-END:variables
}
