package termproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class Main {
	private JFrame mainFrame = new JFrame("Login");
	private JPanel login_Panel = new JPanel();
	private JLabel userLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JTextField userTextField = new JTextField(20);
	private JPasswordField passwordTextField = new JPasswordField(20);
	private JButton loginButton = new JButton("Login");
	private JButton cancelButton = new JButton("Cancel");
	private JCheckBox showPassword = new JCheckBox("Show Password");

	private static final String[] price_Sports = { "29.99", "32.00", "89.99" };
	private static final String[] price_Veg = { "1.99", "1.80", "0.90" };
	private static final String[] price_Tech = { "899.99", "1200.00", "425.99" };

	List<Product> products = new ArrayList<>();
	private ProductTabelModel tableModel = new ProductTabelModel(products);
	private JTable productTable = new JTable(tableModel);
	private JScrollPane productPane = new JScrollPane(productTable);

	List<User> userList = new ArrayList<>();
	UserTableModel userModel = new UserTableModel(userList);
	JTable userTable = new JTable(userModel);
	JScrollPane userPane = new JScrollPane(userTable);

	double totalPrice;
	double earnings = 0;
	String s = "Cost  :";
	Random rand = new Random(); // instance of random class
	int upperbound = 10000;

	JOptionPane optionPane = new JOptionPane("Incorrect Username or Password", JOptionPane.ERROR_MESSAGE);

	public Main() {
		mainFrame.setLayout(new MigLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adding some initial users to the linkedList
		User user1 = new User("Kavon", "Kharaty", "1");
		User user2 = new User("Rod", "Omosigho", "9827");
		User user3 = new User("Emma", "Mc Guinness", "846");
		User user4 = new User("Franklyn", "Okanume", "2457");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		// Sports Section
		products.add(new Product("Football", 29.99));
		products.add(new Product("Basketball", 32.00));
		products.add(new Product("Boxing Gloves", 89.99));
		// Fuit&Veg Section
		products.add(new Product("Tomato", 1.99));
		products.add(new Product("Orange", 1.80));
		products.add(new Product("Apple", .90));
		// Tech Section
		products.add(new Product("Phone", 899.99));
		products.add(new Product("Laptop", 1200.00));
		products.add(new Product("Camera", 425.99));

		login_Panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		login_Panel.setLayout(new MigLayout());
		login_Panel.add(userLabel, "right");
		login_Panel.add(userTextField, "growx, left, wrap, w 100");
		login_Panel.add(passwordLabel, "right");
		login_Panel.add(passwordTextField, "growx, left, wrap, w 100");
		login_Panel.add(showPassword, "wrap, spanx");
		login_Panel.add(loginButton, "split 2, span 2, center");
		login_Panel.add(cancelButton, "tag cancel");
		mainFrame.add(login_Panel);
		mainFrame.add(login_Panel, BorderLayout.CENTER);
		mainFrame.setTitle("Login");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);

		loginButton.addActionListener(new loginAction(userList, products));
		showPassword.addActionListener(new passwordAction());
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.setVisible(false);;
			}

		});
	}

	// login action Listener
	class loginAction implements ActionListener {
		List<User> userList;
		List<Product> products;

		public loginAction(List<User> userList, List<Product> products) {
			this.userList = userList;
			this.products = products;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String user = userTextField.getText();
			String password = passwordTextField.getText();

			if (user.equalsIgnoreCase("Kavon") && password.equalsIgnoreCase("123")) {
				System.out.println("Admin LoggedIn");
				System.out.println(user + " " + password );

				mainFrame.setVisible(false);
				AdminWindow adminWindow = new AdminWindow();
			} else {
				User aUser;
				int userFound = 0;

				if (!userList.isEmpty()) {
					for (Iterator i = userList.iterator(); i.hasNext();) {
						aUser = (User) i.next();
						if (user.equalsIgnoreCase(aUser.getFirstName())
								&& password.equalsIgnoreCase(aUser.getEmployeeNumber())) {
							optionWindow optionWindow = new optionWindow();
							System.out.println("Employee has logged in");
							System.out.println(user + "," + password);
							userFound = 1;
							mainFrame.setVisible(false);
							break;
						}

					}

					if (userFound == 0) {
						JDialog dialog = optionPane.createDialog("Failure");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
				}
			}
		}
	}

	// option1 Action listener
	class passwordAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == showPassword) {
				if (showPassword.isSelected()) {
					passwordTextField.setEchoChar((char) 0);
				} else {
					passwordTextField.setEchoChar('*');
				}
			}

		}
	}

	/****************************************************************************************************************************************************************/
	public class AdminWindow extends JFrame {

		JFrame frame = new JFrame();
		JPanel outerPanel = new JPanel();
		JPanel insidePanel = new JPanel();
		JButton option1 = new JButton("Sports Section");
		JButton option2 = new JButton("Fruit&Veg Section");
		JButton option3 = new JButton("Technology Section");
		JButton option4 = new JButton("View products");
		JButton option5 = new JButton("View Users");
		JButton option6 = new JButton("Checkout");
		JButton option7 = new JButton("Total Sales");
		JButton option8 = new JButton("Log Out");

		List<Product> products = new ArrayList<>();

		AdminWindow() {
			outerPanel.setLayout(new MigLayout());
			insidePanel.setLayout(new MigLayout());
			option1.setSize(200, 40);
			option2.setSize(200, 40);
			option3.setSize(200, 40);
			option4.setSize(200, 40);
			option5.setSize(200, 40);
			option6.setSize(200, 40);
			option7.setSize(200, 40);
			option7.setSize(200, 40);

			frame.add(outerPanel);
			frame.add(insidePanel);
			insidePanel.add(option1, "wrap, growx");
			insidePanel.add(option2, "wrap, growx");
			insidePanel.add(option3, "wrap");
			insidePanel.add(option4, "growx, wrap");
			insidePanel.add(option5, "growx, wrap");
			insidePanel.add(option6, "growx, wrap");
			insidePanel.add(option7, "growx, wrap");
			insidePanel.add(option8, "growx");

			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(getParent());

			option1.addActionListener(new option1());
			option2.addActionListener(new option2());
			option3.addActionListener(new option3());
			option4.addActionListener(new option4());
			option5.addActionListener(new option5());
			option6.addActionListener(new option6());
			option7.addActionListener(new option7());
			option8.addActionListener(new option8());

		}

		class option1 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option1) {
					Option1 option1 = new Option1();
				}
			}
		}

		class option2 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option2) {
					Option2 option2 = new Option2();

				}
			}
		}

		class option3 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option3) {
					Option3 option3 = new Option3();

				}
			}
		}

		class option4 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option4) {
					AdminOption4 adminOption4 = new AdminOption4();

				}
			}
		}

		class option5 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option5) {
					AdminOption5 adminOption5 = new AdminOption5();

				}
			}
		}

		class option6 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option6) {
					AdminOption6 adminOption6 = new AdminOption6();

				}
			}
		}

		class option7 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option7) {
					AdminOption7 adminOption7 = new AdminOption7();

				}
			}
		}

		class option8 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == option8) {
					frame.setVisible(false);
					mainFrame.setVisible(true);
					

				}
			}
		}

	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class optionWindow extends JFrame {
		
		ImageIcon footballImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_football_172468.png");
		ImageIcon basketballImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_basketball_993997.png");
		ImageIcon boxingImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_Boxing_Gloves_22976.png");
				

		JFrame frame = new JFrame();
		JPanel outerPanel = new JPanel();
		JPanel insidePanel = new JPanel();
		JButton option1 = new JButton("Customer");
		JButton option2 = new JButton("Supplier");
		JButton option3 = new JButton("Stock");
		JButton option4 = new JButton("Order");
		JButton option5 = new JButton("Log out");
		JButton football = new JButton("Football", footballImage);
		JButton basketball = new JButton("Basketball", basketballImage);
		JButton boxing = new JButton("Boxing Gloves", boxingImage);
		
		

		optionWindow() {
			outerPanel.setLayout(new MigLayout());
			insidePanel.setLayout(new MigLayout());
			insidePanel.add(football);
			insidePanel.add(basketball);
			insidePanel.add(boxing, "wrap");
			option1.setSize(200, 40);
			option2.setSize(200, 40);
			option3.setSize(200, 40);
			option4.setSize(200, 40);
			option5.setSize(200, 40);

			frame.add(outerPanel);
			frame.add(insidePanel);
			insidePanel.add(option1, "wrap, growx, span");
			insidePanel.add(option2, "wrap, growx, span");
			insidePanel.add(option3, "wrap, growx, span"
					+ "");
			insidePanel.add(option4, "growx, wrap, span");
			insidePanel.add(option5, "growx, span");
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(getParent());

			option1.addActionListener(new option1());
			option2.addActionListener(new option2());
			option3.addActionListener(new option3());
			option4.addActionListener(new option4());
			option5.addActionListener(new option5());

		}

		class option1 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option1) {
					Option1 option1 = new Option1();
				}
			}
		}

		class option2 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option2) {
					Option2 option2 = new Option2();

				}
			}
		}

		class option3 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option3) {
					Option3 option3 = new Option3();

				}
			}
		}

		class option4 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option4) {
					AdminOption6 adminOption6 = new AdminOption6();
				}
			}
		}

		class option5 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == option5) {
					frame.setVisible(false);
					mainFrame.setVisible(true);
				}
			}
		}

	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class Option1 extends JFrame {

		JFrame frame = new JFrame();
		ImageIcon footballImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_football_172468.png");
		ImageIcon basketballImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_basketball_993997.png");
		ImageIcon boxingImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_Boxing_Gloves_22976.png");

		JPanel veg_Panel = new JPanel(new MigLayout());
		JPanel price_Panel = new JPanel(new MigLayout());
		JLabel label = new JLabel(s.concat(price_Sports[0]));
		JLabel label2 = new JLabel(s.concat(price_Sports[1]));
		JLabel label3 = new JLabel(s.concat(price_Sports[2]));
		JLabel quantity_football = new JLabel("Football : Quantity to sell ");
		JLabel quantity_basketball = new JLabel("Basketball : Quantity to sell ");
		JLabel quantity_boxing = new JLabel("Boxing Gloves : Quantity to sell");
		JLabel price_Label = new JLabel();
		JButton football = new JButton("Football", footballImage);
		JButton basketball = new JButton("Basketball", basketballImage);
		JButton boxing = new JButton("Boxing Gloves", boxingImage);
		JButton sell = new JButton("Add To Cart");
		JTextField football_Quantity = new JTextField(10);
		JTextField basketball_Quantity = new JTextField(10);
		JTextField boxing_Quantity = new JTextField(10);
		JSeparator seperator1 = new JSeparator();
		JSeparator seperator2 = new JSeparator();

		public Option1() {
			frame.setLayout(new MigLayout());
			frame.setTitle("Customer");
//			veg_Panel.add(label, "wrap");
//			veg_Panel.add(football, "wrap, growx");
//			veg_Panel.add(quantity_football, "wrap");
//			veg_Panel.add(football_Quantity, "growx, left, wrap, w 100");
//			veg_Panel.add(seperator1, "wrap");
//
//			veg_Panel.add(label2, "wrap");
//			veg_Panel.add(basketball, "wrap, growx");
//			veg_Panel.add(quantity_basketball, "wrap");
//			veg_Panel.add(basketball_Quantity, "growx, left, wrap, w 100");
//			veg_Panel.add(seperator2, "wrap");
//
//			veg_Panel.add(label3, "wrap");
//			veg_Panel.add(boxing, "wrap, growx");
//			veg_Panel.add(quantity_boxing, "wrap");
//			veg_Panel.add(boxing_Quantity, "growx, left, wrap, w 100");
//
//			veg_Panel.add(sell);
			frame.setLocationRelativeTo(rootPane);

			frame.add(veg_Panel);
			frame.pack();
			frame.setVisible(true);

			sell.addActionListener(new sell());
		}

		class sell implements ActionListener {
			String p = "The price is :";

			@Override
			public void actionPerformed(ActionEvent e) {
				String f_q = football_Quantity.getText();
				String b_q = basketball_Quantity.getText();
				String bx_q = boxing_Quantity.getText();

				if (f_q.isEmpty()) {
					f_q = "0";
				}
				if (b_q.isEmpty()) {
					b_q = "0";
				}
				if (bx_q.isEmpty()) {
					bx_q = "0";
				}

				frame.setVisible(false);

				double price;
				price = Float.parseFloat(f_q) * Float.parseFloat(price_Sports[0])
						+ Float.parseFloat(b_q) * Float.parseFloat(price_Sports[1])
						+ Float.parseFloat(bx_q) * Float.parseFloat(price_Sports[2]);
				totalPrice = totalPrice + price;
				frame.getContentPane().remove(veg_Panel);
				price_Label.setText(p.concat(toString(price)));
				price_Panel.add(price_Label, "wrap");
				frame.add(price_Panel);

			}

			public String toString(Double price) {

				return ": " + price;

			}

		}
	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class Option2 extends JFrame {

		JFrame frame = new JFrame();
		ImageIcon tomatoImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_vegetables_flat_7_4569260.png");
		ImageIcon orangeImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_Fruits_-_Color-02_4619640.png");
		ImageIcon appleImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_icon_fruit_maca_3316506.png");
		JPanel veg_Panel = new JPanel(new MigLayout());
		JPanel price_Panel = new JPanel(new MigLayout());
		JLabel label = new JLabel(s.concat(price_Veg[0]));
		JLabel label2 = new JLabel(s.concat(price_Veg[1]));
		JLabel label3 = new JLabel(s.concat(price_Veg[2]));
		JLabel quantity_tomato = new JLabel("Tomato : Quantity to sell ");
		JLabel quantity_orange = new JLabel("Orange : Quantity to sell ");
		JLabel quantity_apple = new JLabel("Apple : Quantity to sell");
		JLabel price_Label = new JLabel();
		JButton tomato = new JButton("Tomato", tomatoImage);
		JButton orange = new JButton("Orange", orangeImage);
		JButton apple = new JButton("Apple", appleImage);
		JButton sell = new JButton("Add To Cart");
		JTextField tomato_Quantity = new JTextField(10);
		JTextField orange_Quantity = new JTextField(10);
		JTextField apple_Quantity = new JTextField(10);
		JSeparator seperator1 = new JSeparator();
		JSeparator seperator2 = new JSeparator();

		public Option2() {
			frame.setLayout(new MigLayout());
			frame.setTitle("Fruit&Veg Section");
//			veg_Panel.add(label, "wrap");
//			veg_Panel.add(tomato, "wrap, growx");
//			veg_Panel.add(quantity_tomato, "wrap");
//			veg_Panel.add(tomato_Quantity, "growx, left, wrap, w 100");
//			veg_Panel.add(seperator1, "wrap");
//
//			veg_Panel.add(label2, "wrap");
//			veg_Panel.add(orange, "wrap, growx");
//			veg_Panel.add(quantity_orange, "wrap");
//			veg_Panel.add(orange_Quantity, "growx, left, wrap, w 100");
//			veg_Panel.add(seperator2, "wrap");
//
//			veg_Panel.add(label3, "wrap");
//			veg_Panel.add(apple, "wrap, growx");
//			veg_Panel.add(quantity_apple, "wrap");
//			veg_Panel.add(apple_Quantity, "growx, left, wrap, w 100");
//
//			veg_Panel.add(sell);
			frame.setLocationRelativeTo(rootPane);

			frame.add(veg_Panel);
			frame.pack();
			frame.setVisible(true);

			sell.addActionListener(new sell());
		}

		class sell implements ActionListener {
			String p = "The price is :";

			@Override
			public void actionPerformed(ActionEvent e) {
				String t_q = tomato_Quantity.getText();
				String o_q = orange_Quantity.getText();
				String a_q = apple_Quantity.getText();
				if (t_q.isEmpty()) {
					t_q = "0";
				}
				if (o_q.isEmpty()) {
					o_q = "0";
				}
				if (a_q.isEmpty()) {
					a_q = "0";
				}
				frame.setVisible(false);

				double price;
				price = Float.parseFloat(t_q) * Float.parseFloat(price_Veg[0])
						+ Float.parseFloat(o_q) * Float.parseFloat(price_Veg[1])
						+ Float.parseFloat(a_q) * Float.parseFloat(price_Veg[2]);
				totalPrice = totalPrice + price;
				frame.getContentPane().remove(veg_Panel);
				price_Label.setText(p.concat(toString(price)));
				price_Panel.add(price_Label, "wrap");
				frame.add(price_Panel);

			}

			public String toString(Double price) {
				return ": " + price;

			}

		}
	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class Option3 extends JFrame {

		JFrame frame = new JFrame();
		ImageIcon phoneImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_phone_sale_shop_4177582.png");
		ImageIcon laptopImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_root-access_4417096.png");
		ImageIcon cameraImage = new ImageIcon(
				"/Users/kavonkharaty/eclipse-workspace/term-project/images/iconfinder_icons_photo_1564522.png");

		JPanel tech_Panel = new JPanel(new MigLayout());
		JPanel price_Panel = new JPanel(new MigLayout());
		JLabel label = new JLabel(s.concat(price_Tech[0]));
		JLabel label2 = new JLabel(s.concat(price_Tech[1]));
		JLabel label3 = new JLabel(s.concat(price_Tech[2]));
		JLabel quantity_phone = new JLabel("Phone : Quantity to sell ");
		JLabel quantity_laptop = new JLabel("Laptop : Quantity to sell ");
		JLabel quantity_camera = new JLabel("Camera : Quantity to sell");
		JLabel price_Label = new JLabel();
		JButton phone = new JButton("Phone", phoneImage);
		JButton laptop = new JButton("Laptop", laptopImage);
		JButton camera = new JButton("Camera", cameraImage);
		JButton sell = new JButton("Add To Cart");
		JTextField phone_Quantity = new JTextField(10);
		JTextField laptop_Quantity = new JTextField(10);
		JTextField camera_Quantity = new JTextField(10);
		JSeparator seperator1 = new JSeparator();
		JSeparator seperator2 = new JSeparator();

		public Option3() {
			frame.setLayout(new MigLayout());
			frame.setTitle("Technology Section");
//			tech_Panel.add(label, "wrap");
//			tech_Panel.add(phone, "wrap, growx");
//			tech_Panel.add(quantity_phone, "wrap");
//			tech_Panel.add(phone_Quantity, "growx, left, wrap, w 100");
//			tech_Panel.add(seperator1, "wrap");
//
//			tech_Panel.add(label2, "wrap");
//			tech_Panel.add(laptop, "wrap, growx");
//			tech_Panel.add(quantity_laptop, "wrap");
//			tech_Panel.add(laptop_Quantity, "growx, left, wrap, w 100");
//			tech_Panel.add(seperator2, "wrap");
//
//			tech_Panel.add(label3, "wrap");
//			tech_Panel.add(camera, "wrap, growx");
//			tech_Panel.add(quantity_camera, "wrap");
//			tech_Panel.add(camera_Quantity, "growx, left, wrap, w 100");
//
//			tech_Panel.add(sell);
			frame.setLocationRelativeTo(rootPane);

			frame.add(tech_Panel);
			frame.pack();
			frame.setVisible(true);

			sell.addActionListener(new sell());
		}

		class sell implements ActionListener {
			String p = "The price is :";

			@Override
			public void actionPerformed(ActionEvent e) {
				String p_q = phone_Quantity.getText();
				String l_q = laptop_Quantity.getText();
				String c_q = camera_Quantity.getText();
				if (p_q.isEmpty()) {
					p_q = "0";
				}
				if (l_q.isEmpty()) {
					l_q = "0";
				}
				if (c_q.isEmpty()) {
					c_q = "0";
				}
				frame.setVisible(false);

				double price;
				price = Float.parseFloat(p_q) * Float.parseFloat(price_Tech[0])
						+ Float.parseFloat(l_q) * Float.parseFloat(price_Tech[1])
						+ Float.parseFloat(c_q) * Float.parseFloat(price_Tech[2]);
				totalPrice = totalPrice + price;
				frame.getContentPane().remove(tech_Panel);
				price_Label.setText(p.concat(toString(price)));
				price_Panel.add(price_Label, "wrap");
				frame.add(price_Panel);

			}

			public String toString(Double price) {
				return ": " + price;

			}

		}
	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class AdminOption4 extends JFrame {

		AdminOption4() {
			this.setTitle("Current Products");
			this.add(productPane);
			productPane.setPreferredSize(new Dimension(400, 300));
			this.pack();
			this.setLocationRelativeTo(getParent());
			this.setVisible(true);

		}
	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class AdminOption5 extends JFrame {

		private JMenuBar menuBar = new JMenuBar();
		private JMenu option = new JMenu("Option");
		private JMenuItem removeUser = new JMenuItem("Remove A User");
		private JMenuItem addUserItem = new JMenuItem("Add User");

		AdminOption5() {
			this.setTitle("Current Users");
			this.setJMenuBar(menuBar);
			menuBar.add(option);
			option.add(removeUser);
			option.add(addUserItem);
			this.add(userPane);
			userPane.setPreferredSize(new Dimension(400, 250));
			this.pack();
			this.setLocationRelativeTo(getParent());
			this.setVisible(true);
			addUserItem.addActionListener(new addUser());
			removeUser.addActionListener(new removeUser());

		}

		class addUser implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddUserDialog dialog = new AddUserDialog(AdminOption5.this, "New User", true);
				dialog.setVisible(true);

			}

		}

		class removeUser implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveUserDialog dialog = new RemoveUserDialog(AdminOption5.this, "Remove User", true);
				dialog.setVisible(true);

			}

		}
	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class AdminOption6 extends JFrame {

		JLabel price_Label = new JLabel();
		JPanel price_Panel = new JPanel(new MigLayout());
		String p = "The Total Price is: $";

		AdminOption6() {
			this.setLayout(new MigLayout());
			this.setTitle("Checkout Window");
			this.setLocationRelativeTo(rootPane);

			this.setSize(300, 100);

			price_Label.setText(p.concat(toString(totalPrice)));
			price_Panel.add(price_Label, "wrap");
			this.add(price_Panel);
			this.setVisible(true);
			earnings = earnings + totalPrice;
			totalPrice = 0;

		}

		public String toString(Double price) {
			return " " + String.format("%,.2f", price);
		}

	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class AdminOption7 extends JFrame {

		JLabel earning_Label = new JLabel();
		JPanel earning_Panel = new JPanel(new MigLayout());
		String p = "The Total Earnings are: $";

		AdminOption7() {
			this.setLayout(new MigLayout());
			this.setTitle("Earnings");
			this.setSize(300, 100);
			this.setLocationRelativeTo(rootPane);

			earning_Label.setText(p.concat(toString(earnings)));
			earning_Panel.add(earning_Label, "wrap");
			this.add(earning_Panel);
			this.setVisible(true);

		}

		public String toString(Double price) {
			return " " + String.format("%,.2f", price);
		}

	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	public class AddUserDialog extends JDialog {

		JLabel firstName = new JLabel("First Name");
		JTextField fNameText = new JTextField(20);
		JLabel secondName = new JLabel("Surname");
		JTextField sNameText = new JTextField(20);
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");

		public AddUserDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			this.setLayout(new MigLayout());
			this.setLocationRelativeTo(getParent());
			this.add(firstName);
			this.add(fNameText, "wrap");
			this.add(secondName);
			this.add(sNameText, "wrap");
			this.add(cancelButton, "tag cancel, skip 1, split 2");
			this.add(okButton, "tag ok");
			this.pack();
			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					AddUserDialog.this.setVisible(false);
				}

			});
			okButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String firstName = fNameText.getText();
					String lName = sNameText.getText();

					userList.add(new User(firstName, lName, toString(rand.nextInt(upperbound))));
					userModel.fireTableDataChanged();
					AddUserDialog.this.setVisible(false);

				}

				public String toString(int employeeNumber) {
					return "" + employeeNumber;
				}

			});
		}
	}

	public class RemoveUserDialog extends JDialog {

		JLabel employeeID = new JLabel("Please input the employee number");
		JTextField employeeNumber = new JTextField(20);
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");

		public RemoveUserDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			this.setLayout(new MigLayout());
			this.setLocationRelativeTo(getParent());

			this.add(employeeID);
			this.add(employeeNumber, "wrap");
			this.add(cancelButton, "tag cancel, skip 1, split 2");
			this.add(okButton, "tag ok");
			this.pack();
			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					RemoveUserDialog.this.setVisible(false);
				}

			});
			okButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String employeeID = employeeNumber.getText();
					User aUser;
					int found_one = 0;
					if (!userList.isEmpty()) {
						for (Iterator i = userList.iterator(); i.hasNext();) {
							aUser = (User) i.next();
							System.out.println("Looking at employee ID..." + aUser.getEmployeeNumber());

							if (employeeID.equals(aUser.getEmployeeNumber())) {
								userList.remove(aUser);

								userModel.fireTableDataChanged();
								RemoveUserDialog.this.setVisible(false);

								found_one = 1;
								break;
							}

						}
						if (found_one == 0)
							System.out.println("Error, no employee to remove ");

					}

				}

				public String toString(int employeeNumber) {
					return "" + employeeNumber;
				}

			});
		}
	}

	public String toString(int ID) {

		return "" + ID;

	}

	/****************************************************************************************************************************************************************/
	/****************************************************************************************************************************************************************/

	// Main Method
	public static void main(String[] args) {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Main();

	}
}
