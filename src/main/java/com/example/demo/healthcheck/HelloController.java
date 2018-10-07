package com.example.demo.healthcheck;

import com.example.demo.domain.data.Category;
import com.example.demo.domain.dto.DocubeDto;
import com.example.demo.domain.service.DocubeManageService;
import com.example.demo.es.ElasticsearchProperties;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Jaden
 * @since : 07/09/2018
 */
@RestController
@Slf4j
public class HelloController {

	@Autowired
	ElasticsearchProperties elasticsearchProperties;

	@Autowired
	private DocubeManageService docubeManageService;

	@RequestMapping(value = "/hello/sirano", method = RequestMethod.GET)
	@ResponseBody
	public String helloSirano() {

		DocubeDto docubeDto = new DocubeDto()
			.setTitle("미션임파서블")
			.setBody("톰크루즈 잘생겼다")
			.setCategory(Category.ENTERTAINMENT.name())
			.setWriter("톰크루즈")
			.setTags(Lists.newArrayList("톰", "크루즈", "액션"))
			.setUserId("bright2013")
			.setLike(1);

		docubeManageService.putDocube(docubeDto);

		return "Hello World!";
	}

	@RequestMapping(value = "/bye", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> bye() throws IOException {
		return docubeManageService.searchAll();
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {

		return "Hello World!";
	}
	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
	@ResponseBody
	public String hello2() {

		log.warn(Arrays.toString(elasticsearchProperties.hosts()));

		return Arrays.toString(elasticsearchProperties.hosts());
	}
}
