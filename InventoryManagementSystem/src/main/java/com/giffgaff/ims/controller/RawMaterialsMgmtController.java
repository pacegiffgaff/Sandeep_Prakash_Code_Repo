package com.giffgaff.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giffgaff.ims.service.RawMaterialsMgmtService;

@Controller
public class RawMaterialsMgmtController {

	private static final Logger logger = Logger.getLogger(RawMaterialsMgmtController.class);

	@Autowired
	RawMaterialsMgmtService rawMaterialsMgmtService;

	/**
	 * Display All products, Product Names, Raw materials and Product Specifications
	 * in Raw materials Page rawmaterials.jsp
	 * 
	 * @param model
	 * @return rawmaterials.jsp
	 */
	@RequestMapping("/rawmaterials")
	public String getRawMaterialsWithSpecs(Model model) {
		logger.info("Dispaly All Product names, rawmaterials and specifications");
		model.addAttribute("rawmaterials", rawMaterialsMgmtService.getRawMaterialsWithSpecs());
		return "rawmaterials";
	}

	/**
	 * To Track raw material information
	 * 
	 * @param model
	 * @return trackrawmaterials.jsp
	 */
	@RequestMapping("/trackrawmaterials")
	public String trackRawmaterials(Model model) {
		logger.info("To Track Raw Material Information");
		model.addAttribute("trackrawmaterials", rawMaterialsMgmtService.trackRawmaterials());
		return "trackrawmaterials";
	}
}
