package com.codecool.ants;

import java.util.Arrays;

public class Grid {
    public static final int size = 50;
    public static String[][] grid;
    public static String queenLocation = "";


    public Grid() {
        String[][] grid = new String[size][size];
        for (String[] row : grid) {
            Arrays.fill(row, " - ");
        }
        this.grid = grid;
    }

    public void drawGrid() {
        for (String[] row : this.grid) {
            System.out.println("");
            for (String cell : row) {
                System.out.print(cell);
            }
        }
    }

    public String getQueenLocation() {
        return queenLocation;
    }

    public static void drawEntities(int positionX, int positionY, String name) {
        grid[positionX][positionY] = name;
    }

    public static void removeEntity(int positionX, int positionY) {
        grid[positionX][positionY] = " - ";
    }
}
