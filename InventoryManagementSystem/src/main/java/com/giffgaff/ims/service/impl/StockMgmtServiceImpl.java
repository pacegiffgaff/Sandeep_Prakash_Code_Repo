package com.giffgaff.ims.service.impl;

import java.util.List;

import com.giffgaff.ims.controller.form.StockForm;
import com.giffgaff.ims.dao.ProductDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.StockDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.StockMgmtService;

@Component
public class StockMgmtServiceImpl implements StockMgmtService {

	private static final Logger logger = Logger.getLogger(StockMgmtServiceImpl.class);

	@Autowired
	StockDAO stockDAO;

	@Autowired
	InventoryDAO inventoryDAO;

	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Stock> getAllStock() {

		List<Stock> listOfStock = stockDAO.findAll();
		for (Stock stock : listOfStock) {
			logger.info("\n Stock ID : " + stock.getStockId() + "Total Stock : " + stock.getHistoryTotal()
					+ "\n Current Stock : " + stock.getTotalCurrentStock() + "\n Product Details : "
					+ stock.getProduct());
		}
		return listOfStock;
	}

	@Override
	public Stock updateProductInStock(StockForm stockForm, String action) {
		String productName= stockForm.getProductName();
		int lot = stockForm.getQuantity();
		Stock stock = stockDAO.findByProduct_ProductName(productName);
		Product product = productDAO.findByProductName(productName);
		if (stock == null) {
			stock = new Stock();
			stock.setProduct(product);
			stock.setHistoryTotal(lot);
			stock.setTotalCurrentStock(lot);
			return stockDAO.save(stock);
		}
		if (product == null) {
			return null;
		}
		updateStock(stock,lot,action);
		return stockDAO.findByProduct(product);
	}

	private Stock updateStock(Stock stock, int lot, String action) {
		int totalCurrentStock = stock.getTotalCurrentStock();
		long historyTotal = stock.getHistoryTotal();
		if (action.equalsIgnoreCase("add")) {
			totalCurrentStock+=lot;
			historyTotal+=lot;
			stock.setTotalCurrentStock(totalCurrentStock);
			stock.setHistoryTotal(historyTotal);
			return stockDAO.save(stock);
		}
		totalCurrentStock-=lot;
		totalCurrentStock= (totalCurrentStock< 0) ?0: totalCurrentStock;
		stock.setTotalCurrentStock(totalCurrentStock);
		stock.setHistoryTotal(historyTotal);

		return stockDAO.save(stock);
	}

	@Override
	public Integer updateAllProductsInStock(Integer lot) {
		if (stockDAO.count() != 0) {
			return stockDAO.manufactureProductsInLot(lot);
		}
		return 0;
	}
}
