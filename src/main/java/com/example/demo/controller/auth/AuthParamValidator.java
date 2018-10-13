package com.example.demo.controller.auth;

import com.example.demo.domain.user.dto.UserDto;
import com.google.common.base.Preconditions;

/**
 * @author : Jaden
 * @since : 13/10/2018
 */
public class AuthParamValidator {
	public static void validate(UserDto userDto) {
		Preconditions.checkNotNull(userDto);
		Preconditions.checkNotNull(userDto.getUserId());
		Preconditions.checkNotNull(userDto.getToken());
		Preconditions.checkNotNull(userDto.getTimeStamp());
	}
}
