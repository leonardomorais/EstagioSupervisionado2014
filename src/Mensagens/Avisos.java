package Mensagens;

import Classes.Parcelas;
import Classes.Produto;
import Consultas.ParcelasAtrasadas;
import Consultas.ProdutosEstoqueInvalido;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;

/**
 *
 * @author Leonardo
 */
public class Avisos {

    
    private SystemTray tray;
    private TrayIcon trayIcon;
    String destino;
    private static TrayIcon atual;
    public static final String AVISO_PRODUTOS = "PRODUTOS";
    public static final String AVISO_PARCELAS = "PARCELAS";
    int nr = 0;
    
    public boolean existemAvisos(){
        boolean avisos = false;
        
        if(new Parcelas().possuemParcelasVencidas()){
            nr = nr + 1;
            avisos = true;
        }
        if(new Produto().possuiEstoqueInvalido()){
            nr = nr + 1;
            avisos = true;
        }
        
        return avisos;
    }
    
    public void adicionarAviso() {
        tray = SystemTray.getSystemTray();
        
        if (SystemTray.isSupported()) {
            tray.remove(atual); // deixa um único aviso
            
            ImageIcon img = new ImageIcon("C:\\Users\\Leonardo\\Documents\\NetBeansProjects\\EstagioSupervisionado\\"
                    + "src\\Extras\\Imagens\\aviso.png");

            
            trayIcon = new TrayIcon(img.getImage(), "Avisos", criaMenu());
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage("Avisos do Sistema", null, TrayIcon.MessageType.INFO);

                trayIcon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        

                    }
                });
                atual = trayIcon;

            } catch (AWTException ex) {
                Logger.getLogger(Avisos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public PopupMenu criaMenu(){
        PopupMenu menu = new PopupMenu();

        MenuItem itemTopo = new MenuItem("Al Tálio Sistema: "+nr+" Notificações");
        MenuItem itemSair = new MenuItem("Sair");
        itemSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(atual);
            }
        });
        
        Parcelas parcelas = new Parcelas();
        MenuItem itemParcelas = new MenuItem();
        
        itemParcelas.setLabel("Existem parcelas com pagamento em atraso");
        itemParcelas.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ParcelasAtrasadas parc = new ParcelasAtrasadas();
                    parc.setVisible(true);
                }
            });
            
        
        
        Produto produto = new Produto();
        MenuItem itemProdutos = new MenuItem();
        
        itemProdutos.setLabel("Existem produtos com o estoque inválido");
        itemProdutos.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ProdutosEstoqueInvalido prod = new ProdutosEstoqueInvalido();
                    prod.setVisible(true);
                }
            });
        
        menu.add(itemTopo);
        menu.add(itemProdutos);
        menu.add(itemParcelas);
        menu.add(itemSair);
        if (!produto.possuiEstoqueInvalido()){
            menu.remove(itemProdutos);
        }
        if (!parcelas.possuemParcelasVencidas()){
            menu.remove(itemParcelas);
        }
        
        return menu;
    }
    
    public void criarAviso(String tipo) {
        tray = SystemTray.getSystemTray();
        String mensagem;

        if (SystemTray.isSupported()) {
            tray.remove(atual); // deixa somente um aviso

            PopupMenu menu = new PopupMenu();

            MenuItem sair = new MenuItem("Fechar");
            sair.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    tray.remove(trayIcon);
                }
            });

            menu.add(sair);

            destino = tipo;
            if (destino.equals(AVISO_PRODUTOS)) {
                mensagem = "Produtos com estoque inválido!";
            } else {
                mensagem = "Parcelas com pagamento em atraso!";
            }
//
//            MenuItem opcao = new MenuItem("Opção");
//
//            opcao.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.err.println("OPCAO");
//                }
//            });
//
//            menu.add(opcao);
            ImageIcon img = new ImageIcon("C:\\Users\\Leonardo\\Documents\\NetBeansProjects\\EstagioSupervisionado\\"
                    + "src\\Extras\\Imagens\\aviso.png");

            trayIcon = new TrayIcon(img.getImage(), "Avisos", menu);
            trayIcon.setImageAutoSize(true);
            try {
                tray.add(trayIcon);

                trayIcon.displayMessage("Avisos do Sistema", mensagem, TrayIcon.MessageType.INFO);

                trayIcon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (destino.equals(AVISO_PRODUTOS)) {
                            ProdutosEstoqueInvalido prod = new ProdutosEstoqueInvalido();
                            prod.setVisible(true);
                        } else {
                            ParcelasAtrasadas parc = new ParcelasAtrasadas();
                            parc.setVisible(true);
                        }
                    }
                });
                atual = trayIcon;
            } catch (AWTException ex) {
                Logger.getLogger(Avisos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
