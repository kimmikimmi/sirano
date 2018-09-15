//package com.example.demo.es.service;
//
//import com.example.demo.es.repository.Article;
//import com.example.demo.es.repository.ArticleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.util.Date;
//
///**
// * @author : Jaden
// * @since : 09/09/2018
// */
//@Service
//public class ArticleService {
//	@Autowired
//	ArticleRepository articleRepository;
//
//	@PostConstruct
//	@Transactional
//	public void loadAll() {
//		System.out.println("------------------------------RUN");
//		System.out.println("Loading Data");
//
//
//		articleRepository.save(
//			new Article()
//				.setId("id1")
//				.setTags("test")
//				.setUserId("bright2013")
//				.setTitle("title")
//				.setBody("body")
//		);
//
//		System.out.printf("Loading Completed");
//	}
//}
