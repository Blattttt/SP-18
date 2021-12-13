package com.company;
import com.company.network.TCPConnection;
import com.company.network.TCPConnectionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

abstract class ChatServer implements TCPConnectionListener {
    public static void main(String[] args) {
        new ChatServer() {
            @Override
            public void onConnectionReady(TCPConnection tcpConnection) {

            }
        };
    }
    private final ArrayList<com.company.network.TCPConnection> connections = new ArrayList<>();
    private ChatServer() {
        System.out.println("Server running...");
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            while(true) {
                try {
                    new com.company.network.TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                }}
        } catch (IOException e) {
            throw new RuntimeException(e);}}
    @Override
    public synchronized void onConnectReady(com.company.network.TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected " + tcpConnection); }
    @Override
    public synchronized void onReceiveString(com.company.network.TCPConnection tcpConnection, String value) {
        sendToAllConnections(value); }
    @Override
    public synchronized void onDisconnect(com.company.network.TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Disconnected " + tcpConnection); }
    @Override
    public void onException(com.company.network.TCPConnection tcpConnection, IOException e) {
        sendToAllConnections("Exception " + e); }


    private void sendToAllConnections(String value) {
        System.out.println(value);
        for (TCPConnection connection: connections) {
            connection.sendString(value);
        }}}
