package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Get_Category_data;
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

public class Panel_Insert_Pembayaran extends JPanel {
    private JTextField name;
    private JTextField paymentDate;
    private JTextField amountPaid;
    private JTextField orderId;
    public static JTable table;
    Product_category is = new Product_category();

    /**
     * Create the panel.
     */
    public Panel_Insert_Pembayaran() {

        setForeground(new Color(0, 51, 204));
        setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][][][][grow]"));

        JLabel lblCategoryName = new JLabel("Nama Kategori : ");
        add(lblCategoryName, "cell 1 0");

        name = new JTextField();
        add(name, "cell 4 0,growx");
        name.setColumns(10);

        JLabel lblPaymentDate = new JLabel("Tanggal Pembayaran : ");
        add(lblPaymentDate, "cell 1 1");

        paymentDate = new JTextField();
        add(paymentDate, "cell 4 1,growx");
        paymentDate.setColumns(10);

        JLabel lblAmountPaid = new JLabel("Bayar : ");
        add(lblAmountPaid, "cell 1 2");

        amountPaid = new JTextField();
        add(amountPaid, "cell 4 2,growx");
        amountPaid.setColumns(10);

        JLabel lblOrderId = new JLabel("ID Pesanan : ");
        add(lblOrderId, "cell 1 3");

        orderId = new JTextField();
        add(orderId, "cell 4 3,growx");
        orderId.setColumns(10);

        JButton save = new JButton("Bayar");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String Cat_name = name.getText();
                String Payment_Date = paymentDate.getText();
                String Amount_Paid = amountPaid.getText();
                String Order_ID = orderId.getText();

                if (Cat_name.isEmpty() || Payment_Date.isEmpty() || Amount_Paid.isEmpty() || Order_ID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi");
                } else {
                    Get_Category_data get_Category_data = new Get_Category_data(Cat_name, Payment_Date, Amount_Paid, Order_ID);
                    is.load();
                }
            }
        });

        add(save, "cell 4 4");

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

                Cat_update cat_update = new Cat_update(id);
                cat_update.textField.setText(get1stColumeValue_name);

                cat_update.setVisible(true);
            }
        });
        scrollPane.setViewportView(table);
    }
}
