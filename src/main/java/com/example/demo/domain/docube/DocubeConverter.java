package com.example.demo.domain.docube;

import com.example.demo.domain.docube.data.Docube;
import com.example.demo.domain.docube.dto.DocubeDto;

import java.util.Date;

/**
 * @author : Jaden
 * @since : 20/09/2018
 */
public class DocubeConverter {
	public static DocubeDto toDocubeDto(Docube docube) {

		return new DocubeDto()
			.setDocubeId(docube.getId())
			.setTitle(docube.getTitle())
			.setBody(docube.getBody())
			.setCategory(docube.getCategory())
			.setWriter(docube.getWriter())
			.setTags(docube.getTags())
			.setLike(docube.getLike())
			.setUserId(docube.getUserId())
			.setCreatedDate(docube.getCreatedDate())
			.setUpdatedDate(docube.getUpdateDate());
	}

	public static Docube toDocube(DocubeDto docubeDto) {
		Docube docube = new Docube();

		docube.setTitle(docubeDto.getTitle());
		docube.setBody(docubeDto.getBody());
		docube.setTags(docubeDto.getTags());
		docube.setLike(docubeDto.getLike());
		docube.setWriter(docubeDto.getWriter());
		docube.setCategory(docubeDto.getCategory());
		docube.setUserId(docubeDto.getUserId());

		docube.setCreatedDate(new Date());
		docube.setUpdateDate(new Date());
		docube.setDeleted(false);

		return docube;
	}
}
