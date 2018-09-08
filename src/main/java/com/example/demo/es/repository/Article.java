package com.example.demo.es.repository;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author : Jaden
 * @since : 09/09/2018
 */
@Document(indexName = "sirano", type = "article")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Article {

	@Id
	private String id;

	private String title;


}
