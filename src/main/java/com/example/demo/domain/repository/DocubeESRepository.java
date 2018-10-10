package com.example.demo.domain.repository;

import com.example.demo.domain.data.Category;
import com.example.demo.domain.data.Docube;
import com.example.demo.domain.dto.DocubeDto;
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
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
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
		super.clazz = Docube.class;
		super.type = ESNameFactory.getType(Docube.class);
	}

	@Override
	public List<Docube> searchAll() throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		return search(searchRequest);
	}

	@Override
	public List<Docube> searchAllInType() throws IOException {

		return Lists.newArrayList();
	}

	private List<Docube> search(SearchRequest searchRequest) throws IOException {
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
		UpdateRequest updateRequest = new UpdateRequest(indexName, type, documentId);

		Docube docube = getDocumentById(documentId);
		updateRequest.doc(jsonBuilder()
			.startObject()
			.field("like", docube.getLike() + 1)
			.endObject());

		client.updateAsync(updateRequest, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}

	public List<Docube> searchByUser(int offset, int limit, String userId) throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.termQuery("userId", userId))
			.from(offset)
			.size(limit);

		searchRequest.source(searchSourceBuilder);

		return search(searchRequest);
	}

	public List<Docube> searchByTag(int offset, int limit, String tag) throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.fuzzyQuery("tag", tag))
			.from(offset)
			.size(limit);

		searchRequest.source(searchSourceBuilder);

		return search(searchRequest);
	}

	public List<Docube> searchByKeyword(int offset, int limit, String keyword) throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.fuzzyQuery("title", keyword))
			.query(QueryBuilders.fuzzyQuery("body", keyword))
			.from(offset)
			.size(limit);

		searchRequest.source(searchSourceBuilder);

		return search(searchRequest);
	}

	public List<Docube> searchByCategory(int offset, int limit, Category categoryEnum) throws IOException {
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.matchQuery("category", categoryEnum.name()))
			.from(offset)
			.size(limit);

		searchRequest.source(searchSourceBuilder);

		return search(searchRequest);
	}

	public List<Docube> searchInPopular(int offset, int limit, String userId) {
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		SearchSourceBuilder searchRequestBuilder = new SearchSourceBuilder();
//		searchRequestBuilder.query(QueryBuilders.constantScoreQuery(BoolQueryBuilder.))

		return Lists.newArrayList();
	}
}
