package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Operacao {

    private static Integer cdOperacao;
    private static String dsOperacao;
    private String tipo;
    private String movEstoque;
    private String movFinanceiro;

    private Map<Integer, Integer> operacoes = new HashMap<Integer, Integer>();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Operacao operacao) {
        RetornaSequencia seq = new RetornaSequencia();
        operacao.setCdOperacao(seq.retornaSequencia("CD_OPERACAO", "OPERACAO"));
        String sql = "INSERT INTO OPERACAO (CD_OPERACAO, DS_OPERACAO, TIPO, "
                + "MOV_ESTOQUE, MOV_FINANCEIRO) VALUES ('" + operacao.getCdOperacao() + "','"
                + operacao.getDsOperacao().toUpperCase() + "','" + operacao.getTipo() + "','"
                + operacao.getMovEstoque() + "','" + operacao.getMovEstoque() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(Operacao operacao) {
        String sql = "UPDATE OPERACAO SET DS_OPERACAO = '" + operacao.getDsOperacao().toString() + "', "
                + "TIPO = '" + operacao.getTipo() + "', MOV_ESTOQUE = '" + operacao.getMovEstoque() + "', "
                + "MOV_FINANCEIRO = '" + operacao.getMovFinanceiro() + "' "
                + "WHERE CD_OPERACAO = " + operacao.getCdOperacao();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Operacao operacao) {
        String sql = "DELETE FROM OPERACAO WHERE CD_OPERACAO = " + operacao.getCdOperacao();
        conexao.deleteSQL(sql);
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT CD_OPERACAO, DS_OPERACAO, "
                + "CASE WHEN TIPO = 'E' THEN 'ENTRADA' "
                + "ELSE 'SAÍDA' END AS TP, "
                + "CASE WHEN MOV_ESTOQUE = 'S' THEN 'SIM' "
                + "ELSE 'NÃO' END AS ESTOQUE, "
                + "CASE WHEN MOV_FINANCEIRO = 'S' THEN 'SIM' "
                + "ELSE 'NÃO' END AS FINANCEIRO FROM OPERACAO ORDER BY CD_OPERACAO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdOperacao(Operacao operacao) {
        String sql = "SELECT CD_OPERACAO, DS_OPERACAO, "
                    + "CASE WHEN TIPO = 'E' THEN 'ENTRADA' "
                    + "ELSE 'SAÍDA' END AS TP, "
                    + "CASE WHEN MOV_ESTOQUE = 'S' THEN 'SIM' "
                    + "ELSE 'NÃO' END AS ESTOQUE, "
                    + "CASE WHEN MOV_FINANCEIRO = 'S' THEN 'SIM' "
                    + "ELSE 'NÃO' END AS FINANCEIRO FROM OPERACAO "
                    + "WHERE CD_OPERACAO = " + operacao.getCdOperacao();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDescricao(Operacao operacao) {
        String sql = "SELECT CD_OPERACAO, DS_OPERACAO, "
                + "CASE WHEN TIPO = 'E' THEN 'ENTRADA' "
                + "ELSE 'SAÍDA' END AS TP, "
                + "CASE WHEN MOV_ESTOQUE = 'S' THEN 'SIM' "
                + "ELSE 'NÃO' END AS ESTOQUE, "
                + "CASE WHEN MOV_FINANCEIRO = 'S' THEN 'SIM' "
                + "ELSE 'NÃO' END AS FINANCEIRO FROM OPERACAO "
                + "WHERE DS_OPERACAO LIKE '%" + operacao.getDsOperacao() + "%' "
                + "ORDER BY CD_OPERACAO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaOperacao(Operacao operacao) {
        ResultSet retorno = consultarCdOperacao(operacao);
        try {
            retorno.first();
            operacao.setDsOperacao(retorno.getString("DS_OPERACAO"));
            operacao.setMovEstoque(retorno.getString("ESTOQUE"));
            operacao.setMovFinanceiro(retorno.getString("FINANCEIRO"));
            operacao.setTipo(retorno.getString("TP"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Operação não encontrada");
            operacao.setDsOperacao("");
        }
    }

    public void retornaComboOperacao(JComboBox combo, String tipo) {
        String sql = "SELECT * FROM OPERACAO WHERE MOV_FINANCEIRO = 'S' AND "
                + "TIPO = '" + tipo + "' ORDER BY CD_OPERACAO";
        if (tipo.equals("TODOS")) {
            sql = "SELECT * FROM OPERACAO ORDER BY CD_OPERACAO";
        }
        conexao.executeSQL(sql);

        combo.removeAllItems();
        int conta = 0;

        try {
            while (conexao.resultset.next()) {
                combo.addItem(conexao.resultset.getString("DS_OPERACAO"));
                operacoes.put(conta, conexao.resultset.getInt("CD_OPERACAO"));
                conta++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Operação não encontrada!");
        }
    }

// getter e setter
    public Integer getCdOperacao() {
        return cdOperacao;
    }

    public void setCdOperacao(Integer cdOperacao) {
        this.cdOperacao = cdOperacao;
    }

    public String getDsOperacao() {
        return dsOperacao;
    }

    public void setDsOperacao(String dsOperacao) {
        this.dsOperacao = dsOperacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMovEstoque() {
        return movEstoque;
    }

    public void setMovEstoque(String movEstoque) {
        this.movEstoque = movEstoque;
    }

    public String getMovFinanceiro() {
        return movFinanceiro;
    }

    public void setMovFinanceiro(String movFinanceiro) {
        this.movFinanceiro = movFinanceiro;
    }

    public Map<Integer, Integer> getOperacoes() {
        return operacoes;
    }

    public int getOperacao(int pos) {
        return operacoes.get(pos);
    }

    public void setOperacoes(Map<Integer, Integer> operacoes) {
        this.operacoes = operacoes;
    }

}
