package ru.netology.Game.service;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String message) {
        super(message);
    }
}

