package com.example.demo.domain.service;

import com.example.demo.domain.DocubeConverter;
import com.example.demo.domain.dto.DocubeDto;
import com.example.demo.domain.repository.DocubeESRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
@Service
@Slf4j
public class DocubeManageService {
	final private DocubeESRepository docubeESRepository;

	@Autowired
	public DocubeManageService(DocubeESRepository docubeESRepository) {
		this.docubeESRepository = docubeESRepository;
	}

	public void putDocube(DocubeDto docubeDto) {

		docubeESRepository.insert(DocubeConverter.toDocube(docubeDto));
	}

	public List<DocubeDto> searchAll() throws IOException {
		try {
			return docubeESRepository.searchAllInType()
				.stream()
				.map(DocubeConverter::toDocubeDto)
				.collect(Collectors.toList());
		} catch (IOException e) {
			log.error("fail to get all documents from docube index");
			throw new IOException();
		}
	}

	public void delete(String docubeId) throws IOException {
		docubeESRepository.delete(docubeId);

	}

	public void increaseLike(String docubeId) throws IOException {
		docubeESRepository.increaseLike(docubeId);
	}
}
