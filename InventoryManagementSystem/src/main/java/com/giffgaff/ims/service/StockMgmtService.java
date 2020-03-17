package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.controller.form.StockForm;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;

public interface StockMgmtService {

	List<Stock> getAllStock();

	Stock updateProductInStock(StockForm stockForm, String action);

	Integer updateAllProductsInStock(Integer lot);
	
}
