package Mensagens;

import Classes.Parcelas;
import Classes.Produto;
import Consultas.ParcelasAtrasadas;
import Consultas.ProdutosEstoqueInvalido;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;

/**
 *
 * @author Leonardo
 */
public class Avisos {

    private SystemTray tray;
    private TrayIcon trayIcon;
    private static TrayIcon atual;
    int nr = 0;

    public void verificaAvisos() {
        boolean avisos = false;

        if (new Parcelas().possuemParcelasVencidas()) {
            nr = nr + 1;
            avisos = true;
        }
        if (new Produto().possuiEstoqueInvalido()) {
            nr = nr + 1;
            avisos = true;
        }
        if (avisos){
            adicionarAvisos();
        }
        else{
            removerAviso();
        } 
    }

    private void adicionarAvisos() {
        tray = SystemTray.getSystemTray();

        if (SystemTray.isSupported()) {
            

            ImageIcon img = new ImageIcon("src\\Extras\\Imagens\\aviso.png");

            trayIcon = new TrayIcon(img.getImage(), "Avisos", null);
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
                String message;
                if (nr == 1) {
                    message = "1 notificação";
                } else {
                    message = "2 notificações";
                }

                if (atual == null){
                    trayIcon.displayMessage("Avisos do Sistema", "O sistema requer sua atenção para "
                            + message, TrayIcon.MessageType.INFO);
                }
                
                tray.remove(atual);
                atual = trayIcon;
                
                trayIcon.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent evt) {
                        JPopupMenu menu = criaMenu();
                        menu.setLocation(evt.getX(), evt.getY());
                        menu.setInvoker(menu);
                        menu.setVisible(true);
                    }
                });

                trayIcon.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPopupMenu menu = criaMenu();
                        menu.setLocation(1000, 600);
                        menu.setInvoker(menu);
                        menu.setVisible(true);
                    }
                });

            } 
            catch (AWTException ex) {
                Logger.getLogger(Avisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private JPopupMenu criaMenu() {
        JPopupMenu menu = new JPopupMenu();
        String titulo;
        if (nr == 1) {
            titulo = "Al Tálio Sistema : 1 Notificação";
        } else {
            titulo = "Al Tálio Sistema : 2 Notificações";
        }
        JMenuItem itemTopo = new JMenuItem(titulo);
        itemTopo.setFont(new Font("Tahoma", Font.BOLD, 11));
        JMenuItem itemSair = new JMenuItem("Sair");

        itemSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(atual);
            }
        });

        JMenuItem itemParcelas = new JMenuItem("Parcelas com pagamento em atraso");

        itemParcelas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ParcelasAtrasadas().setVisible(true);
            }
        });

        JMenuItem itemProduto = new JMenuItem("Produtos com estoque inválido");

        itemProduto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdutosEstoqueInvalido().setVisible(true);
            }
        });

        menu.add(itemTopo);
        menu.add(new Separator());
        menu.add(itemProduto);
        menu.add(itemParcelas);
        menu.add(new Separator());
        menu.add(itemSair);
        if (!new Produto().possuiEstoqueInvalido()) {
            menu.remove(itemProduto);
        }
        if (!new Parcelas().possuemParcelasVencidas()) {
            menu.remove(itemParcelas);
        }

        return menu;
    }
    
    public void removerAviso(){
        tray = SystemTray.getSystemTray();
        tray.remove(atual);
    }
}
