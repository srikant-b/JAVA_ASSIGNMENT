package com.store.util;

import static com.store.util.ProductValidation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.store.exception.ProductCustomException;
import com.store.model.Category;
import com.store.model.Product;

public class ProductUtil {

	/*
	 * private String itemCode; private String itemName; private double
	 * buyingPrice; private double sellingPrice; private Category category;
	 * private double tax; private int quantity;
	 */
	
	// method to add a new product
	public static Product addNewProduct(String itemCode, String itemName,
			double buyingPrice, double sellingPrice, String category,
			double tax, int quantity) throws ProductCustomException, ParseException {
		
		validateBuyingPrice(buyingPrice);
		validateSellingPrice(sellingPrice, buyingPrice);
		Category checkCategory = validateCategory(category);
		
		return new Product(itemCode, itemName, buyingPrice, sellingPrice, checkCategory, tax, quantity);
	}

	// method to send a pre-loaded list
	public static List<Product> loadExistingProductList() throws ParseException {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("101", "HP", 100000, 135000, Category.LAPTOP, 28, 5));
		productList.add(new Product("102", "Lenovo", 70000, 85000, Category.LAPTOP, 28, 15));
		productList.add(new Product("103", "Fastrack", 800, 1800, Category.WATCH, 28, 50));
		productList.add(new Product("104", "Canon", 50000, 65000, Category.CAMERA, 28, 25));
		productList.add(new Product("105", "Nikkon", 55000, 70000, Category.CAMERA, 28, 20));
		
		return productList;
	}
	
}
