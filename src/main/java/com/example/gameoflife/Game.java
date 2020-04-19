/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameoflife;

/**
 *
 * @author noe_5
 */
public class Game {

    Integer[][] panel;

    public void start(int rows, int columns) {
        panel = new Integer[rows][columns];
        initPanel();
        while (true) {
            printPanel();
            updatePanel();
            System.out.println("");
            break;
        }
        printPanel();
    }

    private void initPanel() {
        for (int row = 0; row < panel.length; row++) {
            for (int column = 0; column < panel[row].length; column++) {
                panel[row][column] = generateRandomValue();
            }
        }
    }

    private int generateRandomValue() {
        return (int) (Math.random() * 2);
    }

    private void printPanel() {
        for (int row = 0; row < panel.length; row++) {
            for (int column = 0; column < panel[row].length; column++) {
                System.out.print(panel[row][column]);
            }
            System.out.println("");
        }
    }

    private void updatePanel() {
        Integer[][] newPanel = panel;
        for (int row = 0; row < panel.length; row++) {
            for (int column = 0; column < panel[row].length; column++) {
                Integer cellStatus = getNewCellStatus(panel, row, column);
                newPanel[row][column] = cellStatus;
            }
        }
        panel = newPanel;
    }

    public Integer getNewCellStatus(Integer[][] panel, int row, int column) {
        Integer status = panel[row][column];
        Integer[] neighbors = getNeighbors(panel, row, column);
        switch (status) {
            case 0:
                return born(neighbors) ? 1 : 0;
            case 1:
                return dead(neighbors) ? 1 : 0;
            default:
                return 0;

        }
    }

    public boolean dead(Integer[] neighbors){
        Integer neighborsAlive = 0;
        for (Integer neighborStatus : neighbors) {
            neighborsAlive += neighborStatus;
        }

        return neighborsAlive == 2 || neighborsAlive == 3;
    }

    public boolean born(Integer[] neighbors) {
        Integer neighborsAlive = 0;
        for (Integer neighborStatus : neighbors) {
            neighborsAlive += neighborStatus;
        }
        return neighborsAlive == 3;
    }

    public Integer[] getNeighbors(Integer[][] panel, int row, int column) {
        Integer[] neigbors = new Integer[8];
        int neigborIndex = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r != row || c != column) {
                    try {
                        neigbors[neigborIndex] = panel[r][c];
                    } catch (IndexOutOfBoundsException ex) {
                        neigbors[neigborIndex] = 0;
                    }
//                    System.out.println(neigborIndex);
                    neigborIndex++;
                }
            }
        }
        return neigbors;
    }

}
