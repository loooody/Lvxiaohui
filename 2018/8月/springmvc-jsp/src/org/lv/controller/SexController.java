package org.lv.controller;

import org.lv.domain.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SexController {
	
	@RequestMapping(value="/radiobuttonForm",method=RequestMethod.GET)
	public String radiobuttonForm(Model model) {
		Sex sex = new Sex();
		sex.setSex("ÄÐ");
		model.addAttribute("sex",sex);
		return "radiobuttonForm";
	}
}
