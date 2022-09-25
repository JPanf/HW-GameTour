package ru.netology.Game.service;

public class NotRegisteredPlayerException extends RuntimeException {

    public NotRegisteredPlayerException(String message) {
        super(message);
    }
}

