/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author gaurang
 */
public class InvalidIndexException extends Exception{
    
    public String toString()
    {
        return "Your entered code is invalid.";
    }
}