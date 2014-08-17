package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class AtendimentoMesa {

    private static Integer nrAtendimento;
    private String horaAbertura;
    private String horaFechamento;
    private String abertoFechado;
    private static Double vlTotal;
    private String dtAtendimento;

    private Mesa mesa = new Mesa();
    private Funcionario funcionario = new Funcionario();
    private AtendimentoMesaProdutos atdProdutos = new AtendimentoMesaProdutos();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(AtendimentoMesa atd) {
        RetornaSequencia seq = new RetornaSequencia();
        atd.setNrAtendimento(seq.retornaSequencia("NR_ATENDIMENTO", "ATENDIMENTO_MESA"));
        String sql = "INSERT INTO ATENDIMENTO_MESA (NR_ATENDIMENTO, HORA_ABERTURA, "
                + "ABERTO_FECHADO, DT_ATENDIMENTO) VALUES ('" + atd.getNrAtendimento() + "','"
                + atd.getHoraAbertura() + "','" + atd.getAbertoFechado() + "','" + atd.getDtAtendimento() + "')";
        conexao.incluirSQL(sql);
    }

    public void alterar(AtendimentoMesa atd) {
        String sql = "UPDATE ATENDIMENTO_MESA SET NR_MESA = '" + atd.getMesa().getNrMesa() + "', "
                + "HORA_ABERTURA = '" + atd.getHoraAbertura() + "', "
                + "HORA_FECHAMENTO = '" + atd.getHoraFechamento() + "', "
                + "ABERTO_FECHADO = '" + atd.getAbertoFechado() + "', "
                + "VL_TOTAL = '" + atd.getVlTotal() + "', "
                + "DT_ATENDIMENTO = '" + atd.getDtAtendimento() + "', "
                + "CD_FUNCIONARIO = '" + atd.getFuncionario().getCd_funcionario() + "' "
                + "WHERE NR_ATENDIMENTO = " + atd.getNrAtendimento();
        conexao.atualizarSQL(sql);
    }
    public void alterar (AtendimentoMesa atd, HashMap<String, Object> campos){
        String sql = "UPDATE ATENDIMENTO_MESA SET ";
        
         for (String key : campos.keySet()) {
                      
                      Object valor = campos.get(key);
                      
                      sql = sql + key+" = '"+valor+"', ";
         }
         
         sql = sql.subSequence(0, sql.length()-2).toString();
         sql = sql + " WHERE NR_ATENDIMENTO = "+atd.getNrAtendimento();
        conexao.atualizarSQL(sql);
    }

    public void excluir(AtendimentoMesa atd) {
        String sql = "DELETE FROM ATENDIMENTO_MESA WHERE NR_ATENDIMENTO = " + atd.getNrAtendimento();
        conexao.deleteSQL(sql);
    }

    public double retornaTotalAtendimento(JTable jtable) {
        DefaultTableModel tabela = (DefaultTableModel) jtable.getModel();
        double total = 0;
        double valor = 0;
        int linhas = tabela.getRowCount();
        for (int i = 0; i < linhas; i++) {
            valor = Double.parseDouble(tabela.getValueAt(i, 4).toString());
            total = total + valor;
        }

        return total;
    }

    public ResultSet consultarGeral(boolean fechados) {
        String sql;
        if (fechados) {
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.ABERTO_FECHADO = 'F' ORDER BY A.NR_ATENDIMENTO";
        } else {
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "ORDER BY A.NR_ATENDIMENTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNrAtendimento(AtendimentoMesa atd, boolean fechados) {
        String sql;
        if (fechados) {
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.ABERTO_FECHADO = 'F' AND A.NR_ATENDIMENTO = "
                    + atd.getNrAtendimento();
        } else {
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.NR_ATENDIMENTO = "+atd.getNrAtendimento();
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarNrMesa(AtendimentoMesa atd, boolean fechados){
        String sql;
        if (fechados){
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.ABERTO_FECHADO = 'F' AND A.NR_MESA = "
                    + atd.getMesa().getNrMesa()+" ORDER BY A.NR_ATENDIMENTO";
        }
        else{
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.NR_MESA = "
                    + atd.getMesa().getNrMesa()+" ORDER BY A.NR_ATENDIMENTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarNomeFuncionario(AtendimentoMesa atd, boolean fechados){
        String sql;
        if (fechados){
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE A.ABERTO_FECHADO = 'F' AND P.NOME LIKE '%"
                    + atd.getFuncionario().getPessoa().getNome()+"%' "
                    + "ORDER BY A.NR_ATENDIMENTO";
        }
        else{
            sql = "SELECT A.NR_ATENDIMENTO, A.NR_MESA, A.CD_FUNCIONARIO, P.NOME, "
                    + "A.HORA_ABERTURA, A.HORA_FECHAMENTO, "
                    + "TO_CHAR(A.DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                    + "CASE WHEN A.ABERTO_FECHADO = 'A' THEN 'ABERTO' "
                    + "ELSE 'FECHADO' END AS SITUACAO, "
                    + "COALESCE(A.VL_TOTAL,0.00) AS TOTAL FROM ATENDIMENTO_MESA A "
                    + "LEFT JOIN FUNCIONARIO F ON F.CD_PESSOA = A.CD_FUNCIONARIO "
                    + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                    + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                    + "WHERE P.NOME LIKE '%"+atd.getFuncionario().getPessoa().getNome()+"%' "
                    + "ORDER BY A.NR_ATENDIMENTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void retornaAtendimento(AtendimentoMesa atd){
        String sql = "SELECT NR_MESA, HORA_ABERTURA, HORA_FECHAMENTO, "
                + "ABERTO_FECHADO, VL_TOTAL, TO_CHAR(DT_ATENDIMENTO,'DD/MM/YYYY') AS DATA, "
                + "CD_FUNCIONARIO FROM ATENDIMENTO_MESA WHERE NR_ATENDIMENTO = "+atd.getNrAtendimento()
                +" AND ABERTO_FECHADO = 'F'";
        conexao.executeSQL(sql);
        try{
            conexao.resultset.first();
            atd.getFuncionario().setCd_funcionario(conexao.resultset.getInt("CD_FUNCIONARIO"));
            atd.getMesa().setNrMesa(conexao.resultset.getInt("NR_MESA"));
            atd.setHoraAbertura(conexao.resultset.getString("HORA_ABERTURA"));
            atd.setHoraFechamento(conexao.resultset.getString("HORA_FECHAMENTO"));
            atd.setAbertoFechado(conexao.resultset.getString("ABERTO_FECHADO"));
            atd.setVlTotal(conexao.resultset.getDouble("VL_TOTAL"));
            atd.setDtAtendimento(conexao.resultset.getString("DATA"));   
        }
        catch(SQLException ex){
            atd.setNrAtendimento(0);
        }
    }
    
    public ResultSet exibirAtendimentosAtuais() {
        String sql = "SELECT A.NR_MESA, A.NR_ATENDIMENTO, P.NOME, A.HORA_ABERTURA, COALESCE(A.VL_TOTAL,0.00) "
                + "FROM ATENDIMENTO_MESA A "
                + "LEFT JOIN FUNCIONARIO F ON A.CD_FUNCIONARIO = F.CD_PESSOA "
                + "LEFT JOIN PESSOA_FISICA PF ON PF.CD_PESSOA = F.CD_PESSOA "
                + "LEFT JOIN PESSOA P ON P.CD_PESSOA = PF.CD_PESSOA "
                + "WHERE A.ABERTO_FECHADO = 'A' ORDER BY A.NR_MESA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter e setter
    public Integer getNrAtendimento() {
        return nrAtendimento;
    }

    public void setNrAtendimento(Integer nrAtendimento) {
        this.nrAtendimento = nrAtendimento;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public String getAbertoFechado() {
        return abertoFechado;
    }

    public void setAbertoFechado(String abertoFechado) {
        this.abertoFechado = abertoFechado;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public String getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(String dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public AtendimentoMesaProdutos getAtdProdutos() {
        return atdProdutos;
    }

    public void setAtdProdutos(AtendimentoMesaProdutos atdProdutos) {
        this.atdProdutos = atdProdutos;
    }

}
