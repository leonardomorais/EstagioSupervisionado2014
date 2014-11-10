
package Consultas;

import Cadastros.CadastroMesa;
import Classes.AtendimentoMesa;
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
public class ConsultaMesa extends javax.swing.JDialog {

    AtendimentoMesa atd = new AtendimentoMesa();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form ConsultaMesa
     */
    public ConsultaMesa(java.awt.Frame telaOrigem, boolean modal) {
        super(telaOrigem, modal);
        initComponents();
        valida.validaNivel(null);
        jBtCadastrarNova.setEnabled(valida.validaBotaoCadastro(jBtCadastrarNova.getName()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuCsMesa = new javax.swing.JPopupMenu();
        jMenuItemAtivarMesa = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMesa = new javax.swing.JTable();
        jTableMesa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtSelecionar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtSelecionar, KeyEvent.VK_ENTER, 0);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtCadastrarNova = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCadastrarNova, KeyEvent.VK_F4, 0);

        jPopupMenuCsMesa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuCsMesaPopupMenuWillBecomeVisible(evt);
            }
        });

        jMenuItemAtivarMesa.setText("Ativar Mesa");
        jMenuItemAtivarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtivarMesaActionPerformed(evt);
            }
        });
        jPopupMenuCsMesa.add(jMenuItemAtivarMesa);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Mesa");

        jLabel1.setText("Filtro da Consulta");

        jTableMesa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMesa.setComponentPopupMenu(jPopupMenuCsMesa);
        jTableMesa.getTableHeader().setReorderingAllowed(false);
        jTableMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMesaMouseClicked(evt);
            }
        });
        jTableMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableMesaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMesa);

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

        jBtCadastrarNova.setText("Exibir Cadastro");
        jBtCadastrarNova.setToolTipText("Exibir Cadastro (F4)");
        jBtCadastrarNova.setName("CADASTRAR MESA"); // NOI18N
        jBtCadastrarNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastrarNovaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtCadastrarNova)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtCadastrarNova))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        int linha = jTableMesa.getSelectedRow();
        if (linha >= 0) {
            String situacao = jTableMesa.getValueAt(linha, 2).toString();
            if (situacao.equals("INATIVA")) {
                JOptionPane.showMessageDialog(null, "Não é permitido selecionar uma mesa inativa no atendimento!");
            } else {

                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro !");
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        atd.getMesa().setNrMesa(0);
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jTableMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMesaMouseClicked
        int linha = jTableMesa.getSelectedRow(); 
        atd.getMesa().setNrMesa(Integer.parseInt(jTableMesa.getValueAt(linha, 0).toString()));
    }//GEN-LAST:event_jTableMesaMouseClicked

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableMesa, new int[]{100, 200, 140});

        if (jComboBoxConsulta.getSelectedIndex() == 0) {
            preencher.PreencherJtableGenerico(jTableMesa, atd.getMesa().consultarGeral());
        } else if (jComboBoxConsulta.getSelectedIndex() == 1) {

            try {
                atd.getMesa().setNrMesa(Integer.parseInt(jTextFieldConsulta.getText()));
                preencher.PreencherJtableGenerico(jTableMesa, atd.getMesa().consultarNrMesa(atd.getMesa()));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um número para pesquisar!");
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();

            }
        } else {
            atd.getMesa().setDsMesa(jTextFieldConsulta.getText().toUpperCase());
            preencher.PreencherJtableGenerico(jTableMesa, atd.getMesa().consultarDescricao(atd.getMesa()));
        }
        if (preencher.Vazia()){
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jMenuItemAtivarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtivarMesaActionPerformed
        int linha = jTableMesa.getSelectedRow();
        if (linha >= 0) {
            int nr = Integer.parseInt(jTableMesa.getValueAt(linha, 0).toString());
            String ds = jTableMesa.getValueAt(linha, 1).toString();
            atd.getMesa().setNrMesa(nr);
            atd.getMesa().setDsMesa(ds);
            atd.getMesa().setInAtiva("A");
            
            atd.getMesa().alterar(atd.getMesa());
            jBtPesquisarActionPerformed(null);
        }


    }//GEN-LAST:event_jMenuItemAtivarMesaActionPerformed

    private void jPopupMenuCsMesaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuCsMesaPopupMenuWillBecomeVisible
        int linha = jTableMesa.getSelectedRow();
        String situacao = "";
        if (linha >= 0) {
            situacao = jTableMesa.getValueAt(linha, 2).toString();
            if (situacao.equals("ATIVA")) {
                jMenuItemAtivarMesa.setEnabled(false);
            } else {
                jMenuItemAtivarMesa.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jPopupMenuCsMesaPopupMenuWillBecomeVisible

    private void jBtCadastrarNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastrarNovaActionPerformed
        CadastroMesa cadMesa = new CadastroMesa();
        cadMesa.setVisible(true);
          
        cadMesa.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evento) {
            jComboBoxConsulta.setSelectedIndex(0);
            jBtPesquisarActionPerformed(null);
            }
        });
    }//GEN-LAST:event_jBtCadastrarNovaActionPerformed

    private void jTableMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMesaKeyPressed
        int linha = jTableMesa.getSelectedRow();
            if (linha >= 0 && evt.getKeyChar() == KeyEvent.VK_ENTER) {
                jBtSelecionarActionPerformed(null);
            }
            else{
                evt.consume();
            }
    }//GEN-LAST:event_jTableMesaKeyPressed

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
//            java.util.logging.Logger.getLogger(ConsultaMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaMesa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastrarNova;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemAtivarMesa;
    private javax.swing.JPopupMenu jPopupMenuCsMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMesa;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables
}
