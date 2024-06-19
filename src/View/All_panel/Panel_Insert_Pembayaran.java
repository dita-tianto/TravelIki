package View.All_Panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Controller.Get_Category_data;
import Model.Enums;
import Model.Kategori;
import Model.Pembayaran;
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
import com.toedter.calendar.JDateChooser;


public class Panel_Insert_Pembayaran extends JPanel {
    private JTextField name;
    private JTextField price;
    public static JTable table;
    private JComboBox<Enums.status> cmb;

    public Panel_Insert_Pembayaran() {
        setForeground(new Color(0, 51, 204));
        setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][grow]"));

        JLabel lblCategoryName = new JLabel("id_Pembayaran :");
        add(lblCategoryName, "cell 1 0");

        name = new JTextField();
        add(name, "cell 4 0,growx");
        name.setColumns(10);

        JLabel lblDate = new JLabel("Date :");
        add(lblDate, "cell 1 1,alignx trailing");

        JDateChooser dateChooser = new JDateChooser();
        add(dateChooser, "cell 4 1,growx");

        JLabel lblPrice = new JLabel("Bayar : ");
        add(lblPrice, "cell 1 2");

        price = new JTextField();
        add(price, "cell 4 2,growx");
        price.setColumns(10);

        JLabel lblStatus = new JLabel("Status Pembayaran : ");
        add(lblStatus, "cell 1 3");

        cmb = new JComboBox<>();
        cmb.setModel(new DefaultComboBoxModel<>(Enums.status.values()));
        add(cmb, "cell 4 3,growx");

        JButton save = new JButton("Save");
        save.addActionListener((ActionEvent arg0) -> {
            if (name.getText().isEmpty() || price.getText().isEmpty() || dateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            } else {
                Pembayaran.load_data_pembayaran();
            }
        });
        add(save, "cell 4 4");

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 5 5 1,grow");

        table = new JTable();
        scrollPane.setViewportView(table);

        Pembayaran.load_data_pembayaran();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                String serviceName = table.getModel().getValueAt(row, 0).toString();
                String paymentStatus = table.getModel().getValueAt(row, 1).toString();

                Product_category productCategory = new Product_category();
                int id = productCategory.get_cat_id(serviceName);

                Cat_update catUpdate = new Cat_update(id);
                catUpdate.txf_id.setText(serviceName);
                catUpdate.comboBox.setSelectedItem(paymentStatus);
                catUpdate.setVisible(true);
            }
        });
    }
}


// supaya bisa commit : )
// tes

//dikumpulno