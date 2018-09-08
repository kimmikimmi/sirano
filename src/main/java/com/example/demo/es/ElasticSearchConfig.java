//package com.example.demo.es;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
///**
// * @author : Jaden
// * @since : 07/09/2018
// */
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.example.demo.es.repository")
//@ComponentScan(basePackages = "com.example.demo.es.service")
//public class ElasticSearchConfig {
//
//	@Value("${elasticsearch.path}")
//	private String elasticSearchPath;
//
//	@Value("${elasticsearch.clustername}")
//	private String clusterName;
//
//	@Value("${elasticsearch.host}")
//	private String host;
//
//	@Value("${elasticsearch.port}")
//	private String port;
//
//	@Bean
//	public Client client() throws UnknownHostException {
//		Settings esSettings = Settings.builder()
//			.put("client.transport.sniff", true)
//			.put("path.home", elasticSearchPath)
//			.put("cluster.name", clusterName)
//			.build();
//
//		TransportClient client = new PreBuiltTransportClient(esSettings);
//		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), Integer.getInteger(port)));
//
//		return client;
//	}
//
//	@Bean
//	public ElasticsearchOperations elasticSearchTemplate() throws UnknownHostException {
//		return new ElasticsearchTemplate(client());
//	}
//}
