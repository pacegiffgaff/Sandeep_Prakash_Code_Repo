package com.giffgaff.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giffgaff.ims.service.StockMgmtService;

@Controller
public class StockMgmtController {

	private static final Logger logger = Logger.getLogger(StockMgmtController.class);

	@Autowired
	StockMgmtService stockMgmtService;

	/**
	 * retreive All stock from database
	 * 
	 * @param Model
	 * @return allStock.jsp
	 */
	@RequestMapping("/stocks")
	public String getAllStock(Model model) {
		logger.info("To dispaly stock Information");
		model.addAttribute("stocks", stockMgmtService.getAllStock());
		return "stocks";
	}
}
