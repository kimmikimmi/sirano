package com.example.demo.es.service;

import com.example.demo.es.repository.Article;
import com.example.demo.es.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author : Jaden
 * @since : 09/09/2018
 */
@Service
public class ArticleService {
	@Autowired
	ElasticsearchOperations operations;
	@Autowired
	ArticleRepository articleRepository;

	@PostConstruct
	@Transactional
	public void loadAll() {
		System.out.println("------------------------------RUN");
		operations.putMapping(Article.class);
		System.out.println("Loading Data");
		articleRepository.save(new Article("id1", "title1"));
		System.out.printf("Loading Completed");
	}
}
