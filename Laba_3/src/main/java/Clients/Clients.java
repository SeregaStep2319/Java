package Clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import Element.Order;

public class Clients {
	private List<Order> clientsOrder = new ArrayList<>();
	private List<Integer> clientsNumber = new ArrayList<>();
	private static int counter = 0;

	public void makeOrders() {
		int number = counter;
		counter++;
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContextBuilder.xml");
		System.out.println("Клиент " + (number + 1) + " делает заказ.");
		clientsNumber.add(number + 1);
		clientsOrder.add(ctx.getBean("Order", Order.class));
		System.out.println("Клиент " + (number + 1) + " закончил заказ.");

		ctx.close();
	}

	public int getCounter() {
		return counter;
	}

	public void printOrder() {
		int number = 0;
		for (Order client : clientsOrder) {
			System.out.println();
			System.out.println("Заказ клиента " + clientsNumber.get(number) + ":");
			client.printInformation();
			number++;
		}
	}
}
