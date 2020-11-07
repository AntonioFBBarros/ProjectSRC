package client;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.beans.Visibility;

public class Lobby {


    private JPanel mainPanel;
    private JPanel repeatPanel;
    private JScrollPane scrollPane;

    public  void start() {
        JFrame frame = new JFrame("Lobby");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        scrollPane.add(repeatPanel);
        scrollPane.revalidate();

    }
}
