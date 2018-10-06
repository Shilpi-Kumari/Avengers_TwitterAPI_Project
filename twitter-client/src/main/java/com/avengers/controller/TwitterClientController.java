package com.avengers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(TwitterClientController.TWITTER_BASE_URL)
public class TwitterClientController {
	
	public static final String TWITTER_BASE_URL = "api.twitter.com/1.1";
	
	@Autowired 
	private Twitter twitter;
	
	/*
	 * Returns a collection of the most recent Tweets and retweets posted by the authenticating user and the users they follow
	 */
	@RequestMapping(value = "/statuses/home_timeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> getHomelineTweets() {
		return twitter.searchOperations().search("home_timeline",10).getTweets();
	}
	
	/*
	 * Returns the 10 most recent mentions for the authenticating user
	 */
	@RequestMapping(value = "/statuses/mentions_timeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> getMentionsTimelineTweets() {
		return twitter.searchOperations().search("mentions_timeline",10).getTweets();
	}
	
	/*
	 * Returns a collection of the most recent Tweets posted by the user
	 */
	@RequestMapping(value = "/statuses/user_timeline", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> getUserTimelineTweets() {
		return twitter.searchOperations().search("user_timeline",10).getTweets();
	}
	
	/*
	 * Returns the most recent tweets authored by the authenticating user that have recently been re-tweeted by others. 
	 */
	@RequestMapping(value = "/statuses/retweets_of_me", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> getReTweets() {
		return twitter.searchOperations().search("retweets_of_me",10).getTweets();
	}
	
	/*
	 * Below code is to search the top 10 tweets related to search input (Eg:Cricket)
	 */
	@RequestMapping(value = "/search/tweets/{searchInput}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> searchTweets(@PathVariable final String searchInput) {
		return twitter.searchOperations().search(searchInput,10).getTweets();
	}
	
	/*
	 * Returns a single Tweet, specified by the id parameter (Eg:Sharukh)
	 */
	@RequestMapping(value = "/statuses/show/{input}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> showSpecificTweet(@PathVariable final String input) {
		return twitter.searchOperations().search(input,1).getTweets();
	}
	
	/*
	 * Provides a simple, relevance-based search interface to public user accounts on Twitter.
	 */
	@RequestMapping(value = "/users/search/{searchInput}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Tweet> usersSearch(@PathVariable final String searchInput) {
		return twitter.searchOperations().search(searchInput,5).getTweets();
	}
	
	@RequestMapping(value = "/friends/ids", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public  CursoredList<Long> getFriendsIds() {
		return twitter.friendOperations().getFriendIds();
	}
	
}
