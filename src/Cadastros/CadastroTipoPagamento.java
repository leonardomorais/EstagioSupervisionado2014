/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadastros;

import Classes.TipoPagamento;
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
public class CadastroTipoPagamento extends javax.swing.JFrame {

    TipoPagamento tipo = new TipoPagamento();
    Relatorios report = new Relatorios();

    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();
    int rotina;

    /**
     * Creates new form CadastroTipoPagamento
     */
    public CadastroTipoPagamento() {
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

        jPopupMenuTipoPagamento = new javax.swing.JPopupMenu();
        jMenuItemTipoPagamento = new javax.swing.JMenuItem();
        jTabbedPaneTipo = new javax.swing.JTabbedPane();
        jPanelCadastro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCdTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jPanelBotoes = new javax.swing.JPanel();
        jBtIncluir = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtGravar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jTextFieldDescricao = new javax.swing.JTextField();
        jPanelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtRelatorio = new javax.swing.JButton();

        jMenuItemTipoPagamento.setText("Carregar Dados");
        jMenuItemTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoPagamentoActionPerformed(evt);
            }
        });
        jPopupMenuTipoPagamento.add(jMenuItemTipoPagamento);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipos de Pagamento");
        setResizable(false);

        jLabel2.setText("Código do Tipo de Pagamento");

        jTextFieldCdTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdTipoFocusLost(evt);
            }
        });

        jLabel3.setText("Descrição");

        jLabel4.setText("Situação");

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));

        jBtIncluir.setText("Incluir");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
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
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)))
        );

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneTipo.addTab("Cadastro", jPanelCadastro);

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo de Pagamento", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuTipoPagamento);
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Filtro da Consulta");

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
                .addGap(8, 8, 8)
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneTipo.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneTipo, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneTipo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        jTextFieldDescricao.grabFocus();
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        jTextFieldDescricao.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        jComboBoxSituacao.setSelectedIndex(0);
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdTipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso informar o código do tipo de pagamento que deseja excluir!");
            jTextFieldCdTipo.grabFocus();
        } else {
            tipo.setCdTipo(Integer.parseInt(jTextFieldCdTipo.getText()));
            tipo.exclur(tipo);
            limpar.limparCampos(jPanelCadastro);
        }
        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        limpar.limparCampos(jPanelCadastro);
        jTextFieldCdTipo.grabFocus();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do tipo de pagamento é obrigatória");
            jTextFieldDescricao.grabFocus();
        } else {
            carregarTipo();

            if (rotina == Rotinas.incluir) {
                tipo.incluir(tipo);
                jTextFieldCdTipo.setText(tipo.getCdTipo().toString());
            } else if (rotina == Rotinas.alterar) {
                if (jTextFieldCdTipo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o código do tipo de pagamento que deseja alterar!");
                    jTextFieldCdTipo.grabFocus();
                } else {
                    tipo.setCdTipo(Integer.parseInt(jTextFieldCdTipo.getText()));
                    tipo.alterar(tipo);
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{75, 300, 100});

        if (jComboBoxConsulta.getSelectedIndex() == 0) {
            preencher.PreencherJtableGenerico(jTableConsulta, tipo.consultarGeral());
            editaBotao(preencher.isVazia());
            report.setConsulta(tipo.consultarGeral());
        } else if (jComboBoxConsulta.getSelectedIndex() == 1) {
            try {
                tipo.setCdTipo(Integer.parseInt(jTextFieldConsulta.getText()));
                preencher.PreencherJtableGenerico(jTableConsulta, tipo.consultarCdTipo(tipo));
                editaBotao(preencher.isVazia());
                report.setConsulta(tipo.consultarCdTipo(tipo));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
                jBtRelatorio.setEnabled(false);
            }
        } else {
            tipo.setDsTipo(jTextFieldConsulta.getText().toUpperCase());
            preencher.PreencherJtableGenerico(jTableConsulta, tipo.consultarDsTipo(tipo));
            editaBotao(preencher.isVazia());
            report.setConsulta(tipo.consultarDsTipo(tipo));
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTextFieldCdTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdTipoFocusLost
        if (!jTextFieldCdTipo.getText().equals("")) {
            try {
                tipo.setCdTipo(Integer.parseInt(jTextFieldCdTipo.getText()));
                tipo.retornaTipo(tipo);

                if (tipo.getDsTipo().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preencherCampos();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldCdTipoFocusLost

    private void jMenuItemTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoPagamentoActionPerformed
        int linha = jTableConsulta.getSelectedRow();

        if (linha >= 0) {
            int cd = Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString());
            tipo.setCdTipo(cd);
            tipo.retornaTipo(tipo);

            preencherCampos();
            jTabbedPaneTipo.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jMenuItemTipoPagamentoActionPerformed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldDescricao, 50);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        if (report.login()) {
            try {
                report.setSubreport(false);
                report.setTabela("TIPO_PGTO");
                report.gerarRelatorio(report);
                jBtPesquisarActionPerformed(null);
            } catch (JRException ex) {
                Logger.getLogger(CadastroTipoPagamento.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CadastroTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTipoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTipoPagamento().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItemTipoPagamento;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuTipoPagamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneTipo;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldCdTipo;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

    public void carregarTipo() {
        tipo.setDsTipo(jTextFieldDescricao.getText().toUpperCase());
        if (jComboBoxSituacao.getSelectedIndex() == 0) {
            tipo.setInAtivo("A");
        } else {
            tipo.setInAtivo("I");
        }
    }

    public void preencherCampos() {
        jTextFieldCdTipo.setText(tipo.getCdTipo().toString());
        jTextFieldDescricao.setText(tipo.getDsTipo());
        jComboBoxSituacao.setSelectedItem(tipo.getInAtivo());
    }

    public void editaBotao(boolean vazia) {
        if (vazia) {
            jBtRelatorio.setEnabled(false);
        } else {
            jBtRelatorio.setEnabled(true);
        }
    }
}
