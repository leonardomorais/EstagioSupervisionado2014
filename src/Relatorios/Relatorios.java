package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.util.HashMap;
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
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void gerarRelatorio(Relatorios r) throws JRException{               
        try{
        conexao.conecta();
     
        JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());
        
        String report = "relatorios\\"+r.getTabela()+".jasper";
                
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(),jrRs);
        
        JasperViewer.viewReport(print);
        
//        JasperViewer jpView = new JasperViewer(print);
//        jpView.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
//        jpView.setTitle(r.getTabela());
//        jpView.setVisible(true);
        
        // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
        }
        catch(Exception ex){
            System.err.println("Erro ao gerar Relatório!");
        }
 }
    
    public void gerarRelatorio(ResultSet consulta,String tabela) throws JRException{
        try{
            conexao.conecta();
            
            JRResultSetDataSource jrRs = new JRResultSetDataSource(consulta);
            
            String report = "relatorios\\"+tabela+".jasper";
            
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), jrRs);
            
            JasperViewer.viewReport(print);
            
            JasperExportManager.exportReportToPdfFile(print,
				"relatorios\\Relatorio"+tabela+".pdf");
        }
        catch(Exception ex){
            System.err.println("Erro ao gerar Relatório!");
        }
    }
    
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
}
 
     

