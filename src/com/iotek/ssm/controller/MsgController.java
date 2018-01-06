package com.iotek.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.ssm.service.MsgService;

@RequestMapping("msg")
@Controller
public class MsgController {

	@Autowired
	private MsgService msgService;
	
	
}
