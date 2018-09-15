//package com.example.demo.es;
//
//import com.example.demo.es.repository.Article;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import javax.annotation.PostConstruct;
//
///**
// * @author : Jaden
// * @since : 07/09/2018
// */
//@Configuration
//public class ElasticSearchMappingConfig {
//	@Autowired
//	ElasticsearchOperations operations;
//
//	@PostConstruct
//	public void init() {
//		operations.putMapping(Article.class);
//	}
//}
