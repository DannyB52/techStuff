package com.vs.test1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonCountriesTest {

	String json;
	VN2 vn2;	
	JsonCountries jsCountries;
	
	@Before
	public void setUp() throws Exception {
		 
		vn2 = new VN2();
		json = vn2.getStringfromFile("test.json");
		jsCountries = new JsonCountries();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNumberCountries() {
		assertTrue( jsCountries.numberCountries(json) == 5);
	}

	@Test
	public void testMostOfficialLanguages() {
		
		assertTrue(jsCountries.highestNumberOfficialLanguages (json) == 3);
	}

	@Test
	public void testCountOfficialLanguages() {
	
		assertTrue(jsCountries.countOfficialLanguages (json) == 6);
	}

	@Test
	public void testHighestNumberOfficialLanguages() {
		assertTrue(jsCountries.highestNumberOfficialLanguages (json) == 3);
	}

	@Test
	public void testMostCommonOfficialLanguages() {
		assertTrue(jsCountries.mostCommonOfficialLanguages(json).equalsIgnoreCase("de"));
	}

}
