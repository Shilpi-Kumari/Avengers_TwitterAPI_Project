package com.avengers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avengers.service.TwitterClientService;

/*
 *@author Sumanth Ravipati 
 */

@RestController
@RequestMapping(TwitterClientController.TWITTER_BASE_URL)
public class TwitterClientController {
	
	public static final String TWITTER_BASE_URL = "api.twitter.com/1.1";
	
	@Autowired
	private TwitterClientService twitterClientService;
	
	/*
	 * Returns a collection of the most recent Tweets and retweets posted by the authenticating user and the users they follow.
	 */
	@RequestMapping(value = "/getHometimeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getHomelineTweets() {
		List<String> twitterResponse = twitterClientService.getHomelineTweeets();
		return twitterResponse;
	}
	
	/*
	 * Returns the list of languages supported by Twitter along with their ISO 639-1 code.
	 */
	
	@RequestMapping(value = "/getLanguage", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getLanguageSupport() {
		List<String> twitterResponse = twitterClientService.getLanguageSupport();
		return twitterResponse;
	}
	
	/*
	 * Returns the locations that Twitter has trending topic information for.
	 */
	@RequestMapping(value = "/getTrendsAvailable", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getTrendsAvailable() {
		List<String> twitterResponse = twitterClientService.getTrendsAvailable();
		return twitterResponse;
	}
	
	/*
	 * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").
	 */
	@RequestMapping(value = "/getUserTimeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFriendsList() {
		List<String> twitterResponse = twitterClientService.getUserTimeline();
		return twitterResponse;
	}
	
	/*
	 *@author Shilpi Kumari 
	 */
	
	/*
	 * Returns Twitter's Privacy Policy.
	 */
	@RequestMapping(value = "/getLanguagePrivacy", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getLanguagePrivacy() {
		List<String> twitterResponse = twitterClientService.getLanguagePrivacy();
		return twitterResponse;
	}
	
	/*
	 * Returns the 20 most recent Tweets favorited by the authenticating or specified user.
	 */
	@RequestMapping(value = "/getFavouriteList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFavouriteList() {
		List<String> twitterResponse = twitterClientService.getFavouriteList();
		return twitterResponse;
	}
	
	/*
	 * Returns a collection of relevant Tweets matching a specified query.
	 */
	@RequestMapping(value = "/searchHashTag/{searchInput}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> searchHashTag(@PathVariable String searchInput) {
		List<String> twitterResponse = twitterClientService.searchHashTag(searchInput);
		return twitterResponse;
	}
	
	/*
	 * Returns a cursored collection of user objects for users following the specified user.
	 */
	@RequestMapping(value = "/getFollowersList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getFollowersList() {
		List<String> twitterResponse = twitterClientService.getFollowersList();
		return twitterResponse;
	}
}
