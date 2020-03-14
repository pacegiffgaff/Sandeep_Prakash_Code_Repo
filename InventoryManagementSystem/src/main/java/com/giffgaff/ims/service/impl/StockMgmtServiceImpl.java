package com.giffgaff.ims.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.ims.dao.StockDAO;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.StockMgmtService;

@Component
public class StockMgmtServiceImpl implements StockMgmtService {

	private static final Logger logger = Logger.getLogger(StockMgmtServiceImpl.class);

	@Autowired
	StockDAO stockDAO;

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
}
