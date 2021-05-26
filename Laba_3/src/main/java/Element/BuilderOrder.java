package Element;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuilderOrder {

	private List<IProduct> products = new ArrayList<IProduct>();
	private int numberOfProduct = 0;
	private int Price = 0;

	public Order createOrder() {
		Random rand = new Random();
		boolean check = false;
		while (true) {
			int number = rand.nextInt(8) + 1;
			int sugar = rand.nextInt(5) + 1;
			int choise = rand.nextInt(2) + 1;
			this.makeOrder(number, sugar);
			this.countPrice();
			switch (choise) {
			case 2:
				check = true;
				break;
			}
			if (check) {
				break;
			}
		}
		return new Order(products);
	}

	public void printMenu() {
		System.out.println("Меню:\n");
		System.out.println("1.Чай Lipton(черный).................100р\n");
		System.out.println("2.Чай Lipton(зеленый)................120р\n");
		System.out.println("3.Чай GreenField(черный).............120р\n");
		System.out.println("4.Чай GreenField(зеденый)............140р\n");
		System.out.println("5.Кофе Jacobs(без молока).............80р\n");
		System.out.println("6.Кофе Jacobs(с молоком)..............95р\n");
		System.out.println("7.Кофе Jardin(без молока).............70р\n");
		System.out.println("8.Кофе Jardin(с молоком)..............85р\n");
		System.out.println("Сахар..................................5р\n");
	}

	public void makeOrder(int number, int sugar) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContextProduct.xml");
		switch (number) {
		case 1:
			products.add(ctx.getBean("TeaLiptonBlack", Tea.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 2:
			products.add(ctx.getBean("TeaLiptonGreen", Tea.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 3:
			products.add(ctx.getBean("TeaGreenfieldBlack", Tea.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 4:
			products.add(ctx.getBean("TeaGreenfieldGreen", Tea.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 5:
			products.add(ctx.getBean("CoffeeJacobsBlack", Coffee.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 6:
			products.add(ctx.getBean("CoffeeJacobsMilk", Coffee.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 7:
			products.add(ctx.getBean("CoffeeJardinBlack", Coffee.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		case 8:
			products.add(ctx.getBean("CoffeeJardinMilk", Coffee.class));
			products.get(numberOfProduct).setSugar(sugar);
			break;
		}
		ctx.close();
		numberOfProduct++;
	}

	public void countPrice() {
		Price = 0;
		for (IProduct product : products) {
			Price += product.getPrice();
		}
	}

	public void printOrder() {
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
