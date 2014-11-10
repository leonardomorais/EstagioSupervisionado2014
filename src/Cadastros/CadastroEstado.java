package Cadastros;

import Classes.UF;
import Relatorios.Relatorios;
import Validacoes.LimparCampos;
import Validacoes.PreencherTabela;
import Validacoes.Rotinas;
import Validacoes.TeclasdeAtalho;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import Validacoes.ValidaNivelUsuario;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Leonardo
 */
public class CadastroEstado extends javax.swing.JFrame {

    private MaskFormatter uf;

    UF estado = new UF();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    Relatorios report = new Relatorios();

    LimparCampos limpar = new LimparCampos();
    ValidaBotoes botoes = new ValidaBotoes();
    int rotina;

    TeclasdeAtalho atalho = new TeclasdeAtalho();
    
    /**
     * Creates new form CadastroEstado
     */
    public CadastroEstado() {
        initComponents();
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuConsulta = new javax.swing.JPopupMenu();
        jMenuItemCarregar = new javax.swing.JMenuItem();
        jTabbedPaneEstado = new javax.swing.JTabbedPane();
        atalho.adicionarAtalho(jTabbedPaneEstado);
        jPanelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCdEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        try{      uf = new MaskFormatter("AA");  }  catch(Exception erro)  {  JOptionPane.showMessageDialog(null, "Não foi possivel localizar");  }
        jTextFieldSigla = new JFormattedTextField(uf);
        jPanelBotoes = new javax.swing.JPanel();
        jBtAlterar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtAlterar, KeyEvent.VK_F2, 0);
        jBtExcluir = new javax.swing.JButton();
        atalho. adicionarAtalho(jBtExcluir, KeyEvent.VK_F3, 0);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jBtIncluir = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtIncluir, KeyEvent.VK_F1, 0);
        jBtGravar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtGravar, KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK);
        jLabel21 = new javax.swing.JLabel();
        jPanelConsulta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jBtRelatorio = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtRelatorio,   KeyEvent.VK_F6, 0);

        jMenuItemCarregar.setText("Carregar Dados");
        jMenuItemCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarActionPerformed(evt);
            }
        });
        jPopupMenuConsulta.add(jMenuItemCarregar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Estados");
        setName("CADASTRAR ESTADO"); // NOI18N
        setResizable(false);

        jPanelCadastro.setPreferredSize(new java.awt.Dimension(493, 300));

        jLabel1.setText("Código do Estado");

        jTextFieldCdEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdEstadoFocusLost(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Nome do Estado");

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Sigla");

        jBtAlterar.setText("Alterar");
        jBtAlterar.setToolTipText("Alterar (F2)");
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setText("Excluir");
        jBtExcluir.setToolTipText("Excluir (F3)");
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
        jBtCancelar.setPreferredSize(new java.awt.Dimension(80, 23));
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtIncluir.setText("Incluir");
        jBtIncluir.setToolTipText("Incluir (F1)");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

        jBtGravar.setText("Gravar");
        jBtGravar.setToolTipText("Gravar (Ctrl + Enter)");
        jBtGravar.setMinimumSize(new java.awt.Dimension(80, 23));
        jBtGravar.setPreferredSize(new java.awt.Dimension(80, 23));
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
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
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("- Campos Obrigatórios");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneEstado.addTab("Cadastro", jPanelCadastro);

        jLabel4.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Nome" }));
        jComboBoxConsulta.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxConsultaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTextFieldConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConsultaKeyPressed(evt);
            }
        });

        jBtPesquisar.setText("Pesquisar");
        jBtPesquisar.setToolTipText("Pesquisar (F5)");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Estado", "Sigla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuConsulta);
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jTableConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableConsultaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        jBtRelatorio.setText("Relatório");
        jBtRelatorio.setToolTipText("Relatório (F6)");
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jBtPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtRelatorio)))
                .addContainerGap())
        );
        jPanelConsultaLayout.setVerticalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisar)
                    .addComponent(jBtRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneEstado.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneEstado))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPaneEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do estado é obrigatório!");
            jTextFieldNome.grabFocus();

        } else if (jTextFieldSigla.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A sigla do estado é obrigatória!");
            jTextFieldSigla.grabFocus();
        } else {
            gravarEstado();

            if (rotina == Rotinas.incluir) {
                estado.incluir(estado);
                jTextFieldCdEstado.setText(estado.getCdUf().toString());
                //JOptionPane.showMessageDialog(null, "Estado gravado com sucesso!");
            } else if (rotina == Rotinas.alterar) {
                if (jTextFieldCdEstado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o código do estado que deseja alterar!");
                    jTextFieldCdEstado.grabFocus();
                } else {
                    try {
                        estado.setCdUf(Integer.parseInt(jTextFieldCdEstado.getText()));
                        estado.alterar(estado);
                        //JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
                    } catch (NumberFormatException ex) {
                    }
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        jTextFieldNome.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
        jTextFieldNome.grabFocus();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso informar o código do estado que deseja excluir!");
            jTextFieldCdEstado.grabFocus();
        } else {
            try {
                estado.setCdUf(Integer.parseInt(jTextFieldCdEstado.getText()));

                int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este estado ?",
                        "Excluir Estado", JOptionPane.YES_OPTION);
                if (delete == JOptionPane.YES_OPTION) {
                    estado.excluir(estado);
                    //JOptionPane.showMessageDialog(null, "Estado excluído com sucesso!");
                    limpar.limparCampos(jPanelCadastro);
                }
            } catch (NumberFormatException ex) {

            }
        }

        rotina = Rotinas.excluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        rotina = Rotinas.padrao;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
        limpar.limparCampos(jPanelCadastro);
        jTextFieldCdEstado.grabFocus();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jTextFieldCdEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdEstadoFocusLost
        if (!jTextFieldCdEstado.getText().equals("")) {
            try {
                estado.setCdUf(Integer.parseInt(jTextFieldCdEstado.getText()));
                estado.retornaEstado(estado);

                if (estado.getDsUf().equals("")) {
                    jBtCancelarActionPerformed(null);
                } else {
                    preencherCampos();
                }

            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            }

        }
    }//GEN-LAST:event_jTextFieldCdEstadoFocusLost

    private void jTextFieldConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConsultaKeyPressed

    }//GEN-LAST:event_jTextFieldConsultaKeyPressed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int[]{75, 200, 200});
        
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, estado.consultarGeral());
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;
                
            case 1:
                try {
                    estado.setCdUf(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, estado.consultarCodigo(estado));
                    report.setConsulta(preencher.getConsulta());
                    editaBotao(preencher.Vazia());
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    editaBotao(true);
                }
            break;
                
            default:
                estado.setDsUf(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, estado.consultarNome(estado));
                report.setConsulta(preencher.getConsulta());
                editaBotao(preencher.Vazia());
            break;    
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTableConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableConsultaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableConsultaKeyPressed

    private void jMenuItemCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarActionPerformed
        int linha = jTableConsulta.getSelectedRow();

        if (linha >= 0) {
            int cd = Integer.parseInt(jTableConsulta.getValueAt(linha, 0).toString());
            estado.setCdUf(cd);
            estado.retornaEstado(estado);
            preencherCampos();

            jTabbedPaneEstado.setSelectedIndex(0);

            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jMenuItemCarregarActionPerformed

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        ValidaCampos campos = new ValidaCampos();
        campos.validaCamposLimite(evt, jTextFieldNome, 50);
    }//GEN-LAST:event_jTextFieldNomeKeyTyped

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        jBtPesquisarActionPerformed(null);        
        report.setSubreport(false);
        report.setTabela("UF");
        report.iniciarSplash(report);
    }//GEN-LAST:event_jBtRelatorioActionPerformed

    private void jComboBoxConsultaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxConsultaPopupMenuWillBecomeInvisible
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.setEnabled(false);
            break;    
                
            default:
                jTextFieldConsulta.setEnabled(true);
                jTextFieldConsulta.setText("");
                jTextFieldConsulta.grabFocus();
            break;    
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
            java.util.logging.Logger.getLogger(CadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEstado().setVisible(true);
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
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItemCarregar;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneEstado;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldCdEstado;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSigla;
    // End of variables declaration//GEN-END:variables

    private void gravarEstado() {
        estado.setDsUf(jTextFieldNome.getText().toUpperCase());
        estado.setSigla(jTextFieldSigla.getText().toUpperCase());
    }

    private void preencherCampos() {
        jTextFieldCdEstado.setText(estado.getCdUf().toString());
        jTextFieldNome.setText(estado.getDsUf());
        jTextFieldSigla.setText(estado.getSigla());
    }

    private void editaBotao(boolean vazia) {
        if (vazia) {
            JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
            jBtRelatorio.setEnabled(false);
            jTextFieldConsulta.setText("");
            jTextFieldConsulta.grabFocus();
        } else {
            jBtRelatorio.setEnabled(valida.pRelatorio.equals("S"));
        }
    }
    
    private void carregarUsuario(){
        valida.validaNivel(this.getName());
        valida.validaBotoesUsuario(jPanelBotoes);
    }
}
