package com.company.client;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client();
        client1.startConnection("127.0.0.1", 8888);
        client1.go(client1, "aaaa");

    }
}

