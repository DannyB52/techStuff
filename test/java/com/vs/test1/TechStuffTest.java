package com.vs.test1;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TechStuffTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNumberCountries() {
		assertTrue( 5 == 5);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		// TODO Auto-generated method stub
		int data = 5;
		CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			return "data from supplyAsync ";
			
		}, service);
		System.out.println (" data b4 sleep " + data );
		Thread.sleep(2500);

	}

}
