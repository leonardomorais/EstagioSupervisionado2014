package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class Telas {
    
    private Integer cdTela;
    private String dsTela;
    private String inAtivo;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
   
    public ResultSet consultarTelas(){
        String sql = "SELECT FALSE, CD_TELA, DS_TELA, FALSE, FALSE, FALSE, FALSE, FALSE "
                + "FROM TELAS WHERE IN_ATIVO = 'A' ORDER BY CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarTelasNivel(int codigo){
        String sql = "SELECT NT.CD_TELA, T.DS_TELA, "
                + "CASE WHEN NT.P_INCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS INCLUIR, "
                + "CASE WHEN NT.P_ALTERAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS ALTERAR, "
                + "CASE WHEN NT.P_EXCLUIR = 'S' THEN 'SIM' ELSE 'NÃO' END AS EXCLUIR, "
                + "CASE WHEN NT.P_GRAVAR = 'S' THEN 'SIM' ELSE 'NÃO' END AS GRAVAR, "
                + "CASE WHEN NT.P_RELATORIO = 'S' THEN 'SIM' ELSE 'NÃO' END AS RELATORIO "
                + "FROM NIVEL_TELA NT INNER JOIN TELAS T ON NT.CD_TELA = T.CD_TELA AND "
                + "NT.CD_NIVEL = "+codigo+" ORDER BY NT.CD_TELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    // getter e setter

    public Integer getCdTela() {
        return cdTela;
    }

    public void setCdTela(Integer cdTela) {
        this.cdTela = cdTela;
    }

    public String getDsTela() {
        return dsTela;
    }

    public void setDsTela(String dsTela) {
        this.dsTela = dsTela;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }
    
}
