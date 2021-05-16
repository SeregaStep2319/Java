package Element;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuilderOrder {

	
	private List<IProduct> products = new ArrayList<IProduct>();
	private int numberOfProduct = 0;
	private int Price = 0;

	public Order createOrder() {
		boolean check = false;
		while (true) {
			this.printMenu();
			this.makeOrder();
			this.countPrice();
			this.printOrder();
			switch (this.changeOrder()) {
			case 2:
				products.clear();
				System.out.println("Ваш заказ отменен!\n");
				check = true;
				break;
			case 3:
				System.out.println("Ваш заказ принят!\n");
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
		System.out.println("Чай\n");
		System.out.println("1.Lipton(черный).............100р\n");
		System.out.println("2.Lipton(зеленый)............120р\n");
		System.out.println("3.GreenField(черный).........120р\n");
		System.out.println("4.GreenField(зеденый)........140р\n");
		System.out.println("Кофе\n");
		System.out.println("5.Jacobs(без молока).............80р\n");
		System.out.println("6.Jacobs(с молоком)..............95р\n");
		System.out.println("7.Jardin(без молока).............70р\n");
		System.out.println("8.Jardin(с молоком)..............85р\n");
		System.out.println("Сахар.............................5р\n");
	}

	public void makeOrder() {
		System.out.println("Выберете напиток: ");
		Scanner scan = new Scanner(System.in);
		int number;
		while (true) {
			number = scan.nextInt();
			if (number > 0 && number < 9) {
				break;
			}
			System.out.println("Неверный ввод! Попробуйте снова:");
		}
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContextProduct.xml");
		
		switch(number) {
		case 1:
			products.add(ctx.getBean("TeaLiptonBlack", Tea.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 2:
			products.add(ctx.getBean("TeaLiptonGreen", Tea.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 3:
			products.add(ctx.getBean("TeaGreenfieldBlack", Tea.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 4:
			products.add(ctx.getBean("TeaGreenfieldGreen", Tea.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 5:
			products.add(ctx.getBean("CoffeeJacobsBlack", Coffee.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 6:
			products.add(ctx.getBean("CoffeeJacobsMilk", Coffee.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 7:
			products.add(ctx.getBean("CoffeeJardinBlack", Coffee.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		case 8:
			products.add(ctx.getBean("CoffeeJardinMilk", Coffee.class));
			products.get(numberOfProduct).setSugar(countSugar());
			break;
		}
		ctx.close();
		numberOfProduct++;
	}
	
	private int countSugar() {
		Scanner scan = new Scanner(System.in);
		int number;
		System.out.println("Сколько добавить сахара(0/5): ");
		while (true) {
			number = scan.nextInt();
			if (number > -1 && number < 6) {
				break;
			}
			System.out.println("Неверный ввод! Попробуйте снова:");
		}
		return number;
	}

	public int changeOrder() {
		Scanner scan = new Scanner(System.in);
		int number;
		System.out.println("1.Добавить напиток\n");
		System.out.println("2.Отменить заказ\n");
		System.out.println("3.Оплатить заказ\n");
		while (true) {
			number = scan.nextInt();
			if (number > 0 && number < 4) {
				break;
			}
			System.out.println("Неверный ввод! Попробуйте снова:");
		}
		return number;
	}

	public void countPrice() {
		Price = 0;
		for (IProduct product: products) {
			Price += product.getPrice();
		}
	}

	public void printOrder() {
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
