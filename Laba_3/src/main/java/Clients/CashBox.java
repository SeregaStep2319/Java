package Clients;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CashBox implements Runnable {
	private Clients clients;
	private Thread thread;
	private int number;

	public CashBox(ClassPathXmlApplicationContext ctx, int number) {
		this.clients = ctx.getBean("Clients", Clients.class);
		this.number = number;

		thread = new Thread(this, "CashBox");
		thread.start();
	}

	public void run() {
		while (clients.getCounter() < 10) {
			System.out.println("Касса " + number + " начала работу.");
			clients.makeOrders();
			System.out.println("Касса " + number + " закончила работу.");
		}
	}

	public Clients getClients() {
		return clients;
	}

}
