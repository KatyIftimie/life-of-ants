package com.codecool.ants;

public class Queen  extends Insect {
    private static int mood;
    private static String queenLocation;
//    private String name;

    public Queen() {
        this.name = " Q ";
        this.position = "25 25";
        mood = 0;
        queenLocation = this.position;


    }

    @Override
    public void setPosition() {
        String[] coordinates = position.split(" ");
        Grid.drawEntities(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]),name);

    }

    @Override
    public void setStep() {

    }

    public static void setMood(int qMood) {
        mood = qMood;
    }

    public static int getMood() {
        return mood;
    }

    public static String getQueenLocation() {
        return queenLocation;
    }
}
