package View.Login;

import Controller.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login_Pengguna extends JFrame {

    public static Login_Pengguna window;
    private JTextField username;
    private JPasswordField password;
    private JToggleButton tglbtnNewToggleButton;
    private JDesktopPane desktopPane;
    public static JFrame frmLoginPanel;

    /**
     * Create the application.
     */
    public Login_Pengguna() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                window = new Login_Pengguna();
                window.setVisible(true);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                System.err.println(e);
            }
        });
    }


    private void initialize() {
        setTitle("Welcome To, Traveliki🦇");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(445, 100, 890, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to maximize

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        desktopPane = new JDesktopPane() {
            private Image image;
            {
                try {
                    // Load the background image
                    image = ImageIO.read(Login_Pengguna.class.getResource("/resource/RevDoneAcc1.png"));
                } catch (IOException e) {
                    System.err.println(e);
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        contentPane.add(desktopPane, BorderLayout.CENTER);
        desktopPane.setLayout(null);

        addLoginComponents();

    }

    private void addLoginComponents() {
        // Tambahkan semua komponen GUI pada desktopPane

        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblUsername.setBounds(785, 48, 120, 30); // Sesuaikan bounds agar lebih besar
        desktopPane.add(lblUsername);

        username = new JTextField();
        username.setBounds(885, 48, 250, 30); // Perbesar ukuran dan sesuaikan posisi
        desktopPane.add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblPassword.setBounds(785, 84, 120, 30); // Tempatkan di bawah Username
        desktopPane.add(lblPassword);

        password = new JPasswordField();
        password.setColumns(10);
        password.setBounds(885, 84, 250, 30); // Tempatkan di bawah Username
        desktopPane.add(password);

        // Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener((ActionEvent arg0) -> {
            String give_username = username.getText();
            String give_password = new String(password.getPassword());

            Login.run_login(give_username, give_password);
        });
        btnLogin.setBounds(885, 165, 100, 30); // Adjusted position and size
        desktopPane.add(btnLogin);

        // Reset button
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener((ActionEvent arg0) -> {
            username.setText("");
            password.setText("");
        });
        btnReset.setBounds(1040, 165, 100, 30); // Adjusted posi tion and size
        desktopPane.add(btnReset);

        // Icon untuk field Username
        JLabel lblUsernameIcon = new JLabel();
        lblUsernameIcon.setIcon(new ImageIcon(Login_Pengguna.class.getResource("/resource/Vector.png")));
        lblUsernameIcon.setBounds(1140, 48, 50, 30); // Sesuaikan posisinya
        desktopPane.add(lblUsernameIcon);

        // icon password
        tglbtnNewToggleButton = new JToggleButton("");
        tglbtnNewToggleButton.setIcon(new ImageIcon(Login_Pengguna.class.getResource("/resource/eye.png")));
        tglbtnNewToggleButton.addActionListener((ActionEvent arg0) -> {
            if (tglbtnNewToggleButton.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        });

        tglbtnNewToggleButton.setBounds(1140, 84, 34, 30);
        desktopPane.add(tglbtnNewToggleButton);

        // Label for "Already have an account?"
        JLabel lblNotRegisterYet = new JLabel("Sudah punya akun?");
        lblNotRegisterYet.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNotRegisterYet.setBounds(885, 195, 150, 20); // Adjusted position
        desktopPane.add(lblNotRegisterYet);

        // Label for "Register here"
        JLabel lblRegisterHere = new JLabel("Daftar dulu sini !!!");
        lblRegisterHere.setForeground(new Color(0, 51, 153));
        lblRegisterHere.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRegisterHere.setBounds(1040, 195, 150, 20); // Adjusted position with increased x-value for spacing

        lblRegisterHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // Register_Pengguna loginReg = new Register_Pengguna();
                Register_Pengguna.main(null);
            }
        });
        desktopPane.add(lblRegisterHere);

    }
}
