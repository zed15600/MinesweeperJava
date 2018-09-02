/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.ui;

import minesweeper.game.Game;

/**
 *
 * @author Edison Zapata Henao.
 */
public class Console {
    public Reader r;
    public Writer w;
    
    /**Creates a instance of the Console User Interface.
     *
     */
    public Console(){
        r = new Reader();
        w = new Writer();
    }
    
    /** Using the string that the user inputs, start a movement in the current 
     *  game
     *
     * @param move The string read from the standard input.
     * @param g The game that the movement will affect.
     */
    public void play(String move, Game g){
        String[] values = move.split(" ");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        String m = values[2];
        g.play(x, y, m);
    }
    
}
