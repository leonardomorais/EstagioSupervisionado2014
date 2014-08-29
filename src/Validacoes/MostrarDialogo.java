package Validacoes;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Leonardo
 */
public class MostrarDialogo {

    public String dialogoData(String dataParam){
        RetornaData rdata = new RetornaData();
        String dataRetorno = "";
        
        final JLabel label = new JLabel("Informe a data de vencimento desejada");
        final JFormattedTextField campoData = new JFormattedTextField();
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(campoData);
        } catch (ParseException ex) {
            System.err.println("Erro ao incluir máscara!");
        }
        Object [] itens = {label, campoData};
        JOptionPane jop = new JOptionPane(itens, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog dialogo = jop.createDialog("Vencimento da parcela");
        dialogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        dialogo.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        campoData.requestFocusInWindow();
                    }
                });
            }
        });
        
        dialogo.setVisible(true);
        int result = (Integer) jop.getValue();
        dialogo.dispose();
        String data = "";
        
         if (result == JOptionPane.OK_OPTION) {
            data = campoData.getText();
            if (rdata.dataValida(data)){
               dataRetorno = data;
               dialogo.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Data inválida");
                //dataRetorno = dataParam;
        }
        }
        else{
            dialogo.dispose();
            dataRetorno = dataParam;
        }
        return dataRetorno;
    }
    
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
