package com.example.demo.domain.user.dto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author : Jaden
 * @since : 13/10/2018
 */
@ToString
@EqualsAndHashCode
@Getter
@Accessors(chain = true)
@RequiredArgsConstructor
public class UserDto {
	@NotNull
	private String userId;

	private String userName;
	private String nickName;
	private Integer age;

	@NotNull
	private String token;
	@NotNull
	private String timeStamp; // yyyyMMddhhmmss
}
