package br.com.socketutil.core.service;

import br.com.socketutil.core.pattern.SocketInterface;

public class SocketUtil {

	public static SocketInterface getInstance(int inputPort, int outputPort, String ip) {
		return new Communicator(inputPort, outputPort, ip);
	}

	public static SocketInterface getInstance(int inputPort) {
		return new Communicator(inputPort);
	}

}
