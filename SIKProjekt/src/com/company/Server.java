package com.company;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {

    private static Game game = new Game();
    private static ArrayList<ClientHandler> client = new ArrayList<>();
    private ServerSocket serverSocket;
    private int playerIdTurn = 1;
    private int gameNumber;
    private int roundNumber = 1;
    private boolean turnDone = false;
    private boolean theEnd = false;
    private int place;

    public void start(int port) {
        int clients = 0;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ServerSocket error");
        }
        while (clients < 2) {
            try {
                clients++;
                client.add(new ClientHandler(serverSocket.accept(), clients));
                client.get(clients - 1).start();
                System.out.println("Clients: " + clients);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ClientHandler error");
            }
        }

        for (gameNumber = 1; gameNumber <= 10; gameNumber++) {
            place = 5;
            game.setBoard();
            while (!turnDone) {

            }
            turnDone = false;
            roundNumber = 1;
        }

    }

    public void sendToAll(String message, int id) {
        for (ClientHandler client : client) {
            if (client.id != id)
                client.out.println(message);
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server stop error");
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String line;
        private String login;
        private int id;

        public ClientHandler(Socket socket, int id) {
            this.clientSocket = socket;
            this.id = id;
        }

        public void board() {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    try {
                        String msg = game.giveInfo(x, y);
                        out.println(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void scoreBoard() {

        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out.println("POLACZONO");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO Thread error");
            }

            try {
                line = in.readLine();
                if (line.startsWith("LOGIN")) {
                    String[] message = line.split(" ");
                    login = message[1];
                    game.addPlayer(login, id);
                    out.println("OK");
                } else {
                    out.println("ERROR");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Login error");
            }

            while (true) {
                if (game.ifGameReady()) {
                    try {
                        out.println("START " + game.getIdByLogin(login) + " 1");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (gameNumber <= 10) {
                board();
                while (!(game.getIdByLogin(login) == playerIdTurn)) {
                    out.println("WAIT" + playerIdTurn);
                }

                if (!game.playerIsEliminated(login)) {
                    try {
                        out.println("TWOJ RUCH");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        line = in.readLine();
                        if (line.startsWith("PASS")) {
                            out.println("OK");
                        }
                        while (!line.startsWith("PASS")) {
                            if (line.startsWith("ATAK")) {
                                String[] msg = line.split(" ");
                                if ((game.getIdByLogin(login) == game.getIdFromField(msg[1], msg[2])) && (game.isAttackable(msg[1], msg[2], msg[3], msg[4]))) {
                                    out.println("OK");
                                    sendToAll(line, game.getIdByLogin(login));
                                    line = game.attack(msg[1], msg[2], msg[3], msg[4]);
                                    out.println(line);
                                    sendToAll(line, game.getIdByLogin(login));
                                } else {
                                    out.println("ERROR");
                                }
                            } else {
                                out.println("ERROR");
                            }
                            line = in.readLine();
                            if (line.startsWith("PASS")) {
                                out.println("OK");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    game.isOut(game.getIdByLogin(login));
                    if (playerIdTurn < 2) {
                        roundNumber++;
                        playerIdTurn++;
                    } else {
                        sendToAll("KONIEC RUNDY", 9);
                        roundNumber++;
                        game.giveDice();
                        playerIdTurn = 1;
                        board();
                    }
                    if (game.playerIsEliminated(login)) {
                        out.println("TURA" + gameNumber + place);
                        place--;
                    }
                    if (roundNumber == 100) {
                        turnDone = true;
                        out.println("TURA" + gameNumber);
                        gameNumber++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                out.println("KONIEC");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

