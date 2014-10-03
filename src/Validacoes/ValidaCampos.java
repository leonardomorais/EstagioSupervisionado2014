package Validacoes;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import javax.swing.JSpinner;

/**
 *
 * @author Leonardo
 */
public class ValidaCampos {

    public void validaCamposApenasNumeros(KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    public void validaCamposReais(KeyEvent evt){
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public void validaCamposLimite(KeyEvent evt, JTextField field, int max) {
        String campo = field.getText();
        if (campo.length() >= max) {
            evt.consume();
        }
    }
    
    public void validaSpinner(JSpinner spn){
       
       ((JSpinner.DefaultEditor) spn.getEditor()).getTextField().addKeyListener(new KeyListener() {  

           @Override
           public void keyTyped(KeyEvent e) {
               validaCamposApenasNumeros(e);
           }

           @Override
           public void keyPressed(KeyEvent e) {
               
           }

           @Override
           public void keyReleased(KeyEvent e) {
               
           }
    
        });
       
    }
    
}
