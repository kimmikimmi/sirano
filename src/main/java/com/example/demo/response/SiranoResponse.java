package com.example.demo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SiranoResponse {
	private String statusCode;
	private String message;

	public SiranoResponse(String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
}
