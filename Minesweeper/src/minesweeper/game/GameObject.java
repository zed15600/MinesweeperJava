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
public class GameObject {
    protected final int row;
    protected final int column;
    protected final int type; //1: indicator, 2: mine
    protected final String content;
    
    /**Creates a GameObject instance using the given params.
     *
     * @param x Specifies the x coordinate or row in which the instance is 
     *          placed in the board.
     * @param y Specifies the y coordinate or column in which the instance is 
     *          placed in the board.
     * @param type SpecifiesThe type of GameObject: 1 fot inficator or void 
     *             cell or 2 for a mine.
     * @param cont A representative String of the object: a number or "-" for 
     *             an indicator or "*" for a mine.
     */
    public GameObject(int x, int y, int type, String cont){
        this.type = type;
        this.row = x;
        this.column = y;
        this.content = cont;
    }
}
