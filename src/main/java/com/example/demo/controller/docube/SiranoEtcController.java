package com.example.demo.controller.docube;

import com.example.demo.domain.docube.data.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@RestController
@Slf4j
public class SiranoEtcController {

	@GetMapping("/category")
	public Map<String, String> category() {
		return Arrays.stream(Category.values())
			.collect(Collectors.toMap(Enum::name, Category::getDescription));
	}

}
