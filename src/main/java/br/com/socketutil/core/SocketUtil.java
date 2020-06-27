package br.com.socketutil.core;

import br.com.socketutil.core.pattern.SocketInterface;

public class SocketUtil {

	public static SocketInterface getInstance() {
		return new Communicator();
	}
	
}
