package br.com.socketutil.testing;

import br.com.socketutil.core.service.SocketUtil;

public class ConsoleTest {

	public static void main(String[] args) {
		
		System.out.println("\r\n" + 
				"   ________  _______ ______________  ______________ \r\n" + 
				"  / __/ __ \\/ ___/ //_/ __/_  __/ / / /_  __/  _/ / \r\n" + 
				" _\\ \\/ /_/ / /__/ ,< / _/  / / / /_/ / / / _/ // /__\r\n" + 
				"/___/\\____/\\___/_/|_/___/ /_/  \\____/ /_/ /___/____/\r\n" + 
				"                                                    \r\n" + 
				"\n\n");
		
		if(args.length == 1) {
			SocketUtil.getInstance(Integer.parseInt(args[0]));
		} else {
			SocketUtil.getInstance(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
		}
	}
	
}
