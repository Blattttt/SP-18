package com.company.network;

import java.io.IOException;

public interface TCPConnectionListener {
    void onConnectReady(TCPConnection tcpConnection);
    void onReceiveString(TCPConnection tcpConnection, String s);
    void onDisconnect(TCPConnection tcpConnection);
    void onException(TCPConnection tcpConnection, IOException e);

    void onConnectionReady(TCPConnection tcpConnection);
}