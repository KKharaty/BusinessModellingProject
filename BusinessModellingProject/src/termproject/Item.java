package termproject;

public class Item {
	private static int uniqueID;
	private int itemID;
	String item_name;
	String expiration;
	
	Item(){
		
		itemID = createID();
	}
	
	Item (String name, String exp, int id){
		item_name = name;
		expiration = exp;
		itemID = createID();
	}

	public int createID() {
		// TODO Auto-generated method stub
		return uniqueID++;
	}
	
	public String toString(){
		return "Item: " + itemID +". \nName:"+ item_name +" \nExpiration date: "+expiration;
	}

}
