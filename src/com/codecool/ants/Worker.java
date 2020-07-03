package com.codecool.ants;

public class Worker extends Insect{
//    private String name;
    public Worker(int positionX, int positionY) {
        this.name = " W ";
        this.position = positionX + " " + positionY;
        this.step = this.position;
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
        try {

            int temp = Integer.parseInt(coordinates[0]) + Util.randomIntFromRange(-1, 1);
            if ( temp < Grid.size & temp >= 0) {
                coordinates[0] = String.valueOf(temp);
            }
            temp = Integer.parseInt(coordinates[1]) + Util.randomIntFromRange(-1, 1);
            if ( temp < Grid.size & temp >= 0) {
                coordinates[1] = String.valueOf(temp);
            }
            this.step = coordinates[0] + " " + coordinates[1];
            System.out.println("Worker " + step);
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println(exception);
            this.step = this.position;
        }
    }
}
