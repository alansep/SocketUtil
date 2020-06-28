package br.com.socketutil.core.service;

import org.junit.Test;

public class CommunicatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void getInstanceExceptionTest() {
		SocketUtil.getInstance(-20, 20, "192.28.0.1");
	}

}
