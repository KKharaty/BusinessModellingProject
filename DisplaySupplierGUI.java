

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;



public class DisplaySupplierGUI extends JFrame {
	JPanel pnl;
	JLabel lblSuppliers;
	JComboBox comboBoxSuppliers;
	JButton btnHome;
	
	ArrayList<Supplier> sup;
	
	public DisplaySupplierGUI(ArrayList<Supplier> refSupplierList)
	{	sup = refSupplierList;
		createGUI();
	}
	
	public String[] gatherCustDetails()
	{
		String[] supplierNames = new String [sup.size()];
		
			for(int i = 0; i < sup.size(); i++)
			{
				String allSupplier = "";
				Supplier supplier = sup.get(i);
				String name = sup.toString();
				supplierNames[i] = name;
			}
		return supplierNames;
	}
	
    public void createGUI() {

    	pnl = new JPanel();
    	lblSuppliers = new JLabel("List of Supplier");
    	//comboBoxCustomer = new JComboBox(gatherCustDetails());
    	comboBoxSuppliers = new JComboBox(sup.toArray());
    	btnHome = new JButton("Return");
    	pnl.add(lblSuppliers);
    	pnl.add(comboBoxSuppliers);
    	pnl.add(btnHome);
		add(pnl, BorderLayout.CENTER);
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}


	public static void main(String[] args) {
		DisplaySupplierGUI displayGUI = new DisplaySupplierGUI(new ArrayList());
		displayGUI.setTitle("Display Suppliers");
		displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayGUI.setSize(300, 300);
		displayGUI.setVisible(true);

	}

}
