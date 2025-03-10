/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class ConsInput {

    public static Scanner input = new Scanner(System.in);

    
    public static int getIntinp() {
        return input.nextInt();
    }

    public static double getDouinp() {
        return input.nextDouble();
    }

}

