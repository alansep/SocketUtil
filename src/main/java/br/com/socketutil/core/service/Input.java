package br.com.socketutil.core.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import br.com.socketutil.core.pattern.SocketInterface;

public class Input implements Runnable {

	private int port;
	private SocketInterface communicator;
	private boolean reactiveMode;
	private boolean firstExecution;

	Input(int port, SocketInterface communicator, boolean reativeMode) {
		this.port = port;
		this.communicator = communicator;
		this.reactiveMode = reativeMode;
		this.firstExecution = true;
	}

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Port " + port + " has just been opened!");
			Socket client = server.accept();
			System.out.println("New connection with " + client.getInetAddress().getHostAddress());
			Scanner scanner = new Scanner(client.getInputStream());
			while (scanner.hasNextLine()) {
				if (firstExecution && reactiveMode) {
					communicator.initializeOutput(Integer.parseInt(scanner.nextLine()), client.getInetAddress().getHostAddress());
					firstExecution = false;
				} else {
					String text = scanner.nextLine();
					System.out.println("Someone says: " + text);
				}
			}
			scanner.close();
			server.close();
			client.close();
		} catch (IOException e) {

		}
	}

}
