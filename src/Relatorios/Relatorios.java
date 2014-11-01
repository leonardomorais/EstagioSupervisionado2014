package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private HashMap parametro;
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

    public void gerarRelatorio(Relatorios r) {
        try {
            conexao.conecta();

            if (r.isSubreport()) {
                r.getParametro().put("SUBREPORT_DIR", "relatorios\\");
                r.getParametro().put("REPORT_CONNECTION", conexao.conecta());
            }
            JRResultSetDataSource jrRs = new JRResultSetDataSource(r.getConsulta());

            String report = "relatorios\\" + r.getTabela() + ".jasper";

            JasperPrint print = JasperFillManager.fillReport(report, r.getParametro(), jrRs);

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
    
    public void iniciarSplash(final Relatorios relatorio){
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                   relatorio.gerarRelatorio(relatorio); 
            }
        });
        
        thread.start();
        
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                SplashRelatorio splash = new SplashRelatorio();
                splash.setVisible(true);
                thread.join();
                splash.dispose();
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
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

    public HashMap getParametro() {
        if (parametro == null){
            parametro = new HashMap();
        }
        return parametro;
        
        
    }

    public void setParametro(HashMap parametro) {
        this.parametro = parametro;
    }
    
}
