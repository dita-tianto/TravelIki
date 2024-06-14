package View.Dialogue;

import Controller.Update_Kategori;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Update_cat;
import Model.Kategori;
import Model.Pengguna;
import Model.Product_category;
import Model.Status;
import View.All_panel.Panel_Insert_Layanan;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cat_update extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txf_id;
	public static JTextField txf_kategori;
	public JComboBox comboBox;
	private JButton okButton;
	public Object descriptionField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Cat_update(int ID) {
		setBackground(new Color(0, 51, 153));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][grow][][][][grow]", "[][][][][][]"));

		JLabel lbl_id = new JLabel("ID Kategori ::");
		contentPanel.add(lbl_id, "cell 0 1,alignx trailing");

		txf_id = new JTextField();
		contentPanel.add(txf_id, "cell 2 1 2 1,growx");
		txf_id.setColumns(10);
		txf_id.setEditable(false);

		JLabel lbl_kategori = new JLabel("Nama Kategori ::");
		contentPanel.add(lbl_kategori, "cell 0 2,align trailing");

		txf_kategori = new JTextField();
		contentPanel.add(txf_kategori, "cell 2 2 2 1,growx");
		txf_kategori.setColumns(10);

		// {
		// Status Status = new Status();
		// ArrayList<String> status = new ArrayList<>();
		// status = Status.return_status();

		// comboBox = new JComboBox();

		// contentPanel.add(comboBox, "cell 2 2 2 1,growx");
		// comboBox.setModel(new DefaultComboBoxModel<>(status.toArray()));
		// }
		{

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Update");
				btnNewButton.addActionListener((ActionEvent e) -> {
					// String Cat_name = txf_id.getText();
					String nama_kategori = txf_kategori.getText();

					// Add_category Add_categor=new Add_category();

					new Update_Kategori(ID, nama_kategori);

					Kategori.load_data_kategori();

					Cat_update.this.dispose();
				});
				buttonPane.add(btnNewButton);
			}
			{
				okButton = new JButton("Delete");
				okButton.addActionListener((ActionEvent arg0) -> {
					Kategori.delete_kategori(ID);
					Kategori.load_data_kategori();
					Cat_update.this.dispose();
				});

				buttonPane.add(okButton);

			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener((ActionEvent e) -> {
					Kategori.load_data_kategori();
					Cat_update.this.dispose();
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}

}
