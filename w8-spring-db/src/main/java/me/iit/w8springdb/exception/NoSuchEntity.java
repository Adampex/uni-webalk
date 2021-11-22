package me.iit.w8springdb.exception;

public class NoSuchEntity extends RuntimeException {
    private Long id;

    public NoSuchEntity(Long id) {
        super("No such entity" + id);
        this.id = id;
    }
}
