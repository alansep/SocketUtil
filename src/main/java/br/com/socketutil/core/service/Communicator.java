package br.com.socketutil.core.service;

import java.util.List;

import br.com.socketutil.core.pattern.SocketInterface;
import br.com.socketutil.core.pattern.Validator;
import br.com.socketutil.core.util.ThreadRunner;
import br.com.socketutil.core.validators.PortRangeValidator;

public class Communicator implements SocketInterface {

	private int inputPort;
	private int outputPort;
	private String ip;
	private Input input;
	private Output output;

	Communicator(int inputPort, int outputPort) {
		setValues(inputPort, outputPort);
		input = new Input(inputPort, this, false);
		output = new Output(outputPort, this, false);
		ThreadRunner.run(input, output);
	}

	Communicator(int inputPort) {
		setValues(inputPort);
		input = new Input(inputPort, this, true);
		ThreadRunner.run(input);
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
	public void initializeOutput(int port) {
		output = new Output(port, this, true);
		ThreadRunner.run(output);
	}

	private boolean isInputValid(int inputPort, int outputPort) {
		boolean isValid = true;

		Validator<Integer> portValidator = new PortRangeValidator();

		isValid = isValid && portValidator.isValid(inputPort);
		isValid = isValid && portValidator.isValid(outputPort);

		return isValid;
	}

	private boolean isInputValid(int inputPort) {
		boolean isValid = true;

		Validator<Integer> portValidator = new PortRangeValidator();

		isValid = isValid && portValidator.isValid(inputPort);

		return isValid;
	}

	private void setValues(int inputPort, int outputPort) {
		if (isInputValid(inputPort, outputPort)) {
			this.inputPort = inputPort;
			this.outputPort = outputPort;
		} else {
			throw new IllegalArgumentException("Invalid Parameters!");
		}
	}

	private void setValues(int inputPort) {
		if (isInputValid(inputPort)) {
			this.inputPort = inputPort;
		} else {
			throw new IllegalArgumentException("Invalid Parameters!");
		}
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

}
