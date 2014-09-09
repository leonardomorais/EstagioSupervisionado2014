package Validacoes;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo
 */
public class ValidaBotoes {

    public void validaBotoes(Container container, int rotina) {

        Component components[] = container.getComponents();
        for (Component component : components) {

            if (component instanceof JButton) {
                JButton field = (JButton) component;
                String nome = field.getText();

                if (rotina == Rotinas.incluir | rotina == Rotinas.alterar) {

                    if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")
                            | nome.equals("Iniciar Atendimento") | nome.equals("Incluir Venda/Compra")) {
                        field.setEnabled(false);
                    } else {
                        field.setEnabled(true);
                    }

                } else {
                    if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")
                            | nome.equals("Iniciar Atendimento") | nome.equals("Incluir Venda/Compra")) {
                        field.setEnabled(true);
                    } else {
                        field.setEnabled(false);
                    }
                }
            }
        }
    }
    
    public void validaEstadoCampos(Container container, int rotina){
        
        Component lista[] = container.getComponents();
        
        for (Component c: lista){
            
            // se for um botao
            if (c instanceof JButton){
                JButton botao = (JButton) c;
                String nome = botao.getText();
                
                switch (rotina){
                    
                    case Rotinas.padrao:
                        if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")
                            | nome.equals("Iniciar Atendimento") | nome.equals("Incluir Venda/Compra")
                            | nome.equals("Novo Pagamento") | nome.equals("Nova Tranferência")) {
                            botao.setEnabled(true);
                        }
                        else{
                            botao.setEnabled(false);
                        }
                    break;    
                        
                    default:
                        if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")
                            | nome.equals("Iniciar Atendimento") | nome.equals("Incluir Venda/Compra")
                            | nome.equals("Novo Pagamento") | nome.equals("Nova Tranferência")) {
                            botao.setEnabled(false);
                        }
                        else{
                            botao.setEnabled(true);
                        }
                }
                
            }
            // demais componentes
            else {
                
                switch (rotina){
                    
                    case Rotinas.padrao:
                        c.setEnabled(false);
                    break;
                        
                    default:
                        c.setEnabled(true);
                }
            }
        }
    }
}
