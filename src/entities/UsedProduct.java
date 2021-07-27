package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private Date manufactureDate;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.manufactureDate=manufactureDate;
	}

	public Date getmanufactureDate() {
		return manufactureDate;
	}

	@Override
	public String priceTag() {
		// TODO Auto-generated method stub
		return super.priceTag() +" (Manufacture date: "+ sdf.format(manufactureDate)+")";
	}
	
	
}
