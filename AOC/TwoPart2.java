/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package twopart2;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class TwoPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",|-");
        long[][] ranges = new long[input.length / 2][2];
        for (int i = 0; i < input.length; i++) {
            ranges[i / 2][i % 2] = Long.parseLong(input[i]);
        }
        long sum = 0;
        for (int i = 0; i < ranges.length; i++) {
            for (long j = (ranges[i][0]); j <= ranges[i][1]; j++) {
                String s = Long.toString(j);
                boolean add = false;
                for (int k = 1; k <= s.length()/2 && !add; k++) {
                    String[] a = s.split(s.substring(0, k));
                    boolean loop=true;
                    for (int l = 0; l < a.length&&loop; l++) {
                        if (!a[l].equals("")) {
                            loop=false;
                        }
                    }
                    add=loop;
                }
                if (add) {
                    //System.out.println(s);
                    sum+=j;
                }
                
            }
        }
        System.out.println("sum=" + sum);
    }

}
