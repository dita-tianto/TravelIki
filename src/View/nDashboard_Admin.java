package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class nDashboard_Admin extends JFrame {
    private static nDashboard_Admin frame;
    private static JDesktopPane desktopPane;
    private static JButton btn_panel_1;
    private static JButton btn_panel_2;
    private static JButton btn_panel_3;
    private static JButton btn_panel_4;
    private static JButton btn_panel_5;
    private static JButton btn_panel_6;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initialize();
        });
    }

    private static void initialize() {
        // ==================================================================================================================================
        // FRAME UTAMA
        frame = new nDashboard_Admin();
        frame.setTitle("Traveliki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 485); // Ubah ukuran sesuai kebutuhan
        frame.setResizable(false);

        // Membuat desktopPane sebagai content pane utama
        desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane); // Menetapkan desktopPane sebagai content pane

        // Menampilkan gambar
        ImageIcon imageIcon = new ImageIcon("src/resource/dashboard.png");
        Image image = imageIcon.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);

        // Menambahkan latar belakang gambar ke desktopPane
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setBounds(0, 0, 800, 450);
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE)); // Menempatkan latar belakang di lapisan
                                                                              // terbawah

        // ==================================================================================================================================
        // KOMPONEN GUI

        // Panel Button
        ImageIcon icon_1 = new ImageIcon("src/resource/spls.png");
        Image scld_icon_1 = icon_1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        btn_panel_1 = new JButton("Login1", new ImageIcon(scld_icon_1));
        
        btn_panel_1.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_1.setVerticalTextPosition(JButton.BOTTOM);

        btn_panel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_1.setBackground(new Color(43, 150, 227));
        btn_panel_1.setForeground(Color.WHITE);
        btn_panel_1.setBounds(50, 150, 200, 120);

        

        desktopPane.add(btn_panel_1);

        btn_panel_2 = new JButton("Login2");
        btn_panel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_2.setBackground(new Color(43, 150, 227));
        btn_panel_2.setForeground(Color.WHITE);
        btn_panel_2.setBounds(300, 150, 200, 120);

        desktopPane.add(btn_panel_2);

        btn_panel_3 = new JButton("Login3");
        btn_panel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_3.setBackground(new Color(43, 150, 227));
        btn_panel_3.setForeground(Color.WHITE);
        btn_panel_3.setBounds(550, 150, 200, 120);

        desktopPane.add(btn_panel_3);

        btn_panel_4 = new JButton("Login4");
        btn_panel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_4.setBackground(new Color(43, 150, 227));
        btn_panel_4.setForeground(Color.WHITE);
        btn_panel_4.setBounds(50, 300, 200, 120);

        desktopPane.add(btn_panel_4);

        btn_panel_5 = new JButton("Login5");
        btn_panel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_5.setBackground(new Color(43, 150, 227));
        btn_panel_5.setForeground(Color.WHITE);
        btn_panel_5.setBounds(300, 300, 200, 120);

        desktopPane.add(btn_panel_5);

        btn_panel_6 = new JButton("Login6");
        btn_panel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_6.setBackground(new Color(43, 150, 227));
        btn_panel_6.setForeground(Color.WHITE);
        btn_panel_6.setBounds(550, 300, 200, 120);

        desktopPane.add(btn_panel_6);

        // ==================================================================================================================================
        // ACTION EVENT

        // Panel button
        btn_panel_1.addActionListener((ActionEvent e) -> {
            btn_panel_1();
        });

        // Panel button
        btn_panel_2.addActionListener((ActionEvent e) -> {
            btn_panel_2();
        });

        // Panel button
        btn_panel_3.addActionListener((ActionEvent e) -> {
            btn_panel_3();
        });

        // Panel button
        btn_panel_4.addActionListener((ActionEvent e) -> {
            btn_panel_4();
        });

        // Panel button
        btn_panel_5.addActionListener((ActionEvent e) -> {
            btn_panel_5();
        });

        // Panel button
        btn_panel_6.addActionListener((ActionEvent e) -> {
            btn_panel_6();
        });

        // Memunculkan frame di tengah layar
        centerFrameOnScreen(frame);

        // Menampilkan frame
        frame.setVisible(true);
    }

    private static void btn_panel_1() {
        System.out.println("btn_panel_1");
    }

    private static void btn_panel_2() {
        System.out.println("btn_panel_2");
    }

    private static void btn_panel_3() {
        System.out.println("btn_panel_3");
    }

    private static void btn_panel_4() {
        System.out.println("btn_panel_4");
    }

    private static void btn_panel_5() {
        System.out.println("btn_panel_5");
    }

    private static void btn_panel_6() {
        System.out.println("btn_panel_6");
    }

    // menempatkan frame di tengah layar
    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Mendapatkan ukuran layar saat ini
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = frame.getSize().width; // Mendapatkan ukuran frame
        int frameHeight = frame.getSize().height;

        int x = (screenWidth - frameWidth) / 2; // Menghitung posisi x dan y untuk frame di tengah layar
        int y = (screenHeight - frameHeight) / 2;

        frame.setLocation(x, y); // Menetapkan posisi frame di tengah layar
    }
}
