package Validacoes;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leonardo
 */
public class MostrarDialogo {

    
    public boolean dialogoPassword(String senha) {

        boolean aceito = false;
        final JLabel label = new JLabel("Por favor informe a senha de Administrador");
        final JPasswordField jpf = new JPasswordField();
        Object [] itens = {label, jpf};
        JOptionPane jop = new JOptionPane(itens,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = jop.createDialog("Senha de Administrador solicitada");
        dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        dialog.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jpf.requestFocusInWindow();
                    }
                });
            }
        });
        dialog.setVisible(true);
        int result = (Integer) jop.getValue();
        dialog.dispose();
        String password = null;
        if (result == JOptionPane.OK_OPTION) {
            password = new String(jpf.getPassword());
            
        if (password.toUpperCase().equals(senha)){
            aceito = true;
            dialog.dispose();
        }
        else{
            aceito = false;
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            jpf.setText("");
            jpf.grabFocus();
        }
        }
        else{
            dialog.dispose();
        }
        return aceito;
    }
}
