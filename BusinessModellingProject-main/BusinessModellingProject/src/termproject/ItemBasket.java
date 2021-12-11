package termproject;

public class ItemBasket {
	String item;
	Integer quantity;
	
	public ItemBasket(String item_chosen, Integer qty_chosen) {
		// TODO Auto-generated constructor stub
		item = item_chosen;
		quantity = qty_chosen;
	}
	
	public String toString(){
		return " \nName: "+ item +" \nQuantity: "+ quantity;
	}
}
