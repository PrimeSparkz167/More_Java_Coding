/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threepart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Threepart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String n;
        n = sc.nextLine();
        long sum = 0;
        while (!n.equals("e")) {
            //System.err.println(n);
            ArrayList<Integer> bank = new ArrayList<>(n.length());
            int[] best = new int[12];
            best[11] = -1;
            for (int j = 11; j > 0; j--) {
                int[] max = new int[2];
                for (int i = best[11] + 1; i < n.length() - j; i++) {
                    int d = Integer.parseInt("" + n.charAt(i));
                    if (bank.size()<=i) {
                        bank.add(d);
                    }else{
                    bank.set(i, d);
                    }
                    if (d > max[0]) {
                        max[0] = d;
                        max[1] = i;
                    }
                }
                best[11] = max[1];
                //System.err.println("best11=" + best[11]);
                best[11 - j] = max[0];
            }
            int last = Integer.parseInt("" + n.charAt(n.length() - 1));
            ArrayList<Integer> bank2 = new ArrayList<>();

            for (int i = best[11] + 1; i < n.length() - 1; i++) {
                bank2.add(bank.get(i));
            }
            bank2.add(last);
            Collections.sort(bank2);
            for (int i = 0; i < 11; i++) {
                //System.err.print(best[i] + " ");
                for (int j = 0; j < best[i]; j++) {
                    sum += tens(11 - i);
                }
            }
            //System.err.println("sum" + sum);
            sum += bank2.getLast();
            //System.err.println(sum);
            n = sc.next();
        }
        System.out.println("sum=" + sum);
    }

    public static long tens(int s) {
        long r = 1;
        for (int i = 0; i < s; i++) {
            r *= 10;
        }
        return r;
    }

}
