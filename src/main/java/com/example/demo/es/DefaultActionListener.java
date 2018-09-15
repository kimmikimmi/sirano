package com.example.demo.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.replication.ReplicationResponse;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Slf4j
public class DefaultActionListener<T extends ReplicationResponse> implements ActionListener<T> {
	@Override
	public void onResponse(T response) {
		log.debug("ES send success. response : {}", response);
	}

	@Override
	public void onFailure(Exception e) {
		log.info("ES send fail. exception : {}", e.getMessage());
	}
}
