package ru.itis.inf304.Game;

public class Something extends Creature {
    @Override
    public Point move() {
        currentPosition = new Point((int)(Math.random() * 1000), (int)(Math.random() * 1000));
        return currentPosition;
    }

    @Override
    public void print() {
        System.out.println(name + " - " + currentPosition);
    }
    public Something(String name) {
        this.name = name;
    }
}
