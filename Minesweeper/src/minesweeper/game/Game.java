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
public class Game {
    private Masker mask;
    private Board board;
    
    /**Given the params, generate a game board and a mask that hide the board
     * info to the user.
     *
     * @param rows Specifies the nunmber of rows in the board and in the mask.
     * @param cols Specifies the nunmber of columns in the board and in the 
     *             mask.
     * @param mines Specifies the nunmber of mines randomly placed in the board.
     */
    public Game(int rows, int cols, int mines){
        board = new Board(rows, cols, mines);
        mask = new Masker(rows, cols);
    }
    
    /**Given the kind of movement the user input, this method reveals part of
     * the board or mark a cell with a flag.
     *
     * @param x x coordinate or row where the movement will take effect.
     * @param y y coordinate or column where the movement will take effect.
     * @param move Type of movement the user input: "U" for uncover or "M" for
     *              mark.
     */
    public void play(int x, int y, String move){
        if(x >= board.board.length || y >= board.board[0].length){
            return; //Move out of board limits
        }
        if(x<0 || y<0){
            return; //Move out of board limits
        }
        if(!(move.equals("U") || move.equals("M"))){
            return; //Invalid movement
        }
        if(this.mask.mask[x][y]==1){
            return;
        }else{
            if(move.equals("M")){
                this.mask.marksAmmount++;
                this.mask.mask[x][y]=2;
            }else if(move.equals("U")){
                if(this.mask.mask[x][y]==2){
                    this.mask.marksAmmount--;
                }
                this.mask.mask[x][y]=1;
                if(this.board.board[x][y].type==2){
                    for(int i=0; i<this.board.mines.length; i++){
                        GameObject mine = this.board.mines[i];
                        this.mask.mask[mine.row][mine.column]=1;
                    }
                    return;
                }else if(this.board.board[x][y].type==1){
                    if(this.board.board[x][y].content.equals("-")){
                        for(int i=-1; i<2; i++){
                            for(int j=-1; j<2; j++){
                                if(i==0 && j==0){
                                    continue;
                                }
                                if(x+i>=0 && x+i<this.board.board.length){
                                    if(y+j>=0){
                                        if(y+j<this.board.board[0].length){
                                            play(x+i, y+j, "U");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**Check if the board is still playable every round.
     *
     * @return true if the player can continue playing, false otherways.
     */
    public boolean checkBoard(){
        boolean coveredMines = true;
        for(int i=0; i<this.board.mines.length; i++){
            GameObject mine = this.board.mines[i];
            if(this.mask.mask[mine.row][mine.column]==1){
                return false;
            }
            coveredMines &= this.mask.mask[mine.row][mine.column]==2;
        }
        return !(coveredMines && 
                this.mask.marksAmmount==this.board.minesAmmount);
    }
    
    /**
     *
     * @return string repensenting the game board.
     */
    public String getBoard(){
        return mask.maskBoard(board);
    }
    
}
