package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;

public interface StockMgmtService {

	List<Stock> getAllStock();

	Stock addStock(Stock stock);

	Stock updateProductInStock(Product product, Integer lot);

	Integer updateAllProductsInStock(Integer lot);
	
}
