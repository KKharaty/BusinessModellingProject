package termproject;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class DisplayItemGUI {
  
  JPanel pnl;
	JLabel lblItems;
	JComboBox comboBoxItems;
	JButton btnHome;
	
	ArrayList<Item> items;
	
	public DisplayItemGUI(ArrayList<Item> itemlist)
	{	items = itemlist;
		createGUI();
	}
	
	public String[] gatherItemDetails()
	{
		String[] itemNames = new String [items.size()];
		
			for(int i = 0; i < items.size(); i++)
			{
				String allItem = "";
				Item item = items.get(i);
				String itemname = item.toString();
				itemNames[i] = itemname;
			}
		return itemNames;
	}
	
	 public void createGUI() {

	    	pnl = new JPanel();
	    	lblItems = new JLabel("List of Items in Stock");
	    	//comboBoxCustomer = new JComboBox(gatherItemDetails());
	    	comboBoxItems = new JComboBox(items.toArray());
	    	btnHome = new JButton("Return"); //Return button that will bring the user back to the home screen.
	    	pnl.add(lblItems);
	    	pnl.add(comboBoxItems);
	    	pnl.add(btnHome);
			add(pnl, BorderLayout.CENTER);
			
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			
		}
	 
	 public static void main(String[] args) {
			DisplayItemGUI displayGUI = new DisplayItemGUI(new ArrayList());
			displayGUI.setTitle("Display Items in Stock");
			displayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			displayGUI.setSize(300, 300);
			displayGUI.setVisible(true);

		}
	

}
