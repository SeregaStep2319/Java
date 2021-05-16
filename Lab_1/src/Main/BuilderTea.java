package Main;

public class BuilderTea implements IBuilder {

	private String Name;
	private int Additiv;
	private boolean Parametr;
	private int Price;
	
	@Override
	public void setName(String Name) {
		this.Name = Name;
	}

	@Override
	public void setAdditiv(int Additiv) {
		this.Additiv = Additiv;
	}

	@Override
	public void setParametr(boolean Parametr) {
		this.Parametr = Parametr;
	}
	
	@Override
	public void setPrice(int Price) {
		this.Price = Price;
	}
	
	public Tea getResult() {
		return new Tea(Name,Additiv,Parametr,Price);
	}

}
