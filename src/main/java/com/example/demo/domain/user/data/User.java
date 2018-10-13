package com.example.demo.domain.user.data;

import lombok.*;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@ToString
public class User {
	@NotNull
	private String id;

	@NotNull
	private String userId;
	@NotNull
	private String token;

	private String nickName;
	private String userName;

	private Integer age;

	private List<String> dislikes;
	private List<String> preferences;

	private List<String> followers;
	private List<String> followings;

	@NotNull
	private boolean isDeleted;
	@NotNull
	private Date createDate;
	@NotNull
	private Date updateDate;

}
