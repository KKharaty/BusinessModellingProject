package termproject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProductTabelModel extends AbstractTableModel {

	List<Product> products;
	String[] columnNames = { "Product", "Price"};

	public ProductTabelModel(List<Product> products) {
		this.products = products;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = products.get(rowIndex);
		String result = null;
		switch (columnIndex) {
		case 0:
			result = product.getItemName();
			break;
		case 1:
			result = Double.toString(product.getPrice());
			break;

		}
		return result;
	}

}
