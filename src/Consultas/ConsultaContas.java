package Consultas;

import Cadastros.CadastroContas;
import Classes.Contas;
import Validacoes.PreencherTabela;
import Validacoes.TeclasdeAtalho;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ConsultaContas extends javax.swing.JDialog {
    
    Contas contas = new Contas();
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form ConsultaContas
     */
    public ConsultaContas(java.awt.Frame telaOrigem, boolean modal) {
        super(telaOrigem, modal);
        initComponents();
        
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
        jTableConta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtSelecionar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtSelecionar, KeyEvent.VK_ENTER, 0);
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtCadastro = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCadastro, KeyEvent.VK_F4, 0);
        jComboBoxTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Contas");
        setResizable(false);

        jTableConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Cd Forma", "Forma Pgto", "Valor", "Data Vencimento", "Data Pagamento", "Tipo", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContaMouseClicked(evt);
            }
        });
        jTableConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableContaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConta);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Descrição", "Tipo" }));
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

        jBtCadastro.setText("Exibir Cadastro");
        jBtCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCadastroActionPerformed(evt);
            }
        });

        jComboBoxTipo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtPesquisar)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCancelar)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtCadastro))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxConsultaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 3:
                jComboBoxTipo.setEnabled(true);
                jComboBoxTipo.removeAllItems();
                jComboBoxTipo.addItem("Receber");
                jComboBoxTipo.addItem("Pagar");
            break;
            default:
                jComboBoxTipo.removeAllItems();
                jComboBoxTipo.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConta, new int [] {50, 100, 55, 90, 60, 95, 90, 70, 70});
        
        switch(jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConta, contas.consultarGeral(false));
            break;
            
            case 1:
                try{
                    contas.setCdConta(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConta, contas.consultarCdConta(contas, false));
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    jTextFieldConsulta.setText("");
                    jTextFieldConsulta.grabFocus();
                }
            break;
                
            case 2:
                contas.setDsConta(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConta, contas.consultarDescricao(contas, false));
            break;
            
            default:
                switch (jComboBoxTipo.getSelectedIndex()){
                    case 0 :
                        contas.setTpConta("R");
                    break;
                    
                    default:
                        contas.setTpConta("P");
                }
            preencher.PreencherJtableGenerico(jTableConta, contas.consultarTipo(contas, false));
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTableContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContaMouseClicked
        int linha = jTableConta.getSelectedRow();
        contas.setCdConta(Integer.parseInt(jTableConta.getValueAt(linha, 0).toString()));
        contas.retornaConta(contas, false);
    }//GEN-LAST:event_jTableContaMouseClicked

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        int linha = jTableConta.getSelectedRow();
        if (linha >= 0){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro!");
        }
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        contas.setCdConta(0);
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCadastroActionPerformed
        CadastroContas cad = new CadastroContas();
        cad.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        cad.setVisible(true);
        cad.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evento) {
                jComboBoxConsulta.setSelectedIndex(0);
                jBtPesquisarActionPerformed(null);
            }
        });
    }//GEN-LAST:event_jBtCadastroActionPerformed

    private void jTableContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableContaKeyPressed
        int linha = jTableConta.getSelectedRow();
            if (linha >= 0 && evt.getKeyChar() == KeyEvent.VK_ENTER) {
                jBtSelecionarActionPerformed(null);
            }
            else{
                evt.consume();
            }
    }//GEN-LAST:event_jTableContaKeyPressed
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
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ConsultaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaContas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCadastro;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConta;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables
}
