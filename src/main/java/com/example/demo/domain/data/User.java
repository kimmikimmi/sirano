package com.example.demo.domain.data;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
	@NotNull
	private String userId;
	@NotNull
	private String token;

	private String nickName;
	private String userName;

	private String addr1; //도,광역시, 특별시
	private String addr2; // 동읍면
	private String addr3; // 나머지
	private Integer age;

	private List<String> dislikes;
	private List<String> preferences;

	private List<String> hobbies;

	@NotNull
	private Date createDate;
	@NotNull
	private Date updateDate;

}
