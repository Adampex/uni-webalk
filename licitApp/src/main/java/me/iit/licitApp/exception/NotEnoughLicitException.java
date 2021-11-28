package me.iit.licitApp.exception;

import java.util.UUID;

public class NotEnoughLicitException extends RuntimeException {

    private UUID id;

    public NotEnoughLicitException(UUID id) {
        super("Not enough raise with this licit " + id);
        this.id = id;
    }
}
