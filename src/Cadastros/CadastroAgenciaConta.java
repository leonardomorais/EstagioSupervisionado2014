package Cadastros;

import Classes.AgenciaConta;
import Relatorios.Relatorios;
import Validacoes.FormataMoeda;
import Validacoes.LimparCampos;
import Validacoes.PreencherTabela;
import Validacoes.RetornaDecimal;
import Validacoes.Rotinas;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Leonardo
 */
public class CadastroAgenciaConta extends javax.swing.JFrame {

    AgenciaConta agc = new AgenciaConta();
    Relatorios report = new Relatorios();

    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();

    int rotina;
    RetornaDecimal decimal = new RetornaDecimal();

    MaskFormatter nrConta;
    MaskFormatter nrAgc;

    /**
     * Creates new form CadastroAgenciaConta
     */
    public CadastroAgenciaConta() {
        initComponents();

        jTextFieldVlConta.setDocument(new FormataMoeda());
        agc.retornaComboBanco(jComboBoxBanco);
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuAgcConta = new javax.swing.JPopupMenu();
        jMenuItemAgcConta = new javax.swing.JMenuItem();
        jTabbedPaneAgcConta = new javax.swing.JTabbedPane();
        jPanelCadastro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCdAgcConta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxBanco = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        try{       nrAgc = new MaskFormatter("####-#");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jTextFieldNrAgencia = new JFormattedTextField(nrAgc);
        jLabel5 = new javax.swing.JLabel();
        try{       nrConta = new MaskFormatter("##.###-#");   }   catch(Exception erro)   {   JOptionPane.showMessageDialog(null, "Não foi possivel localizar");   }
        jTextFieldNrConta = new JFormattedTextField(nrConta);
        jLabel6 = new javax.swing.JLabel();
        jTextFieldVlConta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jPanelBotoes = new javax.swing.JPanel();
        jBtIncluir = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtGravar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDsConta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanelConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jBtPesquisar = new javax.swing.JButton();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtRelatorio = new javax.swing.JButton();

        jMenuItemAgcConta.setText("Carregar Dados");
        jMenuItemAgcConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgcContaActionPerformed(evt);
            }
        });
        jPopupMenuAgcConta.add(jMenuItemAgcConta);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Agência Contas");
        setResizable(false);

        jLabel2.setText("Código da Agência Conta");

        jTextFieldCdAgcConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdAgcContaFocusLost(evt);
            }
        });

        jLabel3.setText("Banco");

        jLabel4.setText("Agência");

        jLabel5.setText("Conta");

        jLabel6.setText("Valor da Conta (R$)");

        jTextFieldVlConta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVlConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVlContaActionPerformed(evt);
            }
        });

        jLabel7.setText("Situação");

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVA", "INATIVA" }));

        jBtIncluir.setText("Incluir");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

        jBtAlterar.setText("Alterar");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setText("Excluir");
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtGravar.setText("Gravar");
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)))
        );

        jLabel8.setText("Descrição da Conta");

        jTextFieldDsConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDsContaKeyTyped(evt);
            }
        });

        jButton1.setText("Exibir Cadastro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDsConta)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldCdAgcConta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldNrAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(61, 61, 61))
                                    .addComponent(jTextFieldNrConta))))
                        .addGap(37, 37, 37)))
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldVlConta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jComboBoxBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(81, 81, 81))
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCdAgcConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDsConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNrAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNrConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVlConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneAgcConta.addTab("Cadastro", jPanelCadastro);

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Banco", "Nrº Agência", "Conta", "Descrição", "Valor", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuAgcConta);
        jScrollPane1.setViewportView(jTableConsulta);

        jLabel1.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Descrição Conta" }));

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jTextFieldConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConsultaActionPerformed(evt);
            }
        });

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setEnabled(false);
        jBtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultaLayout = new javax.swing.GroupLayout(jPanelConsulta);
        jPanelConsulta.setLayout(jPanelConsultaLayout);
        jPanelConsultaLayout.setHorizontalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtRelatorio)))
                .addContainerGap())
        );
        jPanelConsultaLayout.setVerticalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAgcConta.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneAgcConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneAgcConta, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        jTextFieldDsConta.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        jTextFieldDsConta.grabFocus();
        botoes.validaBotoes(jPanelBotoes, rotina);
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdAgcConta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso informar o código da agência conta que deseja excluir!");
            jTextFieldCdAgcConta.grabFocus();
        } else {
            try {
                agc.setCdAgcConta(Integer.parseInt(jTextFieldCdAgcConta.getText()));
                int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente inativar esta conta ?",
                        "Inativar Conta", JOptionPane.YES_OPTION);
                if (delete == JOptionPane.YES_OPTION) {
                    agc.excluir(agc);
                    JOptionPane.showMessageDialog(null, "Conta inativada com sucesso!");
                    limpar.limparCampos(jPanelCadastro);
                }
            } catch (NumberFormatException ex) {
            }
        }
        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);

    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDsConta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição da conta é obrigatória!");
            jTextFieldDsConta.grabFocus();
        } else if (jTextFieldNrAgencia.getText().equals(nrAgc.getMask().replace("#", " "))) {
            JOptionPane.showMessageDialog(null, "O número da agência é obrigatório!");
            jTextFieldNrAgencia.grabFocus();
        } else if (jTextFieldNrConta.getText().equals(nrConta.getMask().replace("#", " "))) {
            JOptionPane.showMessageDialog(null, "O número da conta é obrigatório!");
            jTextFieldNrConta.grabFocus();
        } else if (jTextFieldVlConta.getText().length()< 3) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido na conta");
            jTextFieldVlConta.grabFocus();
        } else {
            carregarAgc();

            if (rotina == Rotinas.incluir) {
                agc.incluir(agc);
                JOptionPane.showMessageDialog(null, "Conta gravada com sucesso!");
                jTextFieldCdAgcConta.setText(agc.getCdAgcConta().toString());
            } else if (rotina == Rotinas.alterar) {
                if (jTextFieldCdAgcConta.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o código da agência conta que deseja alterar!");
                    jTextFieldCdAgcConta.grabFocus();
                } else {
                    try {
                        agc.setCdAgcConta(Integer.parseInt(jTextFieldCdAgcConta.getText()));
                        agc.alterar(agc);
                        JOptionPane.showMessageDialog(null, "Conta alterada com sucesso!");
                    } catch (NumberFormatException ex) {
                    }
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        limpar.limparCampos(jPanelCadastro);
        jTextFieldCdAgcConta.grabFocus();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{40, 140, 80, 60, 140, 60, 50});

        if (jComboBoxConsulta.getSelectedIndex() == 0) {
            preencher.PreencherJtableGenerico(jTableConsulta, agc.consultarGeral());
            editaBotao(preencher.Vazia());
            report.setConsulta(agc.consultarGeral());
        } else if (jComboBoxConsulta.getSelectedIndex() == 1) {
            try {
                agc.setCdAgcConta(Integer.parseInt(jTextFieldConsulta.getText()));
                preencher.PreencherJtableGenerico(jTableConsulta, agc.consultarCdAgc(agc));
                editaBotao(preencher.Vazia());
                report.setConsulta(agc.consultarCdAgc(agc));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Informe um código para pesquisar!");
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
                jBtRelatorio.setEnabled(false);
            }
        } else {
            agc.setDsConta(jTextFieldConsulta.getText().toUpperCase());
            preencher.PreencherJtableGenerico(jTableConsulta, agc.consultarDsConta(agc));
            editaBotao(preencher.Vazia());
            report.setConsulta(agc.consultarDsConta(agc));
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTextFieldCdAgcContaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdAgcContaFocusLost
        if (!jTextFieldCdAgcConta.getText().equals("")) {
            try {
                agc.setCdAgcConta(Integer.parseInt(jTextFieldCdAgcConta.getText()));
                agc.retornaAgenciaConta(agc);

                if (agc.getDsConta().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preecherCampos();
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldCdAgcContaFocusLost

    private void jMenuItemAgcContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgcContaActionPerformed
        int linha = jTableConsulta.getSelectedRow();

        if (linha >= 0) {
            int cd = Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString());
            agc.setCdAgcConta(cd);
            agc.retornaAgenciaConta(agc);

            preecherCampos();
            jTabbedPaneAgcConta.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
        }
    }//GEN-LAST:event_jMenuItemAgcContaActionPerformed

    private void jTextFieldDsContaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDsContaKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldDsConta, 20);
    }//GEN-LAST:event_jTextFieldDsContaKeyTyped

    private void jTextFieldConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConsultaActionPerformed

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        if (report.login()) {
            try {
                report.setTabela("AGENCIA_CONTA");
                report.setSubreport(false);
                report.gerarRelatorio(report);
                jBtPesquisarActionPerformed(null);
            } catch (JRException ex) {
                Logger.getLogger(CadastroAgenciaConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtRelatorioActionPerformed

    private void jTextFieldVlContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVlContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVlContaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroBanco cadBanco = new CadastroBanco();
        cadBanco.setVisible(true);
        
        
        cadBanco.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt){
                agc.retornaComboBanco(jComboBoxBanco);
            }
        });
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
            java.util.logging.Logger.getLogger(CadastroAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAgenciaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAgenciaConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtGravar;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JButton jBtPesquisar;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxBanco;
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItemAgcConta;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuAgcConta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneAgcConta;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldCdAgcConta;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDsConta;
    private javax.swing.JTextField jTextFieldNrAgencia;
    private javax.swing.JTextField jTextFieldNrConta;
    private javax.swing.JTextField jTextFieldVlConta;
    // End of variables declaration//GEN-END:variables

    public void carregarAgc() {
        agc.setDsConta(jTextFieldDsConta.getText().toUpperCase());
        agc.setNrAgencia(jTextFieldNrAgencia.getText());
        agc.setNrConta(jTextFieldNrConta.getText());
        agc.setVlConta(Double.parseDouble(jTextFieldVlConta.getText()
                .replace(".", "").replace(",", ".")));
        agc.getBanco().setCdBanco(jComboBoxBanco.getSelectedIndex());
        if (jComboBoxSituacao.getSelectedIndex() == 0) {
            agc.setInAtivo("A");
        } else {
            agc.setInAtivo("I");
        }
    }

    public void preecherCampos() {
        jTextFieldCdAgcConta.setText(agc.getCdAgcConta().toString());
        jTextFieldDsConta.setText(agc.getDsConta());
        jTextFieldNrAgencia.setText(agc.getNrAgencia());
        jTextFieldNrConta.setText(agc.getNrConta());
        
        if(agc.getVlConta()>0){
            jTextFieldVlConta.setText(decimal.retornaDecimal(agc.getVlConta(), 6));
        }
        else{
            jTextFieldVlConta.setText("000");
        }
        
        jComboBoxBanco.setSelectedItem(agc.getBanco().getNmBanco());
        jComboBoxSituacao.setSelectedItem(agc.getInAtivo());
    }

    public void editaBotao(boolean vazia) {
        if (vazia) {
            jBtRelatorio.setEnabled(false);
        } else {
            jBtRelatorio.setEnabled(true);
        }
    }
    
}
