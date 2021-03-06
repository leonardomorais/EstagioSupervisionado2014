package Cadastros;

import Classes.NivelTelas;
import Validacoes.LimparCampos;
import Validacoes.PreencherTabela;
import Validacoes.Rotinas;
import Validacoes.TeclasdeAtalho;
import Validacoes.ValidaBotoes;
import Validacoes.ValidaCampos;
import Validacoes.ValidaNivelUsuario;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Leonardo
 */
public class CadastroNivel extends javax.swing.JFrame {

    NivelTelas nivel = new NivelTelas();
    LimparCampos limpar = new LimparCampos();
    ValidaNivelUsuario valida = new ValidaNivelUsuario();
    ValidaBotoes botoes = new ValidaBotoes();
    TeclasdeAtalho atalho = new TeclasdeAtalho();
    
    int rotina;
    /**
     * Creates new form CadastroNivel
     */
    public CadastroNivel() {
        initComponents();
        preencherTabelaTelas();
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

        jPopupMenuPermissoes = new javax.swing.JPopupMenu();
        jMenuItemSelecionarTodas = new javax.swing.JMenuItem();
        jMenuItemRemoverTodas = new javax.swing.JMenuItem();
        jPopupMenuCarregarDados = new javax.swing.JPopupMenu();
        jMenuItemCarregarDados = new javax.swing.JMenuItem();
        jTabbedPaneNivel = new javax.swing.JTabbedPane();
        atalho.adicionarAtalho(jTabbedPaneNivel);

        jPanelCadastro = new javax.swing.JPanel();
        jPanelBotoes = new javax.swing.JPanel();
        jBtIncluir = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtIncluir, KeyEvent.VK_F1, 0);
        jBtAlterar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtAlterar, KeyEvent.VK_F2, 0);
        jBtExcluir = new javax.swing.JButton();
        atalho. adicionarAtalho(jBtExcluir, KeyEvent.VK_F3, 0);
        jBtGravar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtGravar, KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK);
        jBtCancelar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtCancelar, KeyEvent.VK_ESCAPE, 0);
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldCdNivel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTelas = new javax.swing.JTable();
        jTableTelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jLabel21 = new javax.swing.JLabel();
        jPanelConsulta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxConsulta = new javax.swing.JComboBox();
        jTextFieldConsulta = new javax.swing.JTextField();
        jBtPesquisar = new javax.swing.JButton();
        atalho.adicionarAtalho(jBtPesquisar, KeyEvent.VK_F5, 0);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jTableConsulta.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jPopupMenuPermissoes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenuPermissoesPopupMenuWillBecomeVisible(evt);
            }
        });

        jMenuItemSelecionarTodas.setText("Selecionar Todas");
        jMenuItemSelecionarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSelecionarTodasActionPerformed(evt);
            }
        });
        jPopupMenuPermissoes.add(jMenuItemSelecionarTodas);

        jMenuItemRemoverTodas.setText("Remover Todas");
        jMenuItemRemoverTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverTodasActionPerformed(evt);
            }
        });
        jPopupMenuPermissoes.add(jMenuItemRemoverTodas);

        jMenuItemCarregarDados.setText("Carregar Dados");
        jMenuItemCarregarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarDadosActionPerformed(evt);
            }
        });
        jPopupMenuCarregarDados.add(jMenuItemCarregarDados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Níveis de Acesso");
        setName("CADASTRAR NÍVEIS DE ACESSO"); // NOI18N
        setResizable(false);

        jBtIncluir.setText("Incluir");
        jBtIncluir.setToolTipText("Incluir (F1)");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

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

        jBtGravar.setText("Gravar");
        jBtGravar.setToolTipText("Gravar (Ctrl + Enter)");
        jBtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGravarActionPerformed(evt);
            }
        });

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar (Esc)");
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
                .addComponent(jBtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtIncluir)
                    .addComponent(jBtAlterar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtGravar)
                    .addComponent(jBtCancelar)))
        );

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Situação");

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));

        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Descrição");

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jTextFieldCdNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCdNivelFocusLost(evt);
            }
        });

        jLabel1.setText("Código Nível");

        jTableTelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selecionada", "Código", "Tela", "Incluir", "Alterar", "Excluir", "Gravar", "Relatório"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTelas.setComponentPopupMenu(jPopupMenuPermissoes);
        jTableTelas.getTableHeader().setReorderingAllowed(false);
        jTableTelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTelasjTableTelasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTelas);

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("- Campos Obrigatórios");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCdNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21)))))
                .addContainerGap())
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCdNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneNivel.addTab("Cadastro", jPanelCadastro);

        jLabel4.setText("Filtro da Consulta");

        jComboBoxConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código Nível", "Descrição Nível", "Código Tela", "Descrição Tela" }));
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
        jBtPesquisar.setToolTipText("Pesquisar (F5)");
        jBtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarActionPerformed(evt);
            }
        });

        jTableConsulta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cd. Nível", "Descrição", "Cd. Tela", "Tela", "Incluir", "Alterar", "Excluir", "Gravar ", "Relatório", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.setComponentPopupMenu(jPopupMenuCarregarDados);
        jTableConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsulta);

        javax.swing.GroupLayout jPanelConsultaLayout = new javax.swing.GroupLayout(jPanelConsulta);
        jPanelConsulta.setLayout(jPanelConsultaLayout);
        jPanelConsultaLayout.setHorizontalGroup(
            jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addComponent(jComboBoxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtPesquisar))
                    .addGroup(jPanelConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jBtPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneNivel.addTab("Consulta", jPanelConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNivel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNivel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGravarActionPerformed
        if (jTextFieldDescricao.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor informe uma descrição para o nível!");
        }
        else if (contaPermissoes() == 0){
            JOptionPane.showMessageDialog(null, "Por favor selecione as telas e permissões para o nível!");
        }
        else{
            nivel.getNivel().setDsNivel(jTextFieldDescricao.getText().toUpperCase());
            nivel.getNivel().setInAtivo(jComboBoxSituacao.getSelectedItem().toString().substring(0,1));

            if (rotina == Rotinas.incluir){
                nivel.getNivel().incluir(nivel.getNivel());
                jTextFieldCdNivel.setText(nivel.getNivel().getCdNivel().toString());
                gravarNivelTela();
                JOptionPane.showMessageDialog(null, "Nível gravado com sucesso!");
            }
            else{
                if (jTextFieldCdNivel.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "É preciso informar o código do nível que deseja alterar!");
                    jTextFieldCdNivel.grabFocus();
                } else {
                    try {
                        nivel.getNivel().setCdNivel(Integer.parseInt(jTextFieldCdNivel.getText()));
                        nivel.getNivel().alterar(nivel.getNivel());
                        nivel.excluir(nivel);
                        gravarNivelTela();
                        JOptionPane.showMessageDialog(null, "Nível alterado com sucesso!");
                    } catch (NumberFormatException ex) {
                    }
                }
            }
            rotina = Rotinas.padrao;
            botoes.validaBotoes(jPanelBotoes, rotina);
            carregarUsuario();
        }
    }//GEN-LAST:event_jBtGravarActionPerformed

    private void jTableTelasjTableTelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTelasjTableTelasMouseClicked
        int linha = jTableTelas.getSelectedRow();
        if (linha >= 0){
            int coluna = jTableTelas.getSelectedColumn();
            boolean sel = (boolean) jTableTelas.getValueAt(linha, 0);

            if (coluna != 0 && coluna !=1 && coluna != 2 &&!sel){
                jTableTelas.setValueAt(false, linha, coluna);
            }
            else if (coluna == 0){
                marcarCelulas(sel);
            }
        }
    }//GEN-LAST:event_jTableTelasjTableTelasMouseClicked

    private void jMenuItemSelecionarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSelecionarTodasActionPerformed
        marcarCelulas(true);
    }//GEN-LAST:event_jMenuItemSelecionarTodasActionPerformed

    private void jMenuItemRemoverTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverTodasActionPerformed
        marcarCelulas(false);
    }//GEN-LAST:event_jMenuItemRemoverTodasActionPerformed

    private void jPopupMenuPermissoesPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenuPermissoesPopupMenuWillBecomeVisible
        int linha = jTableTelas.getSelectedRow();
        if (linha >=0){
            jMenuItemRemoverTodas.setEnabled(contaPermissoes(linha) > 0);
            jMenuItemSelecionarTodas.setEnabled(contaPermissoes(linha) < 5);
        }
    }//GEN-LAST:event_jPopupMenuPermissoesPopupMenuWillBecomeVisible

    private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
        limpar.limparCampos(jPanelCadastro);
        limparTabela();
        jTextFieldDescricao.grabFocus();
        rotina = Rotinas.incluir;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
    }//GEN-LAST:event_jBtIncluirActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        rotina = Rotinas.alterar;
        botoes.validaBotoes(jPanelBotoes, rotina);
        carregarUsuario();
        jTextFieldDescricao.grabFocus();
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        if (jTextFieldCdNivel.getText().equals("")){
            JOptionPane.showMessageDialog(null, "É preciso informar o código do nível que deseja excluir!");
            jTextFieldCdNivel.grabFocus();
        }
        else{
            try{
                nivel.getNivel().setCdNivel(Integer.parseInt(jTextFieldCdNivel.getText()));
                
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente inativar este nível ?",
                        "Inativar Nível de Usuário", JOptionPane.YES_NO_OPTION);
                
                if (opcao == JOptionPane.YES_OPTION){
                    nivel.getNivel().excluir(nivel.getNivel());
                    JOptionPane.showMessageDialog(null, "Nível de usuário inativado com sucesso!");
                    limpar.limparCampos(jPanelCadastro);
                    limparTabela();
                }
            }
            catch(NumberFormatException ex){
                
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
        limparTabela();
        jTextFieldCdNivel.grabFocus();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarActionPerformed
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableConsulta, new int [] {55, 160, 55, 200, 50, 50, 50, 50, 55, 55});
        switch (jComboBoxConsulta.getSelectedIndex()){
            case 0:
                preencher.PreencherJtableGenerico(jTableConsulta, nivel.consultarGeral());
            break;
                
            case 1:
                try{
                    nivel.getNivel().setCdNivel(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, nivel.consultarCdNivel(nivel));
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    jTextFieldConsulta.setText("");
                    jTextFieldConsulta.grabFocus();
                }
            break;
                
            case 2:
                nivel.getNivel().setDsNivel(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, nivel.consultarDsNivel(nivel));
            break;
                
            case 3:
                try{
                    nivel.getTela().setCdTela(Integer.parseInt(jTextFieldConsulta.getText()));
                    preencher.PreencherJtableGenerico(jTableConsulta, nivel.consultarCdTela(nivel));
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor informe um código para pesquisar!");
                    jTextFieldConsulta.setText("");
                    jTextFieldConsulta.grabFocus();
                }
            break;
                
            default:
                nivel.getTela().setDsTela(jTextFieldConsulta.getText().toUpperCase());
                preencher.PreencherJtableGenerico(jTableConsulta, nivel.consultarDsTela(nivel));
            break;    
        }
    }//GEN-LAST:event_jBtPesquisarActionPerformed

    private void jTextFieldCdNivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCdNivelFocusLost
        if (!jTextFieldCdNivel.getText().equals("")){
            try{
                nivel.getNivel().setCdNivel(Integer.parseInt(jTextFieldCdNivel.getText()));
                limparTabela();
                nivel.retornaNivelTabela(nivel, jTableTelas);
                if (nivel.getNivel().getDsNivel().equals("")){
                    jTextFieldDescricao.setText("");
                    jBtCancelarActionPerformed(null);
                }
                else{
                    jTextFieldDescricao.setText(nivel.getNivel().getDsNivel());
                    jComboBoxSituacao.setSelectedItem(nivel.getNivel().getInAtivo());
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Por favor informe um código!");
                jBtCancelarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldCdNivelFocusLost

    private void jMenuItemCarregarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarDadosActionPerformed
        int linha = jTableConsulta.getSelectedRow();
        if (linha >=0){
            String cd = jTableConsulta.getValueAt(linha, 0).toString();
            jTextFieldCdNivel.setText(cd);
            jTextFieldCdNivelFocusLost(null);
            jTabbedPaneNivel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jMenuItemCarregarDadosActionPerformed

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

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        new ValidaCampos().validaCamposLimite(evt, jTextFieldDescricao, 40);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

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
            java.util.logging.Logger.getLogger(CadastroNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroNivel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroNivel().setVisible(true);
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
    private javax.swing.JComboBox jComboBoxConsulta;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItemCarregarDados;
    private javax.swing.JMenuItem jMenuItemRemoverTodas;
    private javax.swing.JMenuItem jMenuItemSelecionarTodas;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPopupMenu jPopupMenuCarregarDados;
    private javax.swing.JPopupMenu jPopupMenuPermissoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPaneNivel;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTable jTableTelas;
    private javax.swing.JTextField jTextFieldCdNivel;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

    private void preencherTabelaTelas(){
        PreencherTabela preencher = new PreencherTabela();
        preencher.FormatarJtable(jTableTelas, new int [] {80, 60, 300, 60, 60, 60, 60, 60});
        preencher.preencherJtableTelas(jTableTelas, nivel.getTela().consultarTelas());
    }
    
    private int contaPermissoes(int linha){
        int permissoes = 0;
        for (int col = 3; col < 8; col++){
            if ((boolean) jTableTelas.getValueAt(linha, col)){
                permissoes = permissoes + 1;
            }
        }
        return permissoes;
    }
    
    private int contaPermissoes(){
        int permissoes = 0;
        for (int i = 0; i < jTableTelas.getRowCount(); i++){
            if ((boolean) jTableTelas.getValueAt(i, 0)){
                permissoes = permissoes + 1;
            }
        }
        return permissoes;
    }
    
    private void marcarCelulas(boolean sel){
        int linha = jTableTelas.getSelectedRow();
        if (linha >=0){
            jTableTelas.setValueAt(sel, linha, 0);
            for (int col = 3; col < 8; col++){
                jTableTelas.setValueAt(sel, linha, col);
            }
        }
    }
    
    private void limparTabela(){
        for (int linha = 0; linha < jTableTelas.getRowCount(); linha++){
            jTableTelas.setValueAt(false, linha, 0);
            for (int col = 3; col < 8; col++){
                jTableTelas.setValueAt(false, linha, col);
            }
        }
    }
    
    private void gravarNivelTela(){
        for (int linha = 0; linha < jTableTelas.getRowCount(); linha++){
            boolean sel = (boolean) jTableTelas.getValueAt(linha, 0);
            
            if (sel){
                int cd = Integer.parseInt(jTableTelas.getValueAt(linha, 1).toString());
                
                boolean incluir = (boolean) jTableTelas.getValueAt(linha, 3);
                boolean alterar = (boolean) jTableTelas.getValueAt(linha, 4);
                boolean excluir = (boolean) jTableTelas.getValueAt(linha, 5);
                boolean gravar = (boolean) jTableTelas.getValueAt(linha, 6);
                boolean relatorio = (boolean) jTableTelas.getValueAt(linha, 7);
                
                if (incluir){
                    nivel.setpInclusao("S");
                }
                else{
                    nivel.setpInclusao("N");
                }
                
                if (alterar){
                    nivel.setpAlteracao("S");
                }
                else{
                    nivel.setpAlteracao("N");
                }
                
                if (excluir){
                    nivel.setpExclusao("S");
                }
                else{
                    nivel.setpExclusao("N");
                }
                
                if (gravar){
                    nivel.setpGravacao("S");
                }
                else{
                    nivel.setpGravacao("N");
                }
                
                if (relatorio){
                    nivel.setpRelatorio("S");
                }
                else{
                    nivel.setpRelatorio("N");
                }
                //
                nivel.getTela().setCdTela(cd);
                nivel.incluir(nivel);
            }
        }
    }
    
    private void carregarUsuario(){
        valida.validaNivel(this.getName());
        valida.validaBotoesUsuario(jPanelBotoes);
    }
}
