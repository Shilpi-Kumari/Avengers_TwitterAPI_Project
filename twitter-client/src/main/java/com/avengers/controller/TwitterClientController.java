package com.avengers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avengers.service.TwitterClientService;


@RestController
@RequestMapping(TwitterClientController.TWITTER_BASE_URL)
public class TwitterClientController {
	
	public static final String TWITTER_BASE_URL = "api.twitter.com/1.1";
	
	@Autowired
	private TwitterClientService twitterClientService;
	
	@RequestMapping(value = "/getHometimeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getHomelineTweets() {
		List<String> twitterResponse = twitterClientService.getHomelineTweeets();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getLanguage", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getLanguageSupport() {
		List<String> twitterResponse = twitterClientService.getLanguageSupport();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getTrendsAvailable", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getTrendsAvailable() {
		List<String> twitterResponse = twitterClientService.getTrendsAvailable();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getUserTimeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFriendsList() {
		List<String> twitterResponse = twitterClientService.getUserTimeline();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getLanguagePrivacy", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getLanguagePrivacy() {
		List<String> twitterResponse = twitterClientService.getLanguagePrivacy();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getFavouriteList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFavouriteList() {
		List<String> twitterResponse = twitterClientService.getFavouriteList();
		return twitterResponse;
	}
	
	@RequestMapping(value = "/searchHashTag/{searchInput}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> searchHashTag(@PathVariable String searchInput) {
		List<String> twitterResponse = twitterClientService.searchHashTag(searchInput);
		return twitterResponse;
	}
	
	@RequestMapping(value = "/getFollowersList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFollowersList() {
		List<String> twitterResponse = twitterClientService.getFollowersList();
		return twitterResponse;
	}
}
