//package termproject;
//
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//import net.miginfocom.swing.MigLayout;
//
//public class UserDialog extends JDialog {
//	
//	JLabel firstName = new JLabel("First Name");
//	JTextField fNameText = new JTextField(20);
//	JLabel secondName = new JLabel("Surname");
//	JTextField sNameText = new JTextField(20);
//	JButton okButton = new JButton("Ok");
//	JButton cancelButton = new JButton("Cancel");
//
//
//
//	public UserDialog(Frame owner, String title, boolean modal) {
//		super(owner, title, modal);
//		this.setLayout(new MigLayout());
//		this.setLocationRelativeTo(getParent());
//		this.add(firstName);
//		this.add(fNameText, "wrap");
//		this.add(secondName);
//		this.add(sNameText, "wrap");
//		this.add(cancelButton, "tag cancel, skip 1, split 2");
//		this.add(okButton, "tag ok");
//		this.pack();
//		cancelButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				UserDialog.this.setVisible(false);
//			}
//			
//		});
//		okButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				String firstName = fNameText.getText();
//				String lastName = secondName.getText();
//				int employeeNumber = userList.size() +1;
//				User newUser = new User(firstName, lastName, toString(employeeNumber));
//			}
//			public String toString(int employeeNumber) {
//				return ": " + employeeNumber;
//
//			}
//
//		});
//	}	
//}
