package com.example.demo.domain.repository;

import com.example.demo.domain.data.Docube;
import com.example.demo.es.DefaultActionListener;
import com.example.demo.es.repository.ESRepository;
import com.example.demo.es.repository.ElasticSearchRepository;
import com.example.demo.es.util.ESNameFactory;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */

@Slf4j
@Repository
public class DocubeESRepository extends ESRepository<Docube> implements ElasticSearchRepository<Docube> {
	public DocubeESRepository(RestHighLevelClient client) {
		super(client);
	}

	@PostConstruct
	public void init() {
		super.type = ESNameFactory.getType(Docube.class);
	}

	@Override
	public List<Docube> searchAll() throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		return searchAll(searchRequest);
	}

	@Override
	public List<Docube> searchAllInType() throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName, type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		return searchAll(searchRequest);
	}

	private List<Docube> searchAll(SearchRequest searchRequest) throws IOException {
		Gson gson = new Gson();

		List<Docube> docubes = Lists.newArrayList();
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			searchResponse
				.getHits()
				.forEach(item -> {
					Docube docube = gson.fromJson(item.getSourceAsString(), Docube.class);
					docube.setId(item.getId());
					docubes.add(docube);
				});

			return docubes;
		} catch (IOException e) {
			throw new IOException("fail to search ", e.getCause());
		}
	}

	@Override
	public void delete(String documentId) throws IOException {
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index(indexName);
		updateRequest.type(type);
		updateRequest.id(documentId);

		updateRequest.doc(jsonBuilder()
			.startObject()
			.field("isDeleted", true)
			.endObject());

		client.updateAsync(updateRequest, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	public void increaseLike(String documentId) throws IOException {
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index(indexName);
		updateRequest.type(type);
		updateRequest.id(documentId);

		Gson gson = new Gson();

		GetRequest getRequest = new GetRequest(indexName, type, documentId);

		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
		Docube docube = gson.fromJson(getResponse.getSourceAsString(), Docube.class);

		updateRequest.doc(jsonBuilder()
			.startObject()
			.field("like", docube.getLike() + 1)
			.endObject());

		client.updateAsync(updateRequest, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}
}
