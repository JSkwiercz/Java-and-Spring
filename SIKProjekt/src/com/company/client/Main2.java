package com.company.client;

public class Main2 {

    public static void main(String[] args) {
        Client client2 = new Client();
        client2.startConnection("127.0.0.1", 8888);
        client2.go(client2, "bbbb");
    }
}