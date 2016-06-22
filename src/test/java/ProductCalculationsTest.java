package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.ProductCalculations;

public class ProductCalculationsTest {

	@Test
	public void CalculateAnagrams() {
		ProductCalculations calc = new ProductCalculations();
		Long result1 = calc.Calculate("lorem");
		Long result2 = calc.Calculate("merol");
		assertTrue("Anagrams should have the same products.", result1.equals(result2));
	}

	@Test
	public void CalculateNotAnagrams() {
		ProductCalculations calc = new ProductCalculations();
		Long result1 = calc.Calculate("lorem");
		Long result2 = calc.Calculate("ipsum");
		assertFalse("Non anagrams should have different products.", result1.equals(result2));
	}

	@Test
	public void CalculateLongWord() {
		ProductCalculations calc = new ProductCalculations();
		Long result = calc.Calculate("loremIpsumDolorSitAmet");
		assertTrue("Long words should be omitted", result.equals(-1L));
	}

}
