package com.example.demo.controller

import com.example.demo.controller.auth.AuthController
import com.example.demo.domain.user.AuthService
import spock.lang.Specification

/**
 * @author : Jaden
 * @since : 13/10/2018
 */
class AuthControllerTest extends Specification {

	def authService = Mock(AuthService)
	def controller = Spy(AuthController.class, constructorArgs: [authService])

	def "test checkIfIsAuthorized"() {

		when:
		def result = controller.checkIfIsAuthorized("a")
		then:
		1 == 1
	}
}
