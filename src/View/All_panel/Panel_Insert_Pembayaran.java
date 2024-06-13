package View.All_panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
<<<<<<< HEAD
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

public class Panel_Insert_Pembayaran extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public Panel_Insert_Pembayaran() {
		setBackground(SystemColor.activeCaption);
		setLayout(new MigLayout("", "[][grow][][96.00,grow][][grow][][grow][][grow]", "[grow][][][grow][][][grow]"));
		
		JLabel lblCategory = new JLabel("Category :");
		add(lblCategory, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 0,growx");
		
		JLabel lblDate = new JLabel("Date :");
		add(lblDate, "cell 2 0,alignx right");
		
		JDateChooser dateChooser = new JDateChooser();
		add(dateChooser, "cell 3 0,growx,aligny center");
		
		JLabel lblCustomarName = new JLabel("Customar Name :");
		add(lblCustomarName, "cell 4 0");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 7 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblProduct = new JLabel("Product :");
		add(lblProduct, "cell 0 1,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "cell 1 1,growx");
		
		JLabel lblQuantity = new JLabel("Quantity :");
		add(lblQuantity, "cell 2 1,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 3 1,growx");
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		add(btnEnter, "cell 4 1");
		
		JButton btnNew = new JButton("New");
		add(btnNew, "cell 7 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 3 4 4,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		panel.setBackground(SystemColor.inactiveCaption);
		add(panel, "cell 4 3 6 4,grow");
		panel.setLayout(null);
		
		JLabel lblTotalamount = new JLabel("Total-Amount :");
		lblTotalamount.setBounds(10, 11, 72, 14);
		panel.add(lblTotalamount);
		
		JLabel lblPaid = new JLabel("Paid :");
		lblPaid.setBounds(10, 36, 46, 14);
		panel.add(lblPaid);
		
		JLabel lblDue = new JLabel("Due:");
		lblDue.setBounds(10, 60, 46, 14);
		panel.add(lblDue);
		
		JCheckBox chckbxBalanced = new JCheckBox("Balanced");
		chckbxBalanced.setBounds(6, 81, 97, 23);
		panel.add(chckbxBalanced);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 8, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 33, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 57, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(107, 180, 89, 23);
		panel.add(btnSave);

	}

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
>>>>>>> cd4fc13c803cb07c673b859b8e970f490d64465d
}
