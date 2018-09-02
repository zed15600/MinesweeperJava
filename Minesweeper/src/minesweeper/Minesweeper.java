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
        boolean playable = false;
        do{
            try{
                String line = c.reader.read();
                String[] values = line.split(" ");
                int rows = Integer.parseInt(values[0]);
                int cols = Integer.parseInt(values[1]);
                int mines = Integer.parseInt(values[2]);
                playable = mines < (rows*cols);
                if(playable){
                    g = new Game(rows, cols, mines);
                    c.writer.write(g.getBoard());
                }else{
                    System.out.println();
                    g = null;
                }
            }catch(Exception e){
                System.out.println();
                g = null;
            }
        }while(!playable);
        do{
            String line = c.reader.read();
            c.play(line, g);
            c.writer.write(g.getBoard());
        }while(g.checkBoard());
    }
    
}
