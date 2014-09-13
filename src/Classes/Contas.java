package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaData;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class Contas {

    private static Integer cdConta;
    //private Integer cdVendaCompra;
    private static String dsConta;
    private static String tpConta;
    private static Double vlConta;
    private String dtVencimento;
    private String dtPagamento;
    private String pago;
    private FormaPagamento forma = new FormaPagamento();
    private VendaCompra vendaCompra = new VendaCompra();

    private Map<Integer, Integer> contas = new HashMap<Integer, Integer>();

    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void incluir(Contas contas, boolean venda) {
        String sql;
        contas.getForma().retornaForma(contas.getForma());
        int dias;
        if (contas.getForma().getIntervalo() == 0) {
            dias = 0;
        } else {
            dias = contas.getForma().getIntervalo() * contas.getForma().getQtParcelas();
        }
        RetornaData data = new RetornaData();
        contas.setDtVencimento(data.retornaSomaData("", dias));

        RetornaSequencia seq = new RetornaSequencia();
        contas.setCdConta(seq.retornaSequencia("CD_CONTA", "CONTAS_PAGAR_RECEBER"));

        if (venda) {
            sql = "INSERT INTO CONTAS_PAGAR_RECEBER (CD_CONTA, CD_VENDA_COMPRA, "
                    + "CD_FORMA, DS_CONTA, TIPO_CONTA, VL_CONTA, DT_VENCIMENTO, "
                    + "DT_PAGAMENTO, PAGO) VALUES ('" + contas.getCdConta() + "','"
                    + contas.getVendaCompra().getCdVendaCompra() + "','" + contas.getForma().getCdForma() + "','"
                    + contas.getDsConta() + "','" + contas.getTpConta() + "','"
                    + contas.getVlConta() + "','" + contas.getDtVencimento() + "'," + null
                    + ",'" + contas.getPago() + "')";
        } else {
            sql = "INSERT INTO CONTAS_PAGAR_RECEBER (CD_CONTA, CD_FORMA, DS_CONTA, "
                    + "TIPO_CONTA, VL_CONTA, DT_VENCIMENTO, DT_PAGAMENTO, PAGO) "
                    + "VALUES ('" + contas.getCdConta() + "','" + contas.getForma().getCdForma() + "','"
                    + contas.getDsConta() + "','" + contas.getTpConta() + "','" + contas.getVlConta() + "','"
                    + contas.getDtVencimento() + "'," + null + ",'"
                    + contas.getPago() + "')";
        }
        conexao.incluirSQL(sql);
        Parcelas p = new Parcelas();
        p.setContas(contas);
        p.geraParcelas(p);
//        p.gerarParcelas(p);
    }

    public void alterar(Contas contas) {
        String sql;
        switch (contas.getDtPagamento()){
            case "":
                sql = "UPDATE CONTAS_PAGAR_RECEBER SET CD_FORMA = '" + contas.getForma().getCdForma() + "', "
                    + "DS_CONTA = '" + contas.getDsConta() + "', TIPO_CONTA = '" + contas.getTpConta() + "', "
                    + "VL_CONTA = '" + contas.getVlConta() + "', DT_VENCIMENTO = '" + contas.getDtVencimento() + "' "
                    + "WHERE CD_CONTA = " + contas.getCdConta();
            break;
                
            case "NULL":
                sql = "UPDATE CONTAS_PAGAR_RECEBER SET DT_PAGAMENTO = "+null+", PAGO = 'N' "
                    + "WHERE CD_CONTA = "+contas.getCdConta();
            break;
            
            default:
                sql = "UPDATE CONTAS_PAGAR_RECEBER SET CD_FORMA = '" + contas.getCdConta() + "', "
                    + "DS_CONTA = '" + contas.getDsConta() + "', TIPO_CONTA = '" + contas.getTpConta() + "', "
                    + "VL_CONTA = '" + contas.getVlConta() + "', DT_VENCIMENTO = '" + contas.getDtVencimento() + "', "
                    + "DT_PAGAMENTO = '" + contas.getDtPagamento() + "', PAGO = '" + contas.getPago() + "' "
                    + "WHERE CD_CONTA = " + contas.getCdConta();
        }
        conexao.atualizarSQL(sql);
    }
    
    public void excluir(Contas contas){
        Parcelas p = new Parcelas();
        p.setContas(contas);
        p.excluirTodas(p);
        String sql = "DELETE FROM CONTAS_PAGAR_RECEBER WHERE CD_CONTA = "+contas.getCdConta();
        conexao.deleteSQL(sql);
    }

    public void pagarConta(Contas contas) {
        String sql = "UPDATE CONTAS_PAGAR_RECEBER SET PAGO = 'S', "
                + "DT_PAGAMENTO = '" + contas.getDtPagamento() + "' WHERE CD_CONTA = " + contas.getCdConta();
        conexao.atualizarSQL(sql);
    }

    public ResultSet consultarGeral(boolean todas) {
        String sql;
        if (todas) {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA ORDER BY C.CD_CONTA";
        } else {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.PAGO = 'N' "
                    + "ORDER BY C.CD_CONTA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Contas contas, boolean todas) {
        String sql;
        if (todas) {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.CD_CONTA = " + contas.getCdConta();
        } else {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.CD_CONTA = " + contas.getCdConta() + " AND "
                    + "C.PAGO = 'N' ";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    // método usado na tela de pagamento
    public ResultSet consultarCdConta(Contas contas) {
        String sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_VENDA_COMPRA, C.CD_FORMA, F.DS_FORMA, "
                + "C.VL_CONTA, TO_CHAR(C.DT_VENCIMENTO,'DD/MM/YYYY') AS DT_VENC, "
                + "TO_CHAR(C.DT_PAGAMENTO,'DD/MM/YYYY') AS DT_PGTO, "
                + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F "
                + "ON C.CD_FORMA = F.CD_FORMA "
                + "LEFT JOIN VENDA_COMPRA VC ON C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
                + "WHERE C.CD_CONTA = " + contas.getCdConta();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarDescricao(Contas contas, boolean todas) {
        String sql;
        if (todas) {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.DS_CONTA LIKE '%" + contas.getDsConta() + "%' "
                    + "ORDER BY C.CD_CONTA";
        } else {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.DS_CONTA LIKE '%" + contas.getDsConta() + "%' "
                    + "AND C.PAGO = 'N' ORDER BY C.CD_CONTA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarTipo(Contas contas, boolean todas) {
        String sql;
        if (todas) {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.TIPO_CONTA = '" + contas.getTpConta() + "' "
                    + "ORDER BY C.CD_CONTA";
        } else {
            sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                    + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                    + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                    + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                    + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                    + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                    + "C.CD_FORMA = F.CD_FORMA WHERE C.TIPO_CONTA = '" + contas.getTpConta() + "' "
                    + "AND C.PAGO = 'N' ORDER BY C.CD_CONTA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarSituacao(Contas contas) {
        String sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_FORMA, F.DS_FORMA, C.VL_CONTA, "
                + "TO_CHAR(C.DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "TO_CHAR(C.DT_PAGAMENTO, 'DD/MM/YYYY') AS DT_PGTO, "
                + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F ON "
                + "C.CD_FORMA = F.CD_FORMA WHERE C.PAGO = '" + contas.getPago() + "' "
                + "ORDER BY C.CD_CONTA";
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
                + "WHERE C.CD_VENDA_COMPRA = " + contas.getVendaCompra().getCdVendaCompra();
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdPessoa(Contas contas) {
        String sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_VENDA_COMPRA, "
                + "C.CD_FORMA, F.DS_FORMA, "
                + "C.VL_CONTA, TO_CHAR(C.DT_VENCIMENTO,'DD/MM/YYYY') AS DT_VENC, "
                + "TO_CHAR(C.DT_PAGAMENTO,'DD/MM/YYYY') AS DT_PGTO, "
                + "CASE WHEN C.TIPO_CONTA = 'P' THEN 'A PAGAR' ELSE 'A RECEBER' END AS TIPO, "
                + "CASE WHEN C.PAGO = 'S' THEN 'PAGA' ELSE 'NÃO PAGA' END AS SIT "
                + "FROM CONTAS_PAGAR_RECEBER C INNER JOIN FORMA_PGTO F "
                + "ON C.CD_FORMA = F.CD_FORMA "
                + "LEFT JOIN VENDA_COMPRA VC ON C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
                + "WHERE VC.CD_FORNECEDOR = " + contas.getVendaCompra().getFornecedor().getCdFornecedor() + " "
                + "OR VC.CD_CLIENTE = " + contas.getVendaCompra().getCliente().getCdCliente() + " "
                + "ORDER BY C.CD_CONTA ";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaConta(Contas contas, boolean todas) {
        ResultSet retorno = consultarCdConta(contas, todas);

        try {
            retorno.first();
            contas.setDsConta(retorno.getString("DS_CONTA"));
            contas.getForma().setCdForma(retorno.getInt("CD_FORMA"));
            contas.getForma().setDsForma(retorno.getString("DS_FORMA"));
            contas.setVlConta(retorno.getDouble("VL_CONTA"));
            contas.setDtVencimento(retorno.getString("DT_VENC"));
            contas.setDtPagamento(retorno.getString("DT_PGTO"));
            contas.setTpConta(retorno.getString("TIPO"));
            contas.setPago(retorno.getString("SIT"));
        } catch (SQLException ex) {
            contas.setDsConta("");
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
    }

    public int retornaOperacaoVendaCompra(Contas contas) {
        int cd;
        String sql = "SELECT C.CD_CONTA, C.DS_CONTA, C.CD_VENDA_COMPRA, VC.CD_OPERACAO, O.DS_OPERACAO "
                + "FROM CONTAS_PAGAR_RECEBER C "
                + "INNER JOIN VENDA_COMPRA VC "
                + "ON C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
                + "INNER JOIN OPERACAO O "
                + "ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "WHERE C.CD_VENDA_COMPRA IS NOT NULL "
                + "AND C.CD_CONTA = " + contas.getCdConta();
        conexao.executeSQL(sql);
        try {
            conexao.resultset.first();
            cd = conexao.resultset.getInt("CD_OPERACAO");
            contas.getVendaCompra().setCdVendaCompra(conexao.resultset.getInt("CD_VENDA_COMPRA"));
        } catch (SQLException ex) {
            cd = 0;
        }
        return cd;
    }
    
    public boolean permiteExclusao(Contas contas){
        boolean permitido = true;
        ResultSet retorno = consultarCdConta(contas, false); // irá pesquisar as contas ainda não pagas
        try{
            retorno.first();
            Parcelas p = new Parcelas();
            
            ResultSet parcelas = p.consultarCdConta(contas);
            while (parcelas.next()){
                p.setVlPago(parcelas.getDouble("VL_PAGO"));
                if (p.getVlPago() > 0){
                    permitido = false;
                }
            }
        }
        catch(SQLException ex){
            permitido = false;
        }
        return permitido;
    }

    // getter e setter
    public Integer getCdConta() {
        return cdConta;
    }

    public void setCdConta(Integer cdConta) {
        this.cdConta = cdConta;
    }

//    public Integer getCdVendaCompra() {
//        return cdVendaCompra;
//    }
//
//    public void setCdVendaCompra(Integer cdVendaCompra) {
//        this.cdVendaCompra = cdVendaCompra;
//    }
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

    public int getConta(int pos) {
        return contas.get(pos);
    }

    public Map<Integer, Integer> getContas() {
        return contas;
    }

    public void setContas(Map<Integer, Integer> contas) {
        this.contas = contas;
    }

    public VendaCompra getVendaCompra() {
        return vendaCompra;
    }

    public void setVendaCompra(VendaCompra vendaCompra) {
        this.vendaCompra = vendaCompra;
    }

}
