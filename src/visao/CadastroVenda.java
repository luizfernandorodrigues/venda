package visao;

import controle.ConectaBanco;
import controle.ControleVenda;
import controle.ModeloTabela;
import controle.Utilitarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.ModeloVenda;

public class CadastroVenda extends javax.swing.JFrame {

    ConectaBanco connVenda = new ConectaBanco();
    int flag = 1;
    int codVenda, qtdEstoque;
    float preco_produto, total = 0;
    ModeloVenda mod = new ModeloVenda();
    controle.ControleVenda control = new ControleVenda();
    Utilitarios util = new Utilitarios();
    

    public CadastroVenda() {
        initComponents();
        connVenda.conexao();
        util.Icone(this);
        

        // pega hora do computador
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        txtfData.setText(df.format(hoje));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnPesquisaCliente = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        txtfData = new javax.swing.JFormattedTextField();
        lblNomeProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnPesquisaProduto = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblValorUnitario = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensVenda = new javax.swing.JTable();
        lblRegistroPesquisa = new javax.swing.JLabel();
        lblItensVenda = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnFechaVenda = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAdicionaItem = new javax.swing.JButton();
        lblPagamento = new javax.swing.JLabel();
        cbxPagamento = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Vendas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNomeCliente.setText("Nome Cliente:");

        txtCliente.setEnabled(false);

        btnPesquisaCliente.setText("Pesquisa");
        btnPesquisaCliente.setEnabled(false);
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        lblData.setText("Data:");

        txtfData.setEnabled(false);

        lblNomeProduto.setText("Produto:");

        txtProduto.setEnabled(false);
        txtProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdutoFocusGained(evt);
            }
        });

        btnPesquisaProduto.setText("Pesquisa");
        btnPesquisaProduto.setEnabled(false);
        btnPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade:");

        txtQuantidade.setEnabled(false);
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusGained(evt);
            }
        });

        lblValorUnitario.setText("Valor Unitário:");

        txtValorUnitario.setEnabled(false);

        tblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisa);

        tblItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblItensVenda);

        lblRegistroPesquisa.setText("Registro da Pesquisa:");

        lblItensVenda.setText("Itens da Venda:");

        lblValorTotal.setText("Valor Total:");

        txtValorTotal.setEnabled(false);

        btnNovo.setText("Nova Venda");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancela");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnFechaVenda.setText("Fecha Venda");
        btnFechaVenda.setEnabled(false);
        btnFechaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaVendaActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAdicionaItem.setText("Adiciona Item:");
        btnAdicionaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaItemActionPerformed(evt);
            }
        });

        lblPagamento.setText("Cond.Pagamento:");

        cbxPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A Vista", "Parcelado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechaVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNomeCliente)
                                        .addGap(360, 360, 360)
                                        .addComponent(lblData)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPesquisaProduto)
                                        .addGap(19, 19, 19)
                                        .addComponent(lblQuantidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(lblValorUnitario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisaCliente)
                                .addGap(18, 18, 18)
                                .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNomeProduto)
                            .addComponent(lblRegistroPesquisa)
                            .addComponent(lblItensVenda)
                            .addComponent(btnAdicionaItem))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaCliente)
                    .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(lblNomeProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaProduto)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorUnitario)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnAdicionaItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegistroPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblItensVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(btnCancela)
                    .addComponent(btnFechaVenda)
                    .addComponent(btnSair)
                    .addComponent(lblPagamento)
                    .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtCliente.setEnabled(true);
        txtProduto.setEnabled(true);
        txtQuantidade.setEnabled(true);
        txtValorTotal.setEnabled(true);
        txtValorUnitario.setEnabled(true);
        txtfData.setEnabled(!true);
        txtCliente.setText("");
        txtProduto.setText("");
        txtQuantidade.setText("");
        txtValorTotal.setText("");
        txtValorUnitario.setText("");
        btnFechaVenda.setEnabled(true);
        btnNovo.setEnabled(false);
        btnPesquisaCliente.setEnabled(true);
        btnPesquisaProduto.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        connVenda.conexao();
        try {
            PreparedStatement pst = connVenda.conn.prepareStatement("insert into venda (valor_venda) values (?)");
            pst.setFloat(1, 0);
            pst.execute();

            connVenda.executaSQL("select * from venda");
            connVenda.rs.last();
            codVenda = connVenda.rs.getInt("id_venda");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao abrir venda ! \n ERRO:  " + ex);
        }
        flag = 1;
        preencherTabelaCliente("select * from clientes inner join cidade"
                + " on clientes.id_cidade = cidade.id_cidade where nome_cliente like '%" + txtCliente.getText() + "%'");
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void btnPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProdutoActionPerformed

        flag = 2;
        preencherTabelaProduto("select * from produto where nome_produto like '%" + txtProduto.getText() + "%'");
    }//GEN-LAST:event_btnPesquisaProdutoActionPerformed

    private void tblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaMouseClicked
        if (flag == 1) {
            String nome_cliente = "" + tblPesquisa.getValueAt(tblPesquisa.getSelectedRow(), 1);
            txtCliente.setText(nome_cliente);
        } else {
            String nome_produto = "" + tblPesquisa.getValueAt(tblPesquisa.getSelectedRow(), 1);
            txtProduto.setText(nome_produto);
            connVenda.conexao();

            try {
                connVenda.executaSQL("select * from produto where nome_produto ='" + nome_produto + "' ");
                connVenda.rs.first();
                preco_produto = connVenda.rs.getFloat("preco_venda");
                txtValorUnitario.setText(String.valueOf(preco_produto));
                txtQuantidade.setText("1");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao Carregar Item \n ERRO: " + ex);
            }

        }
    }//GEN-LAST:event_tblPesquisaMouseClicked

    private void txtProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdutoFocusGained

    }//GEN-LAST:event_txtProdutoFocusGained

    private void txtQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusGained

    }//GEN-LAST:event_txtQuantidadeFocusGained

    private void btnAdicionaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaItemActionPerformed
        try {
            connVenda.conexao();
            connVenda.executaSQL("select * from produto where nome_produto='" + txtProduto.getText() + "'");
            connVenda.rs.first();
            qtdEstoque = connVenda.rs.getInt("quantidade");
            if (qtdEstoque >= Integer.parseInt(txtQuantidade.getText())) {

                mod.setNomeProduto(txtProduto.getText());
                mod.setQuantidadedoItem(Integer.parseInt(txtQuantidade.getText()));
                mod.setIdvenda(codVenda);
                control.AdicionaItem(mod);
                preencherTabelaItensVenda("select * from produto inner join itens_venda_produto on produto.id_produto=itens_venda_produto.id_produto inner join venda on venda.id_venda=itens_venda_produto.id_venda where venda.id_venda='" + codVenda + "'");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não contem Estoque Suficiente !!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO \n " + ex);
        }

    }//GEN-LAST:event_btnAdicionaItemActionPerformed

    private void btnFechaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaVendaActionPerformed
        connVenda.conexao();
        if (cbxPagamento.getSelectedItem().equals("A Vista")) {
            mod.setIdvenda(codVenda);
            mod.setNomeCliente(txtCliente.getText());
            mod.setData(txtfData.getText());
            mod.setValorVenda(Float.parseFloat(txtValorTotal.getText()));
            mod.setPagamento((String) cbxPagamento.getSelectedItem());
            control.FechaVenda(mod);
            dispose();
        } else {
            mod.setIdvenda(codVenda);
            mod.setNomeCliente(txtCliente.getText());
            mod.setData(txtfData.getText());
            mod.setValorVenda(Float.parseFloat(txtValorTotal.getText()));
            mod.setPagamento((String) cbxPagamento.getSelectedItem());
            control.FechaVenda(mod);
            CadastroParcelas parcela = new CadastroParcelas(codVenda);
            parcela.setVisible(true);

            dispose();
        }
    }//GEN-LAST:event_btnFechaVendaActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        control.CancelaVenda();
        dispose();
    }//GEN-LAST:event_btnCancelaActionPerformed

    public void preencherTabelaCliente(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"CÓDIGO", "NOME", "CIDADE"};
        connVenda.conexao();

        connVenda.executaSQL(sql);
        try {
            connVenda.rs.first();
            do {
                dados.add(new Object[]{connVenda.rs.getInt("id_cliente"), connVenda.rs.getString("nome_cliente"), connVenda.rs.getString("nome_cidade")});
            } while (connVenda.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Contem Cliente Cadastrado no Banco de Dados  !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblPesquisa.setModel(modelo);
        tblPesquisa.getColumnModel().getColumn(0).setPreferredWidth(226);
        tblPesquisa.getColumnModel().getColumn(0).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblPesquisa.getColumnModel().getColumn(2).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(1).setResizable(false);
        tblPesquisa.getTableHeader().setResizingAllowed(false);
        tblPesquisa.setAutoResizeMode(tblPesquisa.AUTO_RESIZE_OFF);
        tblPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void preencherTabelaProduto(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"CÓDIGO", "NOME", "QUANTIDADE"};
        connVenda.conexao();

        connVenda.executaSQL(sql);
        try {
            connVenda.rs.first();
            do {
                dados.add(new Object[]{connVenda.rs.getInt("id_produto"), connVenda.rs.getString("nome_produto"), connVenda.rs.getInt("quantidade")});
            } while (connVenda.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não Contem Produto Cadastrado no Banco de Dados  !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblPesquisa.setModel(modelo);
        tblPesquisa.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblPesquisa.getColumnModel().getColumn(0).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblPesquisa.getColumnModel().getColumn(1).setResizable(false);
        tblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblPesquisa.getColumnModel().getColumn(2).setResizable(false);
        tblPesquisa.getTableHeader().setResizingAllowed(false);
        tblPesquisa.setAutoResizeMode(tblPesquisa.AUTO_RESIZE_OFF);
        tblPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void preencherTabelaItensVenda(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"DESCRIÇÃO", "QUANTIDADE", "PREÇO UNITARIO", "VALOR TOTAL"};
        connVenda.conexao();

        connVenda.executaSQL(sql);
        try {
            connVenda.rs.first();
            do {

                float valorProduto = connVenda.rs.getFloat("preco_venda");
                int qtdProduto = connVenda.rs.getInt("quantidade_produto");

                dados.add(new Object[]{connVenda.rs.getString("nome_produto"), connVenda.rs.getString("quantidade_produto"), connVenda.rs.getFloat("preco_venda"), valorProduto * qtdProduto});

            } while (connVenda.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Incluir Item na Tabela!! \n ERRO:  " + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblItensVenda.setModel(modelo);
        tblItensVenda.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblItensVenda.getColumnModel().getColumn(0).setResizable(false);
        tblItensVenda.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblItensVenda.getColumnModel().getColumn(1).setResizable(false);
        tblItensVenda.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblItensVenda.getColumnModel().getColumn(2).setResizable(false);
        tblItensVenda.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblItensVenda.getColumnModel().getColumn(3).setResizable(false);
        tblItensVenda.getTableHeader().setResizingAllowed(false);
        tblItensVenda.setAutoResizeMode(tblItensVenda.AUTO_RESIZE_OFF);
        tblItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SomaProduto();

    }

    public void SomaProduto() {
        total = 0;
        connVenda.conexao();
        connVenda.executaSQL("select * from itens_venda_produto inner join produto on itens_venda_produto.id_produto=produto.id_produto where id_venda=" + codVenda);
        try {
            //connVenda.rs.first();
            while (connVenda.rs.next()) {
                total = total + connVenda.rs.getFloat("preco_venda") * connVenda.rs.getInt("quantidade_produto");
            }
            txtValorTotal.setText(String.valueOf(total));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na Soma do Valor Total !! \n ERRO:  " + ex);
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
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaItem;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnFechaVenda;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbxPagamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblItensVenda;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblRegistroPesquisa;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JTable tblItensVenda;
    private javax.swing.JTable tblPesquisa;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    private javax.swing.JFormattedTextField txtfData;
    // End of variables declaration//GEN-END:variables
}
