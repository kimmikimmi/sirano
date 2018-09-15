package com.example.demo.controller;

import com.example.demo.es.DefaultActionListener;
import com.example.demo.es.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : Jaden
 * @since : 07/09/2018
 */
@RestController
@Slf4j
public class HelloController {


	@Autowired
	RestHighLevelClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		Gson gson = new Gson();

		User user = new User();
//		user.setUserName("jaden");
//		user.setMessage("hello from jaden");
//		user.setPostDate(new Date());

//		IndexRequest indexRequest = new IndexRequest("sirano", "users");
//		indexRequest.source(gson.toJson(user), XContentType.JSON);
//		client.indexAsync(indexRequest, RequestOptions.DEFAULT,  new DefaultActionListener<>()); //2

		GetRequest request = new GetRequest("sirano", "users", "bsj93WUBUsARE1752c1D");
		client.getAsync(request, RequestOptions.DEFAULT, new ActionListener<GetResponse>() {
			@Override
			public void onResponse(GetResponse documentFields) {
				log.info(gson.fromJson(documentFields.getSourceAsString(), User.class).getMessage());

			}

			@Override
			public void onFailure(Exception e) {
				e.printStackTrace();
			}
		});


		return "Hello World!";
	}

}
