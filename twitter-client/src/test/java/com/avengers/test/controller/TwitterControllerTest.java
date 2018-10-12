/*
 * @author Sai Kiran
 * JUnit test cases  to validate the response for Twitter APIs
 */
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
		String uri = "/api.twitter.com/1.1/getHometimeline";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testMentionsTimelineTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/getLanguage";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUserTimelineTweets() throws Exception {
		String uri = "/api.twitter.com/1.1/getTrendsAvailable";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testGetUsertimline() throws Exception {
		String uri = "/api.twitter.com/1.1/getUserTimeline";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testgetLanguagePrivacy() throws Exception {
		String uri = "/api.twitter.com/1.1/getLanguagePrivacy";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testgetFavouriteList() throws Exception {
		String uri = "/api.twitter.com/1.1/getFavouriteList";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testsearchHashTag() throws Exception {
		String uri = "/api.twitter.com/1.1/searchHashTag/dhoni";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void testgetFollowersList() throws Exception {
		String uri = "/api.twitter.com/1.1/getFollowersList";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int statusCode = mvcResult.getResponse().getStatus();
		assertEquals(statusCode, 200);
	}
	
}
