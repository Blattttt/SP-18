package com.company;
import com.company.network.TCPConnection;
import com.company.network.TCPConnectionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {
    private static final String IP_ADDR = "127.0.0.1";
    private static final int PORT = 8189;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }});}
    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickName = new JTextField("Гость");
    private final JTextField fieldInput = new JTextField();
    private TCPConnection connection;
    private ClientWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // расположение элементов по центру
        setAlwaysOnTop(true); // позволяет показывать окно поверх всех окон
        add(fieldNickName, BorderLayout.NORTH);
        log.setEditable(false);
        log.setLineWrap(true);
        add(log, BorderLayout.CENTER);
        fieldInput.addActionListener(this);
        add(fieldInput, BorderLayout.SOUTH);
        setVisible(true);
        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            System.out.println("Cant create connection :" + e );
        }}
    private synchronized void printMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(message + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }});}
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;
        fieldInput.setText(null);
        connection.sendString(fieldNickName.getText() + ": " + msg); }
    @Override
    public void onConnectReady(TCPConnection tcpConnection) {
        printMessage("Connection ready..."); }
    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMessage(value); }
    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMessage("Connection lost"); }
    @Override
    public void onException(TCPConnection tcpConnection, IOException e) {
        printMessage("Connection exception: " + e);
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {

    }
}