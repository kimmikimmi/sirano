package com.example.demo.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : Jaden
 * @since : 09/09/2018
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

	Article findByTitle(String title);
}
