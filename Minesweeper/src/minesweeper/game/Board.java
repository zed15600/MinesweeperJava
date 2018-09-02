/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.game;

import java.util.Random;

/**
 *
 * @author Edison Zapata Henao.
 */
public class Board {
    protected int minesAmmount;
    protected GameObject[] mines;
    protected GameObject[][] board;
    
    /**Given the params, generates a board.
     *
     * @param rows Specifies the nunmber of rows in the board.
     * @param cols Specifies the number of columns in the board.
     * @param mines Specifies the quantity of mines randomly placed in the 
     *              board.
     */
    public Board(int rows, int cols, int mines){
        this.minesAmmount = mines;
        this.mines = new GameObject[minesAmmount];
        this.board = new GameObject[rows][cols];
        Random rndm = new Random();
        //Placing the mines
        for(int i=0; i<mines; i++){
            int pos = rndm.nextInt(rows*cols);
            int row = pos/cols;
            int col = pos%cols;
            if(this.board[row][col]!=null){
                i--;
            }else{
                this.mines[i] = new GameObject(row, col, 2, "*");
                this.board[row][col] = this.mines[i];
            }
        }
        //Filling the board
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(this.board[i][j]!=null){
                    continue;
                }
                int minesAround=0;
                for(int k=-1; k<2; k++){
                    for(int l=-1; l<2; l++){
                        if(k==0 && l==0){
                            continue;
                        }
                        if((i+k>=0 && i+k<rows)&&(j+l>=0 && j+l<cols)){
                            if(this.board[i+k][j+l]!=null){
                                if(this.board[i+k][j+l].type==2){
                                    minesAround++;
                                }
                            }
                        }
                    }
                    GameObject g;
                    if(minesAround == 0){
                        g = new GameObject(i, j, 1, "-");
                    }else{
                        g = new GameObject(i, j, 1, ""+minesAround);
                    }
                    this.board[i][j] = g;
                }
            }
        }
    }
    
}
