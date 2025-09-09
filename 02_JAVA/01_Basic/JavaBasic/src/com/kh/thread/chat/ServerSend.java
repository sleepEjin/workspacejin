package com.kh.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSend extends Thread {
	private Socket socket;

	public ServerSend(Socket socket) {
		super();
		this.socket = socket;
		
		
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
