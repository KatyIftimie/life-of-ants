package com.codecool.ants;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid();
        Queen queen = new Queen();
        Queen.setMood(Util.randomIntFromRange(0,10));
        ArrayList<Insect> insects = new ArrayList<>();
        insects.add(queen);
        for (int i=0; i<4; i++) {
            Worker worker = new Worker(Util.randomIntFromRange(1,49), Util.randomIntFromRange(1,49));
            insects.add(worker);
            Soldier soldier = new Soldier(Util.randomIntFromRange(1,49), Util.randomIntFromRange(1,49));
            insects.add(soldier);
            Drone drone = new Drone(Util.randomIntFromRange(1,49), Util.randomIntFromRange(1,49));
            insects.add(drone);
        }

        for(Insect insect: insects) {
            insect.setPosition();
        }
        grid.drawGrid();
        Scanner in = new Scanner(System.in);
        int x = 0;
        String command;
        while ( x  < 50) {
            command = in.nextLine();
            if(command.equals("x")){
                for(Insect insect: insects) {
                    insect.setPosition();
                }
            }
            grid.drawGrid();
            x++;
        }

    }

}
