package com.example.demo.domain.contest;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : Jaden
 * @since : 21/10/2018
 */

@Getter
@Setter
public class Contest {
	private String id;

	private String title;
	private String body;

	private String writer;

	private Date startDate;
	private Date endDate;

	private String etc;

	private Date createdDate;
	private Date updateDate;

}
