/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Consultas.ConsultaParcelas;
import Servicos.TelaAtendimentoMesa;
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
        jMenuFinanceiro = new javax.swing.JMenu();
        jMenuItemBancos = new javax.swing.JMenuItem();
        jMenuItemAgencia = new javax.swing.JMenuItem();
        jMenuItemContas = new javax.swing.JMenuItem();
        jMenuItemParcelas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Al Tálio Sistema");
        setIconImages(null);
        setResizable(false);

        javax.swing.GroupLayout jPanelImagemLayout = new javax.swing.GroupLayout(jPanelImagem);
        jPanelImagem.setLayout(jPanelImagemLayout);
        jPanelImagemLayout.setHorizontalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jPanelImagemLayout.setVerticalGroup(
            jPanelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jMenuCadastros.setText("Cadastros");

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

        jMenuServicos.setText("Serviços");

        jMenuItemAtendimento.setText("Realizar Atendimento");
        jMenuItemAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtendimentoActionPerformed(evt);
            }
        });
        jMenuServicos.add(jMenuItemAtendimento);

        jMenuItemVenda.setText("Realizar Venda");
        jMenuServicos.add(jMenuItemVenda);

        jMenuBarPrincipal.add(jMenuServicos);

        jMenuFinanceiro.setText("Financeiro");

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

        jMenuItemParcelas.setText("Exibir Parcelas");
        jMenuItemParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemParcelasActionPerformed(evt);
            }
        });
        jMenuFinanceiro.add(jMenuItemParcelas);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadMesaActionPerformed
        CadastroMesa cadMesa = new CadastroMesa();
        cadMesa.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadMesaActionPerformed

    private void jMenuItemCadFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFamiliaActionPerformed
        CadastroFamilia cadFamilia = new CadastroFamilia();
        cadFamilia.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFamiliaActionPerformed

    private void jMenuItemBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBancosActionPerformed
        CadastroBanco cadBanco = new CadastroBanco();
        cadBanco.setVisible(true);
    }//GEN-LAST:event_jMenuItemBancosActionPerformed

    private void jMenuItemAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgenciaActionPerformed
        CadastroAgenciaConta cadAgc = new CadastroAgenciaConta();
        cadAgc.setVisible(true);
    }//GEN-LAST:event_jMenuItemAgenciaActionPerformed

    private void jMenuItemCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadClienteActionPerformed
        CadastroCliente cadCliente = new CadastroCliente();
        cadCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadClienteActionPerformed

    private void jMenuItemCadOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadOrigemActionPerformed
        CadastroOrigem cadOrigem = new CadastroOrigem();
        cadOrigem.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadOrigemActionPerformed

    private void jMenuItemCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadProdutoActionPerformed
        CadastroProduto cadProduto = new CadastroProduto();
        cadProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadProdutoActionPerformed

    private void jMenuItemCadEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadEnderecoActionPerformed
        CadastroEndereco cadEndereco = new CadastroEndereco();
        cadEndereco.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadEnderecoActionPerformed

    private void jMenuItemCadContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadContatoActionPerformed
        CadastroContato cadContato = new CadastroContato();
        cadContato.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadContatoActionPerformed

    private void jMenuItemCadEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadEstadoActionPerformed
        CadastroEstado cadEstado = new CadastroEstado();
        cadEstado.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadEstadoActionPerformed

    private void jMenuItemCadCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadCidadeActionPerformed
        CadastroCidade cadCidade = new CadastroCidade();
        cadCidade.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadCidadeActionPerformed

    private void jMenuItemCadFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFormaActionPerformed
        CadastroFormadePagamento cadForma = new CadastroFormadePagamento();
        cadForma.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFormaActionPerformed

    private void jMenuItemCadTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadTipoActionPerformed
        CadastroTipoPagamento cadTipo = new CadastroTipoPagamento();
        cadTipo.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadTipoActionPerformed

    private void jMenuItemCadFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFornecedorActionPerformed
        CadastroFornecedor cadForn = new CadastroFornecedor();
        cadForn.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFornecedorActionPerformed

    private void jMenuItemCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadFuncionarioActionPerformed
        CadastroFuncionario cadFunc = new CadastroFuncionario();
        cadFunc.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadFuncionarioActionPerformed

    private void jMenuItemAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtendimentoActionPerformed
    TelaAtendimentoMesa atdMesa = new TelaAtendimentoMesa();
        atdMesa.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtendimentoActionPerformed

    private void jMenuItemContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasActionPerformed
        CadastroContas cadContas = new CadastroContas();
        cadContas.setVisible(true);
    }//GEN-LAST:event_jMenuItemContasActionPerformed

    private void jMenuItemParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemParcelasActionPerformed
        ConsultaParcelas csParcelas = new ConsultaParcelas();
        csParcelas.setVisible(true);
    }//GEN-LAST:event_jMenuItemParcelasActionPerformed

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
    private javax.swing.JMenuItem jMenuItemParcelas;
    private javax.swing.JMenuItem jMenuItemVenda;
    private javax.swing.JMenu jMenuServicos;
    private javax.swing.JPanel jPanelImagem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables

    public void carregaImagem() {
        Random aleatorio = new Random();

        String caminho = "src\\Extras\\Imagens\\";

        int nr = aleatorio.nextInt(6);
        if (nr == 0) {
            nr = 1;
        }

        ImageIcon img = new ImageIcon(caminho + nr + ".jpg");

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        JLabel labelimg = new JLabel(img);
        labelimg.setSize(largura, altura);

        jPanelImagem.add(labelimg, RIGHT_ALIGNMENT);
    }

}
