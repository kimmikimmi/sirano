package com.example.demo.controller;

import com.example.demo.domain.data.Category;
import com.example.demo.domain.dto.DocubeDto;
import com.example.demo.domain.service.DocubeManageService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@RequestMapping(value = "/docube/search")
@RestController
@Slf4j
public class SiranoSearchController {

	private final DocubeManageService docubeManageService;

	@Autowired
	public SiranoSearchController(DocubeManageService docubeManageService) {
		this.docubeManageService = docubeManageService;
	}

	/**
	 * search based on # of likes .
	 * @param offset
	 * @param limit
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/most-popular/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> mostPopularDocubes(@RequestParam int offset, @RequestParam int limit, @PathVariable String userId) {
		Preconditions.checkNotNull(userId);

		return docubeManageService.searchInPopular(offset, limit, userId);
	}

	@RequestMapping(value = "/category/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> docubesByCategory(@RequestParam String category, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Category categoryEnum = Category.valueOf(category);

		return docubeManageService.searchInCategory(offset, limit, categoryEnum);
	}

	@RequestMapping(value = "/tag/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> DocubesByTag(@RequestParam String tag, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Preconditions.checkNotNull(tag);

		// userId 를 어떻게 확용할 수 있을까? 개인화...
		return docubeManageService.searchByTag(offset, limit, tag);
	}

	@RequestMapping(value = "/keyword/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> docubesByKeyword(@RequestParam String keyword, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Preconditions.checkNotNull(keyword);

		return docubeManageService.searchByKeyword(offset, limit, keyword);

	}

	/**
	 * 특정 유저가 작성한 docube list search order by modified date
	 */
	@RequestMapping(value = "/all/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> docubesByUser(@RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);

		return docubeManageService.searchByUser(offset, limit, userId);

	}
}
