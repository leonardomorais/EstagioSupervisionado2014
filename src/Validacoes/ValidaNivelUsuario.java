package Validacoes;

import Classes.Usuario;
import ConexaoBanco.ConexaoPostgreSQL;
import Telas.MenuPrincipal;
import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Leonardo
 */
public class ValidaNivelUsuario {
    
    public String dsUsuario;
    public String pInclusao;
    public String pAlteracao;
    public String pExclusao;
    public String pGravacao;
    public String pRelatorio;
    
    private String nivel;
    private String cdTela;
    private String cdValida;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public boolean login(Usuario user){
        try {
//            String sql = "SELECT CD_NIVEL FROM USUARIO WHERE LOGIN = '" + user.getLogin() + "' "
//                    + "AND SENHA = '" + user.getSenha() + "'";
            
            String sql = "SELECT U.CD_NIVEL AS CODIGO FROM USUARIO U INNER JOIN "
                    + "NIVEL N ON U.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                    + "WHERE U.LOGIN = '" + user.getLogin() + "' AND U.SENHA = '" + user.getSenha() + "'";
            conexao.executeSQL(sql);
            conexao.resultset.first();
            // encontrou o usuário com a senha correta e nível ativo! 
            nivel = conexao.resultset.getString("CODIGO"); 
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void validaNivel(String nomeTela){
        try{
            conexao.executeSQL("SELECT * FROM USUARIO WHERE LOGIN = '"+MenuPrincipal.usuarioAtual+"'");
            conexao.resultset.first();
            nivel = conexao.resultset.getString("CD_NIVEL");
            
            if (!nivel.equals("")){
                conexao.executeSQL("SELECT * FROM TELAS WHERE DS_TELA = '"+nomeTela+"'");
                conexao.resultset.first();
                cdTela = conexao.resultset.getString("CD_TELA");
                
                if (!cdTela.equals("")){
                    conexao.executeSQL("SELECT * FROM NIVEL_TELA WHERE CD_NIVEL = '"+nivel+"' AND "
                            + "CD_TELA = '"+cdTela+"'");
                    conexao.resultset.first();
                    cdValida = conexao.resultset.getString("CD_TELA");
                    if (!cdValida.equals("")){
                        pInclusao = conexao.resultset.getString("P_INCLUIR");
                        pAlteracao = conexao.resultset.getString("P_ALTERAR");
                        pExclusao = conexao.resultset.getString("P_EXCLUIR");
                        pGravacao = conexao.resultset.getString("P_GRAVAR");
                        pRelatorio = conexao.resultset.getString("P_RELATORIO");
                    }
                }
            }
        }
        catch(SQLException ex){
            
        }
    }
    
    public void checarBarra(JMenuBar barraMenu, String desc_usuario) {
        
        dsUsuario = desc_usuario;
        Component menus[] = barraMenu.getComponents();
        for (Component menu : menus) {
            if (menu instanceof JMenu) {
                checarMenu((JMenu) menu);
            } else if (menu instanceof JMenuItem) {
                checarItens((JMenuItem) menu);
            }
        }

    }

    public void checarMenu(JMenu menu) {

        Component itensMenu[] = menu.getMenuComponents();
        for (Component itemMenu : itensMenu) {
            if (itemMenu instanceof JMenuItem) {
                checarItens((JMenuItem) itemMenu);
            } else if (itemMenu instanceof JMenu) {
                checarMenu((JMenu) itemMenu);
            }
        }
    }

    public void checarItens(JMenuItem item) {
        if (item.getName() != null) {
            String nomeTela = item.getName();
            String sqlNivel = "SELECT CD_NIVEL FROM USUARIO WHERE LOGIN = '" + dsUsuario + "'";
            String sqlTela = "SELECT CD_TELA FROM TELAS WHERE DS_TELA = '" + nomeTela + "'";
            try {
                conexao.executeSQL(sqlNivel);
                conexao.resultset.first();
                int nivel = conexao.resultset.getInt("CD_NIVEL");
                
                conexao.executeSQL(sqlTela);
                conexao.resultset.first();
                int tela = conexao.resultset.getInt("CD_TELA");
                
                String sql_nivel_usuario = "SELECT * FROM NIVEL_TELA WHERE CD_TELA = " + tela
                        + "AND CD_NIVEL = " + nivel;
                conexao.executeSQL(sql_nivel_usuario);
                
//                if (conexao.resultset.first() == false) {
//                    item.setEnabled(false);
//                }
                item.setEnabled(conexao.resultset.first());
                
            } 
            catch (SQLException ex) {
                
            }
        }
    }
    
    public void validaBotoesUsuario(Container container) {

        Component components[] = container.getComponents();
        for (Component component : components) {

            if (component instanceof JButton) {
                JButton field = (JButton) component;
                String nome = field.getText();
                
                if (nome.equals("Incluir") | nome.equals("Iniciar Atendimento")
                        | nome.equals("Incluir Venda/Compra")){
                    if (pInclusao.equals("N") && field.isEnabled()){
                        // se o botão de incluir estiver ativo e não houver a permissão para inclusão
                        field.setEnabled(false);
                    }
                }
                
                else if (nome.equals("Alterar")){
                    if (pAlteracao.equals("N") && field.isEnabled()){
                        // se o botão de alterar estiver ativo e não houver a permissão de alterar
                        field.setEnabled(false);
                    }
                }
                
                else if (nome.equals("Excluir")){
                    if (pExclusao.equals("N") && field.isEnabled()){
                        // se o botão excluir estiver ativo e não houver a permissão de excluir
                        field.setEnabled(false);
                    }
                }
                
                else if (nome.equals("Gravar") | nome.equals("Fechar Atendimento")){
                    if (pGravacao.equals("N") && field.isEnabled()){
                        // se o botão gravar estiver ativo e não houver a permissão de gravar
                    field.setEnabled(false);
                    }
                }
            }
        }
    }
    
    public boolean validaBotaoCadastro(String nome){
        String sql = "SELECT T.DS_TELA FROM NIVEL_TELA NT "
                + "INNER JOIN NIVEL N ON NT.CD_NIVEL = N.CD_NIVEL "
                + "AND NT.CD_NIVEL = "+nivel+" "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.DS_TELA = '"+nome+"'";
        conexao.executeSQL(sql);
        try{
            conexao.resultset.first();
            nome = conexao.resultset.getString("DS_TELA");
            return true;
        }
        catch(SQLException ex){
            return false;
        }
    }
    
}
