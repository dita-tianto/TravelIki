package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
import Model.Product_category;
import Model.Status;
import View.Dialogue.Cat_update;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class panel_insert_layanan extends JPanel {
    private JTextField name;
    private JTextField description;
    private JTextField price;
    public static JTable table;
    private JComboBox<String> cmb;
    private Product_category is = new Product_category();

    /**
     * Create the panel.
     */
    public panel_insert_layanan() {

        setForeground(new Color(0, 51, 204));
        setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][][grow]"));

        // Label and text field for service name
        JLabel lblServiceName = new JLabel("Nama Layanan : ");
        add(lblServiceName, "cell 1 0");

        name = new JTextField();
        add(name, "cell 4 0,growx");
        name.setColumns(10);

        // Label and text field for description
        JLabel lblDescription = new JLabel("Nama Deskripsi : ");
        add(lblDescription, "cell 1 1");

        description = new JTextField();
        add(description, "cell 4 1,growx");
        description.setColumns(10);

        // Label and text field for price
        JLabel lblPrice = new JLabel("Harga : ");
        add(lblPrice, "cell 1 2");

        price = new JTextField();
        add(price, "cell 4 2,growx");
        price.setColumns(10);

        // Label and combo box for payment status
        JLabel lblStatus = new JLabel("Status Pembayaran : ");
        add(lblStatus, "cell 1 3");

        Status Status = new Status();
        ArrayList<String> status = new ArrayList<>(Status.return_status());

        cmb = new JComboBox<>();
        cmb.setModel(new DefaultComboBoxModel<>(status.toArray(new String[0])));
        add(cmb, "cell 4 3,growx");

        // Save button
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String serviceName = name.getText();
                String serviceDescription = description.getText();
                String servicePrice = price.getText();
                String serviceStatus = cmb.getSelectedItem().toString();

                if (cmb.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Select Status");
                } else {
                    // Save service data (adapt as necessary for your data model)
                    Get_Category_data getCategoryData = new Get_Category_data(serviceName, serviceStatus);
                    // Add saving logic for description and price here

                    loadServiceData();
                }
            }
        });
        add(save, "cell 4 4");

        // Scroll pane and table
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 5 5 1,grow");

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nama Layanan", "Nama Deskripsi", "Harga", "Status Pembayaran"}
        ));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    String serviceName = table.getModel().getValueAt(row, 0).toString();
                    String serviceDescription = table.getModel().getValueAt(row, 1).toString();
                    String servicePrice = table.getModel().getValueAt(row, 2).toString();
                    String serviceStatus = table.getModel().getValueAt(row, 3).toString();

                    Product_category productCategory = new Product_category();
                    int id = productCategory.get_cat_id(serviceName);

                    Cat_update catUpdate = new Cat_update(id);
                    catUpdate.textField.setText(serviceName);
                    catUpdate.descriptionField.setText(serviceDescription);
                    catUpdate.priceField.setText(servicePrice);
                    catUpdate.comboBox.setSelectedItem(serviceStatus);

                    catUpdate.setVisible(true);
                }
            }
        });
        scrollPane.setViewportView(table);

        // Load data into the table initially
        loadServiceData();
    }

    private void loadServiceData() {
        // Dummy data for demonstration
        Object[][] data = {
            {"Service1", "Description1", "1000", "Active"},
            {"Service2", "Description2", "2000", "Inactive"}
        };

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object[] row : data) {
            model.addRow(row);
        }
    }
}
