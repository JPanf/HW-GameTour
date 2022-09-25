package ru.netology.Game.service;

import java.util.ArrayList;

public class Game {

    public ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> findAll() {
        return players;
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }

}
