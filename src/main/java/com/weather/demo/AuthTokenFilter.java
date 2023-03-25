package com.weather.demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * This is the AuthTokenFilter class that intercepts incoming requests and checks if they have a valid authentication token.
 * If the token is valid, it allows the request to proceed. Otherwise, it returns an HTTP 401 Unauthorized response.
 * if first time user hit login api (http://localhost:8080/login) then we are returning random clientId and clientSecret which we also store in txt file to validtate.
 * whenever we call other api's first we execute this class to check the token. for that client need to pass request header with base24 encode of clientId:clientSecret
 * once we get the token we decode that and compare that with saved one if they match we allow to access to other api's else throw error.
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthTokenFilter extends OncePerRequestFilter {
	
	private static final String CLIENT_ID_SECRET_FILE = "client_id_secret.txt";
	
	private static final int CLIENT_ID_LENGTH = 16;
	private static final int CLIENT_SECRET_LENGTH = 32;
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_PREFIX = "Basic ";
	
	private static String clientId;
	private static String clientSecret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if (path.equals("/login")) {
			// Generate random client ID and secret
			if(!request.getHeader("email").equals("swapnilahire.sde@gmail.com")){
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("UNAUTHORIZED Error");
				return;
			}
			generateClientIdAndSecret();
			
			// Save client ID and secret to file
			saveClientIdAndSecretToFile();
			
			// Return client ID and secret in response
			String responseMsg = "Client ID: " + clientId + "\n" + "Client Secret: " + clientSecret;
			response.getWriter().write(responseMsg);
			return;
		}
		
		// Check Authorization header for client ID and secret
		String authHeader = request.getHeader(AUTHORIZATION_HEADER);
		if (authHeader == null || !authHeader.startsWith(AUTHORIZATION_PREFIX)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		// Read client ID and secret from file
		BufferedReader reader = new BufferedReader(new FileReader(CLIENT_ID_SECRET_FILE));
		String savedClientId = reader.readLine();
		String savedClientSecret = reader.readLine();
		reader.close();
		
		// Decode and compare credentials
		String encodedCredentials = authHeader.substring(AUTHORIZATION_PREFIX.length());
		byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
		String decodedCredentials = new String(decodedBytes, "UTF-8");
		String[] credentials = decodedCredentials.split(":");
		
		if (credentials.length != 2 || !credentials[0].equals(savedClientId) || !credentials[1].equals(savedClientSecret)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	private void generateClientIdAndSecret() {
		Random random = new SecureRandom();
		byte[] clientIdBytes = new byte[CLIENT_ID_LENGTH];
		byte[] clientSecretBytes = new byte[CLIENT_SECRET_LENGTH];
		random.nextBytes(clientIdBytes);
		random.nextBytes(clientSecretBytes);
		clientId = Base64.getUrlEncoder().encodeToString(clientIdBytes);
		clientSecret = Base64.getUrlEncoder().encodeToString(clientSecretBytes);
	}
	
	private void saveClientIdAndSecretToFile() throws IOException {
		File file = new File(CLIENT_ID_SECRET_FILE);
		FileWriter writer = new FileWriter(file);
		writer.write(clientId + "\n");
		writer.write(clientSecret + "\n");
		writer.close();
	}
}