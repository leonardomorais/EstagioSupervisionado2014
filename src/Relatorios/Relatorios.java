package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.MostrarDialogo;
import java.sql.ResultSet;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Leonardo
 */
public class Relatorios {

    private String tabela;
    private ResultSet consulta;
    private boolean subreport;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void gerarRelatorio(Relatorios r) {

        HashMap parametro = new HashMap();

        try {
            conexao.conecta();

            if (r.isSubreport()) {
                parametro.put("SUBREPORT_DIR", "relatorios\\");
                parametro.put("REPORT_CONNECTION", conexao.conecta());
            }
            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());

            String report = "relatorios\\" + r.getTabela() + ".jasper";

            JasperPrint print = JasperFillManager.fillReport(report, parametro, jrRs);

            //viewReport(JasperPrint jasperPrint, boolean isExitOnClose) 
            JasperViewer relatorio = new JasperViewer(print, false);
            relatorio.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            relatorio.setVisible(true);
            
             //JasperViewer.viewReport(print, false);

            // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
        } catch (JRException ex) {
            System.err.println("Erro ao gerar Relatório!");
        }
    }

//    public void gerarRelatorio(Relatorios r, HashMap params) {
//        try {
//            conexao.conecta();
//            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());
//
//            String report = "relatorios\\" + r.getTabela() + ".jasper";
//
//            JasperPrint print = JasperFillManager.fillReport(report, params, jrRs);
//
//            JasperViewer.viewReport(print, false);
//        } catch (JRException ex) {
//            System.err.println("Erro ao gerar relatório!");
//        }
//    }

//    public void emitirRelatorioContas(HashMap params) {
//        
//        String sql = "SELECT C.CD_CONTA, PS.NOME ,C.DS_CONTA, F.DS_FORMA, C.VL_CONTA, "
//                + "P.NR_PARCELA, P.VL_PARCELA, P.VL_PAGO, "
//                + "TO_CHAR(P.DT_VENCIMENTO,'DD/MM/YYYY') AS DT_VENC, "
//                + "TO_CHAR(P.DT_PAGO,'DD/MM/YYYY') AS DT_PAGO, "
//                + "C.PAGO, "
//                + "(SELECT SUM(VL_CONTA) FROM CONTAS_PAGAR_RECEBER WHERE TIPO_CONTA = '"+params.get("Tipo")+"') AS TOTAL, "
//                + "(SELECT SUM(P.VL_PAGO) FROM PARCELAS P "
//                + "INNER JOIN CONTAS_PAGAR_RECEBER C "
//                + "ON P.CD_CONTA = C.CD_CONTA "
//                + "WHERE P.SITUACAO = 'A' AND P.VL_PAGO > 0 "
//                + "AND C.TIPO_CONTA = '"+params.get("Tipo")+"') AS TOTAL_PAGO, "
//                + "(SELECT SUM(P.VL_PARCELA) FROM PARCELAS P "
//                + "INNER JOIN CONTAS_PAGAR_RECEBER C "
//                + "ON P.CD_CONTA = C.CD_CONTA "
//                + "WHERE P.SITUACAO = 'A' AND P.VL_PAGO  <=0 "
//                + "AND C.TIPO_CONTA = '"+params.get("Tipo")+"') AS AINDA_A_PAGAR "
//                + "FROM CONTAS_PAGAR_RECEBER C "
//                + "INNER JOIN PARCELAS P ON "
//                + "C.CD_CONTA = P.CD_CONTA "
//                + "AND P.SITUACAO = 'A' "
//                + "LEFT JOIN VENDA_COMPRA VC ON "
//                + "C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA "
//                + "AND VC.SITUACAO = 'A' "
//                + "LEFT JOIN PESSOA PS ON "
//                + "PS.CD_PESSOA = VC.CD_CLIENTE "
//                + "OR PS.CD_PESSOA = VC.CD_FORNECEDOR "
//                + "INNER JOIN FORMA_PGTO F ON "
//                + "F.CD_FORMA = C.CD_FORMA "
//                + "WHERE TIPO_CONTA = '"+params.get("Tipo")+"' "
//                + "ORDER BY C.CD_CONTA, P.NR_PARCELA";
////        // 
////SELECT C.CD_CONTA, PS.NOME ,C.DS_CONTA, F.DS_FORMA, C.VL_CONTA, 
////P.NR_PARCELA, P.VL_PARCELA, P.VL_PAGO,
////TO_CHAR(P.DT_VENCIMENTO,'DD/MM/YYYY') AS DT_VENC,
////TO_CHAR(P.DT_PAGO,'DD/MM/YYYY') AS DT_PAGO,
////C.PAGO
////FROM CONTAS_PAGAR_RECEBER C
////INNER JOIN PARCELAS P ON
////C.CD_CONTA = P.CD_CONTA
////AND P.SITUACAO = 'A'
////LEFT JOIN VENDA_COMPRA VC ON
////C.CD_VENDA_COMPRA = VC.CD_VENDA_COMPRA
////AND VC.SITUACAO = 'A'
////LEFT JOIN PESSOA PS ON
////PS.CD_PESSOA = VC.CD_CLIENTE
////OR PS.CD_PESSOA = VC.CD_FORNECEDOR
////INNER JOIN FORMA_PGTO F ON
////F.CD_FORMA = C.CD_FORMA 
//        try{
//            conexao.conecta();
//            conexao.executeSQL(sql);
//            
//            JRResultSetDataSource jrRs = new JRResultSetDataSource(conexao.resultset);
//
//            String report = "relatorios\\CONTAS_RECEBER.jasper";
//
//            JasperPrint print = JasperFillManager.fillReport(report, params, jrRs);
//
//            JasperViewer.viewReport(print, false);
//        }
//        catch(JRException ex){
//            JOptionPane.showMessageDialog(null, "Erro ao gerar documento!");
//        }
//    }

    public boolean login() {
        boolean aceito = false;
        MostrarDialogo dialogo = new MostrarDialogo();
        aceito = dialogo.dialogoPassword("ADMIN");
        return aceito;

    }

    // getter e setter
    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public boolean isSubreport() {
        return subreport;
    }

    public void setSubreport(boolean subreport) {
        this.subreport = subreport;
    }

    public ResultSet getConsulta() {
        return consulta;
    }

    public void setConsulta(ResultSet consulta) {
        this.consulta = consulta;
    }
}
