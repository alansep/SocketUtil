package br.com.socketutil.core.service;

import java.util.Arrays;
import java.util.List;

import br.com.socketutil.core.pattern.SocketInterface;
import br.com.socketutil.core.pattern.Validator;
import br.com.socketutil.core.validators.IpGroupsValidator;
import br.com.socketutil.core.validators.IpNumberValidator;
import br.com.socketutil.core.validators.PortRangeValidator;

public class Communicator implements SocketInterface {

	private int inputPort;
	private int outputPort;
	private String ip;

	Communicator(int inputPort, int outputPort, String outputIp) {
		if (validInput(inputPort, outputPort, outputIp)) {
			this.inputPort = inputPort;
			this.outputPort = outputPort;
			this.ip = outputIp;
		} else {
			throw new IllegalArgumentException("Invalid Parameters");
		}
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

	@Override
	public int getInputPort() {
		return inputPort;
	}

	@Override
	public int getOutputPort() {
		return outputPort;
	}
	
	@Override
	public String getOutputIp() {
		return ip;
	}

	private boolean validInput(int inputPort, int outputPort, String ip) {
		boolean isValid = true;

		Validator<Integer> portValidator = new PortRangeValidator();
		List<Validator<String>> ipValidators = Arrays.asList(new IpNumberValidator(), new IpGroupsValidator());

		isValid = isValid && portValidator.isValid(inputPort);
		isValid = isValid && portValidator.isValid(outputPort);

		for (Validator<String> validator : ipValidators) {
			isValid = isValid && validator.isValid(ip);
		}
		return isValid;
	}

	

}
