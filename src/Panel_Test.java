import View.All_Panel.Panel_Insert_Layanan;
import View.All_Panel.Panel_Insert_Paket;
import View.All_Panel.Panel_Insert_Pemesanan;
import View.Login.Splash_Screen;
import View.Menu_Dashboard;
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

    private JMenu mnHome;
    private JMenuItem mntmAddCategory;
    private JDesktopPane desktopPane;

    public static void main(String[] args) {
        Panel_Test go = new Panel_Test();
        go.setVisible(true);
    }

    public Panel_Test() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Dashboard.class.getResource("/resource/sp (4).png")));
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

        
        // EDIT DI BAWAH untuk Login Register..

        


        // SAMPAI DI SINI

        setContentPane(desktopPane);
    }
}
