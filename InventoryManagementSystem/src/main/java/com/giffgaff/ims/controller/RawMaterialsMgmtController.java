package com.giffgaff.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giffgaff.ims.model.RawMaterial;
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

	@RequestMapping(value = "/rawmaterial", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addrawmaterial", "rawMaterial", new RawMaterial());
	}

	@RequestMapping(value = "/addrawmaterial", method = RequestMethod.POST)
	public String addRawMaterial(@ModelAttribute("rawMaterial") RawMaterial rawMaterial, Model model) {
		model.addAttribute("addrawmaterial", rawMaterialsMgmtService.addRawMaterial(rawMaterial));
		return "success";
	}
}
