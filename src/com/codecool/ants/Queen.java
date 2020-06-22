package com.codecool.ants;

public class Queen  extends Insect {
    private int mood;
//    private String name;

    public Queen() {
        this.name = " Q ";
        this.position = "25 25";
        this.mood = 0;
        Grid.queenLocation = this.position;


    }

    @Override
    public void setPosition() {
        String[] coordinates = position.split(" ");
        Grid.drawEntities(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]),name);

    }

    @Override
    public void setStep() {

    }
}
