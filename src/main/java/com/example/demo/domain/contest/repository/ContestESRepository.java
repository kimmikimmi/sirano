package com.example.demo.domain.contest.repository;

import com.example.demo.domain.contest.Contest;
import com.example.demo.es.repository.ESRepository;
import com.example.demo.es.repository.ElasticSearchRepository;
import com.example.demo.es.util.ESNameFactory;
import org.elasticsearch.client.RestHighLevelClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 21/10/2018
 */
public class ContestESRepository extends ESRepository<Contest> implements ElasticSearchRepository<Contest> {
	public ContestESRepository(RestHighLevelClient client) {
		super(client);
	}
	@PostConstruct
	public void init() {
		super.clazz = Contest.class;
		super.type = ESNameFactory.getType(Contest.class);
	}

	@Override
	public List<Contest> searchAll() throws IOException {
		return null;
	}

	@Override
	public List<Contest> searchAllInType() throws IOException {
		return null;
	}
}
