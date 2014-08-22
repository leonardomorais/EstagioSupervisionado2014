package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaData;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class Contas {

    private Integer cdConta;
    private Integer cdVendaCompra;
    private String dsConta;
    private String tpConta;
    private Double vlConta;
    private String dtVencimento;
    private String dtPagamento;
    private String pago;
    private FormaPagamento forma = new FormaPagamento();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Contas contas, boolean venda) {
        String sql;
        contas.getForma().retornaForma(contas.getForma());
        int dias;
        if (contas.getForma().getIntervalo() == 0) {
            dias = 0;
        } else {
            dias = contas.getForma().getIntervalo() * contas.getForma().getQtParcelas();
            System.err.println("Dias "+dias);
        }
        RetornaData data = new RetornaData();
        contas.setDtVencimento(data.retornaSomaData("", dias));

        RetornaSequencia seq = new RetornaSequencia();
        contas.setCdConta(seq.retornaSequencia("CD_CONTA", "CONTAS_PAGAR_RECEBER"));

        if (venda) {
            sql = "INSERT INTO CONTAS_PAGAR_RECEBER (CD_CONTA, CD_VENDA_COMPRA, "
                    + "CD_FORMA, DS_CONTA, TIPO_CONTA, VL_CONTA, DT_VENCIMENTO, "
                    + "DT_PAGAMENTO, PAGO) VALUES ('" + contas.getCdConta() + "','"
                    + contas.getCdVendaCompra() + "','" + contas.getForma().getCdForma() + "','"
                    + contas.getDsConta() + "','" + contas.getTpConta() + "','"
                    + contas.getVlConta() + "','" + contas.getDtVencimento() + "'," + null
                    + ",'" + contas.getPago() + "')";
        } else {
            sql = "INSERT INTO CONTAS PAGAR_RECEBER (CD_CONTA, CD_FORMA, DS_CONTA, "
                    + "TIPO_CONTA, VL_CONTA, DT_VENCIMENTO, DT_PAGAMENTO, PAGO) "
                    + "VALUES ('" + contas.getCdConta() + "','" + contas.getForma().getCdForma() + "','"
                    + contas.getDsConta() + "','" + contas.getTpConta() + "','" + contas.getVlConta() + "','"
                    + contas.getDtVencimento() + "','" + contas.getDtPagamento() + "','"
                    + contas.getPago() + "')";
        }
        conexao.incluirSQL(sql);
    }

    public ResultSet consultarGeral() {
        String sql = "SELECT C.CD_CONTA, C.CD_VENDA, C.DS_CONTA, F.DS_FORMA, C.VL_CONTA, "
                + "  TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY'), TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY'), "
                + "  CASE WHEN C.TIPO_CONTA = 'C' THEN 'CRÉDITO' ELSE 'DÉBITO' END AS TIPO, "
                + "  CASE WHEN C.PAGO = 'S' THEN 'PAGO' ELSE 'A PAGAR' END AS SIT "
                + "  FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                + "  C.CD_FORMA = F.CD_FORMA ORDER BY C.CD_CONTA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdVendaCompra(Contas contas) {
        String sql = "SELECT C.CD_CONTA, C.CD_VENDA_COMPRA, F.DS_FORMA, "
                + "CASE WHEN C.TIPO_CONTA = 'R' THEN 'A RECEBER' ELSE "
                + "'A PAGAR' END AS TIPO, C.VL_CONTA, "
                + "TO_CHAR(C.DT_VENCIMENTO,'DD/MM/YYYY'), TO_CHAR(C.DT_PAGAMENTO,'DD/MM/YYYY'), "
                + "CASE WHEN C.PAGO = 'S' THEN 'PAGO' ELSE 'NÃO PAGO' END AS PAGO "
                + "FROM CONTAS_PAGAR_RECEBER C "
                + "INNER JOIN FORMA_PGTO F ON C.CD_FORMA = F.CD_FORMA "
                + "WHERE C.CD_VENDA_COMPRA = " + contas.getCdVendaCompra();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter e setter
    public Integer getCdConta() {
        return cdConta;
    }

    public void setCdConta(Integer cdConta) {
        this.cdConta = cdConta;
    }

    public Integer getCdVendaCompra() {
        return cdVendaCompra;
    }

    public void setCdVendaCompra(Integer cdVendaCompra) {
        this.cdVendaCompra = cdVendaCompra;
    }

    public String getDsConta() {
        return dsConta;
    }

    public void setDsConta(String dsConta) {
        this.dsConta = dsConta;
    }

    public String getTpConta() {
        return tpConta;
    }

    public void setTpConta(String tpConta) {
        this.tpConta = tpConta;
    }

    public Double getVlConta() {
        return vlConta;
    }

    public void setVlConta(Double vlConta) {
        this.vlConta = vlConta;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(String dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }

}
