package View.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseAdapter;

public class nLogin_User extends JFrame {
    private static nLogin_User frame;
    private static JDesktopPane desktopPane;
    private static JTextField tx_user;
    private static JPasswordField tx_pass;
    private static JButton btn_show_pass;
    private static JButton btn_login;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initialize();
        });
    }

    private static void initialize() {
// ==================================================================================================================================
    // FRAME UTAMA
        frame = new nLogin_User();
        frame.setTitle("Traveliki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400); // Ubah ukuran sesuai kebutuhan
        frame.setResizable(false);

        // Membuat desktopPane sebagai content pane utama
        desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane); // Menetapkan desktopPane sebagai content pane

        // Menampilkan gambar
        ImageIcon imageIcon = new ImageIcon("src/resource/login.png");
        Image image = imageIcon.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);

        // Menambahkan latar belakang gambar ke desktopPane
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setBounds(0, 0, 800, 400);
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE)); // Menempatkan latar belakang di lapisan terbawah

// ==================================================================================================================================
    // KOMPONEN GUI
        
        // Username
        JLabel lbl_user = new JLabel("Username:");
        lbl_user.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setBounds(490, 135, 120, 10);
        desktopPane.add(lbl_user);

        tx_user = new JTextField(20);
        tx_user.setBounds(480, 150, 250, 30);
        desktopPane.add(tx_user);

        // Password
        JLabel lbl_pass = new JLabel("Password:");
        lbl_pass.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_pass.setForeground(Color.WHITE);
        lbl_pass.setBounds(490, 185, 120, 10);
        desktopPane.add(lbl_pass);

        tx_pass = new JPasswordField(20);
        tx_pass.setBounds(480, 200, 250, 30);
        desktopPane.add(tx_pass);

        // Show Password
        JLabel lbl_show_pass = new JLabel("Show password");
        lbl_show_pass.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_show_pass.setForeground(Color.WHITE);
        lbl_show_pass.setBounds(500, 240, 120, 10);
        desktopPane.add(lbl_show_pass);

        btn_show_pass = new JButton();
        btn_show_pass.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_show_pass.setBackground(Color.WHITE); // Warna latar belakang tombol
        btn_show_pass.setBounds(480, 240, 15, 15);
        
        desktopPane.add(btn_show_pass);        

        // Login Button
        btn_login = new JButton("Login");
        btn_login.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_login.setBackground(new Color(13, 108, 176));
        btn_login.setForeground(Color.WHITE);
        btn_login.setBounds(620, 240, 110, 30);
        
        desktopPane.add(btn_login);

        // Register Menu
        JLabel register = new JLabel("Don't have account?");
        register.setFont(new Font("Poppins", Font.BOLD, 10));
        register.setForeground(Color.WHITE);
        register.setBounds(490, 300, 120, 10);
        desktopPane.add(register);
        
        JLabel click_here = new JLabel("Click here!");
        click_here.setFont(new Font("Poppins", Font.BOLD, 10));
        click_here.setForeground(new Color(13, 108, 176));
        click_here.setBounds(600, 300, 120, 10);
        
        desktopPane.add(click_here);

// ==================================================================================================================================
    // ACTION EVENT

        // Login button
        btn_login.addActionListener((ActionEvent e) -> {
            String username = tx_user.getText();
            String password = new String(tx_pass.getPassword());
            
            // Contoh validasi sederhana
            if (username.equals("admin") && password.equals("admin123")) { // belum di ubah
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                // Lakukan tindakan setelah login berhasil di sini
            } else {
                JOptionPane.showMessageDialog(frame, "Login Failed. Invalid username or password.");
                // Lakukan tindakan setelah login gagal di sini
            }
        });

        // Show password
        btn_show_pass.addActionListener((ActionEvent e) -> {
            // Toggle EchoChar untuk menampilkan/menyembunyikan password
            if (tx_pass.getEchoChar() == '\u2022') { // Jika saat ini ditampilkan dengan karakter tersembunyi
                tx_pass.setEchoChar((char) 0); // Tampilkan teks asli
                lbl_show_pass.setText("Hide Password");
                btn_show_pass.setBackground(new Color(13, 108, 176)); // Warna latar belakang tombol
            } else {
                tx_pass.setEchoChar('\u2022'); // Gunakan karakter tersembunyi (bintang)
                lbl_show_pass.setText("Show Password");
                btn_show_pass.setBackground(Color.WHITE); // Warna latar belakang tombol
            }
        });

        // Register Here
        click_here.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                click_here.setForeground(Color.WHITE);
                System.out.println("CLICKED");

            }

            @Override
            public void mouseReleased(MouseEvent e){
                click_here.setForeground(new Color(13, 108, 176));
                System.out.println("RELEASED");
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    System.err.println(e);
                }
                System.out.println("Login");
            }
            
        });

        // Memunculkan frame di tengah layar
        centerFrameOnScreen(frame);

        // Menampilkan frame
        frame.setVisible(true);
    }

    public static void register() {
        
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
