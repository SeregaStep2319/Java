package Element;

public class Tea implements IProduct {

	protected String NameOfDrink;
	protected int Sugar;
	protected boolean Green;
	protected int Price;

	public Tea(String NameOfDrink, boolean Green, int Price) {
		this.NameOfDrink = NameOfDrink;
		this.Sugar = 0;
		this.Green = Green;
		this.Price = Price;
	}

	@Override
	public void countPrice() {
		if (this.Green) {
			this.Price += 20;
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
		if (this.Green) {
			System.out.println(NameOfDrink + " зеленый " + "\nКоличество сахара: " + Sugar + "\nЦена: " + Price);
		} else {
			System.out.println(NameOfDrink + " черный " + "\nКоличество сахара: " + Sugar + "\nЦена: " + Price);
		}
	}
}
