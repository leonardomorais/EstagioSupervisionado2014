package Consultas;

import Classes.Parcelas;
import Dialogos.DialogoData;
import Relatorios.Relatorios;
import Telas.TelaPagamento;
import Validacoes.EditarComponentes;
import Validacoes.PreencherTabela;
import Validacoes.TeclasdeAtalho;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leonardo
 */
public class ConsultaParcelas extends javax.swing.JFrame {

    Parcelas parcelas = new Parcelas();

    EditarComponentes edit = new EditarComponentes();
    int cod;
    String name;
    public int rotina;
    /**
     * Creates new form ConsultaParcelas
     */
    public ConsultaParcelas() {
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

        jPopupMenuPagaParcela = new javax.swing.JPopupMenu();
        jMenuItemPagarParcela = new javax.swing.JMenuItem();
        jLabelTopo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParcelas = new javax.swing.JTable();
        jTableParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jBtFechar = new javax.swing.JButton();
        TeclasdeAtalho atalho = new TeclasdeAtalho();
        atalho.adicionarAtalho(jBtFechar, KeyEvent.VK_ESCAPE, 0);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        jMenuItemPagarParcela.setToolTipText("");
        jMenuItemPagarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagarParcelaActionPerformed(evt);
            }
        });
        jPopupMenuPagaParcela.add(jMenuItemPagarParcela);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Parcelas");
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
        jTableParcelas.getTableHeader().setReorderingAllowed(false);
        jTableParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableParcelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableParcelas);

        jBtFechar.setText("Fechar");
        jBtFechar.setToolTipText("Fechar (Esc)");
        jBtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFecharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 134, 8));
        jLabel1.setText("- Parcelas devem ser pagas hoje");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("- Parcelas em atraso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTopo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtFechar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableParcelasMouseClicked
        final int linha = jTableParcelas.getSelectedRow();
        final int coluna = jTableParcelas.getSelectedColumn();
        if (linha >=0 && evt.getClickCount() == 2){
            if (coluna == 3) {
                try {
                    String dataPago = jTableParcelas.getValueAt(linha, 5).toString();
                } 
                catch (NullPointerException ex) {
                    final String data = jTableParcelas.getValueAt(linha, coluna).toString();
                    final DialogoData dialogo = new DialogoData(this, true, data);
                    dialogo.setVisible(true);
                    dialogo.addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                            String valor = dialogo.retorno();
                            jTableParcelas.setValueAt(valor, linha, coluna);
                            if (!data.equals(valor)) {
                                // sofreu alteração
                                parcelas.setNrParcela(Integer.parseInt(jTableParcelas.getValueAt(linha, 1).toString()));
                                parcelas.setVlParcela(Double.parseDouble(jTableParcelas.getValueAt(linha, 2).toString()));
                                parcelas.setDtVencimento(valor);
                                parcelas.getContas().setCdConta(Integer.parseInt(jTableParcelas.getValueAt(linha, 0).toString()));
                                // altera a parcela
                                parcelas.alterar(parcelas);
                                parcelas.getContas().retornaConta(parcelas.getContas(), true);
                                parcelas.getContas().setDtVencimento(parcelas.retornaDataUltimaParcela(parcelas));
                            }
                            jTableParcelas.clearSelection();
                        }
                    });

                }
            }
        }
    }//GEN-LAST:event_jTableParcelasMouseClicked

    private void jMenuItemPagarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagarParcelaActionPerformed
        int linha = jTableParcelas.getSelectedRow();
        if (linha >= 0) {
            int cdConta = Integer.parseInt(jTableParcelas.getValueAt(linha, 0).toString());
            int parcela = Integer.parseInt(jTableParcelas.getValueAt(linha, 1).toString());

            TelaPagamento tela = new TelaPagamento();
            tela.setVisible(true);
            tela.carregarConta(cdConta, parcela);

            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evento) {
                    if (rotina == 1){
                        exibirParcelas();
                    }
                    else{
                        exibirParcelasPessoa(cod, name);
                    }
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma parcela!");
        }
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

    private void jBtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFecharActionPerformed
        if (rotina == 1){
            Relatorios report = new Relatorios();
            report.setConsulta(parcelas.consultarCdConta(parcelas.getContas(), true));
            report.setSubreport(false);
            report.setTabela("TICKET_PARCELAS");
            report.iniciarSplash(report);
        }
        dispose();
    }//GEN-LAST:event_jBtFecharActionPerformed

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
    private javax.swing.JButton jBtFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTopo;
    private javax.swing.JMenuItem jMenuItemPagarParcela;
    private javax.swing.JPopupMenu jPopupMenuPagaParcela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableParcelas;
    // End of variables declaration//GEN-END:variables

    public void exibirParcelas() {
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableParcelas, new int[]{90, 90, 90, 90, 90, 90});
        parcelas.getContas().setCdConta(cod);
        preencher.PreencherJtableGenerico(jTableParcelas, parcelas.consultarCdConta(parcelas.getContas(),true));
        parcelas.getContas().retornaConta(parcelas.getContas(), true);
        jLabelTopo.setText("Parcelas da Conta " + parcelas.getContas().getCdConta() + " : " + parcelas.getContas().getDsConta());
        if (!preencher.Vazia()){
            edit.setTipo("PARCELAS");
            edit.editarTabela(jTableParcelas);
        }
    }

    public void exibirParcelasPessoa(int cd, String nome){
        cod = cd;
        name = nome;
        rotina = 0;
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableParcelas, new int [] {90, 90, 90, 90, 90, 90});
        preencher.PreencherJtableGenerico(jTableParcelas, parcelas.consultarCdPessoa(cd, true));
        if (preencher.Vazia()){
           jLabelTopo.setText("Nenhuma parcela encontrada de "+nome);
        }
        else{
            jLabelTopo.setText("Parcelas de "+nome);
            edit.setTipo("PARCELAS");
            edit.editarTabela(jTableParcelas);
        }
//        edit.setTipo("PARCELAS");
//        edit.editarTabela(jTableParcelas);
        
        
    }
}
