package Validacoes;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;

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

                    if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")) {
                        field.setEnabled(false);
                    } else {
                        field.setEnabled(true);
                    }

                } else {
                    if (nome.equals("Incluir") | nome.equals("Excluir") | nome.equals("Alterar")) {
                        field.setEnabled(true);
                    } else {
                        field.setEnabled(false);
                    }
                }

            }
        }
    }

}
