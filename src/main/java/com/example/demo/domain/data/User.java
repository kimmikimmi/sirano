package com.example.demo.domain.data;

import lombok.*;

import java.util.Date;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
	private Long userId;
	private String nickName;
	private String userName;
	private String password;
	private String token;
	private Integer age;
	private Date createDate;
	private Date updateDate;

}
