package com.example.demo.healthcheck;

import com.example.demo.domain.data.Category;
import com.example.demo.domain.dto.DocubeDto;
import com.example.demo.domain.service.DocubeManageService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 07/09/2018
 */
@RestController
@Slf4j
public class HelloController {

	@Autowired
	private DocubeManageService docubeManageService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {

		DocubeDto docubeDto = new DocubeDto()
			.setTitle("미션임파서블")
			.setBody("톰크루즈 잘생겼다")
			.setCategory(Category.ENTERTAINMENT.name())
			.setWriter("톰크루즈")
			.setTags(Lists.newArrayList("톰", "크루즈", "액션"))
			.setLike(1);

		docubeManageService.putDocube(docubeDto);

		return "Hello World!";
	}

	@RequestMapping(value = "/bye", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> bye() throws IOException {
		return docubeManageService.searchAll();
	}

}
