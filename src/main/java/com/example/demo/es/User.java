package com.example.demo.es;

import lombok.*;

import java.util.Date;

/**
 * @author : Jaden
 * @since : 16/09/2018
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
	private Date postDate;
	private String userName;
	private String message;
}
