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
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Leonardo
 */
public class TeclasdeAtalho {
    
    public void adicionarAtalho(final JTabbedPane pane){
        Action actAba1 = new AbstractAction("ABA_1") {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(0);
            }
        };
        
        
        Action actAba2 = new AbstractAction("ABA_2") {

            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(1);
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK);
        KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK);
        
        InputMap map = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = pane.getActionMap();
        
        map.put(keyStroke, "ABA_1");
        map.put(ks, "ABA_2");
        actionMap.put("ABA_1", actAba1);
        actionMap.put("ABA_2", actAba2);
        
    }
    
    public void adicionarAtalho(final JButton botao, int atalho, int input){
        Action acao = new AbstractAction(botao.getText()) {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                botao.doClick();
            }
        };
        
        KeyStroke keyStroke = KeyStroke.getKeyStroke(atalho, input);
        InputMap map = botao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        map.put(keyStroke, "ACT_"+botao.getText());
        ActionMap actionMap = botao.getActionMap();
        actionMap.put("ACT_"+botao.getText(), acao);
    }
    
    public void adicionarAtalho(final JRadioButton radio, int atalho, int input){
        Action acao = new AbstractAction(radio.getText()) {

            @Override
            public void actionPerformed(ActionEvent e) {
                radio.setSelected(true);
            }
        };
        
        KeyStroke keyStroke = KeyStroke.getKeyStroke(atalho, input);
        InputMap map = radio.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        map.put(keyStroke, "ACT_"+radio.getText());
        ActionMap actionMap = radio.getActionMap();
        actionMap.put("ACT_"+radio.getText(), acao);
    }
}
