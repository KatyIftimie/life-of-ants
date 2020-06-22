package com.codecool.ants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Queen queen = new Queen();
        queen.setPosition();
        Worker worker = new Worker(Util.randomIntFromRange(1,49), Util.randomIntFromRange(1,49));
        worker.setPosition();
        Soldier soldier = new Soldier(Util.randomIntFromRange(1,49), Util.randomIntFromRange(1,49));
        soldier.setPosition();
        grid.drawGrid();
        Scanner in = new Scanner(System.in);
        int x = 0;
        String command;
        while ( x  < 50) {
            command = in.nextLine();
            if(command.equals("x")){
                worker.setPosition();
                soldier.setPosition();
            }
            grid.drawGrid();
            x++;
        }

//        worker.setStep();

    }
}
