/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Relatorios;

import ConexaoBanco.ConexaoPostgreSQL;
import java.util.HashMap;
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
        
        try{
        conexao.conecta();
        
        String sql = "SELECT * FROM "+tabela+" ORDER BY CD_"+tabela;
//         
        conexao.executeSQL(sql);
        
        JRResultSetDataSource jrRs = new JRResultSetDataSource(conexao.resultset);
        
        String report = "relatorios\\relatorio01.jasper";
        
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(),jrRs);
        JasperViewer.viewReport(print);
   
        }
        catch(Exception ex){
            System.err.println("Erro ao gerar Relatório!");
        }
        }
    }
 
     

