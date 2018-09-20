package com.example.demo.controller;

import com.example.demo.data.Category;
import com.example.demo.dto.DocubeDto;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@RestController("/docube/search")
@Slf4j
public class SiranoSearchController {
	@RequestMapping(value = "/most-popular/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> mostPopularDocubes(@RequestParam int offset, @RequestParam int limit, @PathVariable String userId) {
		Preconditions.checkNotNull(userId);

		DocubeDto d1 = new DocubeDto();
		d1.setDocubeId(1L);
		d1.setTitle("제시카");
		d1.setBody("소녀시대 제시카 성형..");
		d1.setCategory(Category.ENTERTAINMENT.getDescription());
		d1.setLike(5);
		d1.setDislike(2);
		d1.setWriter("공원기");

		DocubeDto d2 = new DocubeDto();
		d2.setDocubeId(2L);
		d2.setTitle("박보검");
		d2.setBody("박보검 키 실화..?");
		d2.setCategory(Category.ENTERTAINMENT.getDescription());
		d2.setLike(10);
		d2.setDislike(2);
		d2.setWriter("김현준");

		return Lists.newArrayList(d1, d2);
	}

	@RequestMapping(value = "/category/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> mostPopularDocubes(@RequestParam String category, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) {
		Preconditions.checkNotNull(userId);
		Category categoryEnum = Category.valueOf(category);

		DocubeDto d1 = new DocubeDto();
		d1.setDocubeId(1L);
		d1.setTitle("제시카");
		d1.setBody("소녀시대 제시카 성형..");
		d1.setCategory(Category.ENTERTAINMENT.getDescription());
		d1.setLike(5);
		d1.setDislike(2);
		d1.setWriter("공원기");

		DocubeDto d2 = new DocubeDto();
		d2.setDocubeId(2L);
		d2.setTitle("박보검");
		d2.setBody("박보검 키 실화..?");
		d2.setCategory(Category.ENTERTAINMENT.getDescription());
		d2.setLike(10);
		d2.setDislike(2);
		d2.setWriter("김현준");

		return Lists.newArrayList(d1, d2);
	}

	@RequestMapping(value = "/tag/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> DocubesBytag(@RequestParam String tag, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) {
		Preconditions.checkNotNull(userId);
		Category categoryEnum = Category.valueOf(tag);

		DocubeDto d1 = new DocubeDto();
		d1.setDocubeId(1L);
		d1.setTitle("제시카");
		d1.setBody("소녀시대 제시카 성형..");
		d1.setCategory(Category.ENTERTAINMENT.getDescription());
		d1.setLike(5);
		d1.setDislike(2);
		d1.setWriter("공원기");

		DocubeDto d2 = new DocubeDto();
		d2.setDocubeId(2L);
		d2.setTitle("박보검");
		d2.setBody("박보검 키 실화..?");
		d2.setCategory(Category.ENTERTAINMENT.getDescription());
		d2.setLike(10);
		d2.setDislike(2);
		d2.setWriter("김현준");

		return Lists.newArrayList(d1, d2);
	}

	@RequestMapping(value = "/keyword/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> docubesBykeyWord(@RequestParam String keyword, @RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) {
		Preconditions.checkNotNull(userId);
		Category categoryEnum = Category.valueOf(keyword);

		DocubeDto d1 = new DocubeDto();
		d1.setDocubeId(1L);
		d1.setTitle("제시카");
		d1.setBody("소녀시대 제시카 성형..");
		d1.setCategory(Category.ENTERTAINMENT.getDescription());
		d1.setLike(5);
		d1.setDislike(2);
		d1.setWriter("공원기");

		DocubeDto d2 = new DocubeDto();
		d2.setDocubeId(2L);
		d2.setTitle("박보검");
		d2.setBody("박보검 키 실화..?");
		d2.setCategory(Category.ENTERTAINMENT.getDescription());
		d2.setLike(10);
		d2.setDislike(2);
		d2.setWriter("김현준");

		return Lists.newArrayList(d1, d2);
	}

	@RequestMapping(value = "/all/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DocubeDto> docubesByUser(@RequestParam int offset, @RequestParam int limit,
		@PathVariable String userId) {
		Preconditions.checkNotNull(userId);

		DocubeDto d1 = new DocubeDto();
		d1.setDocubeId(1L);
		d1.setTitle("제시카");
		d1.setBody("소녀시대 제시카 성형..");
		d1.setCategory(Category.ENTERTAINMENT.getDescription());
		d1.setLike(5);
		d1.setDislike(2);
		d1.setWriter("공원기");

		DocubeDto d2 = new DocubeDto();
		d2.setDocubeId(2L);
		d2.setTitle("박보검");
		d2.setBody("박보검 키 실화..?");
		d2.setCategory(Category.ENTERTAINMENT.getDescription());
		d2.setLike(10);
		d2.setDislike(2);
		d2.setWriter("김현준");

		return Lists.newArrayList(d1, d2);
	}
}
