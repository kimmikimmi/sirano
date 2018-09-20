package com.example.demo.data;

import lombok.Getter;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
public enum Category {
	ENTERTAINMENT("연예"), BUSINESS("비지니스"), POLITICS("정치"), LOVE("사랑"), FRIENDSHIP("우정"), SPORT("스포츠");

	Category(String description) {
		this.description = description;
	}

	@Getter
	private String description;
}
