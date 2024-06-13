package View.All_Panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Insert_Paket;
import Model.Product_category;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Panel_Insert_Paket extends JPanel {
    private JTextField packageName;
    private JTextField description;
    private JTextField price;
    private JTextField categoryId;
    private JTextField serviceId;
    public static JTable table;
    Product_category is = new Product_category();

    /**
     * Create the panel.
     */
    public Panel_Insert_Paket() {

        setForeground(new Color(0, 51, 204));
        setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][][][][grow]"));

        JLabel lblPackageName = new JLabel("Nama Paket: ");
        add(lblPackageName, "cell 1 0");

        packageName = new JTextField();
        add(packageName, "cell 4 0,growx");
        packageName.setColumns(10);

        JLabel lblDescription = new JLabel("Deskripsi: ");
        add(lblDescription, "cell 1 1");

        description = new JTextField();
        add(description, "cell 4 1,growx");
        description.setColumns(10);

        JLabel lblPrice = new JLabel("Harga: ");
        add(lblPrice, "cell 1 2");

        price = new JTextField();
        add(price, "cell 4 2,growx");
        price.setColumns(10);

        JLabel lblCategoryId = new JLabel("ID Kategori: ");
        add(lblCategoryId, "cell 1 3");

        categoryId = new JTextField();
        add(categoryId, "cell 4 3,growx");
        categoryId.setColumns(10);

        JLabel lblServiceId = new JLabel("ID Layanan: ");
        add(lblServiceId, "cell 1 4");

        serviceId = new JTextField();
        add(serviceId, "cell 4 4,growx");
        serviceId.setColumns(10);

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String Package_Name = packageName.getText();
                String Description = description.getText();
                String Price = price.getText();
                String Category_Id = categoryId.getText();
                String Service_Id = serviceId.getText();

                if (Package_Name.isEmpty() || Description.isEmpty() || Price.isEmpty() || Category_Id.isEmpty() || Service_Id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi");
                } else {
                    try {
                        double parsedPrice = Double.parseDouble(Price);
                        int parsedCategoryId = Integer.parseInt(Category_Id);
                        int parsedServiceId = Integer.parseInt(Service_Id);

                        Insert_Paket insertPaket = new Insert_Paket(Package_Name, Description, parsedPrice, parsedCategoryId, parsedServiceId);
                        JOptionPane.showMessageDialog(null, "Paket berhasil disimpan");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Harga, ID Kategori, dan ID Layanan harus berupa angka");
                    }
                }
            }
        });

        add(save, "cell 4 5");

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 7 5 1,grow");

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();

                String get1stColumeValue_name = table.getModel().getValueAt(row, 0).toString();

                Product_category product_category = new Product_category();
                int id = product_category.get_cat_id(get1stColumeValue_name);

                //Cat_update cat_update = new Cat_update(id);
                //cat_update.textField.setText(get1stColumeValue_name);

                //cat_update.setVisible(true);
            }
        });
        scrollPane.setViewportView(table);
    }
}
