package com.store.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static com.store.util.ProductUtil.*;
import static com.store.util.ProductValidation.*;

import com.store.model.Category;
import com.store.model.Product;

public class ProductStoreApp {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in);
				BufferedReader brRead = new BufferedReader(new InputStreamReader(System.in))) {
			
			// loading the pre-loaded list
			List<Product> productList = loadExistingProductList();
			
			System.out.println("CARTANA APP STORE");
			
			boolean loop = true;
			
			while(true) {
				System.out.println("Press 1 to add a new product");
				System.out.println("Press 2 to list of products by category");
				System.out.println("Press 3 to search a product by item code or its name");
				System.out.println("Press 4 to list all the products");
				System.out.println("Press 9 to exit");
				System.out.println("Enter your choice: ");
				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("Enter Item code: ");
					String productCode = brRead.readLine();
					checkDuplicateProductCode(productCode, productList);
					System.out.println("Enter Item name: ");
					String productName = brRead.readLine();
					System.out.println("Enter buying price of the item: ");
					double buyingPrice = scan.nextDouble();
					System.out.println("Enter selling price of the item: ");
					double sellingPrice = scan.nextDouble();
					System.out.println("Enter category of item: ");
					String category = brRead.readLine().toUpperCase();
					System.out.println("Enter tax input");
					double tax = scan.nextDouble();
					System.out.println("Enter quantity: ");
					int quantity = scan.nextInt();
					System.out.println("");
					System.out.println("--------------------------------");
					System.out.println("");
					addNewProduct(productCode, productName, buyingPrice, sellingPrice, category, tax, quantity);
					break;

				case 2:
					System.out.println("Enter category wise product search : ");
					String searchCategory = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getCategory() == Category.valueOf(searchCategory)) {
							System.out.println(product);
						} 
					}
					break;
					
				case 3:
					System.out.println("Enter product name or product code that you want to search: ");
					String search = brRead.readLine().toUpperCase();
					
					for (Product product : productList) {
						if(product.getItemCode().equals(search) || product.getItemName().toUpperCase().equals(search)) {
							System.out.println("Product found!!!");
							System.out.println("Here are the product details: ");
							System.out.println(product);
						}
					}
					break;
					
				case 4:
					for (Product product : productList) {
						System.out.println(product);
					}
					break;
					
				case 10:
					loop = false;
					break;
					
				default:
					System.out.println("Not a valid choice");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
