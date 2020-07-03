package com.codecool.ants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Soldier extends Insect {
    private String[] route;
    public Soldier(int positionX, int positionY) {
        this.name = " S ";
        this.position = positionX + " " + positionY;
        this.step = this.position;
        this.route = setRoute(this.position);
    }

    @Override
    public void setPosition() {
        setStep();
        this.position = this.step;
        String[] coordinates = this.position.split(" ");
        Grid.drawEntities(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), name);
    }

    int i = 0;

    @Override
    public void setStep() {
        String[] coordinates = this.position.split(" ");
        Grid.removeEntity(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
//        for( int i = 0; i<this.route.length; i++){
        try {
            if (this.step.equals(route[i])) {
                if(i< this.route.length-1){
                    this.step = this.route[i+ 1];
                    i++;
                    System.out.println("Soldier " + this.step);
                }
                else {
                    this.step= this.route[0];
                    i = 0;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception);
            this.step= this.position;
        }




    }

    public String[] setRoute(String position) {
        String[] moves = new String[4];

        try {
            moves[0] = position;
            String[] coordinates = position.split(" ");
            if((Integer.parseInt(coordinates[0])+ 1 & Integer.parseInt(coordinates[1])+ 1) < Grid.size){
                moves[1] =  coordinates[0] + " " + (Integer.parseInt(coordinates[1]) + 1);
                moves[2] =  (Integer.parseInt(coordinates[0])+ 1) + " " + (Integer.parseInt(coordinates[1]) + 1);
                moves[3] = (Integer.parseInt(coordinates[0])+ 1) + " " + coordinates[1];
            return moves;
            }
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception);
            this.step = this.position;
        }
        return moves;
    }


}
