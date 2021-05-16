import java.util.Scanner;

import Main.*;

public class Application {

	public static void main(String[] args) {
		Menu MainMenu = new Menu();
		Order ClientsOrder = new Order();
		Director director = new Director();
		while (true) {
			MainMenu.printMenu();
			MainMenu.makeOrder();
			if (MainMenu.getType() == "Tea") {
				BuilderTea ClientsTea = new BuilderTea();
				director.constructProduct(MainMenu,ClientsTea);
				ClientsOrder.addProduct(ClientsTea.getResult());
			}
			else {
				BuilderCoffee ClientsCoffee = new BuilderCoffee();
				director.constructProduct(MainMenu,ClientsCoffee);
				ClientsOrder.addProduct(ClientsCoffee.getResult());
			}
			System.out.println("������ �������� ��� ���� �������?\n");
			Scanner scan = new Scanner(System.in);
			int number;
			System.out.println("1.��\n");
			System.out.println("2.���\n");
			while (true) {
				number = scan.nextInt();
				if (number > 0 && number < 3) {
					break;
				}
				System.out.println("�������� ����! ���������� �����:");
			}
			if (number == 2) {
				break;
			}
		}
		ClientsOrder.printInformation();
	}

}
