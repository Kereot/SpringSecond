package com.gb.context;

public record Product(Integer id, String name, float cost) {
    @Override
    public String toString() {
        return String.format("Id.%d: %s - %.2f$", id, name, cost);
    }
}
