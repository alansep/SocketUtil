package br.com.socketutil.testing;

import br.com.socketutil.core.service.SocketUtil;

public class ReceiverTest {

	public static void main(String[] args) {
		SocketUtil.getInstance(10051, 10050);
	}
	
}
