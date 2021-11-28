

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MainWindowGUI extends JFrame {
	JPanel pnlSupplier;
	JButton btnCreateSupplier;
	JButton btnShowSupplier;
	ArrayList<Supplier> supList;
	
	public MainWindowGUI()
	{	
		createGUI();
	}
	
	
	
    public void createGUI() {
    	supList = new ArrayList<Supplier>();
    	pnlSupplier = new JPanel();
    	btnCreateSupplier = new JButton("Create");
    	btnShowSupplier = new JButton("Display All");

    	pnlSupplier.add(btnCreateSupplier);
    	pnlSupplier.add(btnShowSupplier);
		add(pnlSupplier, BorderLayout.CENTER);
		
		btnCreateSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierGUI supframe = new SupplierGUI(supList);
				supframe.setTitle("Supplier Details");
				supframe.setSize(400, 300);
				supframe.setVisible(true);
			}
		});
		
		btnShowSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplaySupplierGUI supDisplayframe = new DisplaySupplierGUI(supList);
				supDisplayframe.setTitle("Show Suppliers");
				supDisplayframe.setSize(400, 300);
				supDisplayframe.setVisible(true);
			}
		});
		
		
	}


	public static void main(String[] args) {
		MainWindowGUI mainGUI = new MainWindowGUI();
		mainGUI.setTitle("Main Windiow");
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setSize(400, 300);
		mainGUI.setVisible(true);

	}

}
