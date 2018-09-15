package com.example.demo.es;

import com.google.common.collect.Lists;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Component
@Setter
public class ElasticsearchProperties {

	private List<String> hosts = Lists.newArrayList("http://localhost:9200");

	public HttpHost[] hosts() {
		return hosts.stream().map(HttpHost::create).toArray(HttpHost[]::new);
	}
}
