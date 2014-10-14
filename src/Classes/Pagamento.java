package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaData;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
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
    private String sitCheque;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Pagamento pagamento) {
        if (pagamento.getTipo().getCdTipo() == 2){
            pagamento.setSitCheque("A");
        }
        else{
            pagamento.setSitCheque("");
        }
        RetornaSequencia seq = new RetornaSequencia();
        pagamento.setCdPagamento(seq.retornaSequencia("CD_PAGAMENTO", "PAGAMENTO"));
        String sql = "INSERT INTO PAGAMENTO (CD_PAGAMENTO, NR_PARCELA, CD_CONTA, CD_TIPO, "
                + "CD_AGENCIA_CONTA, SITUACAO, SIT_CHEQUE) VALUES ('" + pagamento.getCdPagamento() + "','"
                + pagamento.getParcelas().getNrParcela() + "','"
                + pagamento.getParcelas().getContas().getCdConta() + "','"
                + pagamento.getTipo().getCdTipo() + "','"
                + pagamento.getAgc().getCdAgcConta() + "','A','"+pagamento.getSitCheque()+"')";
        conexao.incluirSQL(sql);
    }
    
    public void alterar(Pagamento pagamento){
        String sql = "UPDATE PAGAMENTO SET SITUACAO = 'I' WHERE CD_CONTA = "
                +pagamento.getParcelas().getContas().getCdConta()+" AND "
                + "NR_PARCELA = "+pagamento.getParcelas().getNrParcela();
        conexao.atualizarSQL(sql);
    }
    
    public void alterarPagamentoCheque(Pagamento pagamento) {
        String slq = "UPDATE PAGAMENTO SET SIT_CHEQUE = '" + pagamento.getSitCheque() + "' "
                + "WHERE CD_PAGAMENTO = " + pagamento.getCdPagamento();
        conexao.atualizarSQL(slq);

        // se o cheque foi recebido grava a movimentação de caixa
        if (pagamento.getSitCheque().equals("R")) { 
            pagamento.getAgc().retornaAgenciaConta(pagamento.getAgc());
            MovCaixa mov = new MovCaixa();
            mov.getOperacao().setCdOperacao(pagamento.getParcelas().getContas().getVendaCompra().getOperacao().getCdOperacao());
            mov.setParcelas(pagamento.getParcelas());
            mov.setValorMov(pagamento.getParcelas().getVlPago());
            mov.setSaldoAnterior(pagamento.getAgc().getVlConta());
            mov.setDataMov(new RetornaData().retornaDataAtual());
            
            if (mov.getParcelas().getContas().getTpConta().equals("A PAGAR")){
                mov.setSaldoFinal(mov.getSaldoAnterior() - mov.getValorMov());
                mov.setObservacao(situacao);
            }
            else{
                mov.setSaldoFinal(mov.getSaldoAnterior() + mov.getValorMov());
            }
            
            // atualiza a conta
            mov.getAgc().setVlConta(mov.getSaldoFinal());
            mov.getAgc().atualizarValorConta(mov.getAgc());
            
            mov.setObservacao("PAGAMENTO DA CONTA "+mov.getParcelas().getContas().getCdConta()+
                " PARCELA "+mov.getParcelas().getNrParcela());
            
            // grava a movimentação de caixa
            mov.incluir(mov, true);
        }
        
        // se o cheque não foi validado altera a situação da parcela e da conta como não pagas novamente
        else{ 
            // altera a parcela
            String sql = "UPDATE PARCELAS SET VL_PAGO = '0.00' , DT_PAGO = " + null + " "
                + "WHERE CD_CONTA = " + pagamento.getParcelas().getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + pagamento.getParcelas().getNrParcela();
            conexao.atualizarSQL(sql);
            
            // altera a conta
            parcelas.getContas().setPago("N");
            parcelas.getContas().setDtPagamento("NULL");
            parcelas.getContas().alterar(parcelas.getContas());
        }   
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
    
    public ResultSet consultarPagamentosCheque() {
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, PAG.NR_PARCELA, P.VL_PARCELA, "
                + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                + "PAG.CD_AGENCIA_CONTA, AGC.DS_CONTA, B.NM_BANCO , PS.CD_PESSOA, PS.NOME, "
                + "CASE WHEN PAG.SIT_CHEQUE = 'R' THEN 'RECEBIDO' WHEN PAG.SIT_CHEQUE = 'A' THEN 'AGUARDANDO' "
                + "ELSE 'NÃO RECEBIDO' END AS CHEQUE "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON "
                + "PAG.CD_CONTA = P.CD_CONTA "
                + "AND PAG.NR_PARCELA = P.NR_PARCELA "
                + "INNER JOIN AGENCIA_CONTA AGC ON "
                + "PAG.CD_AGENCIA_CONTA = AGC.CD_AGENCIA_CONTA "
                + "INNER JOIN BANCO B ON AGC.CD_BANCO = B.CD_BANCO "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON "
                + "P.CD_CONTA = C.CD_CONTA "
                + "LEFT JOIN VENDA_COMPRA VC ON "
                + "C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
                + "LEFT JOIN PESSOA PS ON "
                + "VC.CD_FORNECEDOR = PS.CD_PESSOA OR "
                + "VC.CD_CLIENTE = PS.CD_PESSOA "
                + "WHERE PAG.CD_TIPO = 2 AND PAG.SITUACAO = 'A'";
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

    public String getSitCheque() {
        return sitCheque;
    }

    public void setSitCheque(String sitCheque) {
        this.sitCheque = sitCheque;
    }
    
    
}
