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
public class FormaPagamento {

    private Integer cdForma;
    private String dsForma;
    private String entrada;
    private Integer intervalo;
    private Integer qtParcelas;

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(FormaPagamento forma) {
        RetornaSequencia seq = new RetornaSequencia();
        forma.setCdForma(seq.retornaSequencia("CD_FORMA", "FORMA_PGTO"));
        String sql = "INSERT INTO FORMA_PGTO (CD_FORMA, DS_FORMA, ENTRADA, INTERVALO, QT_PARCELAS)"
                + "VALUES ('" + forma.getCdForma() + "','" + forma.getDsForma() + "','" + forma.getEntrada() + "','"
                + forma.getIntervalo() + "','" + forma.getQtParcelas() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(FormaPagamento forma) {
        String sql = "UPDATE FORMA_PGTO SET DS_FORMA = '" + forma.getDsForma() + "', ENTRADA = '" + forma.getEntrada() + "',"
                + " INTERVALO = '" + forma.getIntervalo() + "', QT_PARCELAS = '" + forma.getQtParcelas() + "' "
                + "WHERE CD_FORMA = " + forma.getCdForma();
        conexao.atualizarSQL(sql);
    }

    public void excluir(FormaPagamento forma) {
        String sql = "DELETE FROM FORMA_PGTO WHERE CD_FORMA = " + forma.getCdForma();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT CD_FORMA, DS_FORMA, CASE WHEN ENTRADA = 'S' THEN 'SIM' ELSE 'NÃO' END AS ENTRADA,"
                + " INTERVALO, QT_PARCELAS FROM FORMA_PGTO ORDER BY CD_FORMA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCodigo(FormaPagamento forma) {
        ResultSet retorno = null;
        String sql = "SELECT CD_FORMA, DS_FORMA, CASE WHEN ENTRADA = 'S' THEN 'SIM' ELSE 'NÃO' END AS ENTRADA,"
                + " INTERVALO, QT_PARCELAS FROM FORMA_PGTO WHERE CD_FORMA = " + forma.getCdForma();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsForma(FormaPagamento forma) {
        ResultSet retorno = null;
        String sql = "SELECT CD_FORMA, DS_FORMA, CASE WHEN ENTRADA = 'S' THEN 'SIM' ELSE 'NAO' END AS ENTRADA,"
                + " INTERVALO, QT_PARCELAS FROM FORMA_PGTO WHERE DS_FORMA LIKE '%" + forma.getDsForma() + "%' "
                + "ORDER BY CD_FORMA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaForma(FormaPagamento forma) {
        ResultSet retorno = consultarCodigo(forma);
        try {
            retorno.first();
            forma.setDsForma(retorno.getString("DS_FORMA"));
            forma.setEntrada(retorno.getString("ENTRADA"));
            forma.setIntervalo(retorno.getInt("INTERVALO"));
            forma.setQtParcelas(retorno.getInt("QT_PARCELAS"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Forma de pagamento não encontrada !");
            forma.setDsForma("");
        }

    }

// getter e setter
    public Integer getCdForma() {
        return cdForma;
    }

    public void setCdForma(Integer cdForma) {
        this.cdForma = cdForma;
    }

    public String getDsForma() {
        return dsForma;
    }

    public void setDsForma(String dsForma) {
        this.dsForma = dsForma;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public Integer getQtParcelas() {
        return qtParcelas;
    }

    public void setQtParcelas(Integer qtParcelas) {
        this.qtParcelas = qtParcelas;
    }

}
