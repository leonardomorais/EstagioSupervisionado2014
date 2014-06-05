/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Parcelas {

    private Integer nrParcela;
    private Double vlParcela;
    private String dtVencimento;
    private Double vlPago;
    private String dtPago;
        
    private Contas contas = new Contas();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public ResultSet consutarGeral() {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY'), "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') FROM PARCELAS;";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Contas contas) {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY'), "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') FROM PARCELAS WHERE CD_CONTA = " + contas.getCdConta();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // getter  e setter
    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    public Integer getNrParcela() {
        return nrParcela;
    }

    public void setNrParcela(Integer nrParcela) {
        this.nrParcela = nrParcela;
    }

    public Double getVlParcela() {
        return vlParcela;
    }

    public void setVlParcela(Double vlParcela) {
        this.vlParcela = vlParcela;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Double getVlPago() {
        return vlPago;
    }

    public void setVlPago(Double vlPago) {
        this.vlPago = vlPago;
    }

    public String getDtPago() {
        return dtPago;
    }

    public void setDtPago(String dtPago) {
        this.dtPago = dtPago;
    }
    
}
