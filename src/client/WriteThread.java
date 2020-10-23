package client;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
	private PrintWriter writer;
	private Socket socket;
	private ChatClient client;
	private String text;
	private int flag;
	private final JTextArea textArea;


	public WriteThread(Socket socket, ChatClient client, String text,int flag,JTextArea textArea) {
		this.socket = socket;
		this.client = client;
		this.text=text;
		this.flag=flag;
		this.textArea=textArea;
		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error getting output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {
		if(flag==1){
			writer.println(client.getUserName()); // first time joining
		}
		if (!text.equals("")) {
			writer.println(text);
			textArea.setText(textArea.getText()+"\n"+"[" + client.getUserName() + "]: "+text );

		}
	}



}