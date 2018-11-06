/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleParcela;
import controle.ModeloTabela;
import controle.Utilitarios;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ModeloParcela;

public class CadastroParcelas extends javax.swing.JFrame {

    ConectaBanco connParcela = new ConectaBanco();
    ModeloParcela mod = new ModeloParcela();
    ControleParcela control = new ControleParcela();
    Utilitarios util = new Utilitarios();
    int qtdParcela;
    float porcentagem;
    float valorVenda;
    float valorParcela;
    int i = 1;
    int cont = 1;

    // pega os dados da venda quando for parcelado e carrega nos campos da tela de parcela 
    public CadastroParcelas(int cod) {
        initComponents();
        util.Icone(this);
        connParcela.conexao();
        connParcela.executaSQL("select * from venda where id_venda=" + cod);
        try {
            connParcela.rs.first();
            txtCodigoVenda.setText(String.valueOf(cod));
            txtValor.setText(String.valueOf(connParcela.rs.getFloat("valor_venda")));
            txtfData.setText(connParcela.rs.getString("data_venda"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na Busca da Venda! \n ERRO: " + ex);
        }
    }

    private CadastroParcelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCodigoVenda = new javax.swing.JLabel();
        txtCodigoVenda = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        txtfData = new javax.swing.JFormattedTextField();
        lblParcela = new javax.swing.JLabel();
        txtParcela = new javax.swing.JTextField();
        lblJuros = new javax.swing.JLabel();
        txtJuros = new javax.swing.JTextField();
        btnGeraParcelas = new javax.swing.JButton();
        btnGeraDuplicatas = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParcela = new javax.swing.JTable();
        lblValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblTitulo.setText("Parcelamento de Venda");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigoVenda.setText("Código da Venda:");

        lblValor.setText("Valor:");

        lblData.setText("Data:");

        lblParcela.setText("Parcela:");

        lblJuros.setText("Juros Parcela %:");

        btnGeraParcelas.setText("Gerar Parcelas");
        btnGeraParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeraParcelasActionPerformed(evt);
            }
        });

        btnGeraDuplicatas.setText("Gera Duplicatas");
        btnGeraDuplicatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeraDuplicatasActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tblParcela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblParcela);

        lblValorTotal.setText("Valor Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblParcela)
                            .addComponent(lblCodigoVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblJuros))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblValorTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGeraParcelas)
                        .addGap(135, 135, 135)
                        .addComponent(btnGeraDuplicatas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoVenda)
                    .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData)
                    .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParcela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJuros)
                    .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeraParcelas)
                    .addComponent(btnGeraDuplicatas)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGeraParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeraParcelasActionPerformed

        qtdParcela = Integer.parseInt(txtParcela.getText());
        porcentagem = Float.parseFloat(txtJuros.getText());
        valorVenda = Float.parseFloat(txtValor.getText());
        valorParcela = valorVenda / qtdParcela;
        preencherTabela();


    }//GEN-LAST:event_btnGeraParcelasActionPerformed

    private void btnGeraDuplicatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeraDuplicatasActionPerformed
        int j = 1;
        String dataVenda = txtfData.getText();
        String dia, mes, ano;
        dia = "" + dataVenda.charAt(0) + dataVenda.charAt(1) + "/";
        mes = "" + dataVenda.charAt(3) + dataVenda.charAt(4);
        ano = "/" + dataVenda.charAt(6) + dataVenda.charAt(7) + dataVenda.charAt(8) + dataVenda.charAt(9);
        int anoInteiro = Integer.parseInt("" + dataVenda.charAt(6) + dataVenda.charAt(7) + dataVenda.charAt(8) + dataVenda.charAt(9));
        int mesInteiro = Integer.parseInt(mes);
        while (j < cont) {
            if (mesInteiro < 10) {
                mod.setCodigo(Integer.parseInt(txtCodigoVenda.getText()));
                mod.setValorParcela(valorParcela + (valorParcela * (porcentagem / 100)));
                mod.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
                mod.setValorVenda(Float.parseFloat(txtValor.getText()));
                mod.setNumeroParcela(j);
                mod.setDataVencimento(dia + "0" + mesInteiro + "/" + anoInteiro);
                control.SalvarParcela(mod);
            } else {
                mod.setCodigo(Integer.parseInt(txtCodigoVenda.getText()));
                mod.setValorParcela(valorParcela + (valorParcela * (porcentagem / 100)));
                mod.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
                mod.setValorVenda(Float.parseFloat(txtValor.getText()));
                mod.setNumeroParcela(j);
                mod.setDataVencimento(dia + mesInteiro + "/" + anoInteiro);
                control.SalvarParcela(mod);

            }
            mesInteiro++;
            if (mesInteiro > 12) {
                anoInteiro++;
                mesInteiro = 1;
            }
            j++;
        }
        JOptionPane.showMessageDialog(rootPane, "Parcelas Geradas Com Sucesso !!");
    }//GEN-LAST:event_btnGeraDuplicatasActionPerformed
    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"CÓDIGO", "VENCIMENTO", "VALOR"};
        float valorAtualizadoParcela, valorTotal = 0;
        String data = txtfData.getText();
        String dia, mes, ano;
        dia = "" + data.charAt(0) + data.charAt(1) + "/";
        mes = "" + data.charAt(3) + data.charAt(4);
        ano = "/" + data.charAt(6) + data.charAt(7) + data.charAt(8) + data.charAt(9);
        valorAtualizadoParcela = valorParcela + (valorParcela * (porcentagem / 100));
        int anoInt = Integer.parseInt("" + data.charAt(6) + data.charAt(7) + data.charAt(8) + data.charAt(9));
        int mesInt = Integer.parseInt(mes);

        while (i <= qtdParcela) {
            valorTotal = valorTotal + valorAtualizadoParcela;
            if (mesInt < 10) {
                dados.add(new Object[]{i, dia + "0" + mesInt + "/" + anoInt, valorAtualizadoParcela});
            } else {
                dados.add(new Object[]{i, dia + mesInt + "/" + anoInt, valorAtualizadoParcela});
            }
            mesInt++;
            if (mesInt > 12) {
                anoInt++;
                mesInt = 1;
            }
            i++;
            cont++;
        }
        txtValorTotal.setText(String.valueOf(valorTotal));

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblParcela.setModel(modelo);
        tblParcela.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblParcela.getColumnModel().getColumn(0).setResizable(false);
        tblParcela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblParcela.getColumnModel().getColumn(1).setResizable(false);
        tblParcela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblParcela.getColumnModel().getColumn(2).setResizable(false);
        tblParcela.getTableHeader().setResizingAllowed(false);
        tblParcela.setAutoResizeMode(tblParcela.AUTO_RESIZE_OFF);
        tblParcela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

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
            java.util.logging.Logger.getLogger(CadastroParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroParcelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeraDuplicatas;
    private javax.swing.JButton btnGeraParcelas;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoVenda;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblJuros;
    private javax.swing.JLabel lblParcela;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblParcela;
    private javax.swing.JTextField txtCodigoVenda;
    private javax.swing.JTextField txtJuros;
    private javax.swing.JTextField txtParcela;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtfData;
    // End of variables declaration//GEN-END:variables
}
