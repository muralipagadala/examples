package com.murali.sql.groovy.orm;

import java.util.List;

public interface ProductDAO {

	List<Product> getAllProducts();
	Product findProductById(int id);
	int insertProduct(Product p);
	void deleteProduct(int id);
}