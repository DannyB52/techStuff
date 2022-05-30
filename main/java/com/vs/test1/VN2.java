package com.vs.test1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class VN2 {
	
  
	public static void main (String [] args) {

		// new VN2().test1();
		new VN2().test1();
	}

	public String getStringfromFile(String filePath) {
		InputStream inStream = null;

		String text = null;
		try {
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
			text = new String(inStream.readAllBytes());
			// System.out.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return text;
	}
	
	private void test1() { JsonCountries jsContries = new JsonCountries();
		String json = getStringfromFile("test.json");
		//- returns the number of countries in the world
		System.out.println("Number of countries " + jsContries.numberCountries(json));
		
		// - finds the country with the most official languages, where they officially
		// speak German (de).
		jsContries. mostOfficialLanguages( json);
		
		//- that counts all the official languages spoken in the listed countries
		jsContries.countOfficialLanguages (json);
		
		//- to find the country with the highest number of official languages.
		jsContries.highestNumberOfficialLanguages (json);
		
		//- to find the most common official language(s), of all countries.
		jsContries. mostCommonOfficialLanguages(json);
	}
}
