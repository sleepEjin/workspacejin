package com.kh.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {
	private Socket socket;

	public ClientSend(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(Scanner sc = new Scanner(System.in)) {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
