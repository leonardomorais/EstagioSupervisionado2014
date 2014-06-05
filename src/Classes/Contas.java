package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class Contas {
    
    private Integer cdConta;
    private String dsConta;
    private String tpConta;
    private Double vlConta;
    private String dtVencimento;
    private String dtPagamento;
    private String pago;
    
    

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

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

    
    // getter e setter

    public Integer getCdConta() {
        return cdConta;
    }

    public void setCdConta(Integer cdConta) {
        this.cdConta = cdConta;
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
    
    
}
