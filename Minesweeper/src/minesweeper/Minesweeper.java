/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import minesweeper.game.Game;
import minesweeper.ui.Console;

/**
 *
 * @author usuario
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Console c = new Console();
        Game g;
        {
            String line = c.r.read();
            String[] values = line.split(" ");
            int rows = Integer.parseInt(values[0]);
            int cols = Integer.parseInt(values[1]);
            int mines = Integer.parseInt(values[2]);
            g = new Game(rows, cols, mines);
            c.w.write(g.getBoard());
        }
        do{
            String line = c.r.read();
            c.play(line, g);
            c.w.write(g.getBoard());
        }while(g.checkBoard());
    }
    
}
