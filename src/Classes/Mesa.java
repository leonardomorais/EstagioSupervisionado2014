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
public class Mesa {

    private static Integer nrMesa;
    private String dsMesa;
    private String inAtiva;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Mesa mesa) {
        RetornaSequencia seq = new RetornaSequencia();
        mesa.setNrMesa(seq.retornaSequencia("NR_MESA", "MESA"));
        String sql = "INSERT INTO MESA (NR_MESA, DS_MESA, ATIVA) "
                + "VALUES ('" + mesa.getNrMesa() + "','" + mesa.getDsMesa() + "','" + mesa.getInAtiva() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Mesa mesa) {
        String sql = "UPDATE MESA SET DS_MESA = '" + mesa.getDsMesa() + "', "
                + "ATIVA = '" + mesa.getInAtiva() + "' WHERE NR_MESA = " + mesa.getNrMesa();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Mesa mesa) {
        String sql = "UPDATE MESA SET ATIVA = 'I' WHERE NR_MESA = " + mesa.getNrMesa();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral() {
        ResultSet retorno = null;
        String sql = "SELECT NR_MESA, DS_MESA, CASE WHEN ATIVA = 'A' THEN 'ATIVA' ELSE 'INATIVA' "
                + "END AS SITUACAO FROM MESA ORDER BY NR_MESA";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarNrMesa(Mesa mesa) {
        ResultSet retorno = null;
        String sql = "SELECT NR_MESA, DS_MESA, CASE WHEN ATIVA = 'A' THEN 'ATIVA' ELSE 'INATIVA' "
                + "END AS SITUACAO FROM MESA WHERE NR_MESA = " + mesa.getNrMesa();
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public ResultSet consultarDescricao(Mesa mesa) {
        ResultSet retorno = null;
        String sql = "SELECT NR_MESA, DS_MESA, CASE WHEN ATIVA = 'A' THEN 'ATIVA' ELSE 'INATIVA' "
                + "END AS SITUACAO FROM  MESA WHERE DS_MESA LIKE '%" + mesa.getDsMesa() + "%' "
                + "ORDER BY NR_MESA";
        conexao.executeSQL(sql);
        retorno = conexao.resultset;
        return retorno;
    }

    public void retornaMesa(Mesa mesa, boolean todas) {
        ResultSet retorno = consultarNrMesa(mesa);
        try {
            retorno.first();
            mesa.setDsMesa(retorno.getString("DS_MESA"));
            mesa.setInAtiva(retorno.getString("SITUACAO"));
            
            
            if(!todas && mesa.getInAtiva().equals("INATIVA")){
                throw new SQLException();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mesa não encontrada !");
            mesa.setDsMesa("");
        }
    }
    
// getter e setter
    public Integer getNrMesa() {
        return nrMesa;
    }

    public void setNrMesa(Integer nrMesa) {
        this.nrMesa = nrMesa;
    }

    public String getDsMesa() {
        return dsMesa;
    }

    public void setDsMesa(String dsMesa) {
        this.dsMesa = dsMesa;
    }

    public String getInAtiva() {
        return inAtiva;
    }

    public void setInAtiva(String inAtiva) {
        this.inAtiva = inAtiva;
    }

}
