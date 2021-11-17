package termproject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
	
	List<User> userList;
	String[] columnNames = { "Firstname", "Surname", "EmployeeNumber"};
	
	public UserTableModel(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return userList.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = userList.get(rowIndex);
		String result = null;
		switch (columnIndex) {
		case 0:
			result = user.getFirstName();
			break;
		case 1:
			result = user.getLastName();
			break;
		case 2:
			result = user.getEmployeeNumber();
			break;

		}
		return result;
	}

}