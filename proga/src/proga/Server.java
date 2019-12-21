package proga;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void run(String args[]) {
		try {
			ServerSocket ss = new ServerSocket(8080);
			int players = 1;
			while(true) {
				Socket s = ss.accept();
				Client client = new Client(s);
				client.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
