package client;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
	private BufferedReader reader;
	private Socket socket;
	private ChatClient client;
	private final JTextArea textArea;

	public ReadThread(Socket socket, ChatClient client, JTextArea textArea1) {
		this.socket = socket;
		this.client = client;
		this.textArea=textArea1;
		try {
			InputStream input = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input));
		} catch (IOException ex) {
			System.out.println("Error getting input stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			String response = null;
			try {
				response = reader.readLine();
				textArea.setText(textArea.getText()+"\n"+response);
				System.out.println("\n" + response);
			} catch (IOException e) {
				System.out.println("Error reading from server: " + e.getMessage());
				e.printStackTrace();
				break;
			}
		/*	// prints the username after displaying the server's message
			if (client.getUserName() != null) {
				System.out.print("[" + client.getUserName() + "]: ");
			}*/

		}
	}
}