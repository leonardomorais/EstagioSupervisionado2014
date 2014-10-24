package Telas;

import Cadastros.CadastroAgenciaConta;
import Cadastros.CadastroBanco;
import Cadastros.CadastroCidade;
import Cadastros.CadastroCliente;
import Cadastros.CadastroContas;
import Cadastros.CadastroContato;
import Cadastros.CadastroEndereco;
import Cadastros.CadastroEstado;
import Cadastros.CadastroFamilia;
import Cadastros.CadastroFormadePagamento;
import Cadastros.CadastroFornecedor;
import Cadastros.CadastroFuncionario;
import Cadastros.CadastroMesa;
import Cadastros.CadastroOrigem;
import Cadastros.CadastroProduto;
import Cadastros.CadastroTipoPagamento;
import Relatorios.TelaSplash;
import Servicos.ExibirMesas;
import Servicos.TelaAtendimentoMesa;
import Servicos.TelaAtendimentos;
import Servicos.TelaVendaCompra;
import Validacoes.Avisos;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Leonardo
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        procuraAvisos();
        carregaImagem();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelImagem = new javax.swing.JPanel();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadMesa = new javax.swing.JMenuItem();
        jMenuItemCadCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadOrigem = new javax.swing.JMenuItem();
        jMenuItemCadFamilia = new javax.swing.JMenuItem();
        jMenuItemCadProduto = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadEndereco = new javax.swing.JMenuItem();
        jMenuItemCadContato = new javax.swing.JMenuItem();
        jMenuItemCadEstado = new javax.swing.JMenuItem();
        jMenuItemCadCidade = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadForma = new javax.swing.JMenuItem();
        jMenuItemCadTipo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadFornecedor = new javax.swing.JMenuItem();
        jMenuItemCadFuncionario = new javax.swing.JMenuItem();
        jMenuServicos = new javax.swing.JMenu();
        jMenuItemAtendimento = new javax.swing.JMenuItem();
        jMenuItemVenda = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExibirAtendimentos = new javax.swing.JMenuItem();
        jMenuItemExibirMesas = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSaldoProdutos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExibirMovEstoque = new javax.swing.JMenuItem();
        jMenuFinanceiro = new javax.swing.JMenu();
        jMenuItemBancos = new javax.swing.JMenuItem();
        jMenuItemAgencia = new javax.swing.JMenuItem();
        jMenuItemContas = new javax.swing.JMenuItem();
        jMenuItemPagamento = new javax.swing.JMenuItem();
        jMenuItemTransferencia = new javax.swing.JMenuItem();
        jMenuItemGerenciarCheques = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItemMovCaixa = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItemFaturamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Al Tálio Sistema");
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagemLayout = new javax.swing.GroupLayout(jPanelImagem);
        jPanelImagem.setLayout(jPanelImagemLayout);
        jPanelImagemLayout.setHorizontalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanelImagemLayout.setVerticalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jMenuCadastros.setMnemonic(KeyEvent.VK_C);
        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.setMargin(new java.awt.Insets(0, 0, 0, 5));

        jMenuItemCadMesa.setText("Cadastrar Mesa");
        jMenuItemCadMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadMesaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadMesa);

        jMenuItemCadCliente.setText("Cadastrar Cliente");
        jMenuItemCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadClienteActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadCliente);
        jMenuCadastros.add(jSeparator1);

        jMenuItemCadOrigem.setText("Cadastrar Origem de Produtos");
        jMenuItemCadOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadOrigemActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadOrigem);

        jMenuItemCadFamilia.setText("Cadastrar Família de Produtos");
        jMenuItemCadFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFamiliaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadFamilia);

        jMenuItemCadProduto.setText("Cadastrar Produtos");
        jMenuItemCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadProduto);
        jMenuCadastros.add(jSeparator2);

        jMenuItemCadEndereco.setText("Cadastrar Endereços");
        jMenuItemCadEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadEnderecoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadEndereco);

        jMenuItemCadContato.setText("Cadastrar Contatos");
        jMenuItemCadContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadContatoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadContato);

        jMenuItemCadEstado.setText("Cadastrar Estados");
        jMenuItemCadEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadEstadoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadEstado);

        jMenuItemCadCidade.setText("Cadastrar Cidades");
        jMenuItemCadCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadCidadeActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadCidade);
        jMenuCadastros.add(jSeparator3);

        jMenuItemCadForma.setText("Cadastrar Formas de Pagamento");
        jMenuItemCadForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFormaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadForma);

        jMenuItemCadTipo.setText("Cadastrar Tipos de Pagamento");
        jMenuItemCadTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadTipoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadTipo);
        jMenuCadastros.add(jSeparator4);

        jMenuItemCadFornecedor.setText("Cadastrar Fornecedores");
        jMenuItemCadFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFornecedorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadFornecedor);

        jMenuItemCadFuncionario.setText("Cadastrar Funcionários");
        jMenuItemCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadFuncionario);

        jMenuBarPrincipal.add(jMenuCadastros);

        jMenuServicos.setMnemonic(KeyEvent.VK_S);
        jMenuServicos.setText("Serviços");
        jMenuServicos.setMargin(new java.awt.Insets(0, 0, 0, 5));

        jMenuItemAtendimento.setText("Realizar Atendimento");
        jMenuItemAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtendimentoActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemAtendimento);

        jMenuItemVenda.setText("Realizar Venda/Compra");
        jMenuItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVendaActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemVenda);
        jMenuServicos.add(jSeparator5);

        jMenuItemExibirAtendimentos.setText("Exibir Atendimentos");
        jMenuItemExibirAtendimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirAtendimentosActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemExibirAtendimentos);

        jMenuItemExibirMesas.setText("Exibir Mesas");
        jMenuItemExibirMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirMesasActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemExibirMesas);
        jMenuServicos.add(jSeparator7);

        jMenuItemSaldoProdutos.setText("Exibir Saldo dos Produtos");
        jMenuItemSaldoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaldoProdutosActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemSaldoProdutos);
        jMenuServicos.add(jSeparator9);

        jMenuItemExibirMovEstoque.setText("Exibir Movimentação de Estoque");
        jMenuItemExibirMovEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirMovEstoqueActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemExibirMovEstoque);

        jMenuBarPrincipal.add(jMenuServicos);

        jMenuFinanceiro.setMnemonic(KeyEvent.VK_F);
        jMenuFinanceiro.setText("Financeiro");
        jMenuFinanceiro.setMargin(new java.awt.Insets(0, 0, 0, 5));

        jMenuItemBancos.setText("Bancos");
        jMenuItemBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBancosActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemBancos);

        jMenuItemAgencia.setText("Agência");
        jMenuItemAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgenciaActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemAgencia);

        jMenuItemContas.setText("Gerenciar Contas");
        jMenuItemContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemContas);

        jMenuItemPagamento.setText("Realizar Pagamentos");
        jMenuItemPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagamentoActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemPagamento);

        jMenuItemTransferencia.setText("Realizar Transferência entre Contas");
        jMenuItemTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransferenciaActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemTransferencia);

        jMenuItemGerenciarCheques.setText("Conciliação Bancária");
        jMenuItemGerenciarCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarChequesActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemGerenciarCheques);
        jMenuFinanceiro.add(jSeparator6);

        jMenuItemMovCaixa.setText("Consultar Movimentação de Caixa");
        jMenuItemMovCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMovCaixaActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemMovCaixa);
        jMenuFinanceiro.add(jSeparator8);

        jMenuItemFaturamento.setText("Consultar Faturamento");
        jMenuItemFaturamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFaturamentoActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemFaturamento);

        jMenuBarPrincipal.add(jMenuFinanceiro);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadMesaActionPerformed
        new CadastroMesa().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadMesaActionPerformed

    private void jMenuItemCadFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFamiliaActionPerformed
        new CadastroFamilia().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFamiliaActionPerformed

    private void jMenuItemBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBancosActionPerformed
        new CadastroBanco().setVisible(true);
    }//GEN-LAST:event_jMenuItemBancosActionPerformed

    private void jMenuItemAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgenciaActionPerformed
        new CadastroAgenciaConta().setVisible(true);
    }//GEN-LAST:event_jMenuItemAgenciaActionPerformed

    private void jMenuItemCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadClienteActionPerformed
        new CadastroCliente().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadClienteActionPerformed

    private void jMenuItemCadOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadOrigemActionPerformed
        new CadastroOrigem().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadOrigemActionPerformed

    private void jMenuItemCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadProdutoActionPerformed
        new CadastroProduto().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadProdutoActionPerformed

    private void jMenuItemCadContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadContatoActionPerformed
        new CadastroContato().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadContatoActionPerformed

    private void jMenuItemCadEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadEstadoActionPerformed
        new CadastroEstado().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadEstadoActionPerformed

    private void jMenuItemCadCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadCidadeActionPerformed
        new CadastroCidade().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadCidadeActionPerformed

    private void jMenuItemCadFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFormaActionPerformed
        new CadastroFormadePagamento().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFormaActionPerformed

    private void jMenuItemCadTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadTipoActionPerformed
        new CadastroTipoPagamento().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadTipoActionPerformed

    private void jMenuItemCadFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFornecedorActionPerformed
        new CadastroFornecedor().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFornecedorActionPerformed

    private void jMenuItemCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFuncionarioActionPerformed
        new CadastroFuncionario().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFuncionarioActionPerformed

    private void jMenuItemAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtendimentoActionPerformed
        new TelaAtendimentoMesa().setVisible(true);
    }//GEN-LAST:event_jMenuItemAtendimentoActionPerformed

    private void jMenuItemContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasActionPerformed
        new CadastroContas().setVisible(true);
    }//GEN-LAST:event_jMenuItemContasActionPerformed

    private void jMenuItemExibirAtendimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirAtendimentosActionPerformed
        new TelaAtendimentos().setVisible(true);
    }//GEN-LAST:event_jMenuItemExibirAtendimentosActionPerformed

    private void jMenuItemPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagamentoActionPerformed
        new TelaPagamento().setVisible(true);
    }//GEN-LAST:event_jMenuItemPagamentoActionPerformed

    private void jMenuItemMovCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMovCaixaActionPerformed
       new TelaMovCaixa().setVisible(true);
    }//GEN-LAST:event_jMenuItemMovCaixaActionPerformed

    private void jMenuItemFaturamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFaturamentoActionPerformed
        new Faturamento().setVisible(true);
    }//GEN-LAST:event_jMenuItemFaturamentoActionPerformed

    private void jMenuItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVendaActionPerformed
        new TelaVendaCompra().setVisible(true);
    }//GEN-LAST:event_jMenuItemVendaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Avisos().removerAviso();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemCadEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadEnderecoActionPerformed
        new CadastroEndereco().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadEnderecoActionPerformed

    private void jMenuItemExibirMovEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirMovEstoqueActionPerformed
        new TelaMovEstoque().setVisible(true);
    }//GEN-LAST:event_jMenuItemExibirMovEstoqueActionPerformed

    private void jMenuItemTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransferenciaActionPerformed
        new TelaTransferenciaContas().setVisible(true);
    }//GEN-LAST:event_jMenuItemTransferenciaActionPerformed

    private void jMenuItemExibirMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirMesasActionPerformed
        new ExibirMesas().setVisible(true);
    }//GEN-LAST:event_jMenuItemExibirMesasActionPerformed

    private void jMenuItemSaldoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaldoProdutosActionPerformed
        new SaldoProdutos().setVisible(true);
    }//GEN-LAST:event_jMenuItemSaldoProdutosActionPerformed

    private void jMenuItemGerenciarChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarChequesActionPerformed
        new TelaConciliacaoBancaria().setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciarChequesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuFinanceiro;
    private javax.swing.JMenuItem jMenuItemAgencia;
    private javax.swing.JMenuItem jMenuItemAtendimento;
    private javax.swing.JMenuItem jMenuItemBancos;
    private javax.swing.JMenuItem jMenuItemCadCidade;
    private javax.swing.JMenuItem jMenuItemCadCliente;
    private javax.swing.JMenuItem jMenuItemCadContato;
    private javax.swing.JMenuItem jMenuItemCadEndereco;
    private javax.swing.JMenuItem jMenuItemCadEstado;
    private javax.swing.JMenuItem jMenuItemCadFamilia;
    private javax.swing.JMenuItem jMenuItemCadForma;
    private javax.swing.JMenuItem jMenuItemCadFornecedor;
    private javax.swing.JMenuItem jMenuItemCadFuncionario;
    private javax.swing.JMenuItem jMenuItemCadMesa;
    private javax.swing.JMenuItem jMenuItemCadOrigem;
    private javax.swing.JMenuItem jMenuItemCadProduto;
    private javax.swing.JMenuItem jMenuItemCadTipo;
    private javax.swing.JMenuItem jMenuItemContas;
    private javax.swing.JMenuItem jMenuItemExibirAtendimentos;
    private javax.swing.JMenuItem jMenuItemExibirMesas;
    private javax.swing.JMenuItem jMenuItemExibirMovEstoque;
    private javax.swing.JMenuItem jMenuItemFaturamento;
    private javax.swing.JMenuItem jMenuItemGerenciarCheques;
    private javax.swing.JMenuItem jMenuItemMovCaixa;
    private javax.swing.JMenuItem jMenuItemPagamento;
    private javax.swing.JMenuItem jMenuItemSaldoProdutos;
    private javax.swing.JMenuItem jMenuItemTransferencia;
    private javax.swing.JMenuItem jMenuItemVenda;
    private javax.swing.JMenu jMenuServicos;
    private javax.swing.JPanel jPanelImagem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

    private void carregaImagem() {
        Random aleatorio = new Random();

        String caminho = "src\\Extras\\Imagens\\";

        //int nr = aleatorio.nextInt(4);
        
        ImageIcon img = new ImageIcon(caminho + 0 + ".jpg");
        
        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        JLabel labelimg = new JLabel(img);
        labelimg.setSize(largura, altura);
        
        jPanelImagem.add(labelimg, RIGHT_ALIGNMENT);
    }
    
    private void procuraAvisos(){
        new Avisos().verificaAvisos();
    }
}
