package App;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Clients.CashBox;
import Clients.Clients;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContextClients.xml");
		Clients clients = ctx.getBean("Clients", Clients.class);

		List<CashBox> cashboxs = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			cashboxs.add(new CashBox(ctx, i + 1));
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		ctx.close();
		clients.printOrder();
	}

}
