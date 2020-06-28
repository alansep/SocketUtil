package br.com.socketutil.core.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.socketutil.core.pattern.Validator;

public class IpValidatorTest {

	private Validator<String> validator;
	
	@Test
	public void mustHaveFourGroups() {

		validator = new IpGroupsValidator();

		assertTrue(validator.isValid("192.168.0.110"));
		assertTrue(validator.isValid("1942.168.0.110"));
		assertFalse(validator.isValid("1.1.112"));
	}

	@Test
	public void mustHaveRightNumbers() {
		
		validator = new IpNumberValidator();
		
		assertTrue(validator.isValid("192.168.0.110"));
		assertFalse(validator.isValid("1942.168.0.110"));
		assertTrue(validator.isValid("1.1.112"));

	}

}
