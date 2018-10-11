package com.avengers.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;


@Component
public class TwitterHelper {

	public Properties getProperties() throws IOException {
		InputStream input = this.getClass().getResourceAsStream("/application.properties");
		Properties properties = new Properties();
		properties.load(input);
		return properties;
	}

	public OAuthConsumer getOAuthConsumer() throws IOException {
		Properties properties = getProperties();
		String consumerKeyStr = properties.getProperty("twitter.consumer.key");
		String consumerSecretStr = properties.getProperty("twitter.consumet.secret");
		String accessTokenStr = properties.getProperty("twitter.access.token");
		String accessTokenSecretStr = properties.getProperty("twitter.access.secret");
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
		return oAuthConsumer;
	}

	public HttpResponse executeHttpGet(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpGet httprequest = new HttpGet(apiUrl);
		getOAuthConsumer().sign(httprequest);
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpresponse = client.execute(httprequest);
		int statusCode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statusCode + ":" + httpresponse.getStatusLine().getReasonPhrase());
		return httpresponse;
	}

}
