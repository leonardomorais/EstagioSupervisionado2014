package Telas;

import Classes.Pagamento;
import Validacoes.PreencherTabela;
import Validacoes.TeclasdeAtalho;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Leonardo
 */
public class TelaConciliacaoBancaria extends javax.swing.JFrame {

    Pagamento pagamento = new Pagamento();
    TeclasdeAtalho atalho = new TeclasdeAtalho();
    
            
    /**
     * Creates new form PagamentoCheque
     */
    public TelaConciliacaoBancaria() {
        initComponents();
        pagamento.getParcelas().getContas().getVendaCompra().getOperacao().retornaComboOperacao(jComboBoxOperacao, "TODOS");
        
        preencherTabela("TODOS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSitCheque = new javax.swing.ButtonGroup();
        buttonGroupFiltro = new javax.swing.ButtonGroup();
        jPopupMenuCheque = new javax.swing.JPopupMenu();
        jMenuItemEstornarParcela = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTableConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                preencherCampos();
            }
        });
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxRecebido = new javax.swing.JCheckBox();
        jBtConfirmar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtConfirmar, KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK);
        jCheckBoxNaoRecebido = new javax.swing.JCheckBox();
        jComboBoxOperacao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonTodos = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jRadioButtonTodos, KeyEvent.VK_F1, 0);
        jRadioButtonRecebidos = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jRadioButtonRecebidos, KeyEvent.VK_F3, 0);

        jRadioButtonNaoRecebidos = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jRadioButtonNaoRecebidos, KeyEvent.VK_F4, 0);
        jRadioButtonAguardando = new javax.swing.JRadioButton();
        atalho.adicionarAtalho(jRadioButtonAguardando, KeyEvent.VK_F2, 0);

        jPopupMenuCheque.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuChequePopupMenuWillBecomeVisible(evt);
            }
        });

        jMenuItemEstornarParcela.setText("Estornar Parcela");
        jMenuItemEstornarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstornarParcelaActionPerformed(evt);
            }
        });
        jPopupMenuCheque.add(jMenuItemEstornarParcela);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conciliação Bancária");
        setName("CONCILIAÇÃO BANCÁRIA"); // NOI18N
        setResizable(false);

        jTableConsulta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagamento", "Cd Conta", "Parcela", "Valor", "Tipo", "Agência Conta", "Descrição", "Banco", "Cd Pessoa", "Nome", "Cheque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuCheque);
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Marcar situação do cheque");

        buttonGroupSitCheque.add(jCheckBoxRecebido);
        jCheckBoxRecebido.setText("Recebido");
        jCheckBoxRecebido.setEnabled(false);
        jCheckBoxRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRecebidoActionPerformed(evt);
            }
        });

        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.setToolTipText("Confirmar (Ctrl + Enter)");
        jBtConfirmar.setEnabled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        buttonGroupSitCheque.add(jCheckBoxNaoRecebido);
        jCheckBoxNaoRecebido.setText("Não Recebido");
        jCheckBoxNaoRecebido.setEnabled(false);

        jLabel2.setText("Operação");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro da Consulta"));

        buttonGroupFiltro.add(jRadioButtonTodos);
        jRadioButtonTodos.setSelected(true);
        jRadioButtonTodos.setText("Todos");
        jRadioButtonTodos.setToolTipText("Todos (F1)");
        jRadioButtonTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodosActionPerformed(evt);
            }
        });

        buttonGroupFiltro.add(jRadioButtonRecebidos);
        jRadioButtonRecebidos.setText("Recebidos");
        jRadioButtonRecebidos.setToolTipText("Recebidos (F3)");
        jRadioButtonRecebidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRecebidosActionPerformed(evt);
            }
        });

        buttonGroupFiltro.add(jRadioButtonNaoRecebidos);
        jRadioButtonNaoRecebidos.setText("Não Recebidos");
        jRadioButtonNaoRecebidos.setToolTipText("Não Recebidos (F4)");
        jRadioButtonNaoRecebidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNaoRecebidosActionPerformed(evt);
            }
        });

        buttonGroupFiltro.add(jRadioButtonAguardando);
        jRadioButtonAguardando.setText("Aguardando");
        jRadioButtonAguardando.setToolTipText("Aguardando (F2)");
        jRadioButtonAguardando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAguardandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonTodos)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonAguardando)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonRecebidos)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonNaoRecebidos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTodos)
                    .addComponent(jRadioButtonRecebidos)
                    .addComponent(jRadioButtonNaoRecebidos)
                    .addComponent(jRadioButtonAguardando)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtConfirmar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBoxNaoRecebido))
                                    .addComponent(jLabel1))
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 219, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxRecebido)
                    .addComponent(jCheckBoxNaoRecebido)
                    .addComponent(jComboBoxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRecebidoActionPerformed

    }//GEN-LAST:event_jCheckBoxRecebidoActionPerformed

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        preencherCampos();
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        if (jCheckBoxNaoRecebido.isSelected() || jCheckBoxRecebido.isSelected()) {
            String msg = "";
            boolean recebido = jCheckBoxRecebido.isSelected();
            if (recebido){
                msg = "Deseja realmente marcar este cheque como 'Recebido' ?";
            }
            else{
                msg = "Deseja realmente marcar este cheque como 'Não Recebido' ?";
            }
            int opcao = JOptionPane.showConfirmDialog(null, msg, "Conciliação Bancária", JOptionPane.YES_NO_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                alterarCheque(recebido);
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
                preencherTabela(retornaSelecionado());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor selecione uma situação para marcar o cheque");
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jRadioButtonTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodosActionPerformed
        jTableConsulta.clearSelection();
        preencherTabela("TODOS");
    }//GEN-LAST:event_jRadioButtonTodosActionPerformed

    private void jRadioButtonAguardandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAguardandoActionPerformed
        jTableConsulta.clearSelection();
        preencherTabela("AGUARDANDO");
    }//GEN-LAST:event_jRadioButtonAguardandoActionPerformed

    private void jRadioButtonRecebidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRecebidosActionPerformed
        jTableConsulta.clearSelection();
        preencherTabela("RECEBIDOS");
    }//GEN-LAST:event_jRadioButtonRecebidosActionPerformed

    private void jRadioButtonNaoRecebidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNaoRecebidosActionPerformed
        jTableConsulta.clearSelection();
        preencherTabela("NÃO RECEBIDOS");
    }//GEN-LAST:event_jRadioButtonNaoRecebidosActionPerformed

    private void jPopupMenuChequePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuChequePopupMenuWillBecomeVisible
        int linha = jTableConsulta.getSelectedRow();
        if (linha >= 0){
            String cheque = jTableConsulta.getValueAt(linha, 10).toString();
            boolean aguardando = cheque.equals("RECEBIDO");
            jMenuItemEstornarParcela.setEnabled(aguardando);
            
            pagamento.getParcelas().getContas().setDsConta("NAO REMOVE");
        }
    }//GEN-LAST:event_jPopupMenuChequePopupMenuWillBecomeVisible

    private void jMenuItemEstornarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstornarParcelaActionPerformed
        int linha = jTableConsulta.getSelectedRow();
        try{
            pagamento.getParcelas().setNrParcela(Integer.parseInt(jTableConsulta.getValueAt(linha, 2).toString()));
            pagamento.getParcelas().getContas().setCdConta(Integer.parseInt(jTableConsulta.getValueAt(linha, 1).toString()));
            pagamento.getParcelas().getContas().setTpConta(jTableConsulta.getValueAt(linha, 4).toString());
            pagamento.getParcelas().estornarParcela(pagamento.getParcelas(),"CONCILIAÇÃO");
            pagamento.setCdPagamento(Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString()));
            
            pagamento.setSitCheque("A"); // o pagamento ficará aguardando novamente
            pagamento.alterarPagamentoCheque(pagamento);
            
            JOptionPane.showMessageDialog(null, "Parcela extornada com sucesso!");
            preencherTabela(retornaSelecionado());
        }
        catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro!");
        }
    }//GEN-LAST:event_jMenuItemEstornarParcelaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConciliacaoBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConciliacaoBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConciliacaoBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConciliacaoBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConciliacaoBancaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFiltro;
    private javax.swing.ButtonGroup buttonGroupSitCheque;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JCheckBox jCheckBoxNaoRecebido;
    private javax.swing.JCheckBox jCheckBoxRecebido;
    private javax.swing.JComboBox jComboBoxOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItemEstornarParcela;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuCheque;
    private javax.swing.JRadioButton jRadioButtonAguardando;
    private javax.swing.JRadioButton jRadioButtonNaoRecebidos;
    private javax.swing.JRadioButton jRadioButtonRecebidos;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(String condicao) {
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{70, 60, 50, 50, 50, 80, 110, 120, 60, 170, 90});
        pagamento.setSitCheque(condicao);
        preencher.PreencherJtableGenerico(jTableConsulta, pagamento.consultarPagamentosCheque(pagamento));
    }

    private void alterarCheque(boolean recebido) {
        if (recebido) {
            pagamento.setSitCheque("R");
        } else {
            pagamento.setSitCheque("N");
        }
        pagamento.getParcelas().getContas().getVendaCompra().getOperacao().
                setCdOperacao(pagamento.getParcelas().getContas().getVendaCompra().getOperacao().getOperacao(
                                jComboBoxOperacao.getSelectedIndex()));

        pagamento.alterarPagamentoCheque(pagamento);
    }
    
    private String retornaSelecionado(){
        String sel;
        
        if (jRadioButtonTodos.isSelected()){
            sel = "TODOS";
        }
        else if (jRadioButtonAguardando.isSelected()){
            sel = "AGUARDANDO";
        }
        else if (jRadioButtonRecebidos.isSelected()){
            sel = "RECEBIDOS";
        }
        else{
            sel = "NÃO RECEBIDOS";
        }
        
        return sel;
    }
    
    private void preencherCampos(){
        int linha = jTableConsulta.getSelectedRow();
        if (linha >= 0) {

            pagamento.setCdPagamento(Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString()));
            pagamento.getParcelas().getContas().setCdConta(Integer.parseInt(jTableConsulta.getValueAt(linha, 1).toString()));
            pagamento.getParcelas().setNrParcela(Integer.parseInt(jTableConsulta.getValueAt(linha, 2).toString()));
            pagamento.getParcelas().setVlPago(Double.parseDouble(jTableConsulta.getValueAt(linha, 3).toString()));
            pagamento.getParcelas().getContas().setTpConta(jTableConsulta.getValueAt(linha, 4).toString());
            pagamento.getAgc().setCdAgcConta(Integer.parseInt(jTableConsulta.getValueAt(linha, 5).toString()));
            pagamento.getParcelas().getContas().retornaOperacaoVendaCompra(pagamento.getParcelas().getContas());

            String cheque = jTableConsulta.getValueAt(linha, 10).toString();
            boolean sit = cheque.equals("AGUARDANDO");
            jCheckBoxRecebido.setEnabled(sit);
            jCheckBoxNaoRecebido.setEnabled(sit);
            
            String op = pagamento.getParcelas().getContas().retornaOperacaoVendaCompra(pagamento.getParcelas().getContas());
            String tipo = pagamento.getParcelas().getContas().getTpConta();
            if (tipo.equals("A RECEBER")) {
                tipo = "E";
            } else {
                tipo = "S";
            }
            jComboBoxOperacao.setEnabled(true);
            pagamento.getParcelas().getContas().getVendaCompra().getOperacao().retornaComboOperacao(jComboBoxOperacao, tipo);
            
            
            if (!op.equals("")){
                jComboBoxOperacao.setSelectedItem(op); 
                jComboBoxOperacao.setEnabled(false);
            }
            else{
                jComboBoxOperacao.setEnabled(sit);
            }
            
//            
//            switch (cheque){
//                case "AGUARDANDO":
//                    jCheckBoxNaoRecebido.setEnabled(true);
//                    jCheckBoxRecebido.setEnabled(true);
//                break;
//                    
//                case "RECEBIDO":
//                    jCheckBoxRecebido.setEnabled(false);
//                    jCheckBoxNaoRecebido.setEnabled(false);
//                break;
//                    
//                default:
//                    jCheckBoxRecebido.setEnabled(true);
//                    jCheckBoxNaoRecebido.setEnabled(false);
//                break;    
//            }          
            jBtConfirmar.setEnabled(true);
        }
    }
}
