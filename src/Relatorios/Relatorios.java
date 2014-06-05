/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Leonardo
 */
public class Relatorios {
    
    ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();
    
    
    
    public void gerarRelatorio(String tabela) throws JRException{
//        String sql = "SELECT * FROM "+tabela+" ORDER BY CD_"+tabela;
//         
//        System.out.println("SQL: "+sql);
//        conexao.executeSQL(sql);
//        
//        ResultSet rs = conexao.resultset;
        
        JasperReport report = JasperCompileManager.
                compileReport("C:\\Users\\Leonardo\\Documents\\NetBeansProjects\\"
                        + "EstágioSupervisionado\\src\\Relatorios\\Relatorios\\relatorio01.jrxml");
        
        JasperPrint print = JasperFillManager.fillReport(report, null, conexao.conecta());  
JasperViewer view = new JasperViewer(print, false); 
        
        view.setVisible(true);
        
      //  JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
        
//        JasperPrint print = JasperFillManager.fillReport("Relatorios\\Relatorios\\relatorio01.jasper", null, jrRs);
//        JasperViewer.viewReport(print);
//        JasperViewer view = new JasperViewer(print);
//        
//        view.show();
        }
    }
 
     

