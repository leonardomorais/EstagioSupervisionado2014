package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class Pagamento {

    private Integer cdPagamento;

    private AgenciaConta agc = new AgenciaConta();
    private Parcelas parcelas = new Parcelas();
    private TipoPagamento tipo = new TipoPagamento();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Pagamento pagamento) {
        RetornaSequencia seq = new RetornaSequencia();
        pagamento.setCdPagamento(seq.retornaSequencia("CD_PAGAMENTO", "PAGAMENTO"));
        String sql = "INSERT INTO PAGAMENTO (CD_PAGAMENTO, NR_PARCELA, CD_CONTA, CD_TIPO, "
                + "CD_AGENCIA_CONTA) VALUES ('" + pagamento.getCdPagamento() + "','"
                + pagamento.getParcelas().getNrParcela() + "','"
                + pagamento.getParcelas().getContas().getCdConta() + "','"
                + pagamento.getTipo().getCdTipo() + "','"
                + pagamento.getAgc().getCdAgcConta() + "')";
        conexao.incluirSQL(sql);
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, PAG.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "ORDER BY PAG.CD_PAGAMENTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdPagamento(Pagamento pagamento) {
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE PAG.CD_PAGAMENTO = " + pagamento.getCdPagamento();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Pagamento pagamento) {
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE PAG.CD_CONTA = " + pagamento.getParcelas().getContas().getCdConta() + " "
                + "ORDER BY PAG.CD_PAGAMENTO ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDsConta(Pagamento pagamento) {
        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, C.DS_CONTA, P.NR_PARCELA, P.VL_PAGO, "
                + "A.CD_AGENCIA_CONTA , A.DS_CONTA "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P ON PAG.NR_PARCELA = P.NR_PARCELA "
                + "AND PAG.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C ON C.CD_CONTA = P.CD_CONTA "
                + "INNER JOIN AGENCIA_CONTA A ON A.CD_AGENCIA_CONTA = PAG.CD_AGENCIA_CONTA "
                + "WHERE C.DS_CONTA = " + pagamento.getParcelas().getContas().getDsConta() + " "
                + "ORDER BY PAG.CD_PAGAMENTO";
        conexao.executeSQL(sql);
        return conexao.resultset;
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

}
