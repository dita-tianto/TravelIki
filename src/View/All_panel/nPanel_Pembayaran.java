package View.All_panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseAdapter;

import Model.Kategori;
import Model.Pembayaran;
// import View.Dialogue.Cat_update;

public class nPanel_Pembayaran extends JFrame {
    private static nPanel_Pembayaran frame;
    private static JDesktopPane desktopPane;
    private static JScrollPane scrollPane;
    private static JTextField tx_user;
    private static JButton btn_save;

    public static JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nPanel_Pembayaran pl = new nPanel_Pembayaran();
            pl.initialize();
        });
    }

    public void initialize() {
        // ==================================================================================================================================
        // FRAME UTAMA
        frame = new nPanel_Pembayaran();
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
        JLabel lbl_title = new JLabel("TABEL PEMBAYARAN");
        lbl_title.setFont(new Font("Poppins", Font.BOLD, 20));
        lbl_title.setForeground(Color.WHITE);
        lbl_title.setBounds(45, 20, 300, 50);
        desktopPane.add(lbl_title);

        // Tabel
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 120, 460, 300);
        desktopPane.add(scrollPane);
        Pembayaran.load_data_pembayaran();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();

                String index_1 = table.getModel().getValueAt(row, 0).toString();
                String index_2 = table.getModel().getValueAt(row, 1).toString();

                // Tampilkan dialog box

            }
        });

        // Nama
        JLabel lbl_user = new JLabel("ID PEMBAYARAN :");
        lbl_user.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setBounds(30, 100, 100, 10);
        desktopPane.add(lbl_user);

        tx_user = new JTextField(20);
        tx_user.setBounds(20, 115, 200, 20);
        desktopPane.add(tx_user);

        // Kategori
        JLabel kategori = new JLabel("DATE :");
        kategori.setFont(new Font("Poppins", Font.BOLD, 10));
        kategori.setForeground(Color.WHITE);
        kategori.setBounds(30, 140, 100, 10);
        desktopPane.add(kategori);

        tx_user = new JTextField(20);
        tx_user.setBounds(20, 155, 200, 20);
        desktopPane.add(tx_user);

        // Harga
        JLabel harga = new JLabel("BAYAR TIKET :");
        harga.setFont(new Font("Poppins", Font.BOLD, 10));
        harga.setForeground(Color.WHITE);
        harga.setBounds(30, 180, 100, 10);
        desktopPane.add(harga);

        tx_user = new JTextField(20);
        tx_user.setBounds(20, 195, 200, 20);
        desktopPane.add(tx_user);

        // Save Button
        btn_save = new JButton("Save");
        btn_save.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_save.setBackground(new Color(13, 108, 176));
        btn_save.setForeground(Color.WHITE);
        btn_save.setBounds(20, 230, 60, 20);

        desktopPane.add(btn_save);

        // ==================================================================================================================================
        // ACTION EVENT

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
