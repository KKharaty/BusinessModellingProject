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


public class DisplayItemGUI extends JFrame{
  
  JPanel pnl, qpnl;
	JLabel lblItems;
	JComboBox comboBoxItems;
	JButton btnHome;
	JComboBox<Integer> comboBoxItemQ;
	Integer [] quantity = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	ArrayList<ItemBasket> items_calc;
	
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
	    	qpnl = new JPanel(new GridLayout(1,1));
	    	lblItems = new JLabel("List of Items in Stock");
	    	//comboBoxCustomer = new JComboBox(gatherItemDetails());
	    	comboBoxItemQ = new JComboBox(quantity);
	    	comboBoxItems = new JComboBox(items.toArray());
	    	btnHome = new JButton("Return"); //Return button that will bring the user back to the home screen.
	    	qpnl.add(comboBoxItemQ);
	    	pnl.add(lblItems);
	    	pnl.add(comboBoxItems);
	    	pnl.add(qpnl);
	    	pnl.add(btnHome);
			add(pnl, BorderLayout.CENTER);
			
			
			//when add to basket button is pressed
			//save item and quantity
			 String item_chosen = (String)comboBoxItems.getSelectedItem();
			 Integer qty_chosen = (Integer)comboBoxItemQ.getSelectedItem();
		 	 
		 	if(item_chosen.equals("Luxury")){
					//calculate VAT
				}
			 
			 else if(item_chosen.equals("Essential")){
					//calculate VAT
				}
			 
			 else if(item_chosen.equals("Gift")){
					//calculate VAT
				}
		 
			 //save these to a list 
			 //ItemBasket basket = new ItemBasket(item_chosen, qty_chosen);
			 //items_calc.add(basket);
			
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
