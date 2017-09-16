package com.zj.springboot.pmos.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	@RequestMapping("/")
	public String helloHtml(Model model){
    	return "modules/common/index.html";
	}
}
