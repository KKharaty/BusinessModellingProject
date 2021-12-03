package termproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;


public class Main {
	JFrame frame = new JFrame();
	JPanel outerPanel = new JPanel();
	JPanel insidePanel = new JPanel();
	JButton addItems = new JButton("Add Items");
	JButton viewItems = new JButton("View All Items");
	JFrame addItemsFrame = new JFrame();
	JFrame viewItemsFrame= new JFrame();

	public Main() {
		outerPanel.setLayout(new MigLayout());
		insidePanel.setLayout(new MigLayout());
		addItems.setSize(200, 40);
		viewItems.setSize(200, 40);

		frame.add(outerPanel);
		frame.add(insidePanel);
		insidePanel.add(addItems, "wrap, growx");
		insidePanel.add(viewItems, "wrap, growx");	
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		addItems.addActionListener(new option1());
		viewItems.addActionListener(new option2());

		}
	class option1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == addItems) {
				AddItems addItems = new AddItems();
			}
		}
	}

	class option2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == viewItems) {
				ViewItems viewItems = new ViewItems();

			}
		}
	}
	
	//AddItems
	public class AddItems extends JFrame {
		JFrame addItemsFrame = new JFrame();
		public AddItems() {
			addItemsFrame.setLayout(new MigLayout());
			addItemsFrame.setTitle("Add Items");
			addItemsFrame.setVisible(true);
			addItemsFrame.setLocationRelativeTo(null);
			addItemsFrame.setSize(200,200);

		}
	}
	
	//ViewAllI
	public class ViewItems extends JFrame {
		JFrame viewItemsFrame = new JFrame();
		public ViewItems() {
			viewItemsFrame.setLayout(new MigLayout());
			viewItemsFrame.setTitle("View Items");
			viewItemsFrame.setVisible(true);
			viewItemsFrame.setLocationRelativeTo(null);
			viewItemsFrame.setSize(200,200);

		}
	}

	public static void main(String[] args) {
		new Main();

	}
}
