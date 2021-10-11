package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Player> players = new ArrayList<>();
    private Field[][] board = new Field[5][5];

    public void addPlayer(String login, int id) {
        if (players.size() < 6) {
            Player p = new Player(login, id);
            players.add(p);
        }
    }

    public int getIdByLogin(String login) {
        for (Player p : players) {
            if (p.getLogin().equals(login)) {
                return p.getId();
            }
        }
        return 0;
    }

    public int getIdFromField(String a1, String b1) {
        int i = Integer.parseInt(a1);
        int j = Integer.parseInt(b1);
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (x == i && y == j)
                    return board[x][y].getId();
            }
        }
        return 0;
    }

    public boolean playerIsEliminated(String login) {
        for (Player p : players) {
            if (p.getLogin().equals(login))
                return p.isEliminated();
        }
        return true;
    }


    public void setBoard() {
        //creating fields
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                board[x][y] = new Field();
            }
        }

        //random players start field
        for (int i = 1; i <= 5; i++) {
            int j = 0;
            while (j < 2) {
                int x = (int) (Math.random() * 5);
                int y = (int) (Math.random() * 5);
                if (board[x][y].getId() == 0) {
                    board[x][y].setId(i);
                    board[x][y].setDices(2);
                    j++;
                }
            }
        }
        //random inactive fields
        int i = 0;
        while (i < 5) {
            int x = (int) (Math.random() * 5);
            int y = (int) (Math.random() * 5);
            if (board[x][y].getId() == 0) {
                board[x][y].setDices((int) (Math.random() * 5) + 1);
                i++;
            }
        }
    }

    public String attack(String a1, String b1, String a2, String b2) {
        String result;
        int x1 = Integer.parseInt(a1);
        int x2 = Integer.parseInt(a2);
        int y1 = Integer.parseInt(b1);
        int y2 = Integer.parseInt(b2);
        Field attacking = board[x1][y1];
        Field attacked = board[x2][y2];
        int[][] rolls = new int[2][];
        rolls[0] = new int[attacking.getDices()];
        rolls[1] = new int[attacked.getDices()];
        int attackingSum = 0, attackedSum = 0, winner = 0;
        for (int i = 0; i < attacking.getDices(); i++) {
            rolls[0][i] = attacking.roll();
            attackingSum = rolls[0][i];
        }
        for (int i = 0; i < attacked.getDices(); i++) {
            rolls[1][i] = attacked.roll();
            attackedSum = rolls[1][i];
        }

        if (attackingSum > attackedSum) {
            attacked.setId(attacking.getId());
            attacked.setDices(attacking.getDices() - 1);
            winner = attacking.getId();
        } else {
            winner = attacked.getId();
        }
        attacking.setDices(1);
        result = ("WYNIK" + attacking.getId() + " " + rolls[0].length + " ");
        for (int i = 0; i < rolls[0].length; i++) {
            result += (rolls[0][i] + " ");
        }
        result += (attacked.getId() + " " + rolls[1].length + " ");
        for (int i = 0; i < rolls[1].length; i++) {
            result += (rolls[1][i] + " ");
        }
        result += (winner + "\n");
        return result;
    }


    public boolean isAttackable(String a1, String b1, String a2, String b2) {
        int x1 = Integer.parseInt(a1);
        int x2 = Integer.parseInt(a2);
        int y1 = Integer.parseInt(b1);
        int y2 = Integer.parseInt(b2);
        if ((x1 >= 1 && x1 <= 5) && (x2 >= 1 && x2 <= 5) && (y1 >= 1 && y1 <= 5) && (y2 >= 1 && y2 <= 5)) {
            if (x1 == (x2 + 1) || x1 == (x2 - 1)) {
                if (y1 == (y2 + 1) || y1 == (y2 - 1)) {
                    if (board[x1][y1].getDices() > 1) {
                        if (board[x1][y1].getId() != board[x2][y2].getId()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void giveDice() {
        int[] idTable = new int[5];

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (board[x][y].getId() > 0) {
                    if (idTable[board[x][y].getId() - 1] < 8) {
                        idTable[board[x][y].getId() - 1]++;
                    }
                }
            }
        }
    }

    public String giveInfo(int x, int y) {
        return ("PLANSZA " + (x + 1) + " " + (y + 1) + " " + board[x][y].getId() + " " + board[x][y].getDices());

    }

    public void isOut(int id) {
        int fields = 0;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (board[x][y].getId() == id) {
                    fields++;
                }
            }
        }
        if (fields == 0) {
            players.get(id - 1).setEliminated(true);
        }
    }

    public boolean ifGameReady() {
        if (players.size() == 2) {
            return true;
        } else {
            return false;
        }
    }
}