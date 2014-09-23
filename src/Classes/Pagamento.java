package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Pagamento {

    private Integer cdPagamento;

    private AgenciaConta agc = new AgenciaConta();
    private Parcelas parcelas = new Parcelas();
    private TipoPagamento tipo = new TipoPagamento();
    private String situacao;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Pagamento pagamento) {
        RetornaSequencia seq = new RetornaSequencia();
        pagamento.setCdPagamento(seq.retornaSequencia("CD_PAGAMENTO", "PAGAMENTO"));
        String sql = "INSERT INTO PAGAMENTO (CD_PAGAMENTO, NR_PARCELA, CD_CONTA, CD_TIPO, "
                + "CD_AGENCIA_CONTA, SITUACAO) VALUES ('" + pagamento.getCdPagamento() + "','"
                + pagamento.getParcelas().getNrParcela() + "','"
                + pagamento.getParcelas().getContas().getCdConta() + "','"
                + pagamento.getTipo().getCdTipo() + "','"
                + pagamento.getAgc().getCdAgcConta() + "','A')";
        conexao.incluirSQL(sql);
    }
    
    public void alterar(Pagamento pagamento){
        String sql = "UPDATE PAGAMENTO SET SITUACAO = 'I' WHERE CD_CONTA = "
                +pagamento.getParcelas().getContas().getCdConta()+" AND "
                + "NR_PARCELA = "+pagamento.getParcelas().getNrParcela();
        conexao.atualizarSQL(sql);
    }

    public ResultSet consultarGeral(boolean ativos) {
        String clausula;
        if (ativos){
            clausula = "WHERE PAG.SITUACAO = 'A'";
        } 
        else{
            clausula = "";
        }
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, PAG.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                +clausula+" ORDER BY PAG.CD_PAGAMENTO";
        
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdPagamento(Pagamento pagamento, boolean ativos) {
        String clausula;
        if (ativos){
            clausula = "AND PAG.SITUACAO = 'A'";
        }
        else{
            clausula = "";
        }
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE PAG.CD_PAGAMENTO = " + pagamento.getCdPagamento()+clausula;
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Pagamento pagamento, boolean ativos) {
        String clausula;
        if (ativos){
            clausula = "AND PAG.SITUACAO = 'A'";
        }
        else{
            clausula = "";
        }
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE PAG.CD_CONTA = " + pagamento.getParcelas().getContas().getCdConta() +clausula+ " "
                + "ORDER BY PAG.CD_PAGAMENTO ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsConta(Pagamento pagamento, boolean ativos) {
        String clausula;
        if (ativos){
            clausula = "AND PAG.SITUACAO = 'A'";
        }
        else{
            clausula = "";
        }
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE C.DS_CONTA = " + pagamento.getParcelas().getContas().getDsConta() +clausula+ " "
                + "ORDER BY PAG.CD_PAGAMENTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarCdAgencia(Pagamento pagamento, boolean ativos){
        String clausula;
        if(ativos){
            clausula = "AND PAG.SITUACAO = 'A'";
        }
        else{
            clausula = "";
        }
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE A.CD_AGENCIA_CONTA = " + pagamento.getAgc().getCdAgcConta() +clausula+ " "
                + "ORDER BY PAG.CD_PAGAMENTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarSituacao(Pagamento pagamento){
        String sql = "";
        if (pagamento.getSituacao().equals("TODOS")){
            sql = "";
        }
        else{
            sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA AS DS "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE PAG.SITUACAO = '" + pagamento.getSituacao() + "' "
                + "ORDER BY PAG.CD_PAGAMENTO";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public ResultSet consultarTicket(Pagamento pagamento, List<Integer> list){
        
        String consulta = "";
        for (int nr : list) {
            consulta = consulta + ", " + nr;
        }
        consulta = consulta.substring(2, consulta.length()); // remove a primeira virgula
        
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, PAG.NR_PARCELA, C.DS_CONTA,"
                + "PAG.NR_PARCELA, PAG.CD_TIPO, T.DS_TIPO, P.VL_PAGO "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P "
                + "ON P.CD_CONTA = PAG.CD_CONTA "
                + "AND P.NR_PARCELA = PAG.NR_PARCELA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C "
                + "ON PAG.CD_CONTA = C.CD_CONTA "
                + "INNER JOIN TIPO_PGTO T "
                + "ON T.CD_TIPO = PAG.CD_TIPO "
                + "WHERE PAG.SITUACAO = 'A' "
                + "AND PAG.CD_CONTA = " +pagamento.getParcelas().getContas().getCdConta()+ " "
                + "AND P.NR_PARCELA IN (" + consulta + ") AND P.SITUACAO = 'A'";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }
    
    public void gravarMovCaixa(Pagamento pagamento){
        MovCaixa mov = new MovCaixa();
        mov.getOperacao().setCdOperacao(pagamento.getParcelas().getContas().getVendaCompra().getOperacao().getCdOperacao());
        mov.getOperacao().retornaOperacao(mov.getOperacao());
        pagamento.getAgc().retornaAgenciaConta(pagamento.getAgc());
        mov.setParcelas(pagamento.getParcelas());
        mov.setAgc(pagamento.getAgc());
        mov.setValorMov(getParcelas().getVlPago());
        mov.setSaldoAnterior(getAgc().getVlConta());
        mov.setDataMov(getParcelas().getDtPago());
        
        if (mov.getParcelas().getContas().getTpConta().equals("A PAGAR")){
            mov.setSaldoFinal(mov.getSaldoAnterior() - mov.getValorMov());
        }
        else{
            mov.setSaldoFinal(mov.getSaldoAnterior() + mov.getValorMov());
        }
        // atualiza a conta
        mov.getAgc().setVlConta(mov.getSaldoFinal());
        mov.getAgc().atualizarValorConta(mov.getAgc());
        //
        mov.setObservacao("PAGAMENTO DA CONTA "+mov.getParcelas().getContas().getCdConta()+
                " PARCELA "+mov.getParcelas().getNrParcela());
        mov.incluir(mov, true);
    }
    
    // getter e setter
    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public Integer getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(Integer cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
