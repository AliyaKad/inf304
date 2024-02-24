package ru.itis.inf304.Game;

public class Caterpilar extends Creature {
    String name = "Caterpilar";
    public Point move() {
        int direction = (int)(Math.random() * 2);
        if (currentPosition == null)
            init();
        switch (direction) {
            case 0:
                if (currentPosition.getColumn() >= 1000) break;
                currentPosition.setColumn(currentPosition.getColumn()+1);
                break;
            case 1:
                if (currentPosition.getRow() >= 0)
                    break;
                currentPosition.setRow(currentPosition.getRow()-1);
                break;
            case 2:
                if (currentPosition.getRow() >= 1000) break;
                currentPosition.setRow(currentPosition.getRow()+1);
                break;
        }
        return currentPosition;
    }

    public Caterpilar(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name + " - " + currentPosition);
    }
}
