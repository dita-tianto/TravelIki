package View;

import View.All_panel.nPanel_Layanan;
import View.All_panel.nPanel_Pemesanan;
// import View.All_Panel.Panel_Insert_Layanan;
// import View.All_Panel.Panel_Insert_Paket;
// import View.All_Panel.Panel_Insert_Pemesanan;
import View.Login.Splash_Screen;
import View.Login.nLogin_User;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Panel_Test extends JFrame {

    public static Object table;
    private JMenu mnHome;
    private JMenuItem mntmAddCategory;
    private JDesktopPane desktopPane;

    public static void main(String[] args) {
        Panel_Test go = new Panel_Test();
        go.setVisible(true);
    }

    public Panel_Test() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(nLogin_User.class.getResource("/resource/sp (4).png")));
        setTitle("WWW.Traveliki.com");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(445, 100, 850, 550);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        desktopPane = new JDesktopPane() {
            private Image image;
            {
                try {
                    image = ImageIO.read(Splash_Screen.class.getResource("/resource/LatarBelakang.png"));
                } catch (IOException e) {
                    System.err.println(e);
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        mnHome = new JMenu("Home");
        mnHome.setIcon(new ImageIcon(nLogin_User.class.getResource("/resource/home (2).png")));
        menuBar.add(mnHome);

        // EDIT DI BAWAH

        // layanan riski
        mntmAddCategory = new JMenuItem("Tambahkan Layanan");
        mntmAddCategory.setMnemonic(KeyEvent.VK_O);
        mntmAddCategory.setIcon(new ImageIcon(nLogin_User.class.getResource("/resource/cat.png")));
        mntmAddCategory.addActionListener((ActionEvent arg0) -> {
            JInternalFrame JIF = new JInternalFrame("Tambahkan Layanan", false, true, false, true);
            nPanel_Layanan addCategoryPanel = new nPanel_Layanan();
            JIF.getContentPane().add(addCategoryPanel);
            JIF.pack();
            desktopPane.add(JIF);
            JIF.setVisible(true);
        });

        mnHome.add(mntmAddCategory);

        // Tambah kategori ik
        mntmAddCategory = new JMenuItem("Tambahkan Kategori");
        mntmAddCategory.setMnemonic(KeyEvent.VK_O);
        mntmAddCategory.setIcon(new ImageIcon(nLogin_User.class.getResource("/resource/cat.png")));
        mntmAddCategory.addActionListener((ActionEvent arg0) -> {
            JInternalFrame JIF = new JInternalFrame("Tambahkan Kategori", false, true, false, true);
            Insert_Paket addCategoryPanel = new nPanel_Insert_Paket();
            JIF.getContentPane().add(addCategoryPanel);
            JIF.pack();
            desktopPane.add(JIF);
            JIF.setVisible(true);
        });

        mnHome.add(mntmAddCategory);

        // Tambah Paket
        mntmAddCategory = new JMenuItem("Tambahkan paket");
        mntmAddCategory.setMnemonic(KeyEvent.VK_O);
        mntmAddCategory.setIcon(new ImageIcon(nLogin_User.class.getResource("/resource/cat.png")));
        mntmAddCategory.addActionListener((ActionEvent arg0) -> {
            JInternalFrame JIF = new JInternalFrame("Tambahkan Paket", false, true, false, true);
            nPanel_Pemesanan addCategoryPanel = new nPanel_Pemesanan();
            JIF.getContentPane().add(addCategoryPanel);
            JIF.pack();
            desktopPane.add(JIF);
            JIF.setVisible(true);
        });

        mnHome.add(mntmAddCategory);

        // SAMPAI DI SINI

        setContentPane(desktopPane);
    }
}


// apalah 