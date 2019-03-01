package com.sda5.todo;

public class Status {
    private String status;

    public Status(String status) {
        this.status = status;

    }

    @Override
    public boolean equals(Object status) {
        return this.equals(status.toString());
    }

    @Override
    public String toString() {
        return status;
    }
}
