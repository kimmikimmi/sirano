package com.example.demo.es.repository;

import com.example.demo.data.Docube;
import com.example.demo.es.DefaultActionListener;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Slf4j
public class DocubeESRepository extends ESRepository<Docube> implements ElasticSearchRepository<Docube> {
	public DocubeESRepository(RestHighLevelClient client) {
		super(client);
	}

	@Override
	public void createIndex(String indexName, Docube docube) {
		Gson gson = new Gson();

		IndexRequest request = new IndexRequest(indexName);

		request.source(gson.toJson(docube), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	@Override
	public void createType(String indexName, String typeName, Docube docube) {
		Gson gson = new Gson();
		IndexRequest request = new IndexRequest(indexName, typeName);

		request.source(gson.toJson(docube), XContentType.JSON);
		client.indexAsync(request, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	@Override
	public List<Docube> lookAllUp(String index) throws IOException {
		SearchRequest searchRequest = new SearchRequest(index);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			throw new IOException("fail to search ", e.getCause());
		}

		return Lists.newArrayList();
	}

	@Override
	public List<Docube> lookAllUp(String index, String type) throws IOException {
		SearchRequest searchRequest = new SearchRequest(index, type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			throw new IOException("fail to search ", e.getCause());
		}

		return Lists.newArrayList();
	}
}
