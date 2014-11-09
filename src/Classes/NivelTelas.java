
package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Leonardo
 */
public class NivelTelas {

    private Nivel nivel = new Nivel();
    private Telas tela = new Telas();
    private String pInclusao;
    private String pAlteracao;
    private String pExclusao;
    private String pGravacao;
    private String pRelatorio;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(NivelTelas nvTelas){
        String sql = "INSERT INTO NIVEL_TELA (CD_NIVEL, CD_TELA, P_INCLUIR, P_ALTERAR,"
                + " P_EXCLUIR, P_GRAVAR, P_RELATORIO) VALUES ('"+nvTelas.getNivel().getCdNivel()+"','"
                +nvTelas.getTela().getCdTela()+"','"+nvTelas.getpInclusao()+"','"+nvTelas.getpAlteracao()+"','"
                +nvTelas.getpExclusao()+"','"+nvTelas.getpGravacao()+"','"+nvTelas.getpRelatorio()+"')";
        conexao.incluirSQL(sql);
    }
    
    public void excluir(NivelTelas nvTelas){
        String sql = "DELETE FROM NIVEL_TELA WHERE CD_NIVEL = "+nvTelas.getNivel().getCdNivel();
        conexao.deleteSQL(sql);
    }
    
    
    
    public ResultSet consultarGeral(){
        String sql = "SELECT NT.CD_NIVEL, N.DS_NIVEL, NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO,"
                + "CASE WHEN N.IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL_TELA NT INNER JOIN NIVEL N "
                + "ON NT.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.IN_ATIVO = 'A' "
                + "ORDER BY NT.CD_NIVEL, NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdNivel(NivelTelas nvTelas){
        String sql = "SELECT NT.CD_NIVEL, N.DS_NIVEL, NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO, "
                + "CASE WHEN N.IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL_TELA NT INNER JOIN NIVEL N "
                + "ON NT.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.IN_ATIVO = 'A' WHERE NT.CD_NIVEL = "+nvTelas.getNivel().getCdNivel()+" "
                + "ORDER BY NT.CD_NIVEL, NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarDsNivel(NivelTelas nvTelas){
        String sql = "SELECT NT.CD_NIVEL, N.DS_NIVEL, NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO, "
                + "CASE WHEN N.IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL_TELA NT INNER JOIN NIVEL N "
                + "ON NT.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.IN_ATIVO = 'A' WHERE N.DS_NIVEL LIKE '%"+nvTelas.getNivel().getDsNivel()+"%' "
                + "ORDER BY NT.CD_NIVEL, NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdTela(NivelTelas nvTelas){
        String sql = "SELECT NT.CD_NIVEL, N.DS_NIVEL, NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO, "
                + "CASE WHEN N.IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL_TELA NT INNER JOIN NIVEL N "
                + "ON NT.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.IN_ATIVO = 'A' WHERE NT.CD_TELA = "+nvTelas.getTela().getCdTela()+" "
                + "ORDER BY NT.CD_NIVEL, NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarDsTela(NivelTelas nvTelas){
        String sql = "SELECT NT.CD_NIVEL, N.DS_NIVEL, NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO, "
                + "CASE WHEN N.IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL_TELA NT INNER JOIN NIVEL N "
                + "ON NT.CD_NIVEL = N.CD_NIVEL AND N.IN_ATIVO = 'A' "
                + "INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA "
                + "AND T.IN_ATIVO = 'A' WHERE T.DS_TELA LIKE '%"+nvTelas.getTela().getDsTela()+"%' "
                + "ORDER BY NT.CD_NIVEL, NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void retornaNivelTabela(NivelTelas nvTelas, JTable tabela){
        ResultSet retorno = consultarCdNivel(nvTelas);
        
        try{
            retorno.first();
            int nivel = retorno.getInt("CD_NIVEL");
            retorno.beforeFirst();
            while (retorno.next()){
                int tela = retorno.getInt("CD_TELA");
                nvTelas.getNivel().setDsNivel(retorno.getString("DS_NIVEL"));
                nvTelas.getNivel().setInAtivo(retorno.getString("SIT"));
                int linha = retornaLinha(tela, tabela);
                if (linha >=0){
                    tabela.setValueAt(true, linha, 0);
                    String inclusao = retorno.getString("INCLUIR");
                    String alteracao = retorno.getString("ALTERAR");
                    String exclusao = retorno.getString("EXCLUIR");
                    String gravacao = retorno.getString("GRAVAR");
                    String relatorio = retorno.getString("RELATORIO");
                     
                    tabela.setValueAt((boolean) inclusao.equals("SIM"), linha, 3);
                    tabela.setValueAt((boolean) alteracao.equals("SIM"), linha, 4);
                    tabela.setValueAt((boolean) exclusao.equals("SIM"), linha, 5);
                    tabela.setValueAt((boolean) gravacao.equals("SIM"), linha, 6);
                    tabela.setValueAt((boolean) relatorio.equals("SIM"), linha, 7);
                }
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nível não encontrado!");
            nvTelas.getNivel().setDsNivel("");
        }
        
    }
    
    private int retornaLinha(int cdTela, JTable tabela){
        for (int linha = 0; linha < tabela.getRowCount(); linha++){
            if (Integer.parseInt(tabela.getValueAt(linha, 1).toString()) == cdTela){
                return linha;
            }
        }
        return - 1;
    }
    // getter e setter

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getpInclusao() {
        return pInclusao;
    }

    public void setpInclusao(String pInclusao) {
        this.pInclusao = pInclusao;
    }

    public String getpAlteracao() {
        return pAlteracao;
    }

    public void setpAlteracao(String pAlteracao) {
        this.pAlteracao = pAlteracao;
    }

    public String getpExclusao() {
        return pExclusao;
    }

    public void setpExclusao(String pExclusao) {
        this.pExclusao = pExclusao;
    }

    public String getpGravacao() {
        return pGravacao;
    }

    public void setpGravacao(String pGravacao) {
        this.pGravacao = pGravacao;
    }

    public String getpRelatorio() {
        return pRelatorio;
    }

    public void setpRelatorio(String pRelatorio) {
        this.pRelatorio = pRelatorio;
    }

    public Telas getTela() {
        return tela;
    }

    public void setTela(Telas tela) {
        this.tela = tela;
    }
    
    
}
