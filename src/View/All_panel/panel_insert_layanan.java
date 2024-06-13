package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
import Model.Kategori;
import Model.Product_category;
import Model.Status;
import View.Dialogue.Cat_update;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Panel_Insert_Layanan extends JPanel {
	private JTextField name;
	private JTextField description;
	private JTextField price;
	public static JTable table;
	Product_category is = new Product_category();
	private JComboBox cmb;

	/**
	 * Create the panel.
	 */
	public Panel_Insert_Layanan() {

		setForeground(new Color(0, 51, 204));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][grow]"));

		
		JLabel lblCategoryName = new JLabel("Name Kategori :");
		add(lblCategoryName, "cell 1 0");
		
		name = new JTextField();
		add(name, "cell 4 0,growx");
		name.setColumns(10);

		JLabel lblDescription = new JLabel("Deskripsi : ");
		add(lblDescription, "cell 1 1");

		description = new JTextField();
		add(description, "cell 4 1,growx");
		description.setColumns(10);

		JLabel lblPrice = new JLabel("Harga : ");
		add(lblPrice, "cell 1 2");

		price = new JTextField();
		add(price, "cell 4 2,growx");
		price.setColumns(10);

		JLabel lblStatus = new JLabel("Status Pembayaran : ");
		add(lblStatus, "cell 1 3");

		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String serviceName = name.getText();
				String descriptionText = description.getText();
				String priceText = price.getText();
				String paymentStatus = cmb.getSelectedItem().toString();

				if (cmb.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Pilih Status Pembayaran");
				} else {
					// Lakukan sesuatu dengan data yang disimpan
															

					is.load(); // Memuat ulang data yang mungkin diperlukan

				}
			}
		});

		Status status = new Status();
		ArrayList<String> paymentStatuses = new ArrayList<>(status.return_status());

		cmb = new JComboBox();
		cmb.setModel(new DefaultComboBoxModel<>(paymentStatuses.toArray()));
		add(cmb, "cell 4 3,growx");
		add(save, "cell 4 3");

		JScrollPane scrollPane = new JScrollPane();

		add(scrollPane, "cell 0 4 5 1,grow");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();

				String serviceName = table.getModel().getValueAt(row, 0).toString();
				String paymentStatus = table.getModel().getValueAt(row, 1).toString();

				Product_category productCategory = new Product_category();
				int id = productCategory.get_cat_id(serviceName);

				Cat_update catUpdate = new Cat_update(id);

				catUpdate.textField.setText(serviceName);
				catUpdate.comboBox.setSelectedItem(paymentStatus);

				catUpdate.setVisible(true);

			}
		});
		scrollPane.setViewportView(table);
		// is.load();

	}

}