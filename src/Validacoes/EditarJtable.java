package Validacoes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Leonardo
 */
public class EditarJtable extends DefaultTableCellRenderer {

    private Integer linhas;
    private String tipo;
    
    RetornaData data = new RetornaData();
    
    public void editarTabela(JTable tabela) {

        tabela.setDefaultRenderer(Object.class, this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (getTipo().equals("VENDA_COMPRA")) {
            // se for a tabela da tela de venda/compra
            if (getLinhas()> row){
                comp.setForeground(Color.blue);
            }
            else{
                comp.setForeground(Color.black);
            }
        } 
        // se for a tabela das parcelas
        else {
            String 
                dataTabela = table.getValueAt(row, 3).toString();

                if (data.comparaData(dataTabela) > 0) {
                    comp.setForeground(Color.black);
                } else {
                    comp.setForeground(Color.red);
                }
        }
        return comp;
    }
    
    // getter e setter

    public Integer getLinhas() {
        return linhas;
    }

    public void setLinhas(Integer linhas) {
        this.linhas = linhas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
