package com.example.demo.es.repository;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
public interface ElasticSearchRepository<T> {

	void createIndex(String indexName, T entity);

	void createType(String indexName, String typeName, T entity);

	List<T> lookAllUp(String index) throws IOException;

	List<T> lookAllUp(String index, String type) throws IOException;

}
