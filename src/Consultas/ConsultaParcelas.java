
package Consultas;

import Classes.Parcelas;
import Telas.TelaPagamento;
import Validacoes.MostrarDialogo;
import Validacoes.PreencherTabela;

/**
 *
 * @author Leonardo
 */
public class ConsultaParcelas extends javax.swing.JFrame {

    
    Parcelas parcelas = new Parcelas();
    /**
     * Creates new form ConsultaParcelas
     */
    public ConsultaParcelas() {
        initComponents();
        exibirParcelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuPagaParcela = new javax.swing.JPopupMenu();
        jMenuItemPagarParcela = new javax.swing.JMenuItem();
        jLabelTopo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParcelas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jPopupMenuPagaParcela.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuPagaParcelaPopupMenuWillBecomeVisible(evt);
            }
        });

        jMenuItemPagarParcela.setText("Pagar Parcela");
        jMenuItemPagarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagarParcelaActionPerformed(evt);
            }
        });
        jPopupMenuPagaParcela.add(jMenuItemPagarParcela);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Parcelas Geradas");
        setResizable(false);

        jLabelTopo.setText("Parcelas");

        jTableParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Conta", "Nr Parcela", "Valor", "Data Vencimento", "Valor Pago", "Data Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableParcelas.setComponentPopupMenu(jPopupMenuPagaParcela);
        jTableParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableParcelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableParcelas);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addComponent(jLabelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelTopo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableParcelasMouseClicked
        int linha = jTableParcelas.getSelectedRow();
        int coluna = jTableParcelas.getSelectedColumn();
        if (coluna == 3){
            try{
                String dataPago = jTableParcelas.getValueAt(linha, 5).toString();
            }
            catch(NullPointerException ex){
                String data = jTableParcelas.getValueAt(linha, coluna).toString();
                MostrarDialogo dialogo = new MostrarDialogo();
                String valor = dialogo.dialogoData(data);
                jTableParcelas.setValueAt(valor, linha, coluna);
                if (!data.equals(valor)){
                    // sofreu alteração
                parcelas.setNrParcela(Integer.parseInt(jTableParcelas.getValueAt(linha, 1).toString()));
                parcelas.setVlParcela(Double.parseDouble(jTableParcelas.getValueAt(linha, 2).toString()));
                parcelas.setDtVencimento(valor);
                parcelas.getContas().setCdConta(Integer.parseInt(jTableParcelas.getValueAt(linha, 0).toString()));
                // altera a parcela
                parcelas.alterar(parcelas);
                }
            }
        }
    }//GEN-LAST:event_jTableParcelasMouseClicked

    private void jMenuItemPagarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagarParcelaActionPerformed
        int linha = jTableParcelas.getSelectedRow();
        int cdConta = Integer.parseInt(jTableParcelas.getValueAt(linha, 0).toString());
        int parcela = Integer.parseInt(jTableParcelas.getValueAt(linha, 1).toString());
        
        TelaPagamento tela = new TelaPagamento();
        tela.setVisible(true);
        tela.carregarConta(cdConta, parcela);
        
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evento){
                exibirParcelas();
            }
});
        
        
    }//GEN-LAST:event_jMenuItemPagarParcelaActionPerformed

    private void jPopupMenuPagaParcelaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuPagaParcelaPopupMenuWillBecomeVisible
        int linha = jTableParcelas.getSelectedRow();
        if (linha >= 0) {
            try {
                String valor = jTableParcelas.getValueAt(linha, 4).toString();
                String data = jTableParcelas.getValueAt(linha, 5).toString();
                if (valor.equals("0.00") || data.equals("")) {
                    jMenuItemPagarParcela.setEnabled(true);
                } else {
                    jMenuItemPagarParcela.setEnabled(false);
                }
            } catch (NullPointerException ex) {
                jMenuItemPagarParcela.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jPopupMenuPagaParcelaPopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaParcelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelTopo;
    private javax.swing.JMenuItem jMenuItemPagarParcela;
    private javax.swing.JPopupMenu jPopupMenuPagaParcela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableParcelas;
    // End of variables declaration//GEN-END:variables

    public void exibirParcelas(){
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableParcelas, new int[] {90,90,90,90,90,90});
        preencher.PreencherJtableGenerico(jTableParcelas, parcelas.consultarCdConta(parcelas.getContas()));
        parcelas.getContas().retornaConta(parcelas.getContas(), true);
        jLabelTopo.setText("Parcelas da Conta "+parcelas.getContas().getCdConta()+" : "+parcelas.getContas().getDsConta());
    }

}
