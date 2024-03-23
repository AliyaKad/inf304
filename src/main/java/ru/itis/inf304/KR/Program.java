package ru.itis.inf304.KR;

public class Program {
    private String name;
    private BroadcastsTime startTime;

    public Program(String name, BroadcastsTime startTime) {
        this.name = name;
        this.startTime = startTime;

    }

    public String getName() {
        return name;
    }

    public BroadcastsTime getStartTime() {
        return startTime;
    }
}
