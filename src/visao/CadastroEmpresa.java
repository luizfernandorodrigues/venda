/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleEmpresa;
import controle.Utilitarios;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloEmpresa;

/**
 *
 * @author luizf
 */
public class CadastroEmpresa extends javax.swing.JFrame {

    ModeloEmpresa mod = new ModeloEmpresa();
    ControleEmpresa control = new ControleEmpresa();
    ConectaBanco ConnEmpresa = new ConectaBanco();
    int flag = 1;
    Utilitarios util = new Utilitarios();

    public CadastroEmpresa() {
        initComponents();
        CarregaEstado();
        util.Icone(this);
        try {
            MaskFormatter form = new MaskFormatter("##.###.###/####-##");
            txtfCnpj.setFormatterFactory(new DefaultFormatterFactory(form));
            form = new MaskFormatter("(##)####-####");
            txtfTelefone.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na Formatação dos Campos !!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        txtfCnpj = new javax.swing.JFormattedTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtfTelefone = new javax.swing.JFormattedTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        cbxCidade = new javax.swing.JComboBox();
        btnListarCidade = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblIscricao = new javax.swing.JLabel();
        txtInscricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresa = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empresa");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Codigo:");

        txtCodigo.setEnabled(false);

        lblNome.setText("Nome:");

        txtNome.setEnabled(false);

        lblCnpj.setText("CNPJ:");

        txtfCnpj.setEnabled(false);

        lblEndereco.setText("Endereço:");

        txtEndereco.setEnabled(false);

        lblTelefone.setText("Telefone:");

        txtfTelefone.setEnabled(false);

        lblBairro.setText("Bairro:");

        txtBairro.setEnabled(false);

        lblEstado.setText("UF:");

        cbxEstado.setEnabled(false);

        lblCidade.setText("Cidade:");

        cbxCidade.setEnabled(false);

        btnListarCidade.setText("ListarCidade");
        btnListarCidade.setEnabled(false);
        btnListarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCidadeActionPerformed(evt);
            }
        });

        lblEmail.setText("Email:");

        txtEmail.setEnabled(false);

        lblIscricao.setText("Incrição Estadual:");

        txtInscricao.setEnabled(false);

        tblEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEmpresa);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail)
                    .addComponent(lblEstado)
                    .addComponent(lblTelefone)
                    .addComponent(lblCnpj)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfCnpj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEndereco)
                            .addComponent(lblBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco)
                            .addComponent(txtBairro)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListarCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIscricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInscricao))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addGap(6, 6, 6))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnpj)
                    .addComponent(txtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefone)
                        .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBairro)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEstado)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListarCidade)
                        .addComponent(lblCidade))
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIscricao)
                    .addComponent(txtInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(610, 356));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtBairro.setEnabled(true);
        txtEmail.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtInscricao.setEnabled(true);
        txtNome.setEnabled(true);
        txtPesquisar.setEnabled(false);
        txtfCnpj.setEnabled(true);
        txtfTelefone.setEnabled(true);
        txtBairro.setText("");
        txtCodigo.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtInscricao.setText("");
        txtNome.setText("");
        txtfCnpj.setText("");
        txtfTelefone.setText("");
        cbxCidade.setEnabled(true);
        cbxEstado.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnListarCidade.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (flag == 1) {
            mod.setBairroEmpresa(txtBairro.getText());
            mod.setCidadeEmpresa((String) cbxCidade.getSelectedItem());
            mod.setCnpjEmpresa(txtfCnpj.getText());
            mod.setEmailEmpresa(txtEmail.getText());
            mod.setEnderecoEmpresa(txtEndereco.getText());
            mod.setEstadoEmpresa((String) cbxEstado.getSelectedItem());
            mod.setInscricaoEmpresa(txtInscricao.getText());
            mod.setNomeEmpresa(txtNome.getText());
            mod.setTelefoneEmpresa(txtfTelefone.getText());
            control.Salvar(mod);
        } else {
            mod.setIdEmpresa(Integer.parseInt(txtCodigo.getText()));
            mod.setBairroEmpresa(txtBairro.getText());
            mod.setCidadeEmpresa((String) cbxCidade.getSelectedItem());
            mod.setCnpjEmpresa(txtfCnpj.getText());
            mod.setEmailEmpresa(txtEmail.getText());
            mod.setEnderecoEmpresa(txtEndereco.getText());
            mod.setEstadoEmpresa((String) cbxEstado.getSelectedItem());
            mod.setInscricaoEmpresa(txtInscricao.getText());
            mod.setNomeEmpresa(txtNome.getText());
            mod.setTelefoneEmpresa(txtfTelefone.getText());
        }
        flag = 1;
        txtBairro.setEnabled(!true);
        txtEmail.setEnabled(!true);
        txtEndereco.setEnabled(!true);
        txtInscricao.setEnabled(!true);
        txtNome.setEnabled(!true);
        txtPesquisar.setEnabled(!false);
        txtfCnpj.setEnabled(!true);
        txtfTelefone.setEnabled(!true);
        cbxCidade.setEnabled(!true);
        cbxEstado.setEnabled(!true);
        btnEditar.setEnabled(!false);
        btnExcluir.setEnabled(!false);
        btnNovo.setEnabled(!false);
        btnPesquisar.setEnabled(!false);
        btnSalvar.setEnabled(true);
        btnListarCidade.setEnabled(!true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtBairro.setEnabled(true);
        txtEmail.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtInscricao.setEnabled(true);
        txtNome.setEnabled(true);
        txtPesquisar.setEnabled(false);
        txtfCnpj.setEnabled(true);
        txtfTelefone.setEnabled(true);
        cbxCidade.setEnabled(true);
        cbxEstado.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnListarCidade.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        mod.setIdEmpresa(Integer.parseInt(txtCodigo.getText()));
        mod.setBairroEmpresa(txtBairro.getText());
        mod.setCidadeEmpresa((String) cbxCidade.getSelectedItem());
        mod.setCnpjEmpresa(txtfCnpj.getText());
        mod.setEmailEmpresa(txtEmail.getText());
        mod.setEnderecoEmpresa(txtEndereco.getText());
        mod.setEstadoEmpresa((String) cbxEstado.getSelectedItem());
        mod.setInscricaoEmpresa(txtInscricao.getText());
        mod.setNomeEmpresa(txtNome.getText());
        mod.setTelefoneEmpresa(txtfTelefone.getText());
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnListarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCidadeActionPerformed
        CarregaCidade();
    }//GEN-LAST:event_btnListarCidadeActionPerformed

    public void CarregaEstado() {
        ConnEmpresa.conexao();
        cbxEstado.removeAllItems();

        try {
            ConnEmpresa.executaSQL("select * from estado order by sigla_estado");
            ConnEmpresa.rs.first();
            do {
                cbxEstado.addItem(ConnEmpresa.rs.getString("sigla_estado"));
            } while (ConnEmpresa.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Foi Possivel Carregar os Estados!!");
        }

    }

    public void CarregaCidade() {
        ConnEmpresa.conexao();
        cbxCidade.removeAllItems();

        try {
            ConnEmpresa.executaSQL("select * from cidade inner join estado on cidade.id_estado=estado.id_estado where sigla_estado='" + cbxEstado.getSelectedItem() + "'");
            ConnEmpresa.rs.first();
            do {
                cbxCidade.addItem(ConnEmpresa.rs.getString("nome_cidade"));
            } while (ConnEmpresa.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Tem Cidade Cadastrada Para Este Estado! Favor Cadastre Uma Cidade\n"
                    + " Para Continuar!!");

        }

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
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListarCidade;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIscricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable tblEmpresa;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtInscricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JFormattedTextField txtfCnpj;
    private javax.swing.JFormattedTextField txtfTelefone;
    // End of variables declaration//GEN-END:variables
}