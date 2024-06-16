import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    public Main() {
        // Membuat JFrame
        JFrame frame = new JFrame("Button dengan Gambar");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        // Memuat gambar dari file (ganti dengan path file gambar Anda)
        ImageIcon icon = createImageIcon("src/resource/spls.png");
        
        // Jika gagal memuat gambar, gunakan ikon default
        if (icon != null) {
            // Mengatur ukuran gambar
            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Membuat tombol dengan teks dan gambar yang telah diatur ukurannya
            JButton button = new JButton("Klik Disini", scaledIcon);
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.BOTTOM);
        
            // Menambahkan tombol ke dalam JFrame
            frame.add(button);
        } else {
            // Jika gambar tidak dapat dimuat, tetap membuat tombol tanpa gambar
            JButton button = new JButton("Klik Disini");
            frame.add(button);
        }
        
        // Menampilkan JFrame
        frame.setVisible(true);
    }

    // Metode untuk memuat gambar dari file dan mengembalikan ImageIcon
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            try {
                BufferedImage img = ImageIO.read(new File(imgURL.getPath()));
                return new ImageIcon(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
