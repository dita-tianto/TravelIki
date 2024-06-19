package View.All_Panel;

import Model.Pengguna;
import View.nDashboard_Admin;
import View.Dialogue.nDialog_Account;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import Controller.Insert_Pengguna;

public class nPanel_Account extends JFrame {
    private static nPanel_Account frame;
    private static JDesktopPane desktopPane;
    private static JScrollPane scrollPane;
    private static JTextField tx_user;
    private static JTextField tx_email;
    private static JTextField tx_telp;
    private static JTextField tx_pass;
    private static JTextField tx_role;
    private static JButton btn_save;
    private static JButton btn_back;

    public static JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nPanel_Account pl = new nPanel_Account();
            pl.initialize();
        });
    }

    public void initialize() {
        // ==================================================================================================================================
        // FRAME UTAMA
        frame = new nPanel_Account();
        frame.setTitle("Traveliki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 485); // Ubah ukuran sesuai kebutuhan
        frame.setResizable(false);

        // Membuat desktopPane sebagai content pane utama
        desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane); // Menetapkan desktopPane sebagai content pane

        // Menampilkan gambar
        ImageIcon imageIcon = new ImageIcon("src/resource/panel.png");
        Image image = imageIcon.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);

        // Menambahkan latar belakang gambar ke desktopPane
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setBounds(0, 0, 800, 450);
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE)); // Menempatkan latar belakang di lapisan
                                                                              // terbawah

        // ==================================================================================================================================
        // KOMPONEN GUI

        // Judul
        JLabel lbl_title = new JLabel("TABEL ACCOUNT");
        lbl_title.setFont(new Font("Poppins", Font.BOLD, 20));
        lbl_title.setForeground(Color.WHITE);
        lbl_title.setBounds(45, 20, 300, 50);
        desktopPane.add(lbl_title);

        // Tabel
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 120, 460, 300);
        desktopPane.add(scrollPane);
        load_data();

        // Username
        JLabel lbl_user = new JLabel("Username :");
        lbl_user.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setBounds(30, 100, 100, 10);
        desktopPane.add(lbl_user);

        tx_user = new JTextField(20);
        tx_user.setBounds(20, 115, 200, 20);
        desktopPane.add(tx_user);

        // Email
        JLabel lbl_email = new JLabel("Email :");
        lbl_email.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_email.setForeground(Color.WHITE);
        lbl_email.setBounds(30, 140, 100, 10);
        desktopPane.add(lbl_email);

        tx_email = new JTextField(20);
        tx_email.setBounds(20, 155, 200, 20);
        desktopPane.add(tx_email);

        // No Telepon
        JLabel lbl_telp = new JLabel("No Telepon :");
        lbl_telp.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_telp.setForeground(Color.WHITE);
        lbl_telp.setBounds(30, 180, 100, 10);
        desktopPane.add(lbl_telp);

        tx_telp = new JTextField(20);
        tx_telp.setBounds(20, 195, 200, 20);
        desktopPane.add(tx_telp);

        // Password
        JLabel lbl_pass = new JLabel("Password :");
        lbl_pass.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_pass.setForeground(Color.WHITE);
        lbl_pass.setBounds(30, 220, 100, 10);
        desktopPane.add(lbl_pass);

        tx_pass = new JTextField(20);
        tx_pass.setBounds(20, 235, 200, 20);
        desktopPane.add(tx_pass);

        // Role
        JLabel lbl_role = new JLabel("Role :");
        lbl_role.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_role.setForeground(Color.WHITE);
        lbl_role.setBounds(30, 260, 100, 10);
        desktopPane.add(lbl_role);

        tx_role = new JTextField(20);
        tx_role.setBounds(20, 275, 200, 20);
        desktopPane.add(tx_role);

        // Save Button
        btn_save = new JButton("Save");
        btn_save.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_save.setBackground(new Color(13, 108, 176));
        btn_save.setForeground(Color.WHITE);
        btn_save.setBounds(20, 310, 60, 20);

        desktopPane.add(btn_save);

        // Back Button
        btn_back = new JButton("<");
        btn_back.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_back.setBackground(new Color(13, 108, 176));
        btn_back.setForeground(Color.WHITE);
        btn_back.setBounds(0, 0, 25, 25);

        desktopPane.add(btn_back);

        // ==================================================================================================================================
        // ACTION EVENT

        // Table Click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();

                String index_1 = table.getModel().getValueAt(row, 0).toString();
                String index_2 = table.getModel().getValueAt(row, 1).toString();
                String index_3 = table.getModel().getValueAt(row, 2).toString();
                String index_4 = table.getModel().getValueAt(row, 3).toString();
                String index_5 = table.getModel().getValueAt(row, 4).toString();
                String index_6 = table.getModel().getValueAt(row, 5).toString();

                // Tampilkan dialog box
                nDialog_Account dialog = new nDialog_Account();
                dialog.initialize();
                
                dialog.tx_id.setText(index_1);
                dialog.tx_user.setText(index_2);
                dialog.tx_email.setText(index_3);
                dialog.tx_telp.setText(index_4);
                dialog.tx_pass.setText(index_5);
                dialog.tx_role.setText(index_6);

            }
        });

        // Save button
        btn_save.addActionListener((ActionEvent e) -> {
            String user = tx_user.getText();
            String email = tx_email.getText();
            String telp = tx_telp.getText();
            String pass = tx_pass.getText();
            String role = tx_role.getText();

            new Insert_Pengguna(user, email, telp, pass, role);

            load_data();

            // frame.dispose();
        });

        // Button Back
        btn_back.addActionListener((ActionEvent e) -> {
            nDashboard_Admin.frame.setVisible(true);
            
            frame.dispose();
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

    // Menyesuaikan ukuran kolom secara otomatis
    public static void load_data() {
        Pengguna.load_data_pengguna();

        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Minimum width
            for (int row = 0; row < table.getRowCount(); row++) {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300; // Max width
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
