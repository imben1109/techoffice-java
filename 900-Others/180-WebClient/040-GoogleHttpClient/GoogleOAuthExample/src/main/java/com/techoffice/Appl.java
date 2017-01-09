package com.techoffice;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

public class Appl {
	private static final String SCOPE = "read";

	private static final java.io.File DATA_STORE_DIR = new File(System.getProperty("user.home"),
			".store/Google_OAuth_Example");

	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	private static FileDataStoreFactory DATA_STORE_FACTORY;

	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static final String AUTHORIZATION_SERVER_URL = "https://github.com/login/oauth/authorize";

	private static final String TOKEN_SERVER_URL = "https://github.com/login/oauth/access_token";

	private static final String clientId = "480856be9f03afee4633";

	private static final String clientSecret = "7657c6bbfb35e03661fe176c716197cb579db51a";

	private static final String LOCALHOST = "localhost";

	private static final int PORT = 8080;
	
	private static final String userInfoUrl = "https://api.github.com/user";


	private static Credential authorize() throws IOException {

		AuthorizationCodeFlow flow = new AuthorizationCodeFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
				HTTP_TRANSPORT, JSON_FACTORY, new GenericUrl(TOKEN_SERVER_URL),
				new ClientParametersAuthentication(clientId, clientSecret), clientId, AUTHORIZATION_SERVER_URL)
						.setScopes(Arrays.asList(SCOPE)).setDataStoreFactory(DATA_STORE_FACTORY).build();

		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setHost(LOCALHOST).setPort(PORT).build();

		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");

	}

	public static void main(String[] args) throws IOException {
	      DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
	      final Credential credential = authorize();
	      HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
              credential.initialize(request);
              request.setParser(new JsonObjectParser(JSON_FACTORY));
            }
          });
	      HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(userInfoUrl));
	      String content = request.execute().getContent().toString();
	      System.out.println(content);
	      System.exit(1);

	}
}

