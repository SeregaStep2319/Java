package Main;
import java.util.Scanner;

public class Menu {
	private String Type;
	private String Name;
	private int Additiv;
	private boolean Parametr;
	private int Price = 0;
		
	public void printMenu() {
		System.out.println("Ìåíş:\n");
		System.out.println("×àé           ÷åğíûé/çåë¸íûé\n");
		System.out.println("1.Lipton........100ğ/120ğ\n");
		System.out.println("2.GreenField....120ğ/140ğ\n");
		System.out.println("Êîôå          ÷åğíûé/ñ ìîëîêîì");
		System.out.println("3.Jacobs.........80ğ/95ğ\n");
		System.out.println("4.Jardin.........70ğ/85ğ\n");
		System.out.println("Ñàõàğ: 5ğ çà êóáèê\n");
	}
	
	public void makeOrder() {
		System.out.println("Âûáåğåòè ÷àé/êîôå: ");
		Scanner scan = new Scanner(System.in);
		int number;
		while (true) {
			number = scan.nextInt();
			if (number > 0 && number < 5) {
				break;
			}
			System.out.println("Íåâåğíûé ââîä! Ïîïğîáóéòå ñíîâà:");
		}
		switch (number) {
		case 1:
			this.Type = "Tea";
			this.Name = "Lipton";
			this.Parametr = chooseTea();
			this.Price = 100;
			break;
		case 2:
			this.Type = "Tea";
			this.Name = "GreenField";
			this.Parametr = chooseTea();
			this.Price = 120;
			break;
		case 3:
			this.Type = "Coffee";
			this.Name = "Jacobs";
			this.Parametr = chooseCoffee();
			this.Price = 80;
			break;
		case 4:
			this.Type = "Coffee";
			this.Name = "Jardin";
			this.Parametr = chooseCoffee();
			this.Price = 70;
			break;
		}
		Additiv = countSugar();
	}
	
	private boolean chooseTea() {
		Scanner scan = new Scanner(System.in);
		int number;
		System.out.println("1.×åğíûé\n");
		System.out.println("2.Çåëåíûé\n");
		while (true) {
			number = scan.nextInt();
			if (number > 0 && number < 3) {
				break;
			}
			System.out.println("Íåâåğíûé ââîä! Ïîïğîáóéòå ñíîâà:");
		}
		if (number == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean chooseCoffee() {
		Scanner scan = new Scanner(System.in);
		int number;
		System.out.println("1.×åğíûé\n");
		System.out.println("2.Ñ ìîëîêîì\n");
		while (true) {
			number = scan.nextInt();
			if (number > 0 && number < 3) {
				break;
			}
			System.out.println("Íåâåğíûé ââîä! Ïîïğîáóéòå ñíîâà:");
		}
		if (number == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private int countSugar() {
		Scanner scan = new Scanner(System.in);
		int number;
		System.out.println("Ñêîëüêî äîáàâèòü ñàõàğà(0/5): ");
		while (true) {
			number = scan.nextInt();
			if (number > -1 && number < 6) {
				break;
			}
			System.out.println("Íåâåğíûé ââîä! Ïîïğîáóéòå ñíîâà:");
		}
		return number;
	}

	public String getType() {
		return this.Type;
	}

	public String getName() {
		return this.Name;
	}

	public int getAdditiv() {
		return this.Additiv;
	}

	public boolean isParametr() {
		return this.Parametr;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
}
