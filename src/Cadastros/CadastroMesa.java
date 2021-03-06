package Cadastros;

import Classes.Mesa;
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
public class CadastroMesa extends javax.swing.JFrame {

    Mesa mesa = new Mesa();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    
    Relatorios report = new Relatorios();

    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();
    int rotina;
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form CadastroMesa
     */
    public CadastroMesa() {
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

        jPopupMenuMesa = new javax.swing.JPopupMenu();
        jMenuItemMesa = new javax.swing.JMenuItem();
        jTabbedPaneMesa = new javax.swing.JTabbedPane();
        atalho.adicionarAtalho(jTabbedPaneMesa);
        jPanelCadastro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNRMesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel21 = new javax.swing.JLabel();
        jPanelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jBtRelatorio = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtRelatorio,   KeyEvent.VK_F6, 0);

        jMenuItemMesa.setText("Carregar Dados");
        jMenuItemMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMesaActionPerformed(evt);
            }
        });
        jPopupMenuMesa.add(jMenuItemMesa);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Mesas");
        setName("CADASTRAR MESA"); // NOI18N
        setResizable(false);

        jLabel2.setText("Número da Mesa");

        jTextFieldNRMesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNRMesaFocusLost(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Descrição");

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativa", "Inativa" }));

        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("Situação");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)))
        );

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("- Campos Obrigatórios");

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
                        .addComponent(jLabel21))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNRMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNRMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMesa.addTab("Cadastro", jPanelCadastro);

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr Mesa", "Descrição", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuMesa);
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Número", "Descrição" }));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMesa.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneMesa))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneMesa))
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
        jTextFieldNRMesa.grabFocus();
        jComboBoxSituacao.setSelectedIndex(0);
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da mesa é obrigatória !");
            jTextFieldDescricao.grabFocus();
        } else {
            gravarMesa();

            if (rotina == Rotinas.incluir) {
                mesa.incluir(mesa);
                //JOptionPane.showMessageDialog(null, "Mesa gravada com sucesso!");
                jTextFieldNRMesa.setText(mesa.getNrMesa().toString());
            } else if (rotina == Rotinas.alterar) {
                if (jTextFieldNRMesa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o número da mesa que deseja alterar!");
                    jTextFieldNRMesa.grabFocus();
                } else {
                    try {
                        mesa.setNrMesa(Integer.parseInt(jTextFieldNRMesa.getText()));
                        mesa.alterar(mesa);
                        //JOptionPane.showMessageDialog(null, "Mesa alterada com sucesso!");
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
        if (jTextFieldNRMesa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso informar o número da mesa que deseja inativar!");
            jTextFieldNRMesa.grabFocus();
        } else {
            try {
                mesa.setNrMesa(Integer.parseInt(jTextFieldNRMesa.getText()));

                int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente inativar esta mesa ?",
                        "Inativar Mesa", JOptionPane.YES_NO_OPTION);

                if (delete == JOptionPane.YES_OPTION) {
                    mesa.excluir(mesa);
                    //JOptionPane.showMessageDialog(null, "Mesa inativada com sucesso!");
                    limpar.limparCampos(jPanelCadastro);
                }
            } catch (NumberFormatException ex) {

            }
        }
        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{100, 200, 150});

        switch(jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, mesa.consultarGeral());
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;
                
            case 1:
                try{
                    mesa.setNrMesa(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, mesa.consultarNrMesa(mesa));
                    report.setConsulta(preencher.getConsulta());
                    editaBotao(preencher.Vazia());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um número para pesquisar!");
                    editaBotao(true);
                }
            break;
                
            default:
                mesa.setDsMesa(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, mesa.consultarDescricao(mesa));
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;    
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTextFieldNRMesaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNRMesaFocusLost
        if (!jTextFieldNRMesa.getText().equals("")) {
            try {
                mesa.setNrMesa(Integer.parseInt(jTextFieldNRMesa.getText()));
                mesa.retornaMesa(mesa, true);

                if (mesa.getDsMesa().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preencherCampos();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um número!");
                jBtCancelarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldNRMesaFocusLost

    private void jMenuItemMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMesaActionPerformed
        int linha = jTableConsulta.getSelectedRow();

        if (linha >= 0) {
            int nr = Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString());
            mesa.setNrMesa(nr);
            mesa.retornaMesa(mesa, true);

            preencherCampos();
            jTabbedPaneMesa.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jMenuItemMesaActionPerformed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldDescricao, 40);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        jBtPesquisarActionPerformed(null);
        report.setSubreport(false);
        report.setTabela("MESA");
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
            java.util.logging.Logger.getLogger(CadastroMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMesa().setVisible(true);
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
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItemMesa;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneMesa;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNRMesa;
    // End of variables declaration//GEN-END:variables

    private void gravarMesa() {
        mesa.setDsMesa(jTextFieldDescricao.getText().toUpperCase());
        if (jComboBoxSituacao.getSelectedIndex() == 0) {
            mesa.setInAtiva("A");
        } else {
            mesa.setInAtiva("I");
        }
    }

    private void preencherCampos() {
        jTextFieldNRMesa.setText(mesa.getNrMesa().toString());
        jTextFieldDescricao.setText(mesa.getDsMesa());
        if (mesa.getInAtiva().equals("ATIVA")) {
            jComboBoxSituacao.setSelectedIndex(0);
        } else {
            jComboBoxSituacao.setSelectedIndex(1);
        }
    }

    private void editaBotao(boolean vazia) {
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
