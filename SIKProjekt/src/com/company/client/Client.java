package com.company.client;

import java.io.*;
import java.net.*;

public class Client {

    private Field[][] board = new Field[5][5];
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        out.println(msg);
        String resp = null;
        try {
            resp = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public String getMessage() {
        String resp = null;
        while (resp == null) {
            try {
                resp = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resp;
    }

    public void go(Client client, String login) {
        try {
            String msg = client.getMessage();
            System.out.println(msg);
            msg = client.sendMessage("LOGIN " + login);
            System.out.println(msg);
            msg = client.getMessage();
            System.out.println(msg);
            for (int i = 0; i < 25; i++) {
                msg = client.getMessage();
                String[] boardInfo = msg.split(" ");
                int x = Integer.parseInt(boardInfo[1]) - 1;
                int y = Integer.parseInt(boardInfo[2]) - 1;
                int id = Integer.parseInt(boardInfo[3]);
                int dices = Integer.parseInt(boardInfo[4]);
                board[x][y] = new Field();
                board[x][y].setId(id);
                board[x][y].setDices(dices);
                System.out.println(msg);
            }

            while (true) {
                msg = client.getMessage();
                if (msg.startsWith("PLANSZA")) {
                    System.out.println(msg);
                }

                if (msg.startsWith("ATAK")) {
                    System.out.println(msg);
                }

                if (msg.startsWith("WYNIK")) {
                    System.out.println(msg);
                }

                if (msg.equals("KONIEC RUNDY")) {
                    System.out.println(msg);
                }

                if (msg.equals("KONIEC")) {
                    client.stopConnection();
                }

                if (msg.startsWith("TURA")) {
                    System.out.println(msg);
                }

                if (msg.startsWith("TWOJ")) {
                    System.out.println(msg);
                    msg = client.sendMessage("PASS");
                    System.out.println(msg);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
