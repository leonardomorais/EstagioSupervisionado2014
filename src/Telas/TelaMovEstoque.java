
package Telas;

import Classes.MovEstoque;
import Validacoes.PreencherTabela;
import Validacoes.RetornaData;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Leonardo
 */
public class TelaMovEstoque extends javax.swing.JFrame {
    
    MovEstoque estoque = new MovEstoque();
    RetornaData rdata = new RetornaData();
    
    MaskFormatter data;

    /**
     * Creates new form TelaMovEstoque
     */
    public TelaMovEstoque() {
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
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTextFieldConsulta = new javax.swing.JTextField();
        jComboBoxAux = new javax.swing.JComboBox();
        try{       data = new MaskFormatter("##/##/####");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jFormattedTextFieldDataFinal = new JFormattedTextField(data);
        try{       data = new MaskFormatter("##/##/####");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jFormattedTextFieldDataInicial = new JFormattedTextField(data);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Movimentação de Estoque");

        jLabel1.setText("Selecione o Filtro");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Cd Mov", "Cd Venda Compra", "Cd Produto", "Produto", "Período", "Tipo" }));
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
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cd Mov", "Cd Venda Compra", "Cd Produto", "Produto", "Qtd Anterior", "Qtd Atual", "Valor", "Valor Custo", "Data", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setOpaque(false);
        jScrollPane1.setViewportView(jTableConsulta);

        jComboBoxAux.setEnabled(false);

        jFormattedTextFieldDataFinal.setEnabled(false);

        jFormattedTextFieldDataInicial.setEnabled(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("a");

        jLabel3.setText("Consulta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxConsulta, 0, 165, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAux, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtPesquisar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtPesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int [] {60, 110, 100, 250, 80, 70, 70, 70, 70, 70});
        
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarGeral());
            break;    
            
            case 1:
                try{
                    estoque.setCdMov(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarCdMov(estoque));
                }
                catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null, "Informe um código para pesquisar!");
                   jTextFieldConsulta.setText("");
                   jTextFieldConsulta.grabFocus();
                }
            break;
                
            case 2:
                try{
                    estoque.setCdVendaCompra(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarCdVendaCompra(estoque));
                }
                catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null, "Informe um código para pesquisar!");
                   jTextFieldConsulta.setText("");
                   jTextFieldConsulta.grabFocus();
                }
            break;
                
            case 3:
                try{
                   estoque.setCdProduto(Integer.parseInt(jTextFieldConsulta.getText()));
                   preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarCdProduto(estoque));
                }
                catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null, "Informe um código para pesquisar!");
                   jTextFieldConsulta.setText("");
                   jTextFieldConsulta.grabFocus();
                }
            break;
                
            case 4:
                preencher.PreencherJtableGenerico(jTableConsulta, 
                        estoque.consultarProduto(jTextFieldConsulta.getText().toUpperCase()));
            break;
                
            case 5:
                if (datasValidas()){
                    String dt = jFormattedTextFieldDataInicial.getText();
                    String dt2 = jFormattedTextFieldDataFinal.getText();
                    preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarPeriodo(dt, dt2));
                }
            break;
                
            default:
                estoque.setEntrada(jComboBoxAux.getSelectedItem().toString().toUpperCase().substring(0, 1));
                preencher.PreencherJtableGenerico(jTableConsulta, estoque.consultarTipo(estoque));
        }
        
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jComboBoxConsultaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(false);
                jComboBoxAux.removeAllItems();
                jComboBoxAux.setEnabled(false);
            break;
                
            case 5:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(false);
                jComboBoxAux.removeAllItems();
                jComboBoxAux.setEnabled(false);
                jFormattedTextFieldDataFinal.setText("");
                jFormattedTextFieldDataInicial.setText("");
                jFormattedTextFieldDataFinal.setEnabled(true);
                jFormattedTextFieldDataInicial.setEnabled(true);
            break;    
                
            case 6:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(false);
                jComboBoxAux.removeAllItems();
                jComboBoxAux.addItem("Entrada");
                jComboBoxAux.addItem("Saída");
                jComboBoxAux.setEnabled(true);
                jFormattedTextFieldDataFinal.setText("");
                jFormattedTextFieldDataInicial.setText("");
                jFormattedTextFieldDataFinal.setEnabled(false);
                jFormattedTextFieldDataInicial.setEnabled(false);
            break;    
                
            default:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(true);
                jComboBoxAux.removeAllItems();
                jComboBoxAux.setEnabled(false);
                jFormattedTextFieldDataFinal.setText("");
                jFormattedTextFieldDataInicial.setText("");
                jFormattedTextFieldDataFinal.setEnabled(false);
                jFormattedTextFieldDataInicial.setEnabled(false);
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
            java.util.logging.Logger.getLogger(TelaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMovEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JComboBox jComboBoxAux;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataFinal;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldConsulta;
    // End of variables declaration//GEN-END:variables

    private boolean datasValidas(){
        boolean valida = false;
        
            String dt1 = jFormattedTextFieldDataInicial.getText();
            String dt2 = jFormattedTextFieldDataFinal.getText();

            if (!rdata.dataExiste(dt1) || (!rdata.dataExiste(dt2))){
                JOptionPane.showMessageDialog(null, "Por favor, informe duas datas validas");
                jFormattedTextFieldDataInicial.setText("");
                jFormattedTextFieldDataFinal.setText("");
                jFormattedTextFieldDataInicial.grabFocus();
            }
            else if (dt1.equals(dt2)){
                JOptionPane.showMessageDialog(null, "As datas devem ser diferentes!");
            }
            else if (rdata.comparaData(dt1, dt2)>=0){
                JOptionPane.showMessageDialog(null, "Datas ou intervalo entre datas inválido!");
            }
            else {
                valida = true;
            }
        return valida;
    }

}