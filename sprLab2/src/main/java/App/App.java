package App;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import Element.Order;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContextBuilder.xml");
		
		Order ClientOrder = ctx.getBean("Order", Order.class);
		
		ClientOrder.printInformation();
		
		ctx.close();
	}

}

