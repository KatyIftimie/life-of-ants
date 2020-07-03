package com.codecool.ants;

import java.util.Random;


public class Drone extends Insect {
    String queenLocation = Queen.getQueenLocation();
    int queenMood = Queen.getMood();
    int matingTime;


    public Drone(int positionX, int positionY) {
        this.name= " D ";
        this.position = positionX + " " + positionY;
        this.step = this.position;
        this.matingTime = 0;
    }


    @Override
    public void setPosition() {
        setStep();
        this.position = this.step;
        String[] coordinates = this.position.split(" ");
        Grid.drawEntities(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), name);
    }


    @Override
    public void setStep() {
        String[] coordinates = this.position.split(" ");
        Grid.removeEntity(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));

        String[] queenCoordinates = this.queenLocation.split(" ");
        int queenX = Integer.parseInt(queenCoordinates[0]);
        int queenY = Integer.parseInt(queenCoordinates[1]);
        int droneX = Integer.parseInt(coordinates[0]);
        int droneY = Integer.parseInt(coordinates[1]);
        int nextX;
        int nextY;
        if ((queenX== droneX & ((queenY+3) <= droneY || (queenY-3) >=droneY)) || (queenY==droneY & ((queenX+3) <= droneX || (queenX-3) >= droneX))) {
            if (queenMood <= 3) {
                System.out.println("HALLELUJAH");
                if (matingTime<= 3){
                    this.step = this.position;
                    this.matingTime++;
                }else {
                    System.out.println("D’OH");
                    Queen.setMood(Util.randomIntFromRange(0,10));
                    throwDrone();
                }

            }

        }else {
            if (queenX >= droneX & queenY >= droneY) {
                if (droneX == queenX) nextX = droneX;
                else nextX = droneX + 1;
                if (droneY == queenY) nextY = droneY;
                else nextY = droneY + 1;
                this.step = nextX + " " + nextY;
            } else if (queenX < droneX & queenY < droneY) {
                nextX = droneX - 1;
                nextY = droneY - 1;
                this.step = nextX + " " + nextY;
            } else if (queenX >= droneX & queenY < droneY) {
                if (droneX == queenX) nextX = droneX;
                else nextX = droneX + 1;
                nextY = droneY - 1;
                this.step = nextX + " " + nextY;
            } else if (queenX < droneX & queenY >= droneY) {
                nextX = droneX - 1;
                if (droneY == queenY) nextY = droneY;
                else nextY = droneY + 1;
                this.step = nextX + " " + nextY;
            } else {
                this.step = this.position;
            }
        }

    }

    public void throwDrone() {
        int positionX;
        int positionY;
        String[] edges = {"0","49"};
        int randomDirection = Util.randomIntFromRange(0,1);
        Random r = new Random();
        int randomEdge = r.nextInt(edges.length);
        if (randomDirection > 0) {
            positionX = randomEdge;
            positionY = Util.randomIntFromRange(0,49);
        }
        else {
            positionX = Util.randomIntFromRange(0,49);
            positionY = randomEdge;
        }
        System.out.println("Drone before throwing: " + this.step);
        this.step= positionX + " " + positionY;
        this.position = this.step;
        System.out.println("Drone after throwing: " + this.step);




    }

}
