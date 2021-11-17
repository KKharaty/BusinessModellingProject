package termproject;

public class Items {

	class SportItems {
		SportItems[] sportsItem = new SportItems[3];
		String itemName;
		int price;

		SportItems Item1 = new SportItems("Football", 25);
		SportItems Item2 = new SportItems("BasketBall", 30);
		SportItems Item3 = new SportItems("Boxing Gloes", 70);

		public SportItems(String itemName, int price) {
			this.itemName = itemName;
			this.price = price;

		}

	}

	class Food {
		Food[] food = new Food[3];
		String itemName;
		double price;

		Food item1 = new Food("Pasta", 4.99);
		Food item2 = new Food("Rice 10kg", 14.99);
		Food item3 = new Food("Bread", 3);

		public Food(String itemName, double price) {
			this.itemName = itemName;
			this.price = price;

		}
	}

	class Tech {
		Tech[] tech = new Tech[3];
		String itemName;
		int price;

		Tech item1 = new Tech("Laptop", 1300);
		Tech item2 = new Tech("Phone", 699);
		Tech item3 = new Tech("Monitor", 199);

		public Tech(String itemName, int price) {
			this.itemName = itemName;
			this.price = price;
		}

	}
}
