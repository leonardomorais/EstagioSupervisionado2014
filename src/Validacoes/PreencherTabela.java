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
    
    public void PreencherJtableGenerico(JTable tabela, ResultSet resultado) {
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
                //JOptionPane.showMessageDialog(null, "Registros não localizados !");
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

    public boolean isVazia() {
        return vazia;
    }

    public void setVazia(boolean vazia) {
        this.vazia = vazia;
    }    
}
