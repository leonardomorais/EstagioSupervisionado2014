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
    private String situacao;
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

        String sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, DT_VENCIMENTO, VL_PAGO, DT_PAGO, SITUACAO) "
                + "VALUES ('" + parcelas.getContas().getCdConta() + "','" + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','"
                + parcelas.getDtVencimento() + "','" + parcelas.getVlPago() + "', " + null + ",'A')";
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
                    + "DT_VENCIMENTO, VL_PAGO, DT_PAGO, SITUACAO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
                    + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
                    + parcelas.getVlPago() + "', " + null + ",'A')";
            conexao.incluirSQL(sql);
            dias = dias + intervalo;
        }
    }

//    public void gerarParcelas(Parcelas parcelas) {
//        parcelas.getContas().getForma().retornaForma(parcelas.getContas().getForma());
//
//        double total = parcelas.getContas().getVlConta();
//        int quantidade = parcelas.getContas().getForma().getQtParcelas();
//        int intervalo = parcelas.getContas().getForma().getIntervalo();
//
//        double parcela = (total / quantidade);
//        int parcelainteiro = (int) parcela;
//        int parteinteiro = ((int) parcela * quantidade);
//        double diferenca = (total - parteinteiro);
//
//        parcelas.setVlParcela((double) parcelainteiro);
//
//        parcelas.setDtVencimento(data.retornaSomaData("", intervalo));
//        int dias = intervalo;
//        String sql;
//
//        for (int nr = 1; nr <= quantidade; nr++) {
//            parcelas.setNrParcela(nr);
//
//            if (parcelas.getContas().getForma().getEntrada().equals("SIM")) {
//
//                if (nr == 1) {
//                    parcelas.setDtVencimento(data.retornaDataAtual());
//                    parcelas.setDtPago(parcelas.getDtVencimento());
//                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);
//                    parcelas.setVlPago(parcelas.getVlParcela());
//
//                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
//                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
//                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
//                            + parcelas.getVlPago() + "','" + parcelas.getDtPago() + "')";
//                } else {
//                    parcelas.setDtVencimento(data.retornaSomaData("", dias));
//                    parcelas.setVlPago(0.0);
//                    parcelas.setVlParcela((double) parcelainteiro);
//
//                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
//                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
//                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
//                            + parcelas.getVlPago() + "', " + null + ")";
//                }
//            } else {
//                parcelas.setDtVencimento(data.retornaSomaData("", dias));
//                parcelas.setVlPago(0.0);
//                parcelas.setVlParcela((double) parcelainteiro);
//
//                sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
//                        + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
//                        + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
//                        + parcelas.getVlPago() + "', " + null + ")";
//
//                if (nr == 1) {
//                    parcelas.setVlParcela(parcelas.getVlParcela() + diferenca);
//
//                    sql = "INSERT INTO PARCELAS (CD_CONTA, NR_PARCELA, VL_PARCELA, "
//                            + "DT_VENCIMENTO, VL_PAGO, DT_PAGO) VALUES ('" + parcelas.getContas().getCdConta() + "','"
//                            + parcelas.getNrParcela() + "','" + parcelas.getVlParcela() + "','" + parcelas.getDtVencimento() + "','"
//                            + parcelas.getVlPago() + "'," + null + ")";
//                }
//            }
//
//            conexao.incluirSQL(sql);
//
//            dias = dias + intervalo;
//        }
//        conexao.atualizarSQL("UPDATE CONTAS_PAGAR_RECEBER SET DT_VENCIMENTO = '" + parcelas.getDtVencimento() + "' "
//                + "WHERE CD_CONTA = " + parcelas.getContas().getCdConta());
//    }
    public void alterar(Parcelas parcelas) {
        String sql = "UPDATE PARCELAS SET VL_PARCELA = '" + parcelas.getVlParcela() + "', "
                + "DT_VENCIMENTO = '" + parcelas.getDtVencimento() + "' "
                + "WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela();
        conexao.atualizarSQL(sql);
    }

    public void excluir(Parcelas parcelas) {
        //try {
            String sql = "UPDATE PARCELAS SET SITUACAO = 'I' WHERE CD_CONTA = " + parcelas.getContas().getCdConta()
                    + " AND NR_PARCELA = " + parcelas.getNrParcela();
            conexao.atualizarSQL(sql);
            ajustaParcelas(parcelas);    
        //} 
        //catch (Exception ex) {
          //  JOptionPane.showMessageDialog(null, "Esta parcela não pode ser excluída!");
        //}
    }

    public void excluirTodas(Parcelas parcelas) {
        String sql = "DELETE FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta();
        //String sql = "UPDATE PARCELAS SET SITUACAO = 'I' WHERE C_CONTA = "+parcelas.getContas().getCdConta();
        conexao.atualizarSQL(sql);
    }

    public void pagarParcela(Parcelas parcelas) {
        String sql = "UPDATE PARCELAS SET VL_PAGO = '" + parcelas.getVlPago() + "', "
                + "DT_PAGO = '" + parcelas.getDtPago() + "' WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " "
                + "AND NR_PARCELA = " + parcelas.getNrParcela();
        conexao.atualizarSQL(sql);
        if (verificaParcelasPagas(parcelas)) {
            parcelas.getContas().setDtPagamento(parcelas.getDtPago());
            parcelas.getContas().pagarConta(parcelas.getContas());
        }
    }

    public void estornarParcela(Parcelas parcelas) {
        //parcelas.getContas().retornaConta(parcelas.getContas(), true);
        if (verificaParcelasPagas(parcelas)) {
            // se a conta possuir todas as parcelas pagas a situação da conta deve ser alterada

            parcelas.getContas().setPago("N");
            parcelas.getContas().setDtPagamento("NULL");
            parcelas.getContas().alterar(parcelas.getContas());
        }

        // atualiza a parcela
        String sql = "UPDATE PARCELAS SET VL_PAGO = '0.00' , DT_PAGO = " + null + " "
                + "WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela();
        conexao.atualizarSQL(sql);

        // remove o pagamento da parcela e a conta
        Pagamento pag = new Pagamento();
        pag.setParcelas(parcelas);
        pag.alterar(pag);

        RetornaData data = new RetornaData();
        MovCaixa mov = new MovCaixa();
        mov.setParcelas(parcelas);
        mov.retornaMov(mov);

        // retorna a agencia Conta e o valor que foi movimentado
        mov.getAgc().retornaAgenciaConta(mov.getAgc());
        mov.setSaldoAnterior(mov.getAgc().getVlConta());

        if (parcelas.getContas().getTpConta().equals("A PAGAR")) {
            mov.setSaldoFinal(mov.getSaldoAnterior() + mov.getValorMov());
            mov.getOperacao().setCdOperacao(9); // operação de extorno de parcela ENTRADA
        } else {
            mov.setSaldoFinal(mov.getSaldoAnterior() - mov.getValorMov());
            mov.getOperacao().setCdOperacao(10); // operação de extorno de parcela SAÍDA
        }

        // atualiza a agencia Conta
        mov.getAgc().setVlConta(mov.getSaldoFinal());
        mov.getAgc().atualizarValorConta(mov.getAgc());

        mov.setDataMov(data.retornaDataAtual());
        mov.setObservacao("EXTORNO CONTA " + mov.getParcelas().getContas().getCdConta()
                + " PARCELA " + mov.getParcelas().getNrParcela());
        // grava uma nova movimentação para o extorno da parcela
        mov.incluir(mov, true);
    }
    
    public void ajustaParcelas(Parcelas parcelas){
        double valor = parcelas.getVlParcela();
        String data = parcelas.getDtVencimento(); // data da primeira parcela
        
        ResultSet retorno = consultarCdConta(parcelas.getContas(),true);
            int quantidade = 0;
        try {
            while (retorno.next()){ // conta as parcelas ainda não pagas
                parcelas.setVlPago(retorno.getDouble("VL_PAGO"));
                if (parcelas.getVlPago() == 0){
                    quantidade = quantidade + 1;
                }
            }
        } 
        catch (SQLException ex) {
            //Logger.getLogger(Parcelas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            valor = (double) valor/quantidade;
            
            parcelas.getContas().retornaConta(parcelas.getContas(), true);
            parcelas.getContas().getForma().retornaForma(parcelas.getContas().getForma());
            int dias = 0; //parcelas.getContas().getForma().getIntervalo();
            
            RetornaData rdata = new RetornaData();
            retorno = parcelas.consultarCdConta(parcelas.getContas(),true);
            int count = 0;
        try {
            while (retorno.next()){
                count = count + 1;
                parcelas.setVlPago(retorno.getDouble("VL_PAGO"));
                parcelas.setNrParcela(retorno.getInt("NR_PARCELA"));
                parcelas.setVlParcela(retorno.getDouble("VL_PARCELA"));
                
                if (parcelas.getVlPago() == 0.00){
                    // divide o valor entre as parcelas não pagas
                    parcelas.setVlParcela(parcelas.getVlParcela() + valor);
                    
                    if (count == 1){
                        parcelas.setDtVencimento(data);
                    }
                    else{
                        parcelas.setDtVencimento(rdata.retornaSomaData(data, dias));
                    }
                    
                    // altera a parcela
                    parcelas.alterar(parcelas);
                }
                dias = dias + parcelas.getContas().getForma().getIntervalo();
            }
        } 
        catch (SQLException ex) {
            //Logger.getLogger(Parcelas.class.getName()).log(Level.SEVERE, null, ex);
        }
            // atualiza a data de vencimento da conta
            parcelas.getContas().setDtVencimento(retornaDataUltimaParcela(parcelas));
            if (parcelas.getContas().getTpConta().equals("A RECEBER")){
                parcelas.getContas().setTpConta("R");
            }
            else{
                parcelas.getContas().setTpConta("P");
            }
            parcelas.getContas().setDtPagamento("");
            parcelas.getContas().alterar(parcelas.getContas());
    }

    public ResultSet consutarGeral() {
        String sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO FROM PARCELAS;";
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarCdConta(Contas contas, boolean ativas) {
        String sql;
        if (ativas){
            sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + contas.getCdConta() + ""
                + "AND SITUACAO = 'A' ORDER BY NR_PARCELA";
        }
        else{
            sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + contas.getCdConta() + " ORDER BY NR_PARCELA";
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public ResultSet consultarNrParcela(Parcelas parcelas, boolean ativas) {
        String sql;
        if (ativas){
            // retorna apenas as ativas
            sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela()+" AND SITUACAO = 'A'"; 
        }
        else{
            sql = "SELECT CD_CONTA, NR_PARCELA, VL_PARCELA, TO_CHAR(DT_VENCIMENTO, 'DD/MM/YYYY') AS DT_VENC, "
                + "VL_PAGO, TO_CHAR(DT_PAGO, 'DD/MM/YYYY') AS DT_PAGO "
                + "FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta() + " AND "
                + "NR_PARCELA = " + parcelas.getNrParcela();
        }
        conexao.executeSQL(sql);
        return conexao.resultset;
    }

    public void retornaParcela(Parcelas parcelas, boolean ativas) {
        ResultSet retorno = consultarNrParcela(parcelas, ativas);
        try {
            retorno.first();
            parcelas.setNrParcela(retorno.getInt("NR_PARCELA"));
            parcelas.setVlParcela(retorno.getDouble("VL_PARCELA"));
            parcelas.setDtVencimento(retorno.getString("DT_VENC"));
            parcelas.setVlPago(retorno.getDouble("VL_PAGO"));
            parcelas.setDtPago(retorno.getString("DT_PAGO"));
        } 
        catch (SQLException ex) {
            parcelas.setNrParcela(0);
            JOptionPane.showMessageDialog(null, "Parcela não encontrada!");
        }
    }

    public String retornaDataUltimaParcela(Parcelas parcelas) {
        String dataUltima;
        String sql = "SELECT TO_CHAR((MAX(DT_VENCIMENTO)),'DD/MM/YYYY') AS DT_VENC "
                + "FROM PARCELAS WHERE CD_CONTA = " + parcelas.getContas().getCdConta() +
                "AND SITUACAO = 'A'";
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
        ResultSet retorno = consultarCdConta(parcelas.getContas(),true);
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

//    public boolean permiteExclusao(Parcelas parcelas) {
//        String sql = "SELECT * FROM PARCELAS P INNER JOIN PAGAMENTO PAG "
//                + "ON P.CD_CONTA = PAG.CD_CONTA AND P.NR_PARCELA = PAG.NR_PARCELA "
//                + "WHERE P.CD_CONTA = "+parcelas.getContas().getCdConta()+" AND "
//                + "P.NR_PARCELA = "+parcelas.getNrParcela()+" AND P.SITUACAO = 'A'";
//        conexao.executeSQL(sql);
//        try{
//            conexao.resultset.first();
//            int cd = conexao.resultset.getInt("CD_CONTA");
//            return false; // a parcela possui um pagamento
//        }
//        catch(SQLException ex){
//            // a parcela não está em um pagamento , verifica se possui mov caixa
//            sql = "SELECT * FROM PARCELAS P INNER JOIN MOV_CAIXA MOV "
//                + "ON P.CD_CONTA = MOV.CD_CONTA AND P.NR_PARCELA = MOV.NR_PARCELA "
//                + "WHERE P.CD_CONTA = "+parcelas.getContas().getCdConta()+" AND "
//                + "P.NR_PARCELA = "+parcelas.getNrParcela();
//            conexao.executeSQL(sql);
//            try{
//                conexao.resultset.first();
//                int cd = conexao.resultset.getInt("CD_CONTA");
//                return false; // a parcela é refenciada na tabela mov_caixa
//            }
//            catch(SQLException e){
//                return true; // a parcela não possui pagamento e nem mov_caixa
//            }
//        }
//    }

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
