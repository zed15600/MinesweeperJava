/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.game;

/**
 *
 * @author Edison Zapata Henao.
 */
public class Masker {
    protected int marksAmmount;
    protected int[][] mask;
    
    /** Given the params, creates a mask that is used for cover the game board 
     *  info to the user.
     *
     * @param rows Specifies the nunmber of rows for the mask.
     * @param cols Specifies the nunmber of columns for the mask.
     */
    public Masker(int rows, int cols){
        this.marksAmmount = 0;
        this.mask = new int[rows][cols];
    }
    
    /** Uses the information stored in the mask to define which información the 
     *  will see in the console.
     *
     * @param board Is the board whose information will be masked.
     * @return A string with the information ready to display.
     */
    public String maskBoard(Board board){
        String res = "";
        for(int i=0; i<this.mask.length; i++){
            for(int j=0; j<this.mask[i].length; j++){
                switch(this.mask[i][j]){
                    case 0:
                        res+=". ";
                        break;
                    case 1:
                        res+=board.board[i][j].content+" ";
                        break;
                    case 2:
                        res+="P ";
                        break;
                }
            }
            res+="\n";
        }
        return res;
    }
    
}
