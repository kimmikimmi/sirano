package com.example.demo.domain.docube.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class DocubeDto {
	private String docubeId;
	private String userId;

	private String title;
	private String body;

	private long like;

	private List<String> tags;

	private String writer;

	private String category;

	private Date updatedDate;
	private Date createdDate;
}
