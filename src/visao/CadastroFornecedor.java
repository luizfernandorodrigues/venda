/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleFornecedor;
import controle.ModeloTabela;
import controle.Utilitarios;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloFornecedor;

public class CadastroFornecedor extends javax.swing.JFrame {

    ConectaBanco ConnFornecedor = new ConectaBanco();
    ConectaBanco ConnCidade = new ConectaBanco();
    ConectaBanco connEstado = new ConectaBanco();
    ModeloFornecedor mod = new ModeloFornecedor();
    ControleFornecedor control = new ControleFornecedor();
    CadastroCliente cliente = new CadastroCliente();
    Utilitarios util = new Utilitarios();
    int flag = 1;

    public CadastroFornecedor() {
        initComponents();
        ConnFornecedor.conexao();
        preencherCombobox();
        util.Icone(this);

        try {
            MaskFormatter form = new MaskFormatter("##.###.###/####-##");
            txtfCnpj.setFormatterFactory(new DefaultFormatterFactory(form));
            form = new MaskFormatter("(##)####-####");
            txtfTelefone.setFormatterFactory(new DefaultFormatterFactory(form));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Houve um Problema com a Mascara do CNPJ \n ERRO:  " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtfCnpj = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        lblTelefone = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        cbxCidade = new javax.swing.JComboBox();
        btnListarCidade = new javax.swing.JButton();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtfTelefone = new javax.swing.JFormattedTextField();
        lblEstado = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedores");

        lblCodigo.setText("Código:");

        lblNome.setText("Nome:");

        lblEndereco.setText("Endereço:");

        lblCnpj.setText("CNPJ:");

        txtCodigo.setBackground(new java.awt.Color(240, 240, 240));
        txtCodigo.setText(" ");
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(240, 240, 240));
        txtNome.setText(" ");
        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.setEnabled(false);

        txtEndereco.setBackground(new java.awt.Color(240, 240, 240));
        txtEndereco.setText(" ");
        txtEndereco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEndereco.setEnabled(false);

        txtfCnpj.setBackground(new java.awt.Color(240, 240, 240));
        txtfCnpj.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtfCnpj.setEnabled(false);

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFornecedor);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblTelefone.setText("Telefone:");

        cbxEstado.setEnabled(false);

        lblCidade.setText("Cidade:");

        cbxCidade.setEnabled(false);

        btnListarCidade.setText("Listar Cidade");
        btnListarCidade.setEnabled(false);
        btnListarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCidadeActionPerformed(evt);
            }
        });

        lblBairro.setText("Bairro:");

        txtBairro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBairro.setEnabled(false);

        txtfTelefone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtfTelefone.setEnabled(false);

        lblEstado.setText("UF:");

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefone)
                            .addComponent(lblCnpj)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addGap(7, 7, 7)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnSair))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnListarCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(lblBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnpj)
                    .addComponent(txtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarCidade)
                    .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        BotaoNovo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (flag == 1) {
            mod.setNome(txtNome.getText());
            mod.setEndereco(txtEndereco.getText());
            mod.setCnpj(txtfCnpj.getText());
            mod.setTelefone(txtfTelefone.getText());
            mod.setCodigoCidade((String) (cbxCidade.getSelectedItem()));
            mod.setCodigoEstado((String) (cbxEstado.getSelectedItem()));
            mod.setBairro(txtBairro.getText());
            control.Salvar(mod);
            BotaoSalvar();

        } else {
            mod.setId(Integer.parseInt(txtCodigo.getText()));
            mod.setNome(txtNome.getText());
            mod.setEndereco(txtEndereco.getText());
            mod.setCnpj(txtfCnpj.getText());
            mod.setTelefone(txtfTelefone.getText());
            mod.setCodigoCidade((String) (cbxCidade.getSelectedItem()));
            mod.setCodigoEstado((String) (cbxEstado.getSelectedItem()));
            mod.setBairro(txtBairro.getText());
            control.Alterar(mod);
            BotaoSalvar();

        }
        flag = 1;
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        control.Excluir(mod);
        txtCodigo.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtfCnpj.setText("");
        txtBairro.setText("");
        txtfTelefone.setText("");
        cbxCidade.removeAllItems();
        txtEndereco.setEnabled(false);
        txtNome.setEnabled(false);
        txtfCnpj.setEnabled(false);
        txtBairro.setEnabled(false);
        txtfTelefone.setEnabled(false);
        cbxCidade.setEnabled(false);
        cbxEstado.setEnabled(false);
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(!true);
        preencherCombobox();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        flag = 2;
        txtEndereco.setEnabled(true);
        txtNome.setEnabled(true);
        txtfCnpj.setEnabled(true);
        txtBairro.setEnabled(true);
        txtfTelefone.setEnabled(true);
        txtPesquisa.setEnabled(false);
        cbxCidade.setEnabled(true);
        cbxEstado.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnListarCidade.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnExcluir.setEnabled(false);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencherTabela("select * from fornecedores inner join cidade on fornecedores.id_cidade=cidade.id_cidade inner join estado on fornecedores.id_estado=estado.id_estado where fornecedores.nome_fornecedor like '%" + txtPesquisa.getText() + "%' ");
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedorMouseClicked
        String descricaoFornecedor = "" + tblFornecedor.getValueAt(tblFornecedor.getSelectedRow(), 1);
        ConnFornecedor.conexao();
        ConnCidade.conexao();
        connEstado.conexao();

        try {
            ConnFornecedor.executaSQL("select * from fornecedor where nome_fornecedor ='" + descricaoFornecedor + "'");
            ConnFornecedor.rs.first();
            txtCodigo.setText(String.valueOf(ConnFornecedor.rs.getInt("id_fornecedor")));
            txtNome.setText(ConnFornecedor.rs.getString("nome_fornecedor"));
            txtEndereco.setText(ConnFornecedor.rs.getString("endereco_fornecedor"));
            txtfCnpj.setText(ConnFornecedor.rs.getString("cnpj_fornecedor"));
            txtfTelefone.setText(ConnFornecedor.rs.getString("telefone_fornecedor"));
            txtBairro.setText((ConnFornecedor.rs.getString("bairro_fornecedor")));
            ConnCidade.executaSQL("select * from cidade where id_cidade =" + ConnFornecedor.rs.getInt("id_cidade"));
            ConnCidade.rs.first();
            cbxCidade.addItem(ConnCidade.rs.getString("nome_cidade"));
            connEstado.executaSQL("select * from estado where id_estado =" + ConnFornecedor.rs.getInt("id_estado"));
            connEstado.rs.first();
            cbxEstado.setSelectedItem(connEstado.rs.getString("sigla_estado"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel carregar os registros na tela \n ERRO: " + ex);
        }
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tblFornecedorMouseClicked

    private void btnListarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCidadeActionPerformed
        CarregaCidade();
    }//GEN-LAST:event_btnListarCidadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtCodigo.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtfCnpj.setText("");
        txtfTelefone.setText("");
        txtBairro.setText("");
        txtBairro.setEnabled(!true);
        txtfTelefone.setEnabled(!true);
        txtEndereco.setEnabled(!true);
        txtNome.setEnabled(!true);
        txtfCnpj.setEnabled(!true);
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(!true);
        btnListarCidade.setEnabled(!true);
        cbxCidade.setEnabled(!true);
        cbxEstado.setEnabled(!true);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void BotaoNovo() {
        txtCodigo.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtfCnpj.setText("");
        txtfTelefone.setText("");
        txtBairro.setText("");
        txtBairro.setEnabled(true);
        txtfTelefone.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtNome.setEnabled(true);
        txtfCnpj.setEnabled(true);
        btnNovo.setEnabled(!true);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnListarCidade.setEnabled(true);
        cbxCidade.setEnabled(true);
        cbxEstado.setEnabled(true);

    }

    public void BotaoSalvar() {
        txtfCnpj.setEnabled(false);
        txtNome.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtfCnpj.setEnabled(false);
        txtBairro.setEnabled(false);
        txtfTelefone.setEnabled(false);
        cbxCidade.setEnabled(false);
        cbxEstado.setEnabled(false);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(true);
        btnListarCidade.setEnabled(false);
        txtPesquisa.setEnabled(true);

    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"CÓDIGO", "NOME", "CNPJ", "ESTADO", "CIDADE"};

        ConnFornecedor.executaSQL(sql);
        try {
            ConnFornecedor.rs.first();
            do {
                dados.add(new Object[]{ConnFornecedor.rs.getInt("id_fornecedor"), ConnFornecedor.rs.getString("nome_fornecedor"), ConnFornecedor.rs.getString("cnpj_fornecedor"), ConnFornecedor.rs.getString("sigla_estado"), ConnFornecedor.rs.getString("nome_cidade")});
            } while (ConnFornecedor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Contem Fornecedores Cadastrado no Banco de Dados  !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblFornecedor.setModel(modelo);
        tblFornecedor.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblFornecedor.getColumnModel().getColumn(0).setResizable(false);
        tblFornecedor.getColumnModel().getColumn(1).setPreferredWidth(270);
        tblFornecedor.getColumnModel().getColumn(1).setResizable(false);
        tblFornecedor.getColumnModel().getColumn(2).setPreferredWidth(170);
        tblFornecedor.getColumnModel().getColumn(2).setResizable(false);
        tblFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblFornecedor.getColumnModel().getColumn(3).setResizable(false);
        tblFornecedor.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblFornecedor.getColumnModel().getColumn(4).setResizable(false);
        tblFornecedor.getTableHeader().setResizingAllowed(false);
        tblFornecedor.setAutoResizeMode(tblFornecedor.AUTO_RESIZE_OFF);
        tblFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void preencherCombobox() {
        ConnFornecedor.conexao();

        try {
            ConnFornecedor.executaSQL("select * from estado order by sigla_estado");
            ConnFornecedor.rs.first();
            do {
                cbxEstado.addItem(ConnFornecedor.rs.getString("sigla_estado"));
            } while (ConnFornecedor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel carregar os estados !!\n ERRO:  " + ex);
        }
    }

    public void CarregaCidade() {
        ConnFornecedor.conexao();
        cbxCidade.removeAllItems();

        try {
            ConnFornecedor.executaSQL("select * from cidade inner join estado on cidade.id_estado=estado.id_estado where sigla_estado='" + cbxEstado.getSelectedItem() + "'");
            ConnFornecedor.rs.first();
            do {
                cbxCidade.addItem(ConnFornecedor.rs.getString("nome_cidade"));
            } while (ConnFornecedor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Tem Cidade Cadastrada Para Este Estado! Favor Cadastre Uma Cidade\n"
                    + " Para Continuar!!");

        }
    }
   

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
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
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
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtfCnpj;
    private javax.swing.JFormattedTextField txtfTelefone;
    // End of variables declaration//GEN-END:variables
}
