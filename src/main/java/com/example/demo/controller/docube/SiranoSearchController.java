package com.example.demo.controller.docube;

import com.example.demo.domain.docube.data.Category;
import com.example.demo.domain.docube.dto.DocubeDto;
import com.example.demo.domain.docube.service.DocubeManageService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@RequestMapping(value = "/docube/search")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SiranoSearchController {

	private final DocubeManageService docubeManageService;

	/**
	 * search based on # of likes .
	 */
	@GetMapping(value = "/most-popular/{userId}")
	public List<DocubeDto> mostPopularDocubes(@RequestParam int offset, @RequestParam int limit, @PathVariable String userId) {
		Preconditions.checkNotNull(userId);

		return docubeManageService.searchInPopular(offset, limit, userId);
	}

	@GetMapping(value = "/category/{userId}")
	public List<DocubeDto> docubesByCategory(@RequestParam String category, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Category categoryEnum = Category.valueOf(category);

		return docubeManageService.searchInCategory(offset, limit, categoryEnum);
	}

	@GetMapping(value = "/tag/{userId}")
	public List<DocubeDto> DocubesByTag(@RequestParam String tag, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Preconditions.checkNotNull(tag);

		// userId 를 어떻게 확용할 수 있을까? 개인화...
		return docubeManageService.searchByTag(offset, limit, tag);
	}

	@GetMapping(value = "/keyword/{userId}")
	public List<DocubeDto> docubesByKeyword(@RequestParam String keyword, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);
		Preconditions.checkNotNull(keyword);

		return docubeManageService.searchByKeyword(offset, limit, keyword);

	}

	/**
	 * 특정 유저가 작성한 docube list search order by modified date
	 */
	@GetMapping(value = "/all/{userId}")
	public List<DocubeDto> docubesByUser(@RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) throws IOException {
		Preconditions.checkNotNull(userId);

		return docubeManageService.searchByUser(offset, limit, userId);

	}
}
