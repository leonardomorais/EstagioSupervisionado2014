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
    
    private int contaNumeros(String campo){
        int qt = 0;
        for (int i = 0; i < campo.length(); i++){
            if ("0123456789".contains(campo.charAt(i)+"")){
                qt = qt + 1;
            }
        }
        return qt;
    }
    
    public boolean CEPValido(JTextField cep){
        if (contaNumeros(cep.getText())!=0
         && contaNumeros(cep.getText()) !=8){
            cep.grabFocus();
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean fonesValidos(JTextField res, JTextField com, JTextField cel){
        if (contaNumeros(res.getText())!=0 
         && contaNumeros(res.getText())!=10){
            res.grabFocus();
            return false;
        }
        else if (contaNumeros(com.getText())!=0 
         && contaNumeros(com.getText())!=10){
            com.grabFocus();
            return false;
        }
        else if (contaNumeros(cel.getText())!=0 
         && contaNumeros(cel.getText())!=10){
            cel.grabFocus();
            return false;
        }
        else{
            return true;
        }
    }
}
