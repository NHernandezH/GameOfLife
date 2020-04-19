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
public class Main {
    
    private static Game game = new Game();
    
    public static void main(String[] args) {
        int rows = 10;
        int columns = 20;
        game.start(rows, columns);
    }
}