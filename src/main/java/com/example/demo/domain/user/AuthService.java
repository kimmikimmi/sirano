package com.example.demo.domain.user;

import com.example.demo.domain.user.data.User;
import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.domain.user.repository.UserESRepository;
import joptsimple.internal.Strings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * @author : Jaden
 * @since : 11/10/2018
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
	private final UserESRepository userESRepository;

	public boolean addUser(UserDto userDto) throws IOException {
		val user = userESRepository.searchByUserId(userDto.getUserId());

		if (user.isPresent()) {
			log.info("이미 userId : {} 로 등록된 유저가 존재합니다", userDto.getUserId());
			return false;
		}

		val newUser = new User()
			.setUserId(userDto.getUserId())
			.setUserName(userDto.getUserName())
			.setToken(userDto.getToken())
			.setNickName(userDto.getNickName())
			.setAge(userDto.getAge())
			.setDeleted(false)
			.setCreateDate(new Date())
			.setUpdateDate(new Date());

		userESRepository.insert(newUser);

		log.info("userId : {} , token : {} is registered", userDto.getUserId(), userDto.getToken());

		return true;
	}

	public boolean checkIfIsAuthorized(UserDto userDto) throws IOException {
		val authorizedUser = userESRepository.searchByUserIdAndToken(userDto.getUserId(), userDto.getToken());

		return authorizedUser.isPresent();
	}

	public void authorizeUser(UserDto userDto) throws IOException {
		if (checkIfIsAuthorized(userDto)) {
			log.info("이미 인증된 유저와 토큰입니다.");
			return;
		}

		val user = userESRepository.searchByUserId(userDto.getUserId())
			.orElseThrow(IOException::new);

		userESRepository.updateToken(user.getId(), userDto.getToken());
	}

	public boolean logOut(UserDto userDto) throws IOException {
		if (!checkIfIsAuthorized(userDto)) {
			return false;
		}

		val user = userESRepository.searchByUserId(userDto.getUserId())
			.orElseThrow(IOException::new);

		userESRepository.updateToken(user.getId(), Strings.EMPTY);
		return true;
	}
}
