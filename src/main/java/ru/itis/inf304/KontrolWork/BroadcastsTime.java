package ru.itis.inf304.KontrolWork;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private  byte hour;
    private  byte minutes;

    public byte getHour() {
        return hour;
    }


    public byte getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "BroadcastsTime{" +
                "hour=" + hour +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public int compareTo(BroadcastsTime o) {
        return 0;
    }
}