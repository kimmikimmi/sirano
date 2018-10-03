package com.example.demo.es.repository;

import com.example.demo.es.DefaultActionListener;
import com.google.gson.Gson;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Repository
public abstract class ESRepository<T> {

	protected RestHighLevelClient client;

	@Autowired
	public ESRepository(RestHighLevelClient client) {
		this.client = client;
	}

	public void createIndex(String indexName, T document) {
		Gson gson = new Gson();

		IndexRequest request = new IndexRequest(indexName);

		request.source(gson.toJson(document), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	public void createType(String indexName, String typeName, T document) {
		Gson gson = new Gson();
		IndexRequest request = new IndexRequest(indexName, typeName);

		request.source(gson.toJson(document), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}





}
