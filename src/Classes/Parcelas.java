
package Classes;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.RetornaData;
import Validacoes.RetornaSequencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    RetornaData data = new RetornaData();

    public void gerarParcela(Parcelas parcelas) {
        parcelas.getContas().getForma().retornaForma(parcelas.getContas().getForma());
        int intervalo = parcelas.getContas().getForma().getIntervalo();

        parcelas.setDtVencimento(data.retornaSomaData(retornaDataUltimaParcela(parcelas), intervalo));
        parcelas.setVlPago(0.00);
        RetornaSequencia seq = new RetornaSequencia();
        parcelas.setNrParcela(seq.retornaSequencia("NR_PARCELA", "PARCELAS", "CD_CONTA", parcelas.getContas().getCdConta()));

        String sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, DT_VENCIMENTO, VL_PAGO, DT_PAGO) "
                + "VALUES ('" + parcelas.getContas().getCdConta() + "','" + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','"
                + parcelas.getDtVencimento() + "','" + parcelas.getVlPago() + "', " + null + ")";
        conexao.incluirSQL(sql);
    }

    public void geraParcelas(Parcelas parcelas) {
        parcelas.getContas().getForma().retornaForma(parcelas.getContas().getForma());

        double total = parcelas.getContas().getVlConta();
        int quantidade = parcelas.getContas().getForma().getQtParcelas();
        int intervalo = parcelas.getContas().getForma().getIntervalo();

        double parcela = (total / quantidade);
        int parcelainteiro = (int) parcela;
        int parteinteiro = ((int) parcela * quantidade);
        double diferenca = (total - parteinteiro);

        parcelas.setVlParcela((double) parcelainteiro);
        parcelas.setVlPago(0.00);
        parcelas.setDtVencimento(data.retornaSomaData("", intervalo));
        int dias = intervalo;

        for (int nr = 1; nr <= quantidade; nr++) {
            parcelas.setNrParcela(nr);
            if (parcelas.getContas().getForma().getEntrada().equals("SIM")) {

                if (nr == 1) {
                    parcelas.setDtVencimento(data.retornaDataAtual());
                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);
                } else {
                    parcelas.setDtVencimento(data.retornaSomaData("", dias));
                    parcelas.setVlParcela((double) parcelainteiro);
                }
            } else {
                parcelas.setDtVencimento(data.retornaSomaData("", dias));
                parcelas.setVlParcela((double) parcelainteiro);

                if (nr == 1) {
                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);
                }
            }
            String sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
                    + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                    + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                    + parcelas.getVlPago() + "', " + null + ")";
            conexao.incluirSQL(sql);
            dias = dias + intervalo;
        }
    }

    public void gerarParcelas(Parcelas parcelas) {
        parcelas.getContas().getForma().retornaForma(parcelas.getContas().getForma());

        double total = parcelas.getContas().getVlConta();
        int quantidade = parcelas.getContas().getForma().getQtParcelas();
        int intervalo = parcelas.getContas().getForma().getIntervalo();

        double parcela = (total / quantidade);
        int parcelainteiro = (int) parcela;
        int parteinteiro = ((int) parcela * quantidade);
        double diferenca = (total - parteinteiro);

        parcelas.setVlParcela((double) parcelainteiro);

        parcelas.setDtVencimento(data.retornaSomaData("", intervalo));
        int dias = intervalo;
        String sql;

        for (int nr = 1; nr <= quantidade; nr++) {
            parcelas.setNrParcela(nr);

            if (parcelas.getContas().getForma().getEntrada().equals("SIM")) {

                if (nr == 1) {
                    parcelas.setDtVencimento(data.retornaDataAtual());
                    parcelas.setDtPago(parcelas.getDtVencimento());
                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);
                    parcelas.setVlPago(parcelas.getVlParcela());

                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                            + parcelas.getVlPago() + "','" + parcelas.getDtPago() + "')";
                } else {
                    parcelas.setDtVencimento(data.retornaSomaData("", dias));
                    parcelas.setVlPago(0.0);
                    parcelas.setVlParcela((double) parcelainteiro);

                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                            + parcelas.getVlPago() + "', " + null + ")";
                }
            } else {
                parcelas.setDtVencimento(data.retornaSomaData("", dias));
                parcelas.setVlPago(0.0);
                parcelas.setVlParcela((double) parcelainteiro);

                sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
                        + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                        + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                        + parcelas.getVlPago() + "', " + null + ")";

                if (nr == 1) {
                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);

                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                            + parcelas.getVlPago() + "'," + null + ")";
                }
            }

            conexao.incluirSQL(sql);

            dias = dias + intervalo;
        }
        conexao.atualizarSQL("UPDATE CONTAS_PAGAR_RECEBER SET DT_VENCIMENTO = '" + parcelas.getDtVencimento() + "' "
                + "WHERE CD_CONTA = " + parcelas.getContas().getCdConta());
    }

    public void alterar(Parcelas parcelas) {
        String sql = "UPDATE PARCELAS SET VL_PARCELA = '" + parcelas.getVlParcela() + "', "
                + "DT_VENCIMENTO = '" + parcelas.getDtVencimento() + "' "
                + "WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela();
        conexao.atualizarSQL(sql);
    }

    public void pagarParcela(Parcelas parcelas) {
        String sql = "UPDATE PARCELAS SET VL_PAGO = '" + parcelas.getVlPago() + "', "
                + "DT_PAGO = '" + parcelas.getDtPago() + "' WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " "
                + "AND NR_PARCELA = " + parcelas.getNrParcela();
        conexao.atualizarSQL(sql);
        if (verificaParcelasPagas(parcelas)) {
            parcelas.getContas().pagarConta(parcelas.getContas());
        }
    }

    public ResultSet consutarGeral() {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO FROM PARCELAS;";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Contas contas) {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + contas.getCdConta() + " ORDER BY NR_PARCELA";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNrParcela(Parcelas parcelas) {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela() + " AND VL_PAGO < 1";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaParcela(Parcelas parcelas) {
        ResultSet retorno = consultarNrParcela(parcelas);
        try {
            retorno.first();
            parcelas.setNrParcela(retorno.getInt("NR_PARCELA"));
            parcelas.setVlParcela(retorno.getDouble("VL_PARCELA"));
            parcelas.setDtVencimento(retorno.getString("DT_VENC"));
            parcelas.setVlPago(retorno.getDouble("VL_PAGO"));
            parcelas.setDtPago(retorno.getString("DT_PAGO"));
        } catch (SQLException ex) {
            parcelas.setNrParcela(0);
            JOptionPane.showMessageDialog(null, "Parcela não encontrada!");
        }
    }

    public String retornaDataUltimaParcela(Parcelas parcelas) {
        String dataUltima;
        String sql = "SELECT (MAX(TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY'))) AS DT_VENC"
                + "FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta();
        conexao.executeSQL(sql);
        try {
            conexao.resultset.first();
            dataUltima = conexao.resultset.getString("DT_VENC");
        } catch (SQLException ex) {
            dataUltima = "";
        }
        return dataUltima;
    }

    public boolean verificaParcelasPagas(Parcelas parcelas) {
        boolean todasPagas = true;
        ResultSet retorno = consultarCdConta(parcelas.getContas());
        String dataPago;

        try {
            while (retorno.next()) {
                try {
                    dataPago = retorno.getString("DT_PAGO");
                    if (dataPago.equals("")) {
                        todasPagas = false;
                    }
                } catch (NullPointerException ex) {
                    todasPagas = false;
                }
            }
        } catch (SQLException ex) {
        }
        return todasPagas;
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
