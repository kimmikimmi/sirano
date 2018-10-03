package com.example.demo.domain.data;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Docube {
	private String id;

	private String title;
	private String body;

	private long like;

	private List<String> tags;

	private String writer;

	private String category;

	private Date createdDate;
	private Date updateDate;

	private boolean isDeleted;

	private String userId;
}
