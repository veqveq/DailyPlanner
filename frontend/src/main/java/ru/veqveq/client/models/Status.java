package ru.veqveq.client.models;

public enum Status {
    EXPIRED(0),
    CANCELED(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final int statusNumb;

    Status(int statusNumb) {
        this.statusNumb = statusNumb;
    }
}
