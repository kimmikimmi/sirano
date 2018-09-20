package com.example.demo.dto;

import lombok.*;

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
public class DocubeDto {
	private Long docubeId;
	private String title;
	private String body;

	private long like;
	private long dislike;

	private List<String> tags;

	private String writer;

	private String category;
}
