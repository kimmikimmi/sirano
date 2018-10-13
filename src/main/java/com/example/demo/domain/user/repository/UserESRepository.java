package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.data.User;
import com.example.demo.es.DefaultActionListener;
import com.example.demo.es.repository.ESRepository;
import com.example.demo.es.repository.ElasticSearchRepository;
import com.example.demo.es.util.ESNameFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import lombok.val;
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
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author : Jaden
 * @since : 13/10/2018
 */
@Repository
public class UserESRepository extends ESRepository<User> implements ElasticSearchRepository<User> {
	public UserESRepository(RestHighLevelClient client) {
		super(client);
	}

	@PostConstruct
	public void init() {
		super.clazz = User.class;
		super.type = ESNameFactory.getType(User.class);
	}

	@Override
	public List<User> searchAll() throws IOException {
		return null;
	}

	@Override
	public List<User> searchAllInType() throws IOException {
		return null;
	}

	public Optional<User> searchByUserId(String userId) throws IOException {
		val searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		val searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.matchQuery("isDeleted", false))
			.query(QueryBuilders.matchQuery("userId", userId));

		searchRequest.source(searchSourceBuilder);

		return Lists.newArrayList(search(searchRequest)).stream().findFirst();
	}

	public Optional<User> searchByUserIdAndToken(String userId, String token) throws IOException {
		val searchRequest = new SearchRequest(indexName);
		searchRequest.types(type);

		val searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder
			.query(QueryBuilders.matchQuery("userId", userId))
			.query(QueryBuilders.matchQuery("token", token))
			.query(QueryBuilders.matchQuery("isDeleted", false));


		searchRequest.source(searchSourceBuilder);

		return Lists.newArrayList(search(searchRequest)).stream().findFirst();
	}

	private Collection<User> search(SearchRequest searchRequest) throws IOException {
		val gson = new Gson();

		Set<User> users = Sets.newHashSet();
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			searchResponse
				.getHits()
				.forEach(item -> {
					User user = gson.fromJson(item.getSourceAsString(), User.class);
					user.setId(item.getId());
					users.add(user);
				});

			return users;
		} catch (IOException e) {
			throw new IOException("fail to search ", e.getCause());
		}
	}

	public void updateToken(String documentId, String token) throws IOException {
		UpdateRequest updateRequest = new UpdateRequest(indexName, type, documentId);

		val user = getDocumentById(documentId);
		updateRequest.doc(jsonBuilder()
			.startObject()
			.field("token", token)
			.endObject());

		client.updateAsync(updateRequest, RequestOptions.DEFAULT, new DefaultActionListener<>());
	}
}
