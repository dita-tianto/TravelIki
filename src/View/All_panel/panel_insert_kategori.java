package View.All_Panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
import Model.Kategori;
import Model.Product_category;
import View.Dialogue.Cat_update;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Panel_Insert_Kategori extends JPanel {
	private JTextField name;
	public static JTable table;
	Product_category is = new Product_category();

	/**
	 * Create the panel.
	 */
	public Panel_Insert_Kategori() {

		setForeground(new Color(0, 51, 204));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][grow]"));

		JLabel lblCategoryName = new JLabel("Nama Kategori : ");
		add(lblCategoryName, "cell 1 0");

		name = new JTextField();
		add(name, "cell 4 0,growx");
		name.setColumns(10);

		JButton save = new JButton("Save");
		save.addActionListener((ActionEvent arg0) -> {
                    String nama_kategori = name.getText();
                    
                    if (nama_kategori.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nama Kategori tidak boleh kosong");
                    } else {
                        Kategori.load_data_kategori();
                    }
                });

		add(save, "cell 4 2");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 4 5 1,grow");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();

				String get1stColumeValue_name = table.getModel().getValueAt(row, 0).toString();

				Product_category product_category = new Product_category();
				int id = product_category.get_cat_id(get1stColumeValue_name);

				Cat_update cat_update = new Cat_update(id);
				cat_update.textField.setText(get1stColumeValue_name);

				cat_update.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
	}
}
