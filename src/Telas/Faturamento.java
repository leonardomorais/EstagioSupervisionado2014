package Telas;

import Classes.VendaCompra;
import Relatorios.Relatorios;
import Validacoes.PreencherTabela;
import Validacoes.RetornaData;
import Validacoes.TeclasdeAtalho;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Leonardo
 */
public class Faturamento extends javax.swing.JFrame {

    MaskFormatter data;
    VendaCompra venda = new VendaCompra();
    Relatorios report = new Relatorios();
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();
    /**
     * Creates new form Faturamento
     */
    public Faturamento() {
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

        buttonGroupPeriodo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtRelatorio = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtRelatorio,   KeyEvent.VK_F6, 0);
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jTextFieldConsulta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRbtSIm = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jRbtSIm, KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        jrbtNao = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jrbtNao, KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
        try{       data = new MaskFormatter("##/##/####");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jFormattedTextFieldDataFinal = new JFormattedTextField(data);
        try{       data = new MaskFormatter("##/##/####");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jFormattedTextFieldDataInicial = new JFormattedTextField(data);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Venda", "Produto", "Quantidade", "Valor Unitário", "Total Venda", "Data Venda", "Cd Cliente", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Venda", "Cliente", "Produto" }));

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setToolTipText("Relatório (F6)");
        jBtRelatorio.setEnabled(false);
        jBtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRelatorioActionPerformed(evt);
            }
        });

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.setToolTipText("Pesquisar (F5)");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("Consulta");

        jLabel3.setText("Escolher Período");

        buttonGroupPeriodo.add(jRbtSIm);
        jRbtSIm.setSelected(true);
        jRbtSIm.setText("Sim");
        jRbtSIm.setToolTipText("Sim (Ctrl + S)");
        jRbtSIm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbtSImActionPerformed(evt);
            }
        });

        buttonGroupPeriodo.add(jrbtNao);
        jrbtNao.setText("Não");
        jrbtNao.setToolTipText("Não (Ctrl + N)");
        jrbtNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtNaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Inicial");

        jLabel5.setText("Data Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRbtSIm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbtNao))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtRelatorio))
                            .addComponent(jLabel5))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRbtSIm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbtNao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRbtSImActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbtSImActionPerformed
        jFormattedTextFieldDataInicial.setEnabled(true);
        jFormattedTextFieldDataFinal.setEnabled(true);
        jFormattedTextFieldDataInicial.setText("");
        jFormattedTextFieldDataFinal.setText("");
        jFormattedTextFieldDataInicial.grabFocus();
    }//GEN-LAST:event_jRbtSImActionPerformed

    private void jrbtNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtNaoActionPerformed
        jFormattedTextFieldDataInicial.setText("");
        jFormattedTextFieldDataFinal.setText("");
        jFormattedTextFieldDataInicial.setEnabled(false);
        jFormattedTextFieldDataFinal.setEnabled(false);
        jFormattedTextFieldDataInicial.grabFocus();
    }//GEN-LAST:event_jrbtNaoActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        if (jrbtNao.isSelected() || (jRbtSIm.isSelected() && datasValidas())) {
            String data = jFormattedTextFieldDataFinal.getText();
            venda.setDtVenda(jFormattedTextFieldDataInicial.getText());
            
            if (jrbtNao.isSelected()){
                data = "";
                venda.setDtVenda("");
            }
            
            PreencherTabela preencher = new PreencherTabela();
            preencher.FormatarJtable(jTableConsulta, new int [] {80, 80, 80, 80, 80, 80, 80, 300});
            
            switch (jComboBoxConsulta.getSelectedIndex()){
                case 0:
                    preencher.PreencherJtableGenerico(jTableConsulta, venda.consultarGeral(venda, data));
                    report.setConsulta(preencher.getConsulta());
                    editaBotao(preencher.Vazia());
                break;    
                    
                case 1:
                    try{
                        venda.setCdVendaCompra(Integer.parseInt(jTextFieldConsulta.getText()));
                        preencher.PreencherJtableGenerico(jTableConsulta, venda.consultarCdVenda(venda, data));
                        report.setConsulta(preencher.getConsulta());
                        editaBotao(preencher.Vazia());
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                        editaBotao(true);
                    }
                break;    
                    
                case 2:
                    try{
                        venda.getCliente().setCdCliente(Integer.parseInt(jTextFieldConsulta.getText()));
                        preencher.PreencherJtableGenerico(jTableConsulta, venda.consultarCdCliente(venda, data));
                        report.setConsulta(preencher.getConsulta());
                        editaBotao(preencher.Vazia());
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                        editaBotao(true);
                    }
                break;
                    
                default:
                    try{
                        venda.getVcProdutos().getProduto().setCdProduto(Integer.parseInt(jTextFieldConsulta.getText()));
                        preencher.PreencherJtableGenerico(jTableConsulta, venda.consultarCdProduto(venda, data));
                        report.setConsulta(preencher.getConsulta());
                        editaBotao(preencher.Vazia());
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                        editaBotao(true);
                    }
            }
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        HashMap params = new HashMap();
        report.setTabela("FATURAMENTO");
        report.setSubreport(false);
      
        if (jRbtSIm.isSelected()){
            params.put("PERIODO", "DE "+jFormattedTextFieldDataInicial.getText()+" A "
            +jFormattedTextFieldDataFinal.getText());
        }
        else{
            params.put("PERIODO","TODOS");
        }
        if (jComboBoxConsulta.getSelectedIndex() == 1){
            params.put("VENDA", jTextFieldConsulta.getText());
        }
        else{
            params.put("VENDA", "TODAS");
        }
        
        if (jComboBoxConsulta.getSelectedIndex() == 2){
            params.put("CLIENTE", jTextFieldConsulta.getText());
        }
        else{
            params.put("CLIENTE", "TODOS");
        }
        
        if (jComboBoxConsulta.getSelectedIndex() == 3){
            params.put("PRODUTO", jTextFieldConsulta.getText());
        }
        else{
            params.put("PRODUTO", "TODOS");
        }
        report.gerarRelatorio(report, params);
        
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
            java.util.logging.Logger.getLogger(Faturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Faturamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPeriodo;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataFinal;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRbtSIm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JRadioButton jrbtNao;
    // End of variables declaration//GEN-END:variables

    private boolean datasValidas() {
        RetornaData rdata = new RetornaData();
        boolean valida = false;

        String dt1 = jFormattedTextFieldDataInicial.getText();
        String dt2 = jFormattedTextFieldDataFinal.getText();

        if (!rdata.dataExiste(dt1) || (!rdata.dataExiste(dt2))) {
            JOptionPane.showMessageDialog(null, "Por favor, informe duas datas validas");
            jFormattedTextFieldDataInicial.setText("");
            jFormattedTextFieldDataFinal.setText("");
            jFormattedTextFieldDataInicial.grabFocus();
        } else if (rdata.comparaData(dt1, dt2) > 0) {
            JOptionPane.showMessageDialog(null, "Datas ou intervalo entre datas inválido!");
        } else {
            valida = true;
        }
        return valida;
    }

    public void editaBotao(boolean vazia) {
        if (vazia) {
            jBtRelatorio.setEnabled(false);
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        } else {
            jBtRelatorio.setEnabled(true);
        }
    }

}
