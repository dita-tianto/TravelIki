package View.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Splash_Screen {
	public static void main(String[] args) throws InterruptedException {
		initialize();
	}

	public static void initialize() throws InterruptedException {
		showSplash();
		nLogin_User lg = new nLogin_User();
		lg.initialize();
	}

	public static void showSplash() throws InterruptedException {
		// Membuat splash screen kustom menggunakan JWindow
		JWindow splash = new JWindow();

		// Panel untuk konten splash screen
		JPanel content = new JPanel(new BorderLayout());

		// Gambar splash
        ImageIcon imageIcon = new ImageIcon("src/resource/splash.png");
        Image image = imageIcon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
        
		JLabel splashLabel = new JLabel(new ImageIcon(image));
		splash.setBounds(480, 250, 500, 350);

		content.add(splashLabel, BorderLayout.CENTER);

		// Progress bar
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(13, 108, 176)); // Warna progress bar
		progressBar.setStringPainted(true);
		content.add(progressBar, BorderLayout.SOUTH);

		splash.setContentPane(content);
		splash.pack();
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);

		// Simulasi proses loading
		for (int i = 0; i <= 100; i++) {
			progressBar.setValue(i);
			Thread.sleep(50); // Simulasi waktu loading
		}

		// affff
		splash.setVisible(false);
		splash.dispose();
	}
}

