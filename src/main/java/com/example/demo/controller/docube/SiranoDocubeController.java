package com.example.demo.controller.docube;

import com.example.demo.domain.docube.data.Category;
import com.example.demo.domain.docube.dto.DocubeDto;
import com.example.demo.domain.docube.service.DocubeManageService;
import com.example.demo.response.SiranoResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Slf4j
@RequestMapping(value = "/docube")
@RequiredArgsConstructor
@RestController
public class SiranoDocubeController {

	private final DocubeManageService docubeManageService;

	@DeleteMapping(value = "/{docubeId}")
	@SneakyThrows
	public SiranoResponse delete(@PathVariable String docubeId) {
		Preconditions.checkNotNull(docubeId);

		docubeManageService.delete(docubeId);
		log.info("userId : {}, docubeId : {] 인 Docube 를 제거 ");

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage("제거 성공! \n" +
				"docubeId : " + docubeId);
	}

	@PutMapping
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

	@PostMapping(value = "/like/{docubeId}")
	@SneakyThrows
	public SiranoResponse like(@PathVariable String docubeId) {
		Preconditions.checkNotNull(docubeId);

		docubeManageService.increaseLike(docubeId);

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage(" 도큐브 like 성공 \n" +
				"docubeId : " + docubeId);

	}

}
