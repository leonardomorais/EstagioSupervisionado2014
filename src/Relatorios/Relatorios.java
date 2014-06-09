/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    public void gerarRelatorio(String tabela) throws JRException{               
        try{
        conexao.conecta();
        
        String sql = "SELECT * FROM "+tabela+" ORDER BY CD_"+tabela;
               
        conexao.executeSQL(sql);
        
        JRResultSetDataSource jrRs = new JRResultSetDataSource(conexao.resultset);
        
        String report = "relatorios\\"+tabela+".jasper";
        
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(),jrRs);
        
        JasperViewer.viewReport(print);
   
        // exportando para PDF (iText.jar)
//        JasperExportManager.exportReportToPdfFile(print,
//				"relatorios\\Relatorio"+tabela+".pdf");
            JasperExportManager.exportReportToPdf(print);
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
    }
 
     

