package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Nivel {
    
    private static Integer cdNivel;
    private static String dsNivel;
    private String inAtivo;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void incluir(Nivel nivel){
        RetornaSequencia seq = new RetornaSequencia();
        nivel.setCdNivel(seq.retornaSequencia("CD_NIVEL", "NIVEL"));
        String sql = "INSERT INTO NIVEL (CD_NIVEL, DS_NIVEL, IN_ATIVO) VALUES "
                + "('"+nivel.getCdNivel()+"','"+nivel.getDsNivel()+"','"+nivel.getInAtivo()+"')";
        conexao.incluirSQL(sql);
        if (conexao.retorno == 1){
            JOptionPane.showMessageDialog(null, "Nível de usuário cadastrado com sucesso!");
        }
    }
    
    public void alterar(Nivel nivel){
        String sql = "UPDATE NIVEL SET DS_NIVEL = '"+nivel.getDsNivel()+"', IN_ATIVO = '"+nivel.getInAtivo()+"'"
                + "WHERE CD_NIVEL = "+nivel.getCdNivel();
        conexao.atualizarSQL(sql);
    }
    
    public void excluir(Nivel nivel){
        String sql = "UPDATE NIVEL SET IN_ATIVO = 'I' WHERE CD_NIVEL = "+nivel.getCdNivel();
        conexao.atualizarSQL(sql);
    }
    
    public ResultSet consultarGeral(boolean todos){
        String condicao = "";
        if (!todos){
            condicao = "WHERE IN_ATIVO = 'A' ";
        }
        String sql = "SELECT CD_NIVEL, DS_NIVEL, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL "+ condicao +"ORDER BY CD_NIVEL";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdNivel(Nivel nivel, boolean todos){
        String condicao = "";
        if (!todos){
            condicao = "AND IN_ATIVO = 'A' ";
        }
        String sql = "SELECT CD_NIVEL, DS_NIVEL, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL WHERE CD_NIVEL = "+nivel.getCdNivel()+" "
                + condicao;
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarDescricao(Nivel nivel, boolean todos){
        String condicao = "";
        if (!todos){
            condicao = "AND IN_ATIVO = 'A' ";
        }
        String sql = "SELECT CD_NIVEL, DS_NIVEL, "
                + "CASE WHEN IN_ATIVO = 'A' THEN 'ATIVO' ELSE 'INATIVO' END AS SIT "
                + "FROM NIVEL WHERE DS_NIVEL LIKE '%"+nivel.getDsNivel()+"%' "
                +condicao+"ORDER BY CD_NIVEL";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void retornaNivel(Nivel nivel, boolean todos){
        ResultSet retorno = consultarCdNivel(nivel, todos);
        try{
            retorno.first();
            nivel.setDsNivel(retorno.getString("DS_NIVEL"));
            nivel.setInAtivo(retorno.getString("SIT"));
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Nível não encontrado!");
            nivel.setDsNivel("");
        }
    }
    
    // getter e setter

    public Integer getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public String getDsNivel() {
        return dsNivel;
    }

    public void setDsNivel(String dsNivel) {
        this.dsNivel = dsNivel;
    }

    public String getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(String inAtivo) {
        this.inAtivo = inAtivo;
    }
    
    
    
}
