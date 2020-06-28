package br.com.socketutil.core.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.socketutil.core.exception.SocketUtilException;

public class PortRangeValidatorTest {

	private PortRangeValidator validator;

	@Before
	public void define() {
		this.validator = new PortRangeValidator();
	}

	@Test
	public void mustValidPort() {
		assertFalse(validator.isValid(0));
		assertFalse(validator.isValid(-3012));
		assertTrue(validator.isValid(65000));
	}

	@Test(expected = SocketUtilException.class)
	public void mustThrowException() {
		validator.isValid(null);
	}

}
