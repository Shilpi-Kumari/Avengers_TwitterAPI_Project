package com.avengers.service;

import java.util.List;

public interface TwitterClientService {
	
	List<String> getHomelineTweeets();
	
	List<String> getLanguageSupport();
	
	List<String> getTrendsAvailable();
	
	List<String> getUserTimeline();
	
	List<String> getLanguagePrivacy();
	
	List<String> getFavouriteList();
	
	List<String> searchHashTag(String searchHashTag);
	
	List<String> getFollowersList();
}
