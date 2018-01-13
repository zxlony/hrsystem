package com.iotek.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.entity.Rewandpun;
import com.iotek.ssm.service.RewandpunService;

@RequestMapping("rap")
@Controller
public class RewandpunController {

	@Autowired
	private RewandpunService rapService;
	
	@RequestMapping("insert")
	public String insert(Rewandpun rap) {
		rap.setType("им");
		rapService.addRap(rap);
		return "admin_index";
	}
	
}
