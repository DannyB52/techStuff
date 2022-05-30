package com.vs.test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonCountries {

	// - returns the number of countries in the world
	public int numberCountries(String json) {

		JSONArray jArray = (JSONArray) new JSONTokener(json).nextValue();
		return jArray.length();

	}
	
	private boolean hasLanguage(JSONArray jArray, String language) {
		boolean result = false;
		for (int i = 0; i < jArray.length(); i++) {
			String ob = (String) jArray.get(i);
			if (language.equalsIgnoreCase(ob))
				result = true;
		}
		return result;
	}
	
	// - finds the country with the most official languages, where they officially
	// speak German (de).
	public void mostOfficialLanguages(String json) {
		int numberLanguages = 0;
		String sCountry = "";
		int total = 0;
		JSONArray jArray = (JSONArray) new JSONTokener(json).nextValue();
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject country = (JSONObject) jArray.get(i);
			// System.out.println(country.toString() +
			// country.getJSONArray("languages").length());
			if ((country.getJSONArray("languages").length() > numberLanguages)
					&& (hasLanguage(country.getJSONArray("languages"), "de"))) {
				numberLanguages = country.getJSONArray("languages").length();
				sCountry = country.getString("country");
			}

		}
		System.out.println(" Most official languages (with german) " + sCountry + " " + numberLanguages);
	}
	
	//- that counts all the official languages spoken in the listed countries
	public int countOfficialLanguages (String json) { int total = 0;
		JSONArray jArray = (JSONArray) new JSONTokener(json).nextValue();		
		 Set<String> targetSet = new HashSet<String>();
		 
        for (int i = 0; i < jArray.length(); i++) {
        	 JSONObject country = (JSONObject) jArray.get(i); 
        	// System.out.println(country.getString("country") + " " + country.getJSONArray("languages").length());
        	 total += country.getJSONArray("languages").length();
        	 
        	 for (Object s : country.getJSONArray("languages")) {
        		 targetSet.add((String) s);
        	 }

        }
        
        
     //   System.out.println(" Languages total " + total + " " + targetSet.size());
        return targetSet.size();
	}
	
	//- to find the country with the highest number of official languages.
	public int highestNumberOfficialLanguages (String json) { int numberLanguages = 0;  String sCountry = "";
		int total = 0;
		JSONArray jArray = (JSONArray) new JSONTokener(json).nextValue();		 
        for (int i = 0; i < jArray.length(); i++) {
        	 JSONObject country = (JSONObject) jArray.get(i); 
        	// System.out.println(country.toString() + country.getJSONArray("languages").length());
        	 if ( country.getJSONArray("languages").length() > numberLanguages) {
        		 numberLanguages = country.getJSONArray("languages").length();
        		 sCountry = country.getString("country");
        	 };
        	
        }
      //  System.out.println(" highestNumberOfficialLanguages " + sCountry + " " + numberLanguages);
        return numberLanguages;
	}
	

	// - to find the most common official language(s), of all countries.
	public String mostCommonOfficialLanguages(String json) {
		int total = 0;
		JSONArray jArray = (JSONArray) new JSONTokener(json).nextValue();
		HashMap<String, Integer> elementCountMap = new HashMap<String, Integer>();

		for (int i = 0; i < jArray.length(); i++) {
			JSONObject country = (JSONObject) jArray.get(i);
			total += country.getJSONArray("languages").length();
			for (Object so : country.getJSONArray("languages")) {
				String s = (String) so;
				if (elementCountMap.containsKey(s)) {
					elementCountMap.put(s, elementCountMap.get(s) + 1);
				} else {
					elementCountMap.put(s, 1);
				}
			}

		}
		int frequency = 0;
		String freqLanguage = null;
		Set<Entry<String, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > frequency) {
				freqLanguage = entry.getKey();
				frequency = entry.getValue();
			}
		}

		return freqLanguage;
	}
}
