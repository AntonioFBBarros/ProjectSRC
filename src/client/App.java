package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static javax.swing.JOptionPane.showMessageDialog;

public class App {
    private JPanel panelMain;
    private JTextField msgToSend;
    private JButton sendButton;
    private JScrollPane data;
    public JTextArea textArea1;

     final Socket socket;
     ChatClient client;



    public App(Socket socket, ChatClient chatClient) {
        this.client=chatClient;
        this.socket=socket;
        String username= JOptionPane.showInputDialog("Ainda nao fiz rooms vai ser mudado de sitio!" +
                "Inserir nome Utilizador: ");
        client.setUserName(username);
        //primeira vez a juntar-se a uma sala envia só o nome
        new WriteThread(socket,client,"",1,textArea1).start();
        start();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("------->ss"+socket);
                new WriteThread(socket,client, msgToSend.getText(),0,textArea1).start();
                msgToSend.setText("");
            }
        });
    }



    public void start() {

        System.out.println("---->passed"+socket);
        JFrame frame = new JFrame("App");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    /*private static void listen()  {
        try {
            s = new Socket("127.0.0.1", 1201);
             clientWorker= new ClientWorker(s);
            clientWorker.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


}


