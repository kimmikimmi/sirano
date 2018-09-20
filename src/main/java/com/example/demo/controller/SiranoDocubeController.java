package com.example.demo.controller;

import com.example.demo.dto.DocubeDto;
import com.example.demo.response.SiranoResponse;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Slf4j
@RequestMapping(value = "/docube")
public class SiranoDocubeController {

	@RequestMapping(value = "/{userId}/{docubeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public SiranoResponse delete(@PathVariable String userId, @PathVariable Long docubeId) {
		Preconditions.checkNotNull(userId);
		Preconditions.checkNotNull(docubeId);

		log.info("userId : {}, docubeId : {] 인 Docube 를 제거 ");
		/*
			docubeId 인 docube 의 isDeleted 필드 true 로 수정

		 */

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage("제거 성공! \n" +
				"docubeId : " + docubeId + "\n" +
				"userId : " + userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public SiranoResponse insert(@PathVariable String userId, @RequestBody DocubeDto docube) {
		Preconditions.checkNotNull(docube);
		Preconditions.checkNotNull(userId);

		// insert

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage("새 도큐브 생성 성공 \n" +
				"userId : " + userId + "\n" +
				"docubeId : " + 1L);

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public SiranoResponse update(@PathVariable String userId, @RequestBody DocubeDto docube) {
		Preconditions.checkNotNull(docube);
		Preconditions.checkNotNull(userId);

		// insert

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage(" 도큐브 업데이트 성공 \n" +
				"userId : " + userId + "\n" +
				"docubeId : " + 1L);

	}

	@RequestMapping(value = "/like/{docubeId}", method = RequestMethod.POST)
	@ResponseBody
	public SiranoResponse like(@PathVariable Long docubeId) {
		Preconditions.checkNotNull(docubeId);

		//like

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage(" 도큐브 like 성공 \n" +
				"docubeId : " + 1L);

	}

	@RequestMapping(value = "/dislike/{docubeId}", method = RequestMethod.POST)
	@ResponseBody
	public SiranoResponse dislike(@PathVariable Long docubeId) {
		Preconditions.checkNotNull(docubeId);

		//dislike

		return new SiranoResponse()
			.setStatusCode("200")
			.setMessage(" 도큐브 dislike 성공 \n" +
				"docubeId : " + 1L);

	}
}
