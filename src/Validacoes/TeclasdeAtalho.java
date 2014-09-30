package Validacoes;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author Leonardo
 */
public class TeclasdeAtalho {

    public void carregarAtalhos(Container tela) {

        Component components[] = tela.getComponents();

        for (Component c : components) {
            if (c instanceof JButton) {
                final JButton botao = (JButton) c;
                String nome = botao.getText().toUpperCase();
                int valor;

                Action acao = new AbstractAction(nome) {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        botao.doClick();
                    }
                };

                KeyStroke keyStroke;

                try {
                    // se houver apenas o código int da tecla
                    valor = Integer.parseInt(botao.getName());
                    keyStroke = KeyStroke.getKeyStroke(valor, 0);
                } 
                catch (NumberFormatException ex) {
                    // se houver caracteres informando Ctrl

                    valor = Integer.parseInt(nome.substring(0, nome.indexOf("+")));
                    // recebe o número presente antes do +
                    keyStroke = KeyStroke.getKeyStroke(valor, InputEvent.CTRL_DOWN_MASK);
                }

                InputMap map = botao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
                map.put(keyStroke, "ACT_" + nome);
                ActionMap actionMap = botao.getActionMap();
                actionMap.put("ACT_" + nome, acao);

            }
        }

    }

}
