package com.example.demo.config;

import com.example.demo.interceptor.AuthInterceptor;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

/**
 * @author : Jaden
 * @since : 17/10/2018
 */
@Configuration
@RequiredArgsConstructor
public class AuthConfig implements WebMvcConfigurer {
	private final AuthInterceptor authInterceptor;


	public static Set<String> urlsUnderAuth = Sets.newHashSet("/under-auth");
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor);
	}
}
