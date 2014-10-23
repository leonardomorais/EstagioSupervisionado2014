package Telas;

import Classes.Produto;
import Relatorios.Relatorios;
import Validacoes.PreencherTabela;
import Validacoes.TeclasdeAtalho;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class SaldoProdutos extends javax.swing.JFrame {

    Produto produto = new Produto();
    Relatorios report = new Relatorios();
    TeclasdeAtalho atalho = new TeclasdeAtalho();
    /**
     * Creates new form SaldoProdutos
     */
    public SaldoProdutos() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jBtRelatorio = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtRelatorio, KeyEvent.VK_F6, 0);
        jComboBoxConsulta = new javax.swing.JComboBox();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Saldo dos Produtos");
        setResizable(false);

        jLabel1.setText("Filtro da Consulta");

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Quantidade Atual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setToolTipText("Relatório (F6)");
        jBtRelatorio.setEnabled(false);
        jBtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRelatorioActionPerformed(evt);
            }
        });

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Descrição" }));

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.setToolTipText("Pesquisar (F5)");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtRelatorio)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jBtRelatorio)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableProdutos, new int [] {100, 372, 100});
        int index = jComboBoxConsulta.getSelectedIndex();
        switch (index){
            case 1:
                try{
                    produto.setCdProduto(Integer.parseInt(jTextFieldConsulta.getText()));
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    editaBotao(true);
                }
            break;
                
            case 2:
                produto.setDsProduto(jTextFieldConsulta.getText().toUpperCase());
            break;    
        }
        preencher.PreencherJtableGenerico(jTableProdutos, produto.consultarSaldo(produto, index));
        report.setConsulta(preencher.getConsulta());
        editaBotao(preencher.Vazia());
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        report.setSubreport(false);
        report.setTabela("SALDO_PRODUTOS");
        report.gerarRelatorio(report);
        jBtPesquisarActionPerformed(null);
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
            java.util.logging.Logger.getLogger(SaldoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaldoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaldoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaldoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaldoProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables

    public void editaBotao(boolean vazia) {
        if (vazia) {
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jBtRelatorio.setEnabled(false);
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        } else {
            jBtRelatorio.setEnabled(true);
        }
    }

}
