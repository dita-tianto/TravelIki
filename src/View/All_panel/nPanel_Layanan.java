package View.All_Panel;

import Controller.Insert_Layanan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import Model.Kategori;
import Model.Layanan;
import View.nDashboard_Admin;
import View.Dialogue.nDialog_Layanan;

public class nPanel_Layanan extends JFrame {
    private static nPanel_Layanan frame;
    public  static JDesktopPane desktopPane;
    private static JScrollPane scrollPane;
    private static JTextField tx_nama;
    private static JTextField tx_kategori; // ganti combo box
    private static JTextField tx_harga;
    private static JTextField tx_jenis; // ganti combo box
    private static JButton btn_save;
    private static JButton btn_back;

    public static JTable table = new JTable();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new nPanel_Layanan();
            frame.initialize();
        });
    }

    public nPanel_Layanan() {
        // ==================================================================================================================================
        // FRAME UTAMA
        // frame = new nPanel_Layanan();
        setTitle("Traveliki");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(810, 485); // Ubah ukuran sesuai kebutuhan
        setResizable(false);

        // Membuat desktopPane sebagai content pane utama
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane); // Menetapkan desktopPane sebagai content pane

        // Menampilkan gambar
        ImageIcon imageIcon = new ImageIcon("src/resource/panel.png");
        Image image = imageIcon.getImage().getScaledInstance(800, 450, Image.SCALE_SMOOTH);

        // Menambahkan latar belakang gambar ke desktopPane
        JLabel backgroundLabel = new JLabel(new ImageIcon(image));
        backgroundLabel.setBounds(0, 0, 800, 450);
        
        // Menempatkan latar belakang di lapisan terbawah
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE)); 
    }

    public void initialize() {

        // ==================================================================================================================================
        // KOMPONEN GUI

        // Judul
        JLabel lbl_title = new JLabel("TABEL LAYANAN");
        lbl_title.setFont(new Font("Poppins", Font.BOLD, 20));
        lbl_title.setForeground(Color.WHITE);
        lbl_title.setBounds(45, 20, 300, 50);
        desktopPane.add(lbl_title);

        // Tabel
        // table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 120, 460, 300);
        desktopPane.add(scrollPane);
        load_data();

        // Nama
        JLabel lbl_user = new JLabel("Nama Layanan :");
        lbl_user.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setBounds(30, 100, 100, 10);
        desktopPane.add(lbl_user);

        tx_nama = new JTextField(20);
        tx_nama.setBounds(20, 115, 200, 20);
        desktopPane.add(tx_nama);

        // Kategori
        JLabel lbl_kategori = new JLabel("Kategori :");
        lbl_kategori.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_kategori.setForeground(Color.WHITE);
        lbl_kategori.setBounds(30, 140, 100, 10);
        desktopPane.add(lbl_kategori);

        tx_kategori = new JTextField(20);
        tx_kategori.setBounds(20, 155, 200, 20);
        desktopPane.add(tx_kategori);

        // Harga
        JLabel lbl_harga = new JLabel("Harga :");
        lbl_harga.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_harga.setForeground(Color.WHITE);
        lbl_harga.setBounds(30, 180, 100, 10);
        desktopPane.add(lbl_harga);
        
        tx_harga = new JTextField(20);
        tx_harga.setBounds(20, 195, 200, 20);
        desktopPane.add(tx_harga);
        
        // Jenis
        JLabel lbl_jenis = new JLabel("Jenis :");
        lbl_jenis.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_jenis.setForeground(Color.WHITE);
        lbl_jenis.setBounds(30, 220, 100, 10);
        desktopPane.add(lbl_jenis);

        tx_jenis = new JTextField(20);
        tx_jenis.setBounds(20, 235, 200, 20);
        desktopPane.add(tx_jenis);
        
        // Save Button
        btn_save = new JButton("Save");
        btn_save.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_save.setBackground(new Color(13, 108, 176));
        btn_save.setForeground(Color.WHITE);
        btn_save.setBounds(20, 270, 60, 20);

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
                nDialog_Layanan dialog = new nDialog_Layanan();
                dialog.initialize();
                
                dialog.tx_id.setText(index_1);
                dialog.tx_nama.setText(index_2);
                dialog.tx_kategori.setText(index_3);
                dialog.tx_harga.setText(index_4);
                dialog.tx_jenis.setText(index_5);
                dialog.tx_status.setText(index_6);

            }
        });

        // Save button
        btn_save.addActionListener((ActionEvent e) -> {
            String nama = tx_nama.getText();
            int kategori = Kategori.get_kategori_by_name(tx_kategori.getText());
            // int kategori = Integer.parseInt(tx_kategori.getText());
            double harga = Double.parseDouble(tx_harga.getText());
            String jenis = tx_jenis.getText();

            new Insert_Layanan(nama, harga, kategori, jenis);

            load_data();

            // frame.dispose();
        });

        // Panel Back
        btn_back.addActionListener((ActionEvent e) -> {
            nDashboard_Admin.frame.setVisible(true);
            dispose();
        });

        // Memunculkan frame di tengah layar
        centerFrameOnScreen(this);

        // Menampilkan frame
        setVisible(true);
    }


    // Menempatkan frame di tengah layar
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
        Layanan.load_data_layanan();

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
