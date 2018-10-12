package com.avengers.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.helper.TwitterHelper;
import com.avengers.service.TwitterClientService;

/*
 * author sumanth ravipati
 */
@Component
public class TwitterClientServiceImpl implements TwitterClientService{
	
	@Autowired
	TwitterHelper twitterHelper;

	@Override
	public List<String> getHomelineTweeets() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/statuses/home_timeline.json?count=5";
			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					JSONObject userObject = (JSONObject) jsonObject.get("user");
					String displayText = (String) userObject.get("screen_name") + " : "
							+ (String) jsonObject.get("text"); 
					responseList.add(displayText); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}
	
	public List<String> getLanguageSupport() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/help/languages.json";

			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name");
					responseList.add(displayText);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}

	
	@Override
	public List<String> getTrendsAvailable() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/trends/available.json";

			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 1; i < jsonArray.length() && i <= 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("country") + " : " + (String) object.get("url");
					responseList.add(displayText);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}
	
	/*
	 * author: Shilpi Kumari
	 */
	@Override
	public List<String> getUserTimeline() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?count=5";
			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					JSONObject userObject = (JSONObject) jsonObject.get("user");
					String displayText = (String) userObject.get("screen_name") + " : "
							+ (String) jsonObject.get("text"); 
					responseList.add(displayText); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}
	
	public List<String> getLanguagePrivacy() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/help/privacy.json";

			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONObject jsonObject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
					String displayText = (String) jsonObject.get("privacy");
					responseList.add(displayText);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}

	@Override
	public List<String> getFavouriteList() {

		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/favorites/list.json?count=5";
			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONArray jsonArray = new JSONArray(EntityUtils.toString(apiResponse.getEntity()));
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					String displayText = (String) jsonObject.get("text");
					responseList.add(displayText); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}
	
	public List<String> searchHashTag(String searchHashTag) {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/search/tweets.json";
			url = url + "?count=10&q=%23" + searchHashTag; 

			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity())); 
				JSONArray jsonArray = (JSONArray) jsonobject.get("statuses");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					JSONObject userObject = (JSONObject) jsonObject.get("user");

					String displayText = (String) userObject.get("screen_name") + " : "
							+ (String) jsonObject.get("text");
					responseList.add(displayText); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}
	
	public List<String> getFollowersList() {
		List<String> responseList = new ArrayList<String>();
		try {
			String url = "https://api.twitter.com/1.1/followers/list.json";

			HttpResponse apiResponse = twitterHelper.executeHttpGet(url);

			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				JSONObject jsonobject = new JSONObject(EntityUtils.toString(apiResponse.getEntity()));
				JSONArray jsonArray = (JSONArray) jsonobject.get("users");
				for (int i = 0; i < jsonArray.length() && i < 10; i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String displayText = (String) object.get("name") + " : " + (String) object.get("screen_name");
					responseList.add(displayText);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	
	}

}
