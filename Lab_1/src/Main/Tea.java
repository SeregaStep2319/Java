package Main;

public class Tea implements IProduct {
	
	protected String NameOfDrink;
	protected int Sugar;
	private boolean Green;
	protected int Price;
	
	Tea(String NameOfDrink,int Sugar,boolean Green, int Price){
		this.NameOfDrink = NameOfDrink;
		this.Sugar = Sugar;
		this.Green = Green;
		this.Price = Price;
		countPrice();
	}
	
	@Override
	public void countPrice() {
		if (this.Green) {
			this.Price += 20;
		}
		this.Price += this.Sugar * 5;
	}
	
	@Override
	public int getPrice() {
		return this.Price;
	}
	
	@Override
	public void printInformation() {
		if (this.Green) {
			System.out.println(NameOfDrink + " зеленый "+ "\nКоличество сахара: " + Sugar + "\nЦена: " + Price);
		}
		else {
			System.out.println(NameOfDrink + " черный "+ "\nКоличество сахара: " + Sugar + "\nЦена: " + Price);
		}
	}
}
