package br.com.socketutil.core.service;

import java.util.List;

import br.com.socketutil.core.pattern.SocketInterface;

public class Communicator implements SocketInterface {

	Communicator() {
	}

	@Override
	public List<String> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUnreadMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasNewMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
