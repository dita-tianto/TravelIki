package View.All_panel;

import Controller.Insert_Kategori;
import Model.Kategori;
import Model.Layanan;
import View.nDashboard_Admin;
import View.Dialogue.nDialog_Kategori;
import View.Dialogue.nDialog_Layanan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import Controller.Insert_Layanan;

public class nPanel_Kategori extends JFrame {
    private static nPanel_Kategori frame;
    private static JDesktopPane desktopPane;
    private static JScrollPane scrollPane;
    private static JTextField tx_nama;
    private static JButton btn_save;
    private static JButton btn_back;

    public static JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            nPanel_Kategori pk = new nPanel_Kategori();
            pk.initialize();
        });
    }

    public void initialize() {
        // ==================================================================================================================================
        // FRAME UTAMA
        frame = new nPanel_Kategori();
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
        JLabel lbl_title = new JLabel("TABEL KATEGORI");
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

        // Nama
        JLabel lbl_nama = new JLabel("Nama Kategori :");
        lbl_nama.setFont(new Font("Poppins", Font.BOLD, 10));
        lbl_nama.setForeground(Color.WHITE);
        lbl_nama.setBounds(30, 100, 100, 10);
        desktopPane.add(lbl_nama);

        tx_nama = new JTextField(20);
        tx_nama.setBounds(20, 115, 200, 20);
        desktopPane.add(tx_nama);

        // Save Button
        btn_save = new JButton("Save");
        btn_save.setFont(new Font("Poppins", Font.PLAIN, 10));
        btn_save.setBackground(new Color(13, 108, 176));
        btn_save.setForeground(Color.WHITE);
        btn_save.setBounds(20, 150, 60, 20);

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

                // Tampilkan dialog box
                nDialog_Kategori dialog = new nDialog_Kategori();
                dialog.initialize();

                dialog.tx_id.setText(index_1);
                dialog.tx_nama.setText(index_2);

            }
        });

        // Save button
        btn_save.addActionListener((ActionEvent e) -> {
            String nama = tx_nama.getText();

            new Insert_Kategori(nama);

            load_data();

            // frame.dispose();
        });

        // Panel Back
        btn_back.addActionListener((ActionEvent e) -> {
            nDashboard_Admin.frame.setVisible(true);
            dispose();
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
        Kategori.load_data_kategori();
        
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
