package com.giffgaff.ims.controller;

import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ManufacturingMgmtController {

	@Autowired
	ManufacturingMgmtService manufacturingMgmtService;

}
