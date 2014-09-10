package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaData;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class MovCaixa {

    private Integer cdMov;
    private Double saldoAnterior;
    private Double saldoFinal;
    private Double valorMov;
    private String dataMov;
    private String observacao;

    private AgenciaConta agc = new AgenciaConta();
    private Parcelas parcelas = new Parcelas();
    private Operacao operacao = new Operacao();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(MovCaixa mov, boolean conta) {
        RetornaSequencia seq = new RetornaSequencia();
        mov.setCdMov(seq.retornaSequencia("CD_MOV", "MOV_CAIXA"));
        String sql;
        if (conta) {
            // se for movimentação de caixa referente a parcela de uma conta 
            sql = "INSERT INTO MOV_CAIXA (CD_MOV, CD_AGENCIA_CONTA, CD_OPERACAO, CD_CONTA, "
                    + "NR_PARCELA, SALDO_ANTERIOR, SALDO_FINAL, DATA_MOV, VALOR_MOV, OBSERVACAO) "
                    + "VALUES ('" + mov.getCdMov() + "','" + mov.getAgc().getCdAgcConta() + "','"
                    + mov.getOperacao().getCdOperacao() + "','" + mov.getParcelas().getContas().getCdConta() + "','"
                    + mov.getParcelas().getNrParcela() + "','" + mov.getSaldoAnterior() + "','" + mov.getSaldoFinal() + "','"
                    + mov.getDataMov() + "','" + mov.getValorMov() + "','" + mov.getObservacao() + "')";
        } else {
            sql = "INSERT INTO MOV_CAIXA (CD_MOV, CD_AGENCIA_CONTA, CD_OPERACAO, SALDO_ANTERIOR, SALDO_FINAL, "
                    + "DATA_MOV, VALOR_MOV, OBSERVACAO) VALUES ('" + mov.getCdMov() + "','" + mov.getAgc().getCdAgcConta() + "','"
                    + mov.getOperacao().getCdOperacao() + "','" + mov.getSaldoAnterior() + "','" + mov.getSaldoFinal() + "','"
                    + mov.getDataMov() + "','" + mov.getValorMov() + "','" + mov.getObservacao() + "')";
        }
        conexao.incluirSQL(sql);
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdMov(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE MOV.CD_MOV = " + mov.getCdMov();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

//    public ResultSet consultarCdAgenciaConta(MovCaixa mov){
//        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
//                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
//                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
//                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
//                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
//                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
//                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO INNER JOIN PARCELAS P "
//                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
//                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
//                + "WHERE MOV.CD_AGENCIA_CONTA = "+mov.getAgc().getCdAgcConta()+" ORDER BY MOV.CD_MOV";
//        conexao.executeSQL(sql);
//        return conexao.resultset;
//    }
    public ResultSet consultarAgenciaConta(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE A.DS_CONTA = '" + mov.getAgc().getDsConta() + "' ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

//    public ResultSet consultarCdOperacao(MovCaixa mov){
//        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
//                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
//                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
//                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
//                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
//                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
//                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO INNER JOIN PARCELAS P "
//                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
//                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
//                + "WHERE MOV.CD_OPERACAO = "+mov.getOperacao().getCdOperacao()+" ORDER BY MOV.CD_MOV";
//        conexao.executeSQL(sql);
//        return conexao.resultset;
//    }
    public ResultSet consultarOperacao(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE O.DS_OPERACAO = '" + mov.getOperacao().getDsOperacao() + "' ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE MOV.CD_CONTA = " + mov.getParcelas().getContas().getCdConta() + " ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarConta(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO INNER JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE C.DS_CONTA LIKE '%" + mov.getParcelas().getContas().getDsConta() + "%' ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarTipo(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE O.TIPO = '" + mov.getOperacao().getTipo() + "' ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarObservacao(MovCaixa mov) {
        String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE MOV.OBSERVACAO LIKE '%" + mov.getObservacao() + "%' ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarPeriodo(String dtInicial, String dtFinal){
         String sql = "SELECT MOV.CD_MOV, MOV.CD_AGENCIA_CONTA, A.DS_CONTA, MOV.CD_OPERACAO, O.DS_OPERACAO, "
                + "MOV.CD_CONTA, C.DS_CONTA, MOV.NR_PARCELA, MOV.SALDO_ANTERIOR, MOV.SALDO_FINAL, "
                + "TO_CHAR(MOV.DATA_MOV,'DD/MM/YYYY') AS DATA, MOV.VALOR_MOV, MOV.OBSERVACAO , "
                + "CASE WHEN O.TIPO = 'S' THEN 'SAÍDA' ELSE 'ENTRADA' END AS TIPO "
                + "FROM MOV_CAIXA MOV INNER JOIN AGENCIA_CONTA A "
                + "ON MOV.CD_AGENCIA_CONTA = A.CD_AGENCIA_CONTA INNER JOIN OPERACAO O "
                + "ON MOV.CD_OPERACAO = O.CD_OPERACAO LEFT JOIN PARCELAS P "
                + "ON MOV.CD_CONTA = P.CD_CONTA AND MOV.NR_PARCELA = P.NR_PARCELA "
                + "LEFT JOIN CONTAS_PAGAR_RECEBER C ON P.CD_CONTA = C.CD_CONTA "
                + "WHERE DATA_MOV BETWEEN '"+dtInicial+"' AND '"+dtFinal+"' "
                + "ORDER BY MOV.CD_MOV";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

// getter e setter
    public AgenciaConta getAgc() {
        return agc;
    }

    public void setAgc(AgenciaConta agc) {
        this.agc = agc;
    }

    public Parcelas getParcelas() {
        return parcelas;
    }

    public void setParcelas(Parcelas parcelas) {
        this.parcelas = parcelas;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Integer getCdMov() {
        return cdMov;
    }

    public void setCdMov(Integer cdMov) {
        this.cdMov = cdMov;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Double getValorMov() {
        return valorMov;
    }

    public void setValorMov(Double valorMov) {
        this.valorMov = valorMov;
    }

    public String getDataMov() {
        return dataMov;
    }

    public void setDataMov(String dataMov) {
        this.dataMov = dataMov;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
