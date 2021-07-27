package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Aplication {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
		System.out.println("Product #"+(i+1)+" data:");
		System.out.print("Common, used or imported (c/u/i): ");
		char letra = sc.next().charAt(0);
		if(letra!='c' && letra!='u' && letra!='i') {
			System.out.println("Código errado.");
		}
		else {
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
		
		if (letra == 'c') {
			Product prod = new Product(name, price);
			list.add(prod);
		}
		else if(letra == 'u') {
			System.out.print("Manufacture Date: ");
			Date mDate = sdf.parse(sc.next());
			UsedProduct uprod = new UsedProduct(name, price, mDate);
			list.add(uprod);
		}
		else if(letra=='i') {
			System.out.print("Customs Fee: ");
			double customsFee = sc.nextDouble();
			ImportedProduct improd = new ImportedProduct(name, price, customsFee);
			list.add(improd);
		}
		else {
			System.out.println("Código errado.");
		}
		}}
		if(list.size()>0) {
		System.out.println();
		System.out.println("Price Tags:");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		}
		sc.close();
	}
}

