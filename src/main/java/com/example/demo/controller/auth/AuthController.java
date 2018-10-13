package com.example.demo.controller.auth;

import com.example.demo.domain.user.AuthService;
import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.response.SiranoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author : Jaden
 * @since : 11/10/2018
 */
@RequestMapping(value = "/auth")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping("/sign-in")
	public SiranoResponse signIn(@RequestBody UserDto userDto) throws IOException {
		AuthParamValidator.validate(userDto);
		authService.authorizeUser(userDto);

		return new SiranoResponse("200", "userId : + " + userDto.getUserId() + " is Authorized");
	}

	@PostMapping("/sign-up")
	public SiranoResponse signUp(@RequestBody UserDto userDto) throws IOException {
		AuthParamValidator.validate(userDto);

		val isSignedUp = authService.addUser(userDto);

		val message = isSignedUp ? "signed up" : "not signed up";
		return new SiranoResponse("200", message);
	}

	@PostMapping("/logout")
	public SiranoResponse logout(@RequestBody UserDto userDto) throws IOException {
		AuthParamValidator.validate(userDto);

		authService.logOut(userDto);

		return new SiranoResponse("200", "로그아웃 성공");
	}

	@PostMapping("/authorized")
	public SiranoResponse checkIfIsAuthorized(@RequestBody UserDto userDto) throws IOException {
		AuthParamValidator.validate(userDto);
		val isAuthorized = authService.checkIfIsAuthorized(userDto);

		val message = isAuthorized ? "authorized" : "not authorized";
		return new SiranoResponse("200", message);
	}
}
