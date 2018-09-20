package com.example.demo.es.repository;

import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

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





}
