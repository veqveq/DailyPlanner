package ru.veqveq.client.models;

public enum Priority {
    NOT_IMPORTANT_NOT_URGENT(0),
    NOT_IMPORTANT_URGENT(1),
    IMPORTANT_NOT_URGENT(2),
    IMPORTANT_URGENT(3);

    private final int priorityNumb;

    Priority(int priorityNumb) {
        this.priorityNumb = priorityNumb;
    }

}
