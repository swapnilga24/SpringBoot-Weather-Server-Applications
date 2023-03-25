package es.softtek.jwtDemo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.softtek.jwtDemo.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	private static final String AUTHORIZATION_PREFIX = "Bearer ";
	
	@PostMapping("Login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) 
	throws Exception {
		if(username.equals("swapnilahire.sde@gmail.com") && pwd.equals("Swapnil@123")){
			String token = getJWTToken(username);
			User user = new User();
			user.setUsername(username);
			user.setToken(token);		
			return user;
		}else{
			throw new Exception("Admin User Name and Password is wrong!!!");
		}
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("swapnilID")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return AUTHORIZATION_PREFIX + token;
	}
}
