package br.com.socketutil.core.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommunicatorTest {

	@Test
	public void deveReceberInstanciaDeComunicador() {
		assertEquals(new Communicator() instanceof Communicator, SocketUtil.getInstance() instanceof Communicator);
	}

}
