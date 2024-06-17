package View;

import View.Login.nLogin_User;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class nDashboard_Admin extends JFrame {
    private static nDashboard_Admin frame;
    private static nLogin_User login;
    private static JDesktopPane desktopPane;
    private static JButton btn_logout;
    private static JButton btn_panel_1;
    private static JButton btn_panel_2;
    private static JButton btn_panel_3;
    private static JButton btn_panel_4;
    private static JButton btn_panel_5;
    private static JButton btn_panel_6;

    public void initialize() {
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


        // Info Login
        JLabel role_as = new JLabel("Login as : ");
        role_as.setFont(new Font("Poppins", Font.BOLD, 10));
        role_as.setForeground(Color.WHITE);
        role_as.setBounds(20, 420, 50, 20);
        
        desktopPane.add(role_as);
        
        JLabel log_role = new JLabel("CUSTOMER");
        log_role.setFont(new Font("Poppins", Font.BOLD, 10));
        log_role.setForeground(Color.WHITE);
        log_role.setBounds(70, 420, 100, 20);
        
        desktopPane.add(log_role);
        
        JLabel user_as = new JLabel("Username : ");
        user_as.setFont(new Font("Poppins", Font.BOLD, 10));
        user_as.setForeground(Color.WHITE);
        user_as.setBounds(170, 420, 100, 20);
        
        desktopPane.add(user_as);
        
        JLabel log_user = new JLabel("Fauzan Udan");
        log_user.setFont(new Font("Poppins", Font.BOLD, 10));
        log_user.setForeground(Color.WHITE);
        log_user.setBounds(230, 420, 200, 20);
        
        desktopPane.add(log_user);
        
        // Logout
        btn_logout = new JButton("Logout");
        btn_logout.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_logout.setBackground(new Color(43, 150, 227));
        btn_logout.setForeground(Color.WHITE);
        btn_logout.setBounds(720, 420, 65, 20);

        desktopPane.add(btn_logout);

        // Button 1
        ImageIcon icon_1 = new ImageIcon("src/resource/layanan.png");
        Image scld_icon_1 = icon_1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        btn_panel_1 = new JButton("Layanan", new ImageIcon(scld_icon_1));
        
        btn_panel_1.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_1.setVerticalTextPosition(JButton.BOTTOM);
        
        btn_panel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_1.setBackground(new Color(43, 150, 227));
        btn_panel_1.setForeground(Color.WHITE);
        btn_panel_1.setBounds(100, 150, 180, 100);

        desktopPane.add(btn_panel_1);

        // Button 2
        ImageIcon icon_2 = new ImageIcon("src/resource/pemesanan.png");
        Image scld_icon_2 = icon_2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        btn_panel_2 = new JButton("Pemesanan", new ImageIcon(scld_icon_2));
        
        btn_panel_2.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_2.setVerticalTextPosition(JButton.BOTTOM);
        
        btn_panel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_2.setBackground(new Color(43, 150, 227));
        btn_panel_2.setForeground(Color.WHITE);
        btn_panel_2.setBounds(310, 150, 180, 100);

        desktopPane.add(btn_panel_2);

        // Button 3
        ImageIcon icon_3 = new ImageIcon("src/resource/pembayaran.png");
        Image scld_icon_3 = icon_3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        btn_panel_3 = new JButton("Pembayaran", new ImageIcon(scld_icon_3));
        
        btn_panel_3.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_3.setVerticalTextPosition(JButton.BOTTOM);

        btn_panel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_3.setBackground(new Color(43, 150, 227));
        btn_panel_3.setForeground(Color.WHITE);
        btn_panel_3.setBounds(520, 150, 180, 100);

        desktopPane.add(btn_panel_3);

        // Button 4
        ImageIcon icon_4 = new ImageIcon("src/resource/kategori.png");
        Image scld_icon_4 = icon_4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        btn_panel_4 = new JButton("Kategori", new ImageIcon(scld_icon_4));
        
        btn_panel_4.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_4.setVerticalTextPosition(JButton.BOTTOM);

        btn_panel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_4.setBackground(new Color(43, 150, 227));
        btn_panel_4.setForeground(Color.WHITE);
        btn_panel_4.setBounds(100, 280, 180, 100);

        desktopPane.add(btn_panel_4);

        // Button 5
        ImageIcon icon_5 = new ImageIcon("src/resource/ulasan.png");
        Image scld_icon_5 = icon_5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        btn_panel_5 = new JButton("Ulasan", new ImageIcon(scld_icon_5));
        
        btn_panel_5.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_5.setVerticalTextPosition(JButton.BOTTOM);

        btn_panel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_5.setBackground(new Color(43, 150, 227));
        btn_panel_5.setForeground(Color.WHITE);
        btn_panel_5.setBounds(310, 280, 180, 100);

        desktopPane.add(btn_panel_5);

        // Button 6
        ImageIcon icon_6 = new ImageIcon("src/resource/account.png");
        Image scld_icon_6 = icon_6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        btn_panel_6 = new JButton("Account Center", new ImageIcon(scld_icon_6));
        
        btn_panel_6.setHorizontalTextPosition(JButton.CENTER);
        btn_panel_6.setVerticalTextPosition(JButton.BOTTOM);

        btn_panel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
        btn_panel_6.setBackground(new Color(43, 150, 227));
        btn_panel_6.setForeground(Color.WHITE);
        btn_panel_6.setBounds(520, 280, 180, 100);

        desktopPane.add(btn_panel_6);

        // ==================================================================================================================================
        // ACTION EVENT

        // Panel button 1
        btn_logout.addActionListener((ActionEvent e) -> {
            System.out.println("UDAN DERES");
            
            frame.dispose();
            login = new nLogin_User();
            login.initialize();
        });
        
        // Panel button 1
        btn_panel_1.addActionListener((ActionEvent e) -> {
            btn_panel_1();
        });

        // Panel button 2
        btn_panel_2.addActionListener((ActionEvent e) -> {
            btn_panel_2();
        });

        // Panel button 3
        btn_panel_3.addActionListener((ActionEvent e) -> {
            btn_panel_3();
        });

        // Panel button 4
        btn_panel_4.addActionListener((ActionEvent e) -> {
            btn_panel_4();
        });

        // Panel button 5
        btn_panel_5.addActionListener((ActionEvent e) -> {
            btn_panel_5();
        });

        // Panel button 6
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
