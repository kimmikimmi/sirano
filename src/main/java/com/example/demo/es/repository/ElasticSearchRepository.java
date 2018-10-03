package com.example.demo.es.repository;

import java.io.IOException;
import java.util.List;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
public interface ElasticSearchRepository<T> {

	/**
	 * index 내 모든 범위에서 검색한다. MATCH_ALL
	 * @return
	 * @throws IOException
	 */
	List<T> searchAll() throws IOException;

	/**
	 * index 내 특정 타입으로 검색한다
	 * @return
	 * @throws IOException
	 */
	List<T> searchAllInType() throws IOException;

	/**
	 * 해당 documentId 에 해당하는 document 를 제거한다.
	 * @param documentId
	 * @throws IOException
	 */
	void delete(String documentId) throws IOException;

}
