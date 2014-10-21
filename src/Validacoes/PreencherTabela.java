package Validacoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class PreencherTabela {
    
    private boolean vazia;
    private ResultSet consulta;
    
    public void PreencherJtableGenerico(JTable tabela, ResultSet resultado) {
        setConsulta(resultado);
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            int colunas = resultado.getMetaData().getColumnCount();

            while (resultado.next()) {
                Object[] row = new Object[colunas];
                for (int i = 0; i != colunas; i++) {
                    row[i] = resultado.getString(i + 1);
                }
                modelo.addRow(row);
                setVazia(false);
            }
            if (!resultado.first()) {
                JOptionPane.showMessageDialog(null, "A consulta não encontrou resultados!");
                setVazia(true);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable" + erro);
            setVazia(true);
        }
    }

    public void FormatarJtable(JTable tabela, int valores[]) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor verificar os parametros passados !");
        }
    }

    public void PreencherJtableGenericoSel(JTable tabela, ResultSet resultado) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        try {
            int colunas = resultado.getMetaData().getColumnCount();

            while (resultado.next()) {
                Object[] row = new Object[colunas];
                for (int i = 0; i != colunas; i++) {

                    if (i == 0) {
                        row[i] = (false);
                    } else {
                        row[i] = resultado.getString(i + 1);
                    }

                }
                modelo.addRow(row);
            }
            if (!resultado.first()) {
                JOptionPane.showMessageDialog(null, "Registros não localizados !");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable" + erro);
        }
    }
    
//    public void preencherJtableComSelecao(JTable tabela, ResultSet resultado, int posicao){
//        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
//        model.setNumRows(0);
//        
//        try{
//            int colunas = resultado.getMetaData().getColumnCount();
//            
//            while (resultado.next()){
//                Object[] linha = new Object[colunas];
//                for (int i = 0; i < colunas; i++){
//                    if (i == posicao){
//                        linha [i] = (false);
//                    }
//                    else{
//                        linha [i] = resultado.getString(i + 1);
//                    }
//                    
//                }
//                model.addRow(linha);
//            }
//            if (!resultado.first()){
//                JOptionPane.showMessageDialog(null, "Registros não localizados !");
//            }
//        }
//        catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela "+ex);
//        }
//    }
//    

    public boolean Vazia() {
        return vazia;
    }

    public void setVazia(boolean vazia) {
        this.vazia = vazia;
    }   

    public ResultSet getConsulta() {
        try {
            consulta.beforeFirst();
        } catch (SQLException ex) {
            consulta = null;
            setVazia(true);
        }
        return consulta;
    }

    public void setConsulta(ResultSet consulta) {
        this.consulta = consulta;
    }
    
    
}
