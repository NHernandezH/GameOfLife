/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameoflife;

import junit.framework.Assert;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author noe_5
 */
public class GameTest {
    
    private static Game game;
    private Integer[][] panel ={
            {0,1,1,1,0,1,0,1,0,0},
            {0,0,0,1,0,1,0,1,0,1},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,0},
            {1,0,0,1,0,1,0,0,1,0},
            {1,1,1,1,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,0,0,1},
            {1,1,1,1,0,1,0,1,0,1}};
        
    
    @BeforeClass
    public static void init(){
        game = new Game();
    }
    
    
    @Test
    public void testDead(){
        Integer[] neighbors = {0,1,0,1,0,1}; //dead is true
        assertTrue(game.dead(neighbors));
        Integer[] neighbors1 = {0,1,0,0,1}; //dead is true
        assertTrue(game.dead(neighbors1));
        Integer[] neighbors2 = {0,1,0,1,0,1,1};  //dead is false
        assertFalse(game.dead(neighbors2));
        Integer[] neighbors3 = {0,1,0,0,}; //dead is false 
        assertFalse(game.dead(neighbors3));
        Integer[] neighbors4 = {0,0,0}; //dead is false
        assertFalse(game.dead(neighbors4));
        Integer[] neighbors5 = {0,1,0,1,0,1,1,1}; //dead is false
        assertFalse(game.dead(neighbors5));
    }
    
    @Test
    public void testBorn(){
        Integer[] neighbors = {0,1,0,1,0,1}; //born is true
        assertTrue(game.born(neighbors));
        Integer[] neighbors1 = {0,0,0,1}; //born is false
        assertFalse(game.born(neighbors1));
        Integer[] neighbors2 = {0,1,0,1,0};  //born is false
        assertFalse(game.born(neighbors2));
        Integer[] neighbors4 = {0,0,0,1,1,1,1}; //born is false
        assertFalse(game.born(neighbors4));
        Integer[] neighbors5 = {0,1,0,1,0,1,1,1}; //born is false
        assertFalse(game.born(neighbors5));
    }
    
    @Test
    public void testGetNeighbors(){
        
        Integer[] neigbors = game.getNeighbors(panel,0,0);
        assertEquals(neigbors.length,8);
        Integer[] neigborsMock = {0,0,0,0,1,0,0,0}; 
        assertArrayEquals(neigbors,neigborsMock);
        
        Integer[] neigbors1 = game.getNeighbors(panel,0,9);
        assertEquals(neigbors1.length,8);
        Integer[] neigborsMock1 = {0,0,0,0,0,0,1,0}; 
        printArray(neigbors1);
        printArray(neigborsMock1);
        assertArrayEquals(neigbors1,neigborsMock1);
        
        Integer[] neigbors2 = game.getNeighbors(panel,9,0);
        assertEquals(neigbors2.length,8);
        Integer[] neigborsMock2 = {0,0,0,0,1,0,0,0}; 
        assertArrayEquals(neigbors2,neigborsMock2);
        
        Integer[] neigbors3 = game.getNeighbors(panel,9,9);
        assertEquals(neigbors3.length,8);
        Integer[] neigborsMock3 = {0,1,0,0,0,0,0,0}; 
        assertArrayEquals(neigbors3,neigborsMock3);
        
        Integer[] neigbors4 = game.getNeighbors(panel,5,5);
        assertEquals(neigbors4.length,8);
        Integer[] neigborsMock4 = {0,1,0,1,1,0,0,0}; 
        assertArrayEquals(neigbors4,neigborsMock4);
    }
    
    @Test
    public void testGetNewCellStatus(){
        assertEquals(Integer.valueOf("1"),game.getNewCellStatus(panel, 6, 2));
        assertEquals(Integer.valueOf("1"),game.getNewCellStatus(panel, 6, 5));
        assertEquals(Integer.valueOf("1"),game.getNewCellStatus(panel, 0, 2));
        assertEquals(Integer.valueOf("1"),game.getNewCellStatus(panel, 0, 3));
        
        assertEquals(Integer.valueOf("0"),game.getNewCellStatus(panel, 0, 0));
        assertEquals(Integer.valueOf("0"),game.getNewCellStatus(panel, 9, 9));
        assertEquals(Integer.valueOf("0"),game.getNewCellStatus(panel, 6, 9));
        assertEquals(Integer.valueOf("0"),game.getNewCellStatus(panel, 7, 0));
    }
    
//    private Integer[][] panel ={
//            {0,1,1,1,0,1,0,1,0,0},
//            {0,0,0,1,0,1,0,1,0,1},
//            {0,0,0,0,0,0,0,0,0,0},
//            {1,1,1,1,1,1,1,1,1,0},
//            {1,0,0,1,0,1,0,0,1,0},
//            {1,1,1,1,1,1,1,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,1,1,0,0,1},
//            {1,1,1,1,0,1,0,1,0,1}};
//    
    public void printArray(Integer[] array){
        for(Integer row: array){
            System.out.print(row);
        }
        System.out.println("");
    }
}
