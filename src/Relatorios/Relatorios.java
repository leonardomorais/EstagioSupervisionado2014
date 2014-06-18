package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
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
    
    public void gerarRelatorio(Relatorios r) throws JRException{
        
        HashMap parametro = new HashMap();
        
        try{
            conexao.conecta();
            
            if (r.isSubreport()){
            parametro.put("SUBREPORT_DIR", "relatorios\\");
            parametro.put("REPORT_CONNECTION", conexao.conecta());
        }
            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());
   
            String report = "relatorios\\"+r.getTabela()+".jasper";
            
            JasperPrint print = JasperFillManager.fillReport(report, parametro, jrRs);
            
            JasperViewer.viewReport(print);
                        
        // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
            
            
//        JasperViewer jpView = new JasperViewer(print);
//        jpView.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
//        jpView.setTitle(r.getTabela());
//        jpView.setVisible(true);
     
        }
        catch(Exception ex){
            System.err.println("Erro ao gerar Relatório!");
        }
    }

    // getter e setter
    
    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public ResultSet getConsulta() {
        return consulta;
    }

    public void setConsulta(ResultSet consulta) {
        this.consulta = consulta;
    }

    public boolean isSubreport() {
        return subreport;
    }

    public void setSubreport(boolean subreport) {
        this.subreport = subreport;
    }
    
    
}
 
     

