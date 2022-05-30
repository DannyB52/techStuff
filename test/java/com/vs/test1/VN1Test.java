package com.vs.test1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class VN1Test {

	VN1 vn1;
	@Before
	public void setUp() throws Exception {
		
		vn1 = new VN1();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWrite() {
		
		assertTrue(vn1.write(15).equalsIgnoreCase("Visual Nuts"));
		assertTrue(vn1.write(9).equalsIgnoreCase("Visual"));
		assertTrue(vn1.write(10).equalsIgnoreCase("Nuts"));
		
		assertTrue(vn1.write(7).equalsIgnoreCase("7"));

	}
	
	
	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
	    List mockList = Mockito.mock(ArrayList.class);
	    
	    mockList.add("one");
	    Mockito.verify(mockList).add("one");
	    assertEquals(0, mockList.size());

	    Mockito.when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
	}

	@Test
	public void whenNotUseSpyAnnotation_thenCorrect() {
	    List<String> spyList = Mockito.spy(new ArrayList<String>());
	    
	    spyList.add("one");
	    spyList.add("two");

	    Mockito.verify(spyList).add("one");
	    Mockito.verify(spyList).add("two");

	    assertEquals(2, spyList.size());

	    Mockito.doReturn(100).when(spyList).size();
	    assertEquals(100, spyList.size());
	}
	
	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
	    spiedList.add("one");
	    spiedList.add("two");

	    Mockito.verify(spiedList).add("one");
	    Mockito.verify(spiedList).add("two");

	    assertEquals(2, spiedList.size());

	    Mockito.doReturn(100).when(spiedList).size();
	    assertEquals(100, spiedList.size());
	}
}
