/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.ui;

import java.util.Scanner;

/**
 *
 * @author Edison Zapata Henao.
 */
public class Reader {
    private Scanner scan;
    
    /**Creates an instance of the reader for the CUI.
     *
     */
    public Reader(){
        scan = new Scanner(System.in);
    }
    
    /**Read a line from the standard input.
     *
     * @return the string readed from the standard input.
     */
    public String read(){
        return scan.nextLine();
    }
}
