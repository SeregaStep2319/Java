package Main;

public class Director {
	public void constructProduct(Menu menu,IBuilder builder) {
		builder.setName(menu.getName());
		builder.setAdditiv(menu.getAdditiv());
		builder.setParametr(menu.isParametr());
		builder.setPrice(menu.getPrice());
	}
}
