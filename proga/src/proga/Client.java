package proga;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread{
	Socket client;
	gem Game = new gem();
	public Client(Socket s) {
		client = s;
	}
	public void run() {
		Game.run();
		while(true) {
			try {
				InputStream is = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String word;
				String sendWord = "";
				while((word = br.readLine())!=null) {
					sendWord = new MyTurn().MakeTurn(word);
				}
				OutputStream out = client.getOutputStream();
				out.write(sendWord.getBytes());
			}
			catch(Exception e) {
				
			}
			
		}
	}	
}
