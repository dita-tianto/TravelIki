package View.All_Panel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
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

public class Panel_Insert_Ulasan extends JPanel {
    private JTextField userId;
    private JTextField serviceId;
    private JTextField packageId;
    private JTextField reviewDate;
    private JTextField comment;
    public static JTable table;
    Product_category is = new Product_category();

    /**
     * Create the panel.
     */
    public Panel_Insert_Ulasan() {

        setForeground(new Color(0, 51, 204));
        setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][][][][grow]"));

        JLabel lblUserId = new JLabel("ID Pengguna: ");
        add(lblUserId, "cell 1 0");

        userId = new JTextField();
        add(userId, "cell 4 0,growx");
        userId.setColumns(10);

        JLabel lblServiceId = new JLabel("ID Layanan: ");
        add(lblServiceId, "cell 1 1");

        serviceId = new JTextField();
        add(serviceId, "cell 4 1,growx");
        serviceId.setColumns(10);

        JLabel lblPackageId = new JLabel("ID Paket: ");
        add(lblPackageId, "cell 1 2");

        packageId = new JTextField();
        add(packageId, "cell 4 2,growx");
        packageId.setColumns(10);

        JLabel lblReviewDate = new JLabel("Tanggal Ulasan: ");
        add(lblReviewDate, "cell 1 3");

        reviewDate = new JTextField();
        add(reviewDate, "cell 4 3,growx");
        reviewDate.setColumns(10);

        JLabel lblComment = new JLabel("Komentar: ");
        add(lblComment, "cell 1 4");

        comment = new JTextField();
        add(comment, "cell 4 4,growx");
        comment.setColumns(10);

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String User_Id = userId.getText();
                String Service_Id = serviceId.getText();
                String Package_Id = packageId.getText();
                String Review_Date = reviewDate.getText();
                String Comment = comment.getText();

                if (User_Id.isEmpty() || Service_Id.isEmpty() || Package_Id.isEmpty() || Review_Date.isEmpty() || Comment.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi");
                } else {
                    Get_Category_data get_Category_data = new Get_Category_data(User_Id, Service_Id, Package_Id, Review_Date, Comment);
                    is.load();
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

                Cat_update cat_update = new Cat_update(id);
                cat_update.textField.setText(get1stColumeValue_name);

                cat_update.setVisible(true);
            }
        });
        scrollPane.setViewportView(table);
    }
}
