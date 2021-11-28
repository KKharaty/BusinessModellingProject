


public class Supplier {
	
	private static int uniqueID; // static allows it to be global
	private int supplierID;
	String name;
	String surname;
	String product;
	
	Supplier(){
		
		supplierID = createID();
	}
	
	Supplier(String n, String s, String pr){
		name = n;
		surname = s;
		product = pr;
		supplierID = createID();
	}
	
	public static int createID(){
		return uniqueID++;
	}
	
	public String toString(){
		return "Supplier: " + supplierID +". \nName:"+ name +" "+ surname +" \nProduct: "+product;
	}

}
