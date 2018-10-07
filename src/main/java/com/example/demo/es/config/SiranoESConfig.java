package com.example.demo.es.config;

import com.example.demo.es.ElasticsearchProperties;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Configuration
@Slf4j
public class SiranoESConfig {

	@Bean
	public RestHighLevelClient client(ElasticsearchProperties properties) {

		log.info("build restHighLevelClient with properties.host() : ", Arrays.toString(properties.hosts()));
		return new RestHighLevelClient(
			RestClient.builder(properties.hosts())
		);
	}
}
