package ru.netology.Game.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTourTest {

    Game game = new Game();

    Player player1 = new Player(1, "Egor", 20);
    Player player2 = new Player(2, "Petya", 15);
    Player player3 = new Player(3, "Dasha", 10);
    Player player4 = new Player(4, "Alesha", 15);

    //   Player player5 = new Player(5, "Natasha", 18);
    //   Player player6 = new Player(6, "Yulia", 20);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void ShowAllRegisteredPlayers() {

        List<Player> expected = List.of(player1, player2, player3, player4);
        List<Player> actual = game.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldOfferDrawIfEqualStrength() {
        int expected = 0;
        int actual = game.round("Petya", "Alesha");

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinFirstPlayerIfHisStrengthGreater() {
        int expected = 1;
        int actual = game.round(player1.getName(), player2.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinSecondPlayerIfHisStrengthGreater() {
        int expected = 2;
        int actual = game.round("Dasha", "Alesha");

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldStopIfOneUnregisteredPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round("Egor", "Natasha");
                }
        );
    }

    @Test
    public void ShouldStopIfAllUnregisteredPlayers() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round("Yulia", "Natasha");
                }
        );
    }

}
