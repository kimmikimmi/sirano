//package com.example.demo.es.repository;
//
//import lombok.*;
//import lombok.experimental.Accessors;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
///**
// * @author : Jaden
// * @since : 09/09/2018
// */
//@Document(indexName = "sirano", type = "article")
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@Accessors(chain = true)
//public class Article {
//
//	@Id
//	@Field(type = FieldType.Text, index = true)
//	private String id;
//
//	@Field(type = FieldType.Text)
//	private String title;
//
//	@Field(type = FieldType.Text)
//	private String body;
//
//	@Field(type = FieldType.Text)
//	private String tags;
//
//	@Field(type = FieldType.Text)
//	private String userId;
//
//	@Field(type = FieldType.Text)
//	private String category;
//
//	@Field(type = FieldType.Date, format = DateFormat.basic_date_time_no_millis)
//	private String createDate;
//
//	@Field(type = FieldType.Date, format = DateFormat.basic_date_time_no_millis)
//	private String updateDate;
//
//}
