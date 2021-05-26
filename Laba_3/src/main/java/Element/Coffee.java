package Element;

public class Coffee implements IProduct {

	protected String NameOfDrink;
	protected int Sugar;
	protected boolean Milk;
	protected int Price;

	public Coffee(String NameOfDrink, boolean Milk, int Price) {
		this.NameOfDrink = NameOfDrink;
		this.Sugar = 0;
		this.Milk = Milk;
		this.Price = Price;
	}

	@Override
	public void countPrice() {
		if (this.Milk) {
			this.Price += 15;
		}
		this.Price += this.Sugar * 5;
	}

	@Override
	public void setSugar(int Sugar) {
		this.Sugar = Sugar;
		countPrice();
	}

	@Override
	public int getPrice() {
		return this.Price;
	}

	@Override
	public void printInformation() {
		if (this.Milk) {
			System.out
					.println(NameOfDrink + " с молоком " + "\nКоличество сахара: " + Sugar + "\nЦена: " + Price + "\n");
		} else {
			System.out.println(NameOfDrink + " черный " + "\nКоличество сахара: " + Sugar + "\nЦена: " + Price + "\n");
		}
	}
}