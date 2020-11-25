package com.techoffice.example;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class ListenerAppl {

    private static final int PORT = 5353;

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[8972];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        MulticastSocket multicastSocket = new MulticastSocket(5353);
        multicastSocket.receive(packet);

        packet.g
    }

}
