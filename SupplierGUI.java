

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class SupplierGUI extends JFrame {

	private JPanel pnlMain, pnlInput, pnlBtns;
	private JLabel lblFirstname, lblSurname, lblProduct;
	private JTextField txtFirstname, txtSurname, txtProduct;
	private JButton btnSubmit, btnCancel;
	ArrayList<Supplier> sup;



	/**
	 * Create the frame.
	 */
	public SupplierGUI( ArrayList<Supplier> refSupplier) {
		sup = refSupplier;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        lblFirstname = new JLabel("First name:");
        lblSurname = new JLabel("Surname:");
        lblProduct = new JLabel("Product:");
        
		txtFirstname = new JTextField();
		txtFirstname.setColumns(10);
		txtSurname  = new JTextField();
		txtSurname.setColumns(10);
		txtProduct = new JTextField();
		txtProduct.setColumns(10);
		btnSubmit = new JButton("Submit");
		btnCancel = new JButton("Cancel");
		
		pnlMain = new JPanel(new GridLayout(2,1));

		pnlInput = new JPanel(new GridLayout(3,1));
		pnlBtns = new JPanel();
		pnlInput.add(lblFirstname);
		pnlInput.add(txtFirstname);
		pnlInput.add(lblSurname);
		pnlInput.add(txtSurname);
		pnlInput.add(lblProduct);
		pnlInput.add(txtProduct);
		pnlBtns.add(btnSubmit);
		pnlBtns.add(btnCancel);

		pnlMain.add(pnlInput);
		pnlMain.add(pnlBtns);
		add(pnlMain);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Read the data from the text fields
				String name = txtFirstname.getText();
				String surname = txtSurname.getText();
				String product = txtProduct.getText();
				// Create a customer object using the data
				Supplier sup1 = new Supplier(name, surname, product);
				sup.add(sup1);
				dispose();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFirstname.setText("");
				txtSurname.setText("");
				txtProduct.setText("");
			}
		});
	}

}
