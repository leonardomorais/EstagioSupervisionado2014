package Validacoes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Leonardo
 */
public class EditarComponentes extends DefaultTableCellRenderer {

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
            String dataTabela = table.getValueAt(row, 3).toString();
            double vlPago = Double.parseDouble(table.getValueAt(row, 4).toString());
                if (data.comparaData(dataTabela) > 0) {
                    comp.setForeground(Color.black);
                } else {
                    comp.setForeground(Color.red);
                    if (vlPago > 0){
                        comp.setForeground(Color.black);
                    }
                }
        }
        return comp;
    }
    
    public void editaBotoes(Container container){
        Component botoes [] = container.getComponents();
        
        for (Component c : botoes){
            if (c instanceof JButton){
                final JButton botao = (JButton) c;
                
                botao.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        //botao.setBackground(new Color(51, 153, 254));
                        //JOptionPane.showMessageDialog(null, "CLICOU!");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(51, 153, 254));
                        //JOptionPane.showMessageDialog(null, "PRESSED!");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(195, 225, 255));
                        //JOptionPane.showMessageDialog(null, "RELEASED!");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(195, 225, 255));
                        //JOptionPane.showMessageDialog(null, "ENTERED!");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        botao.setBorder(BorderFactory.createEmptyBorder());
                        botao.setBackground(new Color(240, 240, 240));
                        //JOptionPane.showMessageDialog(null, "EXITED!");
                    }
                });
                
            }
        }
    }
    
    public void editaBotao(final JButton botao){
        botao.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        //botao.setBackground(new Color(51, 153, 254));
                        //JOptionPane.showMessageDialog(null, "CLICOU!");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(51, 153, 254));
                        //JOptionPane.showMessageDialog(null, "PRESSED!");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(195, 225, 255));
                        //JOptionPane.showMessageDialog(null, "RELEASED!");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        botao.setBorder(BorderFactory.createLineBorder(new Color(128, 172, 212), 2, false));
                        botao.setBackground(new Color(195, 225, 255));
                        //JOptionPane.showMessageDialog(null, "ENTERED!");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        botao.setBorder(BorderFactory.createEmptyBorder());
                        botao.setBackground(new Color(240, 240, 240));
                        //JOptionPane.showMessageDialog(null, "EXITED!");
                    }
                });
                
    }
    
    public void editaJpanel (final JPanel panelMesa, final JTextField campo){
        
        
        final JLabel labelnr = (JLabel) panelMesa.getComponent(0);
        
        
        panelMesa.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMesa.setBackground(new Color(0, 108, 217));
                campo.setText(labelnr.getText().replace("Mesa:", "").replace(" ", ""));
                campo.grabFocus();
                panelMesa.grabFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               // panelMesa.setBackground(new Color(51, 153, 254));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //panelMesa.setBackground(new Color(51, 153, 254));
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // panelMesa.setBackground(new Color(197, 222, 243));
            }
        });
        
        panelMesa.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e){
                //panelMesa.setBackground(new Color(255, 231, 39));
                panelMesa.setBackground(new Color(0, 108, 217));
            }
            
            @Override
            public void focusLost(FocusEvent e){
                panelMesa.setBackground(new Color(197, 222, 243));
            }
        });
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
