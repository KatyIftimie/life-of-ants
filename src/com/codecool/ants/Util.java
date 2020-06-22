package com.codecool.ants;

import java.util.Random;

public class Util {
    public static int stepsToQueen() {
        return 25;
    }

    public static int randomIntFromRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) +1) + min;

        return randomNum;
    }

}
