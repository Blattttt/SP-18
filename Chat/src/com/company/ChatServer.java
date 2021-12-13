package com.company;
import ru.iaa.example.network.TCPConnection;
import ru.iaa.example.network.TCPConnectionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
public class ChatServer implements TCPConnectionListener {
    public static void main(String[] args) {
        new ChatServer();
    }
    private final ArrayList<TCPConnection> connections = new ArrayList<>();
    private ChatServer() {
        System.out.println("Server running...");
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            while(true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                }}
        } catch (IOException e) {
            throw new RuntimeException(e);}}
    @Override
    public synchronized void onConnectReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected " + tcpConnection); }
    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value); }
    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Disconnected " + tcpConnection); }
    @Override
    public void onException(TCPConnection tcpConnection, IOException e) {
        sendToAllConnections("Exception " + e); }
    private void sendToAllConnections(String value) {
        System.out.println(value);
        for (TCPConnection connection: connections) {
            connection.sendString(value);
        }}}