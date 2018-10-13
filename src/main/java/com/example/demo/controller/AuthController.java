package com.example.demo.controller;

import com.example.demo.domain.auth.AuthService;
import com.example.demo.response.SiranoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/sign-up")
	public SiranoResponse signUp() {
		return new SiranoResponse();
	}

	@PostMapping("/sign-in")
	public SiranoResponse signIn() {
		return new SiranoResponse();
	}

	@PostMapping("/logout")
	public SiranoResponse logout() {
		return new SiranoResponse();
	}

	@GetMapping("/authorized")
	public SiranoResponse checkIfIsAuthorized(@RequestParam String userId) {
		return new SiranoResponse();
	}
}
