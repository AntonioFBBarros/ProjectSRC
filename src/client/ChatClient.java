package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;

/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class ChatClient {
	private String hostname;
	private int port;
	private String userName;

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);
			System.out.println("Connected to the chat server");
			App app=new App(socket,this);
			new ReadThread(socket, this,app.textArea1).start();
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}

	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getUserName() {
		return this.userName;
	}


	public static void main(String[] args) {
		String hostname = "localhost";
		int port = 30002;
		ChatClient client = new ChatClient(hostname, port);
		client.execute();
	}



}