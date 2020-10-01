package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	void checkAValid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result, "first value");
		result = validator.checkISBN("0140177396");
		assertTrue(result, "second value");
	}
	
	@Test
	void checkAVaild13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853260087");
		assertTrue(result, "first value");
		result = validator.checkISBN("9781853267338");
		assertTrue(result, "second value");
	}
	
	@Test
	void TenDigitISBNNumbersEndingInAnXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	void checkAInvalid10DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	void checkAInvalid13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853267336");
		assertFalse(result);
	}
	
	@Test
	void nineDigitISBNsAreNotAllowed() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			ValidateISBN validator = new ValidateISBN();
			validator.checkISBN("123456789");
		});		
	}
	
	@Test
	void nonNumericISBNsAreNotAllowed() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			ValidateISBN validator = new ValidateISBN();
			validator.checkISBN("helloword");
		});			
	}
}
