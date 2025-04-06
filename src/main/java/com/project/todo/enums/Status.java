package com.project.todo.enums;

public enum Status {
    NEW(0), ASSIGN(1), RE_ASSIGN(2), START(3), COMPLETE(4);
    private final int value;
    Status(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
