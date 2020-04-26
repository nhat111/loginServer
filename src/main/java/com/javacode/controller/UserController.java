package com.javacode.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.model.Login;
import com.javacode.model.Register;
import com.javacode.repository.LoginRepository;
import com.javacode.repository.RegisterRepository;
import com.javacode.request.LoginForm;
import com.javacode.request.SignupForm;
import com.javacode.response.MessagerResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class UserController {

	private String userNameLogin;
	private Boolean isLogin = false;

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private LoginRepository loginRepository;

	@GetMapping("")
	public String home() {
		return "Hello World";
	}

	@GetMapping("/home")
	public String userhome() {
		return "Hello your name";
	}

	@PostMapping("/signup")
	public ResponseEntity<?> register(@Valid @RequestBody SignupForm signupRequesr) {
		if (loginRepository.existsByUserName(signupRequesr.getUserName())) {
			return new ResponseEntity<>(new MessagerResponse("user exists"), HttpStatus.BAD_REQUEST);
		}

		Register user = new Register(signupRequesr.getUserName(), signupRequesr.getPassword(),
				signupRequesr.getFirstName(), signupRequesr.getLastName(), signupRequesr.getBirthDay(),
			signupRequesr.getGender(), signupRequesr.getAddress());

		Login userLogin = new Login(signupRequesr.getUserName(), signupRequesr.getPassword());

		registerRepository.save(user);

		loginRepository.save(userLogin);

		return new ResponseEntity<>(new MessagerResponse("register success"), HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> sigin(@Valid @RequestBody LoginForm signinRequest) {

		if (!loginRepository.existsByUserName(signinRequest.getUserName())) {
			return new ResponseEntity<>(new MessagerResponse("user not found"), HttpStatus.BAD_REQUEST);

		}

		Login user = loginRepository.findUserByUserName(signinRequest.getUserName());

		String pass = user.getPassword();

		if (signinRequest.getPassword().equals(pass)) {

			isLogin = true;
			userNameLogin = user.getUserName();

			return new ResponseEntity<>(new MessagerResponse("login success"), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(new MessagerResponse("password error"), HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/userlogin")
	public ResponseEntity<?> getUserInfo(){

		if (isLogin) {
			Register user = registerRepository.findByUserName(userNameLogin);
			return ResponseEntity.ok().body(user);// return Object
		}

		return new ResponseEntity<>(new MessagerResponse("user not login"), HttpStatus.BAD_REQUEST);

	}

}
