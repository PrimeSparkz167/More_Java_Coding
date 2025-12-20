/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package twopart1;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class TwoPart1 {

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
                if (s.length() % 2 == 0) {
                    if (s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2))) {
                        sum += j;
                    }
                }
            }
        }
        System.out.println("fin sum" + sum);
    }

}
