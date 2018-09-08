package com.example.demo.controller;

import com.example.demo.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jaden
 * @since : 07/09/2018
 */
@RestController
public class HelloController {

	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		articleService.loadAll();
		return "Hello World!";
	}

}
