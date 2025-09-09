package com.kh.thread.chat;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3000);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
