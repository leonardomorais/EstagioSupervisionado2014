package Consultas;

import Cadastros.CadastroAgenciaConta;
import Classes.AgenciaConta;
import Validacoes.PreencherTabela;
import Validacoes.TeclasdeAtalho;
import Validacoes.ValidaNivelUsuario;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leonardo
 */
public class ConsultaAgenciaConta extends javax.swing.JDialog {

    AgenciaConta agcConta = new AgenciaConta();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form ConsultaAgenciaConta
     */
    public ConsultaAgenciaConta(java.awt.Frame telaOrigem, boolean modal) {
        super(telaOrigem, modal);
        initComponents();
        valida.validaNivel(null);
        jBtCadastrar.setEnabled(valida.validaAcessoTela(jBtCadastrar.getName()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jBtCadastrar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCadastrar, KeyEvent.VK_F4, 0);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtSelecionar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtSelecionar, KeyEvent.VK_ENTER, 0);
        jTextFieldConsulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Agência Conta");
        setResizable(false);

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

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Banco", "Nr Agência", "Nr Conta", "Descrição", "Valor", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jTableConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableConsultaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        jBtCadastrar.setText("Exibir Cadastro");
        jBtCadastrar.setToolTipText("Exibir Cadastro (F4)");
        jBtCadastrar.setName("CADASTRAR AGÊNCIA CONTA"); // NOI18N
        jBtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.setToolTipText("Selecionar (Enter)");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCadastrar)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSelecionar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{80, 100, 60, 60, 100, 80, 80});

        switch (jComboBoxConsulta.getSelectedIndex()) {
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, agcConta.consultarGeral());
                break;

            case 1:
                try {
                    agcConta.setCdAgcConta(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, agcConta.consultarCdAgc(agcConta));
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    jTextFieldConsulta.setText("");
                    jTextFieldConsulta.grabFocus();
                }
                break;

            default:
                agcConta.setDsConta(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, agcConta.consultarDsConta(agcConta));
        }
        if (preencher.Vazia()){
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jBtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarActionPerformed
        CadastroAgenciaConta cad = new CadastroAgenciaConta();
        cad.setVisible(true);
        cad.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evento) {
                jComboBoxConsulta.setSelectedIndex(0);
                jBtPesquisarActionPerformed(null);
            }
        });
    }//GEN-LAST:event_jBtCadastrarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        agcConta.setCdAgcConta(0);
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        int linha = jTableConsulta.getSelectedRow();
        agcConta.setCdAgcConta(Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString()));
        agcConta.setDsConta(jTableConsulta.getValueAt(linha, 4).toString());
        agcConta.setInAtivo(jTableConsulta.getValueAt(linha, 6).toString());
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        int linha = jTableConsulta.getSelectedRow();
        if (linha >= 0) {
            if (agcConta.getInAtivo().equals("INATIVA")) {
                JOptionPane.showMessageDialog(null, "Não é permitido selecionar uma conta inativa!");
            } else {

                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro !");
        }

    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jTableConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableConsultaKeyPressed
            int linha = jTableConsulta.getSelectedRow();
            if (linha >= 0 && evt.getKeyChar() == KeyEvent.VK_ENTER) {
                agcConta.setCdAgcConta(Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString()));
                agcConta.setDsConta(jTableConsulta.getValueAt(linha, 4).toString());
                agcConta.setInAtivo(jTableConsulta.getValueAt(linha, 6).toString());
                jBtSelecionarActionPerformed(null);
            }
    }//GEN-LAST:event_jTableConsultaKeyPressed

    private void jComboBoxConsultaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible
         switch (jComboBoxConsulta.getSelectedIndex()) {
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
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ConsultaAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaAgenciaConta().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables

}
