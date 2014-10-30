package Telas;

import Cadastros.CadastroAgenciaConta;
import Classes.AgenciaConta;
import Classes.MovCaixa;
import Validacoes.FormataMoeda;
import Validacoes.LimparCampos;
import Validacoes.RetornaData;
import Validacoes.RetornaDecimal;
import Validacoes.Rotinas;
import Validacoes.TeclasdeAtalho;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class TelaTransferenciaContas extends javax.swing.JFrame {

    AgenciaConta agc = new AgenciaConta();
    RetornaDecimal decimal = new RetornaDecimal();
    LimparCampos limpar = new LimparCampos();
    MovCaixa mov = new MovCaixa();
    int rotina;
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form TelaTransferenciaContas
     */
    public TelaTransferenciaContas() {
        initComponents();
        rotina = Rotinas.padrao;
        validaEstadoCampos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxContaOrigem = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxContaDestino = new javax.swing.JComboBox();
        jBtNovaTransferencia = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtNovaTransferencia, KeyEvent.VK_F1, 0);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtGravar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtGravar, KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK);
        jLabel6 = new javax.swing.JLabel();
        jTextFieldVlContaOrigem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldVlContaDestino = new javax.swing.JTextField();
        jBtCadAgenciaConta = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCadAgenciaConta, KeyEvent.VK_F4, 0);
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVlTransferência = new javax.swing.JTextField();
        jLabelNrAgenciaOrigem = new javax.swing.JLabel();
        jLabelNrContaOrigem = new javax.swing.JLabel();
        jLabelNrContaDestino = new javax.swing.JLabel();
        jLabelNrAgenciaDestino = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Tranferência");
        setResizable(false);

        jComboBoxContaOrigem.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxContaOrigemPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setText("Selecione a conta a ser debidata");

        jLabel5.setText("Selecione a conta a ser creditada");

        jComboBoxContaDestino.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxContaDestinoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jBtNovaTransferencia.setText("Nova Tranferência");
        jBtNovaTransferencia.setToolTipText("Nova Transferência (F1)");
        jBtNovaTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaTransferenciaActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtGravar.setText("Gravar");
        jBtGravar.setToolTipText("Gravar (Ctrl + Enter)");
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor na Conta");

        jTextFieldVlContaOrigem.setDocument(new FormataMoeda());
        jTextFieldVlContaOrigem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVlContaOrigem.setEnabled(false);

        jLabel7.setText("Valor na Conta");

        jTextFieldVlContaDestino.setDocument(new FormataMoeda());
        jTextFieldVlContaDestino.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVlContaDestino.setEnabled(false);

        jBtCadAgenciaConta.setText("Exibir Cadastro");
        jBtCadAgenciaConta.setToolTipText("Exibir Cadastro (F4)");
        jBtCadAgenciaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadAgenciaContaActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor da Tranferência");

        jTextFieldVlTransferência.setDocument(new FormataMoeda());
        jTextFieldVlTransferência.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVlTransferência.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVlTransferênciaKeyTyped(evt);
            }
        });

        jLabelNrAgenciaOrigem.setText("Nr Agência");

        jLabelNrContaOrigem.setText("Nr Conta");

        jLabelNrContaDestino.setText("Nr Conta");

        jLabelNrAgenciaDestino.setText("Nr Agência");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jComboBoxContaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jBtCadAgenciaConta))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelNrAgenciaOrigem)
                                                .addComponent(jLabelNrContaOrigem))
                                            .addGap(51, 51, 51)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldVlContaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel5)
                                        .addComponent(jComboBoxContaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldVlTransferência, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNrAgenciaDestino)
                                    .addComponent(jLabelNrContaDestino))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldVlContaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtNovaTransferencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxContaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCadAgenciaConta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelNrAgenciaOrigem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldVlContaOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNrContaOrigem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jComboBoxContaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNrAgenciaDestino)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNrContaDestino))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldVlContaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldVlTransferência, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovaTransferencia)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxContaOrigemPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxContaOrigemPopupMenuWillBecomeInvisible
        try {
            int pos = jComboBoxContaOrigem.getSelectedItem().toString().indexOf(" ");
            int cd = Integer.parseInt(jComboBoxContaOrigem.getSelectedItem().toString().substring(0, pos));
            //System.out.println("CD "+cd);
            agc.setCdAgcConta(cd);
            agc.retornaAgenciaConta(agc);
            jLabelNrAgenciaOrigem.setText("Nr Agência: " + agc.getNrAgencia());
            jLabelNrContaOrigem.setText("Nr Conta: " + agc.getNrConta());
            jTextFieldVlContaOrigem.setText(decimal.retornaDecimal(agc.getVlConta(), 6));

            agc.retornaComboAgcConta(jComboBoxContaDestino, agc);
            jComboBoxContaDestino.removeItemAt(jComboBoxContaOrigem.getSelectedIndex());
            jComboBoxContaDestinoPopupMenuWillBecomeInvisible(evt);
        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_jComboBoxContaOrigemPopupMenuWillBecomeInvisible

    private void jComboBoxContaDestinoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxContaDestinoPopupMenuWillBecomeInvisible
        try {
            int pos = jComboBoxContaDestino.getSelectedItem().toString().indexOf(" ");
            int cd = Integer.parseInt(jComboBoxContaDestino.getSelectedItem().toString().substring(0, pos));
            //System.out.println("CD "+cd);
            agc.setCdAgcConta(cd);
            agc.retornaAgenciaConta(agc);
            jLabelNrAgenciaDestino.setText("Nr Agência: " + agc.getNrAgencia());
            jLabelNrContaDestino.setText("Nr Conta: " + agc.getNrConta());
            jTextFieldVlContaDestino.setText(decimal.retornaDecimal(agc.getVlConta(), 6));

        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_jComboBoxContaDestinoPopupMenuWillBecomeInvisible

    private void jBtNovaTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaTransferenciaActionPerformed
        agc.retornaComboAgcConta(jComboBoxContaOrigem, agc);
        rotina = Rotinas.incluir;
        validaEstadoCampos();
    }//GEN-LAST:event_jBtNovaTransferenciaActionPerformed

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        try {
            double valor = Double.parseDouble(jTextFieldVlTransferência.getText().replace(".", "").replace(",", "."));
            double vlConta = Double.parseDouble(jTextFieldVlContaOrigem.getText().replace(".", "").replace(",", "."));
            if (jTextFieldVlTransferência.getText().length() < 3) {
                JOptionPane.showMessageDialog(null, "Informe um valor válido!");
                jTextFieldVlTransferência.grabFocus();
            } else if (jComboBoxContaDestino.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a conta a ser creditada!");
                jComboBoxContaDestino.grabFocus();
            } else if (valor > vlConta) {
                JOptionPane.showMessageDialog(null, "Não é possível transferir um valor maior que o valor da conta!");
                jTextFieldVlTransferência.grabFocus();
            } else {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer a tranferência de R$ " + valor
                        + " entre as contas ?", "Confirmar Transferência", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    gravarTransferencia(valor);
                    JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
                    limpar.limparCampos(this);
                    rotina = Rotinas.padrao;
                    validaEstadoCampos();
                }
            }
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido!");
            jTextFieldVlTransferência.grabFocus();
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jTextFieldVlTransferênciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVlTransferênciaKeyTyped
        new ValidaCampos().validaCamposApenasNumeros(evt);
    }//GEN-LAST:event_jTextFieldVlTransferênciaKeyTyped

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        limpar.limparCampos(this);
        validaEstadoCampos();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtCadAgenciaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadAgenciaContaActionPerformed
        CadastroAgenciaConta cadAgc = new CadastroAgenciaConta();
        cadAgc.setVisible(true);

        cadAgc.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {

                agc.retornaComboAgcConta(jComboBoxContaOrigem, agc);
            }
        });
    }//GEN-LAST:event_jBtCadAgenciaContaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTransferenciaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTransferenciaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTransferenciaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTransferenciaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTransferenciaContas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadAgenciaConta;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtGravar;
    private javax.swing.JButton jBtNovaTransferencia;
    private javax.swing.JComboBox jComboBoxContaDestino;
    private javax.swing.JComboBox jComboBoxContaOrigem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNrAgenciaDestino;
    private javax.swing.JLabel jLabelNrAgenciaOrigem;
    private javax.swing.JLabel jLabelNrContaDestino;
    private javax.swing.JLabel jLabelNrContaOrigem;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldVlContaDestino;
    private javax.swing.JTextField jTextFieldVlContaOrigem;
    private javax.swing.JTextField jTextFieldVlTransferência;
    // End of variables declaration//GEN-END:variables

    private void gravarTransferencia(double valor) {
        RetornaData data = new RetornaData();
        int pos = jComboBoxContaOrigem.getSelectedItem().toString().indexOf(" ");
        int cd = Integer.parseInt(jComboBoxContaOrigem.getSelectedItem().toString().substring(0, pos));
        agc.setCdAgcConta(cd);
        double vlAnterior = Double.parseDouble(jTextFieldVlContaOrigem.getText().replace(".", "").replace(",", "."));
        // atualiza a conta a ser debitada
        agc.setVlConta(vlAnterior - valor);
        agc.atualizarValorConta(agc);

        mov.setAgc(agc);
        mov.setDataMov(data.retornaDataAtual());
        mov.setValorMov(valor);
        mov.setSaldoAnterior(vlAnterior);
        mov.setSaldoFinal(agc.getVlConta());
        mov.getOperacao().setCdOperacao(7);
        // OPERAÇÃO "SAÍDA POR TRANSFERÊNCIA BANCÁRIA"
        mov.setObservacao("SAÍDA POR TRANSFERÊNCIA");
        // grava a movimentação de saída na conta a ser debitada
        mov.incluir(mov, false);
        jTextFieldVlContaOrigem.setText(decimal.retornaDecimal(agc.getVlConta(), 6));

        pos = jComboBoxContaDestino.getSelectedItem().toString().indexOf(" ");
        cd = Integer.parseInt(jComboBoxContaDestino.getSelectedItem().toString().substring(0, pos));
        agc.setCdAgcConta(cd);
        vlAnterior = Double.parseDouble(jTextFieldVlContaDestino.getText().replace(".", "").replace(",", "."));
        // atualiza a conta creditada
        agc.setVlConta(vlAnterior + valor);
        agc.atualizarValorConta(agc);
        mov.setAgc(agc);

        mov.setSaldoAnterior(vlAnterior);
        mov.setSaldoFinal(agc.getVlConta());
        mov.getOperacao().setCdOperacao(8);
        // OPERAÇÃO "ENTRADA POR TRANSFERÊNCIA BANCÁRIA"
        mov.setObservacao("ENTRADA POR TRANSFERÊNCIA");
        // grava a movimentação de entrada na conta creditada
        mov.incluir(mov, false);

        jTextFieldVlContaDestino.setText(decimal.retornaDecimal(agc.getVlConta(), 6));
    }

    private void validaEstadoCampos() {
        ValidaBotoes botoes = new ValidaBotoes();
        botoes.validaEstadoCampos(this.getContentPane(), rotina);
        jTextFieldVlContaOrigem.setEnabled(false);
        jTextFieldVlContaDestino.setEnabled(false);
    }
}
