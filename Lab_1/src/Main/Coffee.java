package Main;

public class Coffee implements IProduct {
	
	protected String NameOfDrink;
	protected int Sugar;
	private boolean Milk;
	protected int Price;
	
	Coffee(String NameOfDrink,int Sugar,boolean Milk, int Price){
		this.NameOfDrink = NameOfDrink;
		this.Sugar = Sugar;
		this.Milk = Milk;
		this.Price = Price;
		countPrice();
	}
	
	@Override
	public void countPrice() {
		if (this.Milk) {
			this.Price += 15;
		}
		this.Price += this.Sugar * 5;
	}
	
	@Override
	public int getPrice() {
		return this.Price;
	}
	
	@Override
	public void printInformation() {
		if (this.Milk) {
			System.out.println(NameOfDrink + " с молоком "+ "\nКоличество сахара: " + Sugar + "\nЦена: " + Price + "\n");
		}
		else {
			System.out.println(NameOfDrink + " черный "+ "\nКоличество сахара: " + Sugar + "\nЦена: " + Price + "\n");
		}
	}
}
