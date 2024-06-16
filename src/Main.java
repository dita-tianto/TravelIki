import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    private JFrame frame;

    public Main() {
        // Membuat JFrame
        frame = new JFrame("JFrame Tanpa Title Bar");
        frame.setSize(400, 300);
        frame.setUndecorated(true); // Mengatur JFrame menjadi undecorated
        
        // Membuat panel sederhana untuk ditampilkan di JFrame
        JPanel panel = new JPanel();
        JLabel label = new JLabel("JFrame tanpa title bar");
        panel.add(label);
        
        // Membuat tombol close
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menutup JFrame saat tombol close diklik
                frame.dispose();
            }
        });
        
        // Menambahkan tombol close ke panel
        panel.add(closeButton);
        
        // Menambahkan panel ke dalam JFrame
        frame.add(panel, BorderLayout.CENTER);
        
        // Menampilkan JFrame
        frame.setVisible(true);
        
        // Mengatur posisi JFrame ke tengah layar
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
