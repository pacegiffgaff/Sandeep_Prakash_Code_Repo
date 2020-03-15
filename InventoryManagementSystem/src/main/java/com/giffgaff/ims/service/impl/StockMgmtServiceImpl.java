package com.giffgaff.ims.service.impl;

import java.util.List;

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
	public Stock addStock(Stock stock) {
		Stock rawObj = stockDAO.save(stock);
		logger.info("\n Stock ID : " + stock.getStockId() + "Total Stock : " + stock.getHistoryTotal()
				+ "\n Current Stock : " + stock.getTotalCurrentStock() + "\n Product Details : " + stock.getProduct());
		return rawObj;
	}

	@Override
	public Stock updateProductInStock(Product product, Integer lot) {
		Stock stock = stockDAO.findByProduct(product);
		if (stock == null) {
			stock = new Stock();
			stock.setProduct(product);
			stock.setHistoryTotal(lot);
			stock.setTotalCurrentStock(lot);
			return stockDAO.save(stock);
		}
		stockDAO.manufactureProductInLot(product, lot);
		inventoryDAO.updateRawmaterialonProduction(lot);
		return stockDAO.findByProduct(product);
	}

	@Override
	public Integer updateAllProductsInStock(Integer lot) {
		if (stockDAO.count() != 0) {
			return stockDAO.manufactureProductsInLot(lot);
		}
		return 0;
	}
}
