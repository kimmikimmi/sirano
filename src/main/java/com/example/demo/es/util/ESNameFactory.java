package com.example.demo.es.util;

import lombok.Getter;

/**
 * @author : Jaden
 * @since : 04/10/2018
 */
public class ESNameFactory {

	@Getter
	private static String index = "sirano";

	public static String getType(Class clazz) {
		return camelToSnake(clazz.getSimpleName());
	}

	private static String camelToSnake(String name) {
		String regex = "([a-z])([A-Z]+)";
		String replacement = "$1_$2";

		return name.replaceAll(regex, replacement)
			.toLowerCase();
	}

}
