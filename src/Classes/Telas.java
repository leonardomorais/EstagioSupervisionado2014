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
