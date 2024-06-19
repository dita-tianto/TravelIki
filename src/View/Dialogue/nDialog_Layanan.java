package View.Dialogue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.Update_Layanan;
import Model.Kategori;
import Model.Layanan;
import View.All_Panel.nPanel_Layanan;

// import Model.Layanan;
// import View.nDashboard_Admin;
// import View.Dialogue.Cat_update;

// import org.w3c.dom.events.MouseEvent;

// import Model.Layanan;
// import View.All_Panel.nDialog_Layanan;

public class nDialog_Layanan extends JFrame {
    private static nDialog_Layanan frame;
    private static JDesktopPane desktopPane;
    public JTextField tx_id;
    public JTextField tx_nama;
    public JTextField tx_kategori; // ganti combo box
    public JTextField tx_deskripsi; // ganti text area
    public JTextField tx_harga;
    public JTextField tx_status; // ganti combo box
    public JTextField tx_jenis; // ganti combo box
    private static JButton btn_update;
    private static JButton btn_delete;
    private static JButton btn_back;

    // public static JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nDialog_Layanan dl = new nDialog_Layanan();
            dl.initialize();
        });
    }

    public void initialize() {
        // ==================================================================================================================================
        // FRAME UTAMA
        frame = new nDialog_Layanan();
        frame.setTitle("Traveliki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 485); // Ubah ukuran sesuai kebutuhan
        frame.setResizable(false);

        // Membuat desktopPane sebagai content pane utama
        desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane); // Menetapkan desktopPane sebagai content pane

        // Menampilkan gambar
        ImageIcon imageIcon = new ImageIcon("src/resource/dialog.png");
        Image image = imageIcon.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);

        // Menambahkan latar belakang gambar ke desktopPane
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setBounds(0, 0, 400, 450);
        
        // Menempatkan latar belakang di lapisan terbawah
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE)); 

        // ==================================================================================================================================
        // KOMPONEN GUI

        // ID
        JLabel lbl_id = new JLabel("ID Layanan :");
        lbl_id.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_id.setForeground(Color.WHITE);
        lbl_id.setBounds(30, 100, 100, 10);
        desktopPane.add(lbl_id);

        tx_id = new JTextField(20);
        tx_id.setBounds(150, 100, 200, 20);
        tx_id.setEditable(false);
        desktopPane.add(tx_id);

        // Nama
        JLabel lbl_nama = new JLabel("Nama Layanan :");
        lbl_nama.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_nama.setForeground(Color.WHITE);
        lbl_nama.setBounds(30, 130, 100, 10);
        desktopPane.add(lbl_nama);

        tx_nama = new JTextField(20);
        tx_nama.setBounds(150, 130, 200, 20);
        desktopPane.add(tx_nama);

        // Kategori
        JLabel lbl_kategori = new JLabel("Kategori :");
        lbl_kategori.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_kategori.setForeground(Color.WHITE);
        lbl_kategori.setBounds(30, 160, 100, 10);
        desktopPane.add(lbl_kategori);

        tx_kategori = new JTextField(20);
        tx_kategori.setBounds(150, 160, 200, 20);
        desktopPane.add(tx_kategori);

        // Deskripsi
        JLabel lbl_deskripsi = new JLabel("Deskripsi :");
        lbl_deskripsi.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_deskripsi.setForeground(Color.WHITE);
        lbl_deskripsi.setBounds(30, 190, 100, 10);
        desktopPane.add(lbl_deskripsi);

        tx_deskripsi = new JTextField(20);
        tx_deskripsi.setBounds(150, 190, 200, 20);
        desktopPane.add(tx_deskripsi);

        // Harga
        JLabel lbl_harga = new JLabel("Harga :");
        lbl_harga.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_harga.setForeground(Color.WHITE);
        lbl_harga.setBounds(30, 220, 100, 10);
        desktopPane.add(lbl_harga);

        tx_harga = new JTextField(20);
        tx_harga.setBounds(150, 220, 200, 20);
        desktopPane.add(tx_harga);

        // Jenis
        JLabel lbl_jenis = new JLabel("Jenis :");
        lbl_jenis.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_jenis.setForeground(Color.WHITE);
        lbl_jenis.setBounds(30, 250, 100, 10);
        desktopPane.add(lbl_jenis);

        tx_jenis = new JTextField(20);
        tx_jenis.setBounds(150, 250, 200, 20);
        desktopPane.add(tx_jenis);

        // Status
        JLabel lbl_status = new JLabel("Status :");
        lbl_status.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_status.setForeground(Color.WHITE);
        lbl_status.setBounds(30, 280, 100, 10);
        desktopPane.add(lbl_status);

        tx_status = new JTextField(20);
        tx_status.setBounds(150, 280, 200, 20);
        desktopPane.add(tx_status);

        // Update Button
        btn_update = new JButton("Update");
        btn_update.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_update.setBackground(new Color(30, 140, 227));
        btn_update.setForeground(Color.WHITE);
        btn_update.setBounds(150, 310, 90, 20);

        desktopPane.add(btn_update);

        // Delete Button
        btn_delete = new JButton("Delete");
        btn_delete.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_delete.setBackground(new Color(30, 140, 227));
        btn_delete.setForeground(Color.WHITE);
        btn_delete.setBounds(260, 310, 90, 20);

        desktopPane.add(btn_delete);

        // Back Button
        btn_back = new JButton("<");
        btn_back.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_back.setBackground(new Color(13, 108, 176));
        btn_back.setForeground(Color.WHITE);
        btn_back.setBounds(0, 0, 25, 25);

        desktopPane.add(btn_back);

        // ==================================================================================================================================
        // ACTION EVENT

        // Tambah Layanan
        btn_update.addActionListener((ActionEvent e) -> {
            // String Cat_name = txf_id.getText();
            int id = Integer.parseInt(tx_id.getText());
            String nama = tx_nama.getText();
            String deskripsi = tx_deskripsi.getText();
            int kategori = Kategori.get_kategori_by_name(tx_kategori.getText());
            double harga = Double.parseDouble(tx_harga.getText());
            String status = tx_status.getText();
            String jenis = tx_jenis.getText();

            new Update_Layanan(id, nama, deskripsi, harga, kategori, status, jenis);

            nPanel_Layanan.load_data();

            frame.dispose();
        });

        // Delete Layanan
				btn_delete.addActionListener((ActionEvent arg0) -> {
					Layanan.delete_layanan(Integer.parseInt(tx_id.getText()));
					nPanel_Layanan.load_data();
                    frame.dispose();
				});

        // Panel Back
        btn_back.addActionListener((ActionEvent e) -> {
            System.out.println("UDAN DERES");

            // nDashboard_Admin.frame.setVisible(true);

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

}
