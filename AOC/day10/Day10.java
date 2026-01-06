/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day10;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Day10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] ins;
        int sum=0,n=200;
        for (int i = 0; i < n; i++) {
            ins=in.split(" ");
            Graph g = new Graph();
            sum+=g.makeFind(ins);
            in=sc.nextLine();
            System.out.println(sum);
        }
        System.out.println("Final= "+sum);
    }
    
    
}
