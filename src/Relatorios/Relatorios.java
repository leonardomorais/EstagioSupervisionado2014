package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.util.HashMap;
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
            JasperViewer relatorio = new JasperViewer(print, false); 
            relatorio.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            relatorio.setVisible(true);
            
             //JasperViewer.viewReport(print, false);

            // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar documento");
        }
    }
    
    public void gerarRelatorio(Relatorios r, HashMap parametros){
        try{
            conexao.conecta();
            
            if (r.isSubreport()){
                parametros.put("SUBREPORT_DIR", "relatorios\\");
                parametros.put("REPORT_CONNECTION", conexao.conecta());
            }
            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());
            
            String report = "relatorios\\"+r.getTabela()+".jasper";
            
            JasperPrint print = JasperFillManager.fillReport(report, parametros, jrRs);
            
            JasperViewer relatorio = new JasperViewer(print, false);
            relatorio.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            
            relatorio.setVisible(true);
        }
        catch(JRException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar documento");
        }
    }
//
//    public boolean login() {
//        boolean aceito;
//        MostrarDialogo dialogo = new MostrarDialogo();
//        aceito = dialogo.dialogoPassword("ADMIN");
//        return aceito;
//    }
    
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
