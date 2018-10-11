package com.avengers.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TwitterControllerTest extends AbstractClass {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testHomelineTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/statuses/home_timeline";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testMentionsTimelineTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/statuses/mentions_timeline";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUserTimelineTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/statuses/user_timeline";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testReTweetsOfMe() throws Exception {
		String uri = "/api.twitter.com/1.1/statuses/retweets_of_me";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testSearchTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/search/tweets/cricket";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testSearchTweetBasedOnId() throws Exception {
		String uri = "/api.twitter.com/1.1/statuses/show/sharukh";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUserSearchTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/users/search/sumanth";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUserSearch100Tweets() throws Exception {
		String uri = "/api.twitter.com/1.1/users/search/shilpi";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
}
