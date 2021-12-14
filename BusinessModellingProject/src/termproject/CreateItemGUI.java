package termproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CreateItemGUI extends JFrame {

	private JPanel pnlMain, pnlInput, pnlBtns;
	private JLabel lblItem_name, lblExpiration, lblItemID;
	private JTextField txtItem_name, txtExpiration;
	private JButton btnSubmit, btnCancel;
	JComboBox comboBoxItemType;
	String [] item_types = {"Luxury", "Essential", "Gift"};
	ArrayList<Item> item;
	int item_ID = 0;

	public CreateItemGUI( ArrayList<Item> refItem) {

		item = refItem;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblItem_name = new JLabel("Item name:");
		lblExpiration = new JLabel("Expiration:");

		txtItem_name = new JTextField();
		txtItem_name.setColumns(10);
		txtExpiration  = new JTextField();
		txtExpiration.setColumns(10);
		comboBoxItemType = new JComboBox(item_types);
		btnSubmit = new JButton("Submit"); //submit button
		btnCancel = new JButton("Cancel"); //cancel button

		pnlMain = new JPanel(new GridLayout(2,1));
				
		pnlInput = new JPanel(new GridLayout(4,1));
		//pnlInput.setAlignmentX(comboBoxItemType.CENTER_ALIGNMENT);
		pnlBtns = new JPanel();
		pnlInput.add(lblItem_name);
		pnlInput.add(txtItem_name);
		pnlInput.add(lblExpiration);
		pnlInput.add(txtExpiration);
		pnlInput.add(comboBoxItemType);
		pnlBtns.add(btnSubmit);
		pnlBtns.add(btnCancel);
		
		pnlMain.add(pnlInput);
		pnlMain.add(pnlBtns);
		add(pnlMain);

		btnSubmit.addActionListener(new ActionListener() { //when submit button is pressed
			public void actionPerformed(ActionEvent e) {
				// Read the data from the text fields
				String item_name = txtItem_name.getText();
				String expiration = txtExpiration.getText();
				String text = (String)comboBoxItemType.getSelectedItem();
				item_ID++;
				// Create a customer object using the data
				Item item1 = new Item(item_name, expiration, text, item_ID);
				item.add(item1); //adds object to list, list can be used as parameter
				dispose();
			}
		});
		btnCancel.addActionListener(new ActionListener() {  //when cancel button is pressed
			public void actionPerformed(ActionEvent e) {
				txtItem_name.setText("");
				txtExpiration.setText("");
			}
		});

	}

}