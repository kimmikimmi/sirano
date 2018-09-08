package com.example.demo.es.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author : Jaden
 * @since : 09/09/2018
 */
@Document(indexName = "sirano", type = "article")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Article {

	@Id
	@Field(type = FieldType.Text)
	private String id;

	@Field(type = FieldType.Text)
	private String title;

}
