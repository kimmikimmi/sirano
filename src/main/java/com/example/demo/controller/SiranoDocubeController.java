package com.example.demo.controller;

import com.example.demo.domain.data.Category;
import com.example.demo.domain.dto.DocubeDto;
import com.example.demo.domain.service.DocubeManageService;
import com.example.demo.response.SiranoResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Slf4j
@RequestMapping(value = "/docube")
@RestController
public class SiranoDocubeController {

	private final DocubeManageService docubeManageService;

	@Autowired
	public SiranoDocubeController(DocubeManageService docubeManageService) {
		this.docubeManageService = docubeManageService;
	}

	@RequestMapping(value = "/{docubeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public SiranoResponse delete(@PathVariable String docubeId) throws IOException {
		Preconditions.checkNotNull(docubeId);

		docubeManageService.delete(docubeId);
		log.info("userId : {}, docubeId : {] 인 Docube 를 제거 ");

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage("제거 성공! \n" +
				"docubeId : " + docubeId);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public SiranoResponse insert(@RequestBody DocubeDto docube) {
		Preconditions.checkNotNull(docube);

		if (StringUtils.isEmpty(docube.getTitle())) {
			docube = new DocubeDto()
				.setTitle("미션임파서블")
				.setBody("톰크루즈 잘생겼다")
				.setCategory(Category.ENTERTAINMENT.name())
				.setWriter("톰크루즈")
				.setTags(Lists.newArrayList("톰", "크루즈", "액션"))
				.setLike(1);
		}

		docubeManageService.putDocube(docube);

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage("새 도큐브 생성 성공 ");
	}

	@RequestMapping(value = "/like/{docubeId}", method = RequestMethod.POST)
	@ResponseBody
	public SiranoResponse like(@PathVariable String docubeId) throws IOException {
		Preconditions.checkNotNull(docubeId);

		docubeManageService.increaseLike(docubeId);

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage(" 도큐브 like 성공 \n" +
				"docubeId : " + docubeId);

	}

}
