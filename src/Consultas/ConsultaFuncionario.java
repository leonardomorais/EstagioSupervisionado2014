
package Consultas;

import Cadastros.CadastroFuncionario;
import Classes.AtendimentoMesa;
import Classes.Funcionario;
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
public class ConsultaFuncionario extends javax.swing.JDialog {

    //AtendimentoMesa atd = new AtendimentoMesa();
    
    Funcionario funcionario = new Funcionario();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form ConsultaFuncionario
     */
    public ConsultaFuncionario(java.awt.Frame telaOrigem, boolean modal) {
        super(telaOrigem, modal);
        initComponents();
        valida.validaNivel(null);
        jBtCadastrarNovo.setEnabled(valida.validaBotaoCadastro(jBtCadastrarNovo.getName()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jTableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtSelecionar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtSelecionar, KeyEvent.VK_ENTER, 0);

        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtCadastrarNovo = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCadastrarNovo, KeyEvent.VK_F4, 0);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Funcionário");
        setResizable(false);

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jTableFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableFuncionariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Nome" }));
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

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.setToolTipText("Selecionar (Enter)");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtCadastrarNovo.setText("Exibir Cadastro");
        jBtCadastrarNovo.setToolTipText("Exibir Cadastro (F4)");
        jBtCadastrarNovo.setName("CADASTRAR FUNCIONÁRIOS"); // NOI18N
        jBtCadastrarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtCadastrarNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtCadastrarNovo))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        int linha = jTableFuncionarios.getSelectedRow();
        if(linha >= 0){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro !");
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        funcionario.setCdFuncionario(0);
        //atd.getFuncionario().setCdFuncionario(0);
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableFuncionarios, new int[]{100, 280, 100, 100});

        if (jComboBoxConsulta.getSelectedIndex() == 0) {
            //preencher.PreencherJtableGenerico(jTableFuncionarios, atd.getFuncionario().consultarGeral(false));
            preencher.PreencherJtableGenerico(jTableFuncionarios, funcionario.consultarGeral(false));
        } else if (jComboBoxConsulta.getSelectedIndex() == 1) {
            try {
                //atd.getFuncionario().setCdFuncionario(Integer.parseInt(jTextFieldConsulta.getText()));
                funcionario.setCdFuncionario(Integer.parseInt(jTextFieldConsulta.getText()));
                preencher.PreencherJtableGenerico(jTableFuncionarios, funcionario.consultarCdFuncionario(funcionario, false));
//                preencher.PreencherJtableGenerico(jTableFuncionarios,
//                        atd.getFuncionario().consultarCdFuncionario(atd.getFuncionario(), false));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
            }
        } else {
//            atd.getFuncionario().getPessoa().setNome(jTextFieldConsulta.getText().toUpperCase());
//            preencher.PreencherJtableGenerico(jTableFuncionarios,
//                    atd.getFuncionario().consultarNomeFuncionario(atd.getFuncionario(), false));
            funcionario.getPessoa().setNome(jTextFieldConsulta.getText().toUpperCase());
            preencher.PreencherJtableGenerico(jTableFuncionarios, funcionario.consultarNomeFuncionario(funcionario, false));
        }
        if (preencher.Vazia()){
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked
        int linha = jTableFuncionarios.getSelectedRow();
        funcionario.setCdFuncionario(Integer.parseInt(jTableFuncionarios.getValueAt(linha, 0).toString()));
        //atd.getFuncionario().setCdFuncionario(Integer.parseInt(jTableFuncionarios.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jTableFuncionariosMouseClicked

    private void jBtCadastrarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarNovoActionPerformed
          CadastroFuncionario cadFunc = new CadastroFuncionario();
          cadFunc.setVisible(true);
           cadFunc.addWindowListener(new WindowAdapter() {
           public void windowClosed(WindowEvent evento) {
                jComboBoxConsulta.setSelectedIndex(0);
                jBtPesquisarActionPerformed(null);
           }
        });
    }//GEN-LAST:event_jBtCadastrarNovoActionPerformed

    private void jTableFuncionariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFuncionariosKeyPressed
        int linha = jTableFuncionarios.getSelectedRow();
            if (linha >= 0 && evt.getKeyChar() == KeyEvent.VK_ENTER) {
                jBtSelecionarActionPerformed(null);
            }
            else{
                evt.consume();
            }
    }//GEN-LAST:event_jTableFuncionariosKeyPressed

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

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaFuncionario().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrarNovo;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables
}
