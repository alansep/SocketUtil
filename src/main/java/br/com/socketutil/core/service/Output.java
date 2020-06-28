package br.com.socketutil.core.service;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.com.socketutil.core.pattern.SocketInterface;

public class Output implements Runnable {

	private int port;
	private SocketInterface communicator;
	private boolean reactive;
	private String ip;

	Output(int port, String ip, SocketInterface communicator, boolean reactive) {
		this.port = port;
		this.ip = ip;
		this.communicator = communicator;
		this.reactive = reactive;
	}

	@Override
	public void run() {
		try {
			System.out.println(port);
			Socket client = new Socket(ip, port);
			System.out.println("A client has just connected to the server!");
			Scanner scanner = new Scanner(System.in);
			PrintStream outputStream = new PrintStream(client.getOutputStream());
			if (!reactive) {
				outputStream.println(communicator.getInputPort());
			}
			while (scanner.hasNextLine()) {
				String texto = scanner.nextLine();
				outputStream.println(texto);
			}
			outputStream.close();
			scanner.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
