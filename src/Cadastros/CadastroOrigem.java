package Cadastros;

import Classes.Origem;
import Relatorios.Relatorios;
import Validacoes.LimparCampos;
import Validacoes.PreencherTabela;
import Validacoes.Rotinas;
import Validacoes.TeclasdeAtalho;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import Validacoes.ValidaNivelUsuario;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leonardo
 */
public class CadastroOrigem extends javax.swing.JFrame {

    Origem origem = new Origem();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    Relatorios report = new Relatorios();

    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();
    int rotina;
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();
    
    /**
     * Creates new form CadastroOrigem
     */
    public CadastroOrigem() {
        initComponents();
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOrigem = new javax.swing.JPopupMenu();
        jMenuItemOrigem = new javax.swing.JMenuItem();
        jTabbedPaneOrigem = new javax.swing.JTabbedPane();
        atalho.adicionarAtalho(jTabbedPaneOrigem);
        jPanelCadastro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCdOrigem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jPanelBotoes = new javax.swing.JPanel();
        jBtIncluir = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtIncluir, KeyEvent.VK_F1, 0);
        jBtAlterar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtAlterar, KeyEvent.VK_F2, 0);
        jBtExcluir = new javax.swing.JButton();
        atalho. adicionarAtalho(jBtExcluir, KeyEvent.VK_F3, 0);
        jBtGravar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtGravar, KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jLabel7 = new javax.swing.JLabel();
        jPanelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtRelatorio = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtRelatorio,   KeyEvent.VK_F6, 0);

        jMenuItemOrigem.setText("Carregar Dados");
        jMenuItemOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOrigemActionPerformed(evt);
            }
        });
        jPopupMenuOrigem.add(jMenuItemOrigem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Origens");
        setName("CADASTRAR ORIGEM"); // NOI18N
        setResizable(false);

        jLabel2.setText("Código da Origem");

        jTextFieldCdOrigem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdOrigemFocusLost(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Descrição");

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jBtIncluir.setText("Incluir");
        jBtIncluir.setToolTipText("Incluir (F1)");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

        jBtAlterar.setText("Alterar");
        jBtAlterar.setToolTipText("Alterar (F2)");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setText("Excluir");
        jBtExcluir.setToolTipText("Excluir (F3)");
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtGravar.setText("Gravar");
        jBtGravar.setToolTipText("Gravar (Ctrl + Enter)");
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
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
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)))
        );

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("- Campos Obrigatórios");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCdOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCdOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneOrigem.addTab("Cadastro", jPanelCadastro);

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Origem", "Descrição Origem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuOrigem);
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Descrição" }));
        jComboBoxConsulta.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxConsultaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.setToolTipText("Pesquisar (F5)");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setToolTipText("Relatório (F6)");
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
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jBtPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtRelatorio)))
                .addContainerGap())
        );
        jPanelConsultaLayout.setVerticalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneOrigem.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneOrigem, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneOrigem, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        jTextFieldDescricao.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        jTextFieldDescricao.grabFocus();
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
        limpar.limparCampos(jPanelCadastro);
        jTextFieldCdOrigem.grabFocus();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da origem é obrigatória !");
            jTextFieldDescricao.grabFocus();
        } else {
            carregarOrigem();
            if (rotina == Rotinas.incluir) {
                origem.incluir(origem);
//                JOptionPane.showMessageDialog(null, "Origem gravada com sucesso!");
                preencherCampos();
            } else if (rotina == Rotinas.alterar) {
                if (jTextFieldCdOrigem.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o código da origem que deseja alterar");
                    jTextFieldCdOrigem.grabFocus();
                } else {
                    try {
                        origem.setCdOrigem(Integer.parseInt(jTextFieldCdOrigem.getText()));
                        origem.alterar(origem);
                        //JOptionPane.showMessageDialog(null, "Origem alterada com sucesso!");
                    } catch (NumberFormatException ex) {

                    }
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdOrigem.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso informar o código da origem que deseja excluir!");
            jTextFieldCdOrigem.grabFocus();
        } else {
            try {
                origem.setCdOrigem(Integer.parseInt(jTextFieldCdOrigem.getText()));

                int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta origem ?",
                        "Excluir Origem", JOptionPane.YES_NO_OPTION);

                if (delete == JOptionPane.YES_OPTION) {
                    origem.excluir(origem);
                    //JOptionPane.showMessageDialog(null, "Origem excluída com sucesso!");
                    limpar.limparCampos(jPanelCadastro);

                }
            } catch (NumberFormatException ex) {

            }
        }
        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jTextFieldCdOrigemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdOrigemFocusLost
        if (!jTextFieldCdOrigem.getText().equals("")) {
            try {
                origem.setCdOrigem(Integer.parseInt(jTextFieldCdOrigem.getText()));
                origem.retornaOrigem(origem);
                if (origem.getDsOrigem().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preencherCampos();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldCdOrigemFocusLost

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{175, 300});

        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, origem.consultarGeral());
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;
                
            case 1:
                try{
                    origem.setCdOrigem(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, origem.consultarCdOrigem(origem));
                    report.setConsulta(preencher.getConsulta());
                    editaBotao(preencher.Vazia());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    editaBotao(true);
                }
            break;
                
            default:
                origem.setDsOrigem(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, origem.consultarDsOrigem(origem));
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;    
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jMenuItemOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOrigemActionPerformed
        int linha = jTableConsulta.getSelectedRow();

        if (linha >= 0) {
            int cd = Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString());
            origem.setCdOrigem(cd);
            origem.retornaOrigem(origem);
            preencherCampos();
            jTabbedPaneOrigem.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jMenuItemOrigemActionPerformed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldDescricao, 45);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        jBtPesquisarActionPerformed(null);
        report.setSubreport(false);
        report.setTabela("ORIGEM");
        report.iniciarSplash(report);
    }//GEN-LAST:event_jBtRelatorioActionPerformed

    private void jComboBoxConsultaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(false);
            break;    
                
            default:
                jTextFieldConsulta.setEnabled(true);
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
            break;    
        }
    }//GEN-LAST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(CadastroOrigem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroOrigem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroOrigem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroOrigem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroOrigem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtGravar;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItemOrigem;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuOrigem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneOrigem;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldCdOrigem;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

    public void carregarOrigem() {
        origem.setDsOrigem(jTextFieldDescricao.getText().toUpperCase());
    }

    public void preencherCampos() {
        jTextFieldCdOrigem.setText(origem.getCdOrigem().toString());
        jTextFieldDescricao.setText(origem.getDsOrigem());
    }

    public void editaBotao(boolean vazia) {
        if (vazia) {
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jBtRelatorio.setEnabled(false);
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        } else {
            jBtRelatorio.setEnabled(valida.pRelatorio.equals("S"));
        }
    }
    
    private void carregarUsuario(){
        valida.validaNivel(this.getName());
        valida.validaBotoesUsuario(jPanelBotoes);
    }
}
