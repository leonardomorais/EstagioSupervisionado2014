package Validacoes;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComboBox;

import javax.swing.JTextField;

/**
 *
 * @author Leonardo
 */
public class LimparCampos {

    public void limparCampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {

            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText("");
            }

            if (component instanceof JComboBox) {
                JComboBox field = (JComboBox) component;
                field.setSelectedIndex(0);
            }

        }
    }
}
