package org.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ��̬ҳ��ת��
 * @author 319667916
 *
 */
@Controller
public class FormController {
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		//��̬��תҳ��
		return formName;
	}
}
