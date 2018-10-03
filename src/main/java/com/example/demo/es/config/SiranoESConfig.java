package com.example.demo.es.config;

import com.example.demo.es.ElasticsearchProperties;
import lombok.Value;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Configuration
public class SiranoESConfig {

	@Bean
	public RestHighLevelClient client(ElasticsearchProperties properties) {
		return new RestHighLevelClient(
			RestClient.builder(properties.hosts())
		);
	}
}
