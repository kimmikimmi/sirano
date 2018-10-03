package com.example.demo.controller;

import com.example.demo.domain.data.Category;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@RestController
@Slf4j
public class SiranoEtcController {

	@RequestMapping("/category")
	@ResponseBody
	public List<String> category() {
		return Lists.newArrayList(Arrays.toString(Category.values()));
	}

}
