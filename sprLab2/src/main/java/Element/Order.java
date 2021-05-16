package Element;

import java.util.ArrayList;
import java.util.List;

public class Order implements IProduct {

	private List<IProduct> products = new ArrayList<IProduct>();
	private int Price = 0;
	
	public Order(List<IProduct> products) {
		for (IProduct product : products) {
			this.products.add(product);
		}
		countPrice();
	}
	
	public void addProduct(IProduct product) {
		products.add(product);
	}
	
	@Override
	public void countPrice() {
		for (IProduct product : products) {
			Price += product.getPrice();
		}
	}
	
	@Override
	public void setSugar(int Sugar) {}

	@Override
	public int getPrice() {
		return this.Price;
	}

	@Override
	public void printInformation() {
		System.out.println("Ваш заказ:\n");
		System.out.println("****************************************");
		int number = 1;
		for (IProduct product : products) {
			System.out.println(number + ":");
			product.printInformation();
			System.out.println("****************************************");
			number++;
		}
		System.out.println("Итоговая цена: " + this.Price + "\n");
	}
}

