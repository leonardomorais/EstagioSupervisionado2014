package Servicos;

import Classes.AtendimentoMesa;
import Classes.AtendimentoMesaProdutos;
import Validacoes.PreencherTabela;
import Validacoes.RetornaData;
import Validacoes.TeclasdeAtalho;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leonardo
 */
public class TelaAtendimentos extends javax.swing.JFrame {

    AtendimentoMesa atendimento = new AtendimentoMesa();
    
    TeclasdeAtalho atalho = new TeclasdeAtalho();

    /**
     * Creates new form Atendimento
     */
    public TelaAtendimentos() {
        initComponents();
        consultarAtendimentos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuAtendimentos = new javax.swing.JPopupMenu();
        jMenuItemExibirDetalhes = new javax.swing.JMenuItem();
        jMenuItemEncerrar = new javax.swing.JMenuItem();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jBtNovo = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtNovo, KeyEvent.VK_F1, 0);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMesas = new javax.swing.JTable();
        jTableMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jBtAtualizar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtAtualizar, KeyEvent.VK_F5, 0);

        jLabel1 = new javax.swing.JLabel();

        jPopupMenuAtendimentos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuAtendimentosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuAtendimentosPopupMenuWillBecomeVisible(evt);
            }
        });

        jMenuItemExibirDetalhes.setText("Exibir Detalhes");
        jMenuItemExibirDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirDetalhesActionPerformed(evt);
            }
        });
        jPopupMenuAtendimentos.add(jMenuItemExibirDetalhes);

        jMenuItemEncerrar.setText("Encerrar Atendimento");
        jMenuItemEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEncerrarActionPerformed(evt);
            }
        });
        jPopupMenuAtendimentos.add(jMenuItemEncerrar);

        jMenuItemCancelar.setText("Cancelar Atendimento");
        jMenuItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarActionPerformed(evt);
            }
        });
        jPopupMenuAtendimentos.add(jMenuItemCancelar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exibir Atendimentos");
        setName("CONSULTAR ATENDIMENTOS"); // NOI18N
        setResizable(false);

        jBtNovo.setText("Novo Atendimento");
        jBtNovo.setToolTipText("Novo Atendimento (F1)");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jTableMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mesa", "Nr Atendimento", "Cd Funcionário", "Funcionário", "Hora Abertura", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMesas.setComponentPopupMenu(jPopupMenuAtendimentos);
        jTableMesas.getTableHeader().setReorderingAllowed(false);
        jTableMesas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableMesasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMesas);

        jBtAtualizar.setText("Atualizar");
        jBtAtualizar.setToolTipText("Atualizar (F5)");
        jBtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Atendimentos atuais:");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtNovo)
                                .addGap(18, 18, 18)
                                .addComponent(jBtAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 441, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovo)
                    .addComponent(jBtAtualizar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        TelaAtendimentoMesa tela = new TelaAtendimentoMesa();
        tela.setVisible(true);
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtualizarActionPerformed
        consultarAtendimentos();
    }//GEN-LAST:event_jBtAtualizarActionPerformed

    private void jMenuItemExibirDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirDetalhesActionPerformed
        int linha = jTableMesas.getSelectedRow();
        int nr = Integer.parseInt(jTableMesas.getValueAt(linha, 1).toString());
        TelaAtendimentoMesa tela = new TelaAtendimentoMesa();
        tela.setVisible(true);
        tela.exibirAtendimento(nr);
    }//GEN-LAST:event_jMenuItemExibirDetalhesActionPerformed

    private void jMenuItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Os atendimentos cancelados não serão salvos no sistema.\n"
                + "Deseja cancelar este atendimento ?", "Cancelar Atendimento", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            int linha = jTableMesas.getSelectedRow();
            int nr = Integer.parseInt(jTableMesas.getValueAt(linha, 1).toString());
            atendimento.setNrAtendimento(nr);
            AtendimentoMesaProdutos prod = new AtendimentoMesaProdutos();
            prod.setAtendimento(atendimento);
            //atendimento.getAtdProdutos().setNrAtendimento(nr);
            prod.excluirTodos(prod);
            //atendimento.getAtdProdutos().excluirTodos(atendimento.getAtdProdutos());
            atendimento.excluir(atendimento);
            //
            consultarAtendimentos();
        }
    }//GEN-LAST:event_jMenuItemCancelarActionPerformed

    private void jMenuItemEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEncerrarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja encerrar este atendimento ?", "Encerrar Atendimento", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            
            RetornaData data = new RetornaData();
            int linha = jTableMesas.getSelectedRow();
            int mesa = Integer.parseInt(jTableMesas.getValueAt(linha, 0).toString());
            int nr = Integer.parseInt(jTableMesas.getValueAt(linha, 1).toString());
            int cdFunc = Integer.parseInt(jTableMesas.getValueAt(linha, 2).toString());
            String horaAbre = jTableMesas.getValueAt(linha, 4).toString();
            double valor = Double.parseDouble(jTableMesas.getValueAt(linha, 5).toString());
            
            atendimento.setNrAtendimento(nr);
            atendimento.getMesa().setNrMesa(mesa);
            atendimento.getFuncionario().setCdFuncionario(cdFunc);
            atendimento.setHoraAbertura(horaAbre);
            atendimento.setHoraFechamento(data.retornaHoraAtual());
            atendimento.setDtAtendimento(data.retornaDataAtual());
            atendimento.setVlTotal(valor);
            atendimento.setAbertoFechado("F");
            
            atendimento.alterar(atendimento);
            
            consultarAtendimentos();
            JOptionPane.showMessageDialog(null, "Atendimento Encerrado");
            //
            TelaVendaCompra tela = new TelaVendaCompra();
            tela.setVisible(true);
            tela.CarregarAtendimento(atendimento);
            
        }


    }//GEN-LAST:event_jMenuItemEncerrarActionPerformed

    private void jPopupMenuAtendimentosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuAtendimentosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jPopupMenuAtendimentosPopupMenuWillBecomeInvisible

    private void jPopupMenuAtendimentosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuAtendimentosPopupMenuWillBecomeVisible
        int linha = jTableMesas.getSelectedRow();
        if (linha >= 0) {
            try {
                String mesa = jTableMesas.getValueAt(linha, 0).toString();
                String func = jTableMesas.getValueAt(linha, 2).toString();
                String valor = jTableMesas.getValueAt(linha, 5).toString();

                if (mesa.equals("") || func.equals("") || valor.equals("0.00")) {
                    jMenuItemEncerrar.setEnabled(false);
                } else {
                    jMenuItemEncerrar.setEnabled(true);
                }
            } catch (NullPointerException ex) {
                jMenuItemEncerrar.setEnabled(false);
            }

        }
    }//GEN-LAST:event_jPopupMenuAtendimentosPopupMenuWillBecomeVisible

    private void jTableMesasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMesasKeyPressed
        int linha = jTableMesas.getSelectedRow();
        if (linha >=0){
            switch (evt.getKeyCode()){
                
                case KeyEvent.VK_F2:
                    jMenuItemExibirDetalhesActionPerformed(null);
                break;    
                
                case KeyEvent.VK_ENTER:
                    evt.consume();
                    jMenuItemEncerrarActionPerformed(null);
                break;
                    
                case KeyEvent.VK_DELETE:
                    jMenuItemCancelarActionPerformed(null);
                break;    
                
            }
        }
    }//GEN-LAST:event_jTableMesasKeyPressed

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
            java.util.logging.Logger.getLogger(TelaAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtendimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAtualizar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemEncerrar;
    private javax.swing.JMenuItem jMenuItemExibirDetalhes;
    private javax.swing.JPopupMenu jPopupMenuAtendimentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMesas;
    // End of variables declaration//GEN-END:variables

    private void consultarAtendimentos() {
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableMesas, new int[]{70, 90, 85, 275, 80, 80});

        preencher.PreencherJtableGenerico(jTableMesas, atendimento.exibirAtendimentosAtuais());

    }
}
