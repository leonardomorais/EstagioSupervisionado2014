package Cadastros;

import Classes.Operacao;
import Relatorios.Relatorios;
import Validacoes.LimparCampos;
import Validacoes.PreencherTabela;
import Validacoes.Rotinas;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


/**
 *
 * @author Leonardo
 */
public class CadastroOperacao extends javax.swing.JFrame {
    
    Operacao operacao = new Operacao();
    Relatorios report = new Relatorios();
    
    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();

    int rotina;

    /**
     * Creates new form CadastroOperacao
     */
    public CadastroOperacao() {
        initComponents();
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMovEstoque = new javax.swing.ButtonGroup();
        buttonGroupMovCaixa = new javax.swing.ButtonGroup();
        jPopupMenuOperacao = new javax.swing.JPopupMenu();
        jMenuItemCarregarDados = new javax.swing.JMenuItem();
        jTabbedPaneOperacao = new javax.swing.JTabbedPane();
        jPanelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCdOperacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jPanelBotoes = new javax.swing.JPanel();
        jBtIncluir = new javax.swing.JButton();
        jBtGravar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox();
        jRadioButtonFinanceiroSim = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonFinanceiroNao = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonEstoqueSim = new javax.swing.JRadioButton();
        jRadioButtonEstoqueNao = new javax.swing.JRadioButton();
        jPanelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOperacao = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        jBtRelatorio = new javax.swing.JButton();
        jTextFieldConsulta = new javax.swing.JTextField();

        jMenuItemCarregarDados.setText("Carregar Dados");
        jMenuItemCarregarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarDadosActionPerformed(evt);
            }
        });
        jPopupMenuOperacao.add(jMenuItemCarregarDados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Operação");
        setResizable(false);

        jLabel1.setText("Código da Operação");

        jTextFieldCdOperacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdOperacaoFocusLost(evt);
            }
        });

        jLabel2.setText("Descrição");

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jBtIncluir.setText("Incluir");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

        jBtGravar.setText("Gravar");
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAlterar.setText("Alterar");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setText("Excluir");
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)))
        );

        jLabel6.setText("Tipo da Operação");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Saída" }));

        buttonGroupMovCaixa.add(jRadioButtonFinanceiroSim);
        jRadioButtonFinanceiroSim.setSelected(true);
        jRadioButtonFinanceiroSim.setText("Sim");

        jLabel3.setText("Movimenta Financeiro");

        buttonGroupMovCaixa.add(jRadioButtonFinanceiroNao);
        jRadioButtonFinanceiroNao.setText("Não");

        jLabel4.setText("Movimenta Estoque");

        buttonGroupMovEstoque.add(jRadioButtonEstoqueSim);
        jRadioButtonEstoqueSim.setSelected(true);
        jRadioButtonEstoqueSim.setText("Sim");

        buttonGroupMovEstoque.add(jRadioButtonEstoqueNao);
        jRadioButtonEstoqueNao.setText("Não");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCdOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelCadastroLayout.createSequentialGroup()
                            .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                    .addComponent(jRadioButtonEstoqueSim)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButtonEstoqueNao))
                                .addComponent(jLabel4))
                            .addGap(49, 49, 49)
                            .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                    .addComponent(jRadioButtonFinanceiroSim)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButtonFinanceiroNao))))
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCdOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonFinanceiroSim)
                    .addComponent(jRadioButtonFinanceiroNao)
                    .addComponent(jRadioButtonEstoqueSim)
                    .addComponent(jRadioButtonEstoqueNao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneOperacao.addTab("Cadastro", jPanelCadastro);

        jTableOperacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo", "Mov Estoque", "Mov Financeiro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOperacao.setComponentPopupMenu(jPopupMenuOperacao);
        jScrollPane1.setViewportView(jTableOperacao);

        jLabel5.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Descrição" }));

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setEnabled(false);
        jBtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaLayout = new javax.swing.GroupLayout(jPanelConsulta);
        jPanelConsulta.setLayout(jPanelConsultaLayout);
        jPanelConsultaLayout.setHorizontalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtRelatorio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelConsultaLayout.setVerticalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneOperacao.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneOperacao, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneOperacao, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "A descrição é obrigatória!");
        }
        else {
           carregarOperacao();
            
            switch (rotina){
                case Rotinas.incluir :
                    operacao.incluir(operacao);
                    JOptionPane.showMessageDialog(null, "Operação gravada com sucesso!");
                    jTextFieldCdOperacao.setText(operacao.getCdOperacao().toString());
                    break;
                
                default:
                if (jTextFieldCdOperacao.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "É preciso informar o código da operação que deseja alterar!");
                }
                else{
                    try{
                        operacao.setCdOperacao(Integer.parseInt(jTextFieldCdOperacao.getText()));
                        operacao.alterar(operacao);
                        JOptionPane.showMessageDialog(null, "Operação alterada com sucesso!");
                    }
                    catch(NumberFormatException ex){
                    }
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        jTextFieldDescricao.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        jComboBoxTipo.setSelectedIndex(0);
        jRadioButtonEstoqueSim.setSelected(true);
        jRadioButtonFinanceiroSim.setSelected(true);
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        limpar.limparCampos(jPanelCadastro);
        jTextFieldCdOperacao.grabFocus();
        jComboBoxTipo.setSelectedIndex(0);
        jRadioButtonEstoqueSim.setSelected(true);
        jRadioButtonFinanceiroSim.setSelected(true);
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        jTextFieldDescricao.grabFocus();
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdOperacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É preciso informar o código da operação que deseja excluir!");
            jTextFieldCdOperacao.grabFocus();
        } else {
            try {
                operacao.setCdOperacao(Integer.parseInt(jTextFieldCdOperacao.getText()));

                int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta operação ?",
                        "Excluir Operação", JOptionPane.YES_OPTION);
                if (delete == JOptionPane.YES_OPTION) {
                    operacao.excluir(operacao);
                    JOptionPane.showMessageDialog(null, "Operação excluída com sucesso!");
                    limpar.limparCampos(jPanelCadastro);
                }
            } catch (NumberFormatException ex) {
            }
        }
        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldDescricao, 50);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableOperacao, new int [] {60,180,100,90,90});
        
        if (jComboBoxConsulta.getSelectedIndex()==0){
            preencher.PreencherJtableGenerico(jTableOperacao, operacao.consultarGeral());
            editaBotao(preencher.isVazia());
            report.setConsulta(operacao.consultarGeral());
        }
        else if (jComboBoxConsulta.getSelectedIndex() == 1){
            try{
                operacao.setCdOperacao(Integer.parseInt(jTextFieldConsulta.getText()));
                preencher.PreencherJtableGenerico(jTableOperacao, operacao.consultarCdOperacao(operacao));
                editaBotao(preencher.isVazia());
                report.setConsulta(operacao.consultarCdOperacao(operacao));
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
                jBtRelatorio.setEnabled(false);
            }
        }
        else{
            operacao.setDsOperacao(jTextFieldConsulta.getText().toUpperCase());
            preencher.PreencherJtableGenerico(jTableOperacao, operacao.consultarDescricao(operacao));
            editaBotao(preencher.isVazia());
            report.setConsulta(operacao.consultarDescricao(operacao));
        }
        
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTextFieldCdOperacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdOperacaoFocusLost
        if(!jTextFieldCdOperacao.getText().equals("")){
            try{
                operacao.setCdOperacao(Integer.parseInt(jTextFieldCdOperacao.getText()));
                operacao.retornaOperacao(operacao);

                if (operacao.getDsOperacao().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preencherCampos();
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            
            }
        }
    }//GEN-LAST:event_jTextFieldCdOperacaoFocusLost

    private void jMenuItemCarregarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarDadosActionPerformed
        int linha = jTableOperacao.getSelectedRow();

        if (linha >= 0) {
            int cd = Integer.parseInt(jTableOperacao.getValueAt(linha, 0).toString());
            operacao.setCdOperacao(cd);
            operacao.retornaOperacao(operacao);

            preencherCampos();
            jTabbedPaneOperacao.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jMenuItemCarregarDadosActionPerformed

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        if (report.login()) {
            try {
                report.setSubreport(false);
                report.setTabela("OPERACAO");
                report.gerarRelatorio(report);
                jBtPesquisarActionPerformed(null);
            } catch (JRException ex) {
                Logger.getLogger(CadastroBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtRelatorioActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroOperacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMovCaixa;
    private javax.swing.ButtonGroup buttonGroupMovEstoque;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtGravar;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItemCarregarDados;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuOperacao;
    private javax.swing.JRadioButton jRadioButtonEstoqueNao;
    private javax.swing.JRadioButton jRadioButtonEstoqueSim;
    private javax.swing.JRadioButton jRadioButtonFinanceiroNao;
    private javax.swing.JRadioButton jRadioButtonFinanceiroSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneOperacao;
    private javax.swing.JTable jTableOperacao;
    private javax.swing.JTextField jTextFieldCdOperacao;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

    public void carregarOperacao(){
         operacao.setDsOperacao(jTextFieldDescricao.getText().toUpperCase());
            if (jComboBoxTipo.getSelectedIndex() == 0){
                operacao.setTipo("E");
            }
            else{
                operacao.setTipo("S");
            }
            
            if (jRadioButtonEstoqueSim.isSelected()){
                operacao.setMovEstoque("S");
            }
            else{
                operacao.setMovEstoque("N");
            }
            
            if (jRadioButtonFinanceiroSim.isSelected()){
                operacao.setMovFinanceiro("S");
            }
            else{
                operacao.setMovFinanceiro("F");
            }
    }
    
    public void preencherCampos(){
        jTextFieldCdOperacao.setText(operacao.getCdOperacao().toString());
        jTextFieldDescricao.setText(operacao.getDsOperacao());
        
        if(operacao.getMovEstoque().equals("SIM")){
            jRadioButtonEstoqueSim.setSelected(true);
        }
        else{
            jRadioButtonEstoqueNao.setSelected(true);
        }
        
        if(operacao.getMovFinanceiro().equals("SIM")){
            jRadioButtonFinanceiroSim.setSelected(true);
        }
        else{
            jRadioButtonFinanceiroNao.setSelected(true);
        }
        
        if(operacao.getTipo().equals("ENTRADA")){
            jComboBoxTipo.setSelectedIndex(0);
        }
        else{
            jComboBoxTipo.setSelectedIndex(1);
        }
    }
    
    public void editaBotao(boolean vazia) {
        if (vazia) {
            jBtRelatorio.setEnabled(false);
        } else {
            jBtRelatorio.setEnabled(true);
        }
    }

}
