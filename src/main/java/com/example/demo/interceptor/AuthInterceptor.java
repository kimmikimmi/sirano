package com.example.demo.interceptor;

import com.example.demo.config.AuthConfig;
import com.example.demo.domain.user.AuthService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Jaden
 * @since : 17/10/2018
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor, AsyncHandlerInterceptor {

	private final AuthService authService;
	private final String USER_TOKEN = "userToken";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		val header = request.getHeader(USER_TOKEN);

		if (isUnderAuth(request.getServletPath())) {
			if (isValidHeader(header)) {
				val idAndToken = Lists.newArrayList(header.split("@"));
				return authService.checkIfIsAuthorized(idAndToken.get(0), idAndToken.get(1));

			} else {
				throw new IllegalArgumentException("No header or header format is wrong");
			}

		}

		return true;
	}

	private boolean isUnderAuth(String servletPath) {

		return AuthConfig.urlsUnderAuth
			.stream()
			.anyMatch(servletPath::startsWith);
	}

	private boolean isValidHeader(String header) {
		return StringUtils.isEmpty(header) && header.contains("@");
	}
}
