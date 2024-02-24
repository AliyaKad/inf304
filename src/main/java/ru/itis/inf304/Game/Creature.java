package ru.itis.inf304.Game;

public abstract class Creature implements Moveable, Printable {

    protected String name;

    protected Point currentPosition;

    public void init() {
        currentPosition = new Point(Math.abs((int)(Math.random() * 1000)), Math.abs((int)(Math.random() * 1000)));
    }

    @Override
    public abstract Point move();

    @Override
    public void print() {
    }
}
