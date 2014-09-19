package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import Validacoes.MostrarDialogo;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
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
            JasperViewer.viewReport(print, false);

            // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
        } catch (JRException ex) {
            System.err.println("Erro ao gerar Relatório!");
        }
    }

    public void gerarRelatorio(Relatorios r, HashMap params) {
        try {
            conexao.conecta();
            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());

            String report = "relatorios\\" + r.getTabela() + ".jasper";

            JasperPrint print = JasperFillManager.fillReport(report, params, jrRs);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            System.err.println("Erro ao gerar relatório!");
        }
    }

    public void emitirTicketVendaCompra(int cd) {
        HashMap parametro = new HashMap();

        String sql = "SELECT VC.CD_VENDA_COMPRA, VC.CD_FORMA, F.DS_FORMA, "
                + "VC.CD_OPERACAO, O.DS_OPERACAO, TO_CHAR(DT_VENDA_COMPRA,'DD/MM/YYYY') AS DATA, "
                + "VC.VL_TOTAL, "
                + "VCPROD.CD_PRODUTO, P.DS_PRODUTO, VCPROD.QT_PRODUTO, VCPROD.VL_UNITARIO, "
                + "VCPROD.QT_PRODUTO * VCPROD.VL_UNITARIO AS TOTAL "
                + "FROM VENDA_COMPRA VC INNER JOIN "
                + "VENDA_COMPRA_PRODUTOS VCPROD "
                + "ON VC.CD_VENDA_COMPRA = VCPROD.CD_VENDA_COMPRA "
                + "INNER JOIN FORMA_PGTO F ON VC.CD_FORMA = F.CD_FORMA "
                + "INNER JOIN OPERACAO O ON VC.CD_OPERACAO = O.CD_OPERACAO "
                + "INNER JOIN PRODUTOS P ON VCPROD.CD_PRODUTO = P.CD_PRODUTO "
                + "WHERE VC.CD_VENDA_COMPRA = " + cd;
        try {
            conexao.conecta();
            conexao.executeSQL(sql);

            JRResultSetDataSource jrRs = new JRResultSetDataSource(conexao.resultset);

            String report = "relatorios\\TICKET_VENDA_COMPRA.jasper";

            JasperPrint print = JasperFillManager.fillReport(report, parametro, jrRs);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar documento!");
        }
    }

    public void emitirTicketPagamento(List<Integer> list, int cd) {

        HashMap parametro = new HashMap();
        String consulta = "";
        for (int nr : list) {
            consulta = ", " + consulta + nr;
        }
        consulta = consulta.substring(0, 1); // remove a primeira virgula
        System.err.println("Consulta " + consulta);

        String sql = "SELECT PAG.CD_PAGAMENTO, PAG.CD_CONTA, PAG.NR_PARCELA, C.DS_CONTA," 
                + "PAG.NR_PARCELA, PAG.CD_TIPO, T.DS_TIPO "
                + "FROM PAGAMENTO PAG "
                + "INNER JOIN PARCELAS P " 
                + "ON P.CD_CONTA = PAG.CD_CONTA "
                + "AND P.NR_PARCELA = PAG.NR_PARCELA "
                + "INNER JOIN CONTAS_PAGAR_RECEBER C "
                + "ON PAG.CD_CONTA = C.CD_CONTA "
                + "INNER JOIN TIPO_PGTO T "
                + "ON T.CD_TIPO = PAG.CD_TIPO "
                + "WHERE PAG.SITUACAO = 'A' "
                + "AND PAG.CD_CONTA = "+cd+" "
                + "AND P.NR_PARCELA IN ("+consulta+")";
        try{
            conexao.conecta();
            conexao.executeSQL(sql);
             
            JRResultSetDataSource jrRs = new JRResultSetDataSource(conexao.resultset);

            String report = "relatorios\\TICKET_PAGAMENTO.jasper";

            JasperPrint print = JasperFillManager.fillReport(report, parametro, jrRs);

            JasperViewer.viewReport(print, false);
        }
        catch(JRException ex){
            
        }
    }

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
