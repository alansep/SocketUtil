package br.com.socketutil.core.pattern;

import java.util.List;

public interface SocketInterface {
	
	List<String> getAllMessages();
	List<String> getUnreadMessages();
	void sendMessage(String message);
	boolean hasNewMessages();
	int getInputPort();
	int getOutputPort();
	String getOutputIp();
}
