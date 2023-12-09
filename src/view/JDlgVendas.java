/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClientesEma;
import bean.FuncionariosEma;
import bean.VendasEma;
import bean.VendasProdutoEma;
import controles.VendasControle;
import controles.VendasProdutosControle;
import dao.DAO_Clientes;
import dao.DAO_Funcionarios;
import dao.DAO_Vendas;
import dao.DAO_VendasProdutos;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tools.Util;

/**
 *
 * @author EDUARDO
 */
public class JDlgVendas extends javax.swing.JDialog {

    public boolean incluindo;

    DAO_Vendas vendasDAO;
    DAO_VendasProdutos vendasProdutosDAO;
    VendasProdutoEma vendasProdutosEma;
    VendasEma vendas;
    VendasProdutosControle vendasProdutosControle = new VendasProdutosControle();
    private JDlgVendas jDlgVendas;
    private VendasControle vendasControle;
    JDlgVendasProdutos jDlgVendasProdutos;

    /**
     * Creates new form JDlgVendas
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(new Dimension(800, 650));
        setMinimumSize(new Dimension(800, 650));
        setLocationRelativeTo(null);

        setTitle("Cadastro de vendas");

        Util.habilitar(false, jTxtID, jFmtDataDaVenda, jCboCliente, jCboFuncionario, jCboMetodo, jCboStatusEntrega, jTxtPreco, jBtnCancelar, jBtnCancelar, jBtnConfirmar, jBtnAlterar, jBtnExcluir);
        Util.limparCampos(jTxtID, jFmtDataDaVenda, jCboCliente, jCboFuncionario, jCboMetodo, jCboStatusEntrega, jTxtPreco);

        DAO_Clientes clientes_DAO = new DAO_Clientes();
        List listaCbo = clientes_DAO.listAll();
        for (int i = 0; i < listaCbo.size(); i++) {
            jCboCliente.addItem((ClientesEma) listaCbo.get(i));
        }

        DAO_Funcionarios funcionarios_DAO = new DAO_Funcionarios();
        List listaCba = funcionarios_DAO.listAll();
        for (int i = 0; i < listaCba.size(); i++) {
            jCboFuncionario.addItem((FuncionariosEma) listaCba.get(i));
        }

        vendasDAO = new DAO_Vendas();

        List lista = new ArrayList();
        vendasProdutosControle.setList(lista);
        jTable1.setModel(vendasProdutosControle);

    }

    public VendasEma viewBean() {
        VendasEma vendas = new VendasEma();
        int id = Util.strInt(jTxtID.getText());
        Date dataNascimento = Util.StrDate(jFmtDataDaVenda.getText());
        Double salario = Util.strDouble(jTxtPreco.getText());

        vendas.setIdVendaEma(id);
        vendas.setDataVendaEma(dataNascimento);
        vendas.setFkClienteEma(jCboCliente.getSelectedIndex());
        vendas.setFkFuncionarioEma(jCboFuncionario.getSelectedIndex());

        if (jCboMetodo.getSelectedIndex() == 0) {
            vendas.setMetodoPagamentoEma("A vista");
        } else if (jCboMetodo.getSelectedIndex() == 1) {
            vendas.setMetodoPagamentoEma("Parcelado");
        }
            if (jCboStatusEntrega.getSelectedIndex() == 0) {
                vendas.setStatusEntregaEma("Enviado");
            } else if (jCboStatusEntrega.getSelectedIndex() == 1) {
                vendas.setStatusEntregaEma("Entregue");
            } else if (jCboStatusEntrega.getSelectedIndex() == 2) {
                vendas.setStatusEntregaEma("A caminho");
            }
            vendas.setTotalVendaEma(salario);
        
        return vendas;
    }

    public void beanView(VendasEma vendas) {
        String idStr = Util.intStr(vendas.getIdVendaEma());
        String dataVendaStr = Util.dateStr(vendas.getDataVendaEma());
        String totalVendaStr = Util.doubleStr(vendas.getTotalVendaEma());

        jTxtID.setText(idStr);
        jFmtDataDaVenda.setText(dataVendaStr);
        jTxtPreco.setText(totalVendaStr);

        jCboCliente.setSelectedIndex(vendas.getFkClienteEma());
        jCboFuncionario.setSelectedIndex(vendas.getFkFuncionarioEma());
        
        DAO_VendasProdutos vendasProdutosDAO = new DAO_VendasProdutos();
        List listaProd = (List) vendasProdutosDAO.listProdutos(vendas);
        vendasProdutosControle.setList(listaProd);

        
            
            String metodo = vendas.getMetodoPagamentoEma();            
            if(metodo.equals("A vista")){
                jCboMetodo.setSelectedIndex(0);
            }else{
                jCboMetodo.setSelectedIndex(1);
            }
            String status = vendas.getStatusEntregaEma();
            if(status.equals("Enviado")){
                jCboStatusEntrega.setSelectedIndex(0);
            }else if(status.equals("Entregue")){
                 jCboStatusEntrega.setSelectedIndex(1);
            }else if(status.equals("A caminho")){
                jCboStatusEntrega.setSelectedIndex(2);
            }

        
    }

    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }

    public void setTelaAnterior(JDlgVendas jDlgVendas) {
        this.jDlgVendas = jDlgVendas;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnAlterarProdutos = new javax.swing.JButton();
        jBtnInclusaoDeProdutos = new javax.swing.JButton();
        jBtnExcluirProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTxtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFmtDataDaVenda = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jCboCliente = new javax.swing.JComboBox<ClientesEma>();
        jLabel3 = new javax.swing.JLabel();
        jCboFuncionario = new javax.swing.JComboBox<FuncionariosEma>();
        jLabel4 = new javax.swing.JLabel();
        jCboMetodo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCboStatusEntrega = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtPreco = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, null));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jBtnAlterarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdutosActionPerformed(evt);
            }
        });

        jBtnInclusaoDeProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnInclusaoDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInclusaoDeProdutosActionPerformed(evt);
            }
        });

        jBtnExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir (1).png"))); // NOI18N
        jBtnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterarProdutos)
                    .addComponent(jBtnInclusaoDeProdutos)
                    .addComponent(jBtnExcluirProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBtnInclusaoDeProdutos)
                .addGap(18, 18, 18)
                .addComponent(jBtnAlterarProdutos)
                .addGap(18, 18, 18)
                .addComponent(jBtnExcluirProduto))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, null));

        jTxtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIDActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        try {
            jFmtDataDaVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFmtDataDaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataDaVendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Data da venda");

        jLabel3.setText("Cliente");

        jLabel4.setText("Funcionario");

        jCboMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A vista", "Parcelado" }));

        jLabel5.setText("Método de pag.");

        jCboStatusEntrega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enviado", "Entregue", "A caminho" }));

        jLabel6.setText("Status da entrega");

        jLabel7.setText("Total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFmtDataDaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCboStatusEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtDataDaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboStatusEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnIncluir);

        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnPesquisar);

        jBtnAlterar.setText("Alterar");
        jPanel3.add(jBtnAlterar);

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnExcluir);

        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnConfirmar);

        jBtnCancelar.setText("Cancelar");
        jPanel3.add(jBtnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIDActionPerformed

    private void jFmtDataDaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataDaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataDaVendaActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed

        vendas = viewBean();
        if (incluindo == true) {
            vendasDAO.insert(vendas);
            DAO_VendasProdutos vendasProdutosDAO = new DAO_VendasProdutos();
            VendasProdutoEma vendasProdutos;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                vendasProdutos = vendasProdutosControle.getBean(linha);
                vendasProdutos.setVendasEma(vendas);
                vendasProdutosDAO.insert(vendasProdutos);
            }
        } else {
            vendasDAO.update(vendas);
            DAO_VendasProdutos vendasProdutosDAO = new DAO_VendasProdutos();
            VendasProdutoEma vendasProdutos;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                vendasProdutos = vendasProdutosControle.getBean(linha);
                vendasProdutos.setVendasEma(vendas);
                vendasProdutosDAO.insert(vendasProdutos);
            }
        }

        Util.limparCampos(jTxtID, jFmtDataDaVenda, jCboCliente, jCboFuncionario, jCboMetodo, jCboStatusEntrega, jTxtPreco);

        vendasProdutosControle.setList(new ArrayList());

        vendas = null;

    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        incluindo = true;
        Util.habilitar(true, jTxtID, jFmtDataDaVenda, jCboCliente, jCboFuncionario, jCboMetodo, jCboStatusEntrega, jTxtPreco, jBtnCancelar, jBtnCancelar, jBtnConfirmar, jBtnAlterar, jBtnExcluir, jBtnAlterar, jBtnExcluir, jBtnCancelar, jBtnInclusaoDeProdutos, jBtnExcluirProduto, jBtnAlterarProdutos);
        Util.habilitar(false, jBtnIncluir, jBtnPesquisar, jBtnAlterar, jBtnExcluir);

    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnInclusaoDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInclusaoDeProdutosActionPerformed

        JDlgVendasProdutos jDlgVendasProduto = new JDlgVendasProdutos(null, true);
        jDlgVendasProduto.setTitle("Incluir");
        jDlgVendasProduto.setTelaAnterior(this);
        jDlgVendasProduto.setVisible(true);


    }//GEN-LAST:event_jBtnInclusaoDeProdutosActionPerformed

    private void jBtnAlterarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdutosActionPerformed

        JDlgVendasProdutos vendasProdutos = new JDlgVendasProdutos(null, true);
        vendasProdutos.setLocationRelativeTo(null);
        vendasProdutos.setTelaAnterior(this);
        setTitle("Alteração de produto");
        int linSel = jTable1.getSelectedRow();
        VendasProdutoEma vendasProdutosEma = (VendasProdutoEma) vendasProdutosControle.getBean(linSel);
        vendasProdutos.beanView(vendasProdutosEma);
        vendasProdutos.setVisible(true);

    }//GEN-LAST:event_jBtnAlterarProdutosActionPerformed

    private void jBtnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdutoActionPerformed

        if (getSelectedRowProd() == -1) {
            Util.mensagem("Nenhuma linha selecionada");
        } else {
            if (Util.perguntar("Confirmar exclusão do produto") == true) {
                vendasProdutosControle.removeBean(getSelectedRowProd());
            }
        }

    }//GEN-LAST:event_jBtnExcluirProdutoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed

        vendas = viewBean();
        if (incluindo == true) {
            vendasDAO.insert(vendas);
            DAO_VendasProdutos vendasProdutosDAO = new DAO_VendasProdutos();
            VendasProdutoEma vendasProdutos;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                vendasProdutos = vendasProdutosControle.getBean(linha);
                vendasProdutosDAO.delete(vendasProdutos);
            }
            vendasProdutosDAO.delete(vendas);
        } else {
            Util.mensagem("Deve ser feita uma pesquisa antes");
        }

        Util.limparCampos();
        vendas = null;

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed

        JDlgVendasPesquisa jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true);
        jDlgVendasPesquisa.setTelaAnterior(this);
        jDlgVendasPesquisa.setVisible(true);

    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProdutos;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProduto;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnInclusaoDeProdutos;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<ClientesEma> jCboCliente;
    private javax.swing.JComboBox<FuncionariosEma> jCboFuncionario;
    private javax.swing.JComboBox<String> jCboMetodo;
    private javax.swing.JComboBox<String> jCboStatusEntrega;
    private javax.swing.JFormattedTextField jFmtDataDaVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtPreco;
    // End of variables declaration//GEN-END:variables

}
