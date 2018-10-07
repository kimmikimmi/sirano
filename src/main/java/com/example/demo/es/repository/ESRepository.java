package com.example.demo.es.repository;

import com.example.demo.es.DefaultActionListener;
import com.example.demo.es.util.ESNameFactory;
import com.google.gson.Gson;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Repository
public abstract class ESRepository<T> {

	protected Class<T> clazz;

	protected RestHighLevelClient client;
	protected final String indexName = ESNameFactory.getIndex();
	protected String type;

	@Autowired
	public ESRepository(RestHighLevelClient client) {
		this.client = client;
	}

	public void createIndex(T document) {
		Gson gson = new Gson();

		IndexRequest request = new IndexRequest(indexName, indexName);

		request.source(gson.toJson(document), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	public void insert(T document) {
		Gson gson = new Gson();
		IndexRequest request = new IndexRequest(indexName, type);

		request.source(gson.toJson(document), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	public T getDocumentById(String documentId) throws IOException {
		Gson gson = new Gson();

		GetRequest getRequest = new GetRequest(indexName, type, documentId);
		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

		return gson.fromJson(getResponse.getSourceAsString(), clazz);
	}

}
