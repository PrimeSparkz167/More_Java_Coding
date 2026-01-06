/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Day09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] ins;
        int n = 100000, n2 = 50000, s = 0;
        ArrayList<int[]> ul = new ArrayList<>();
        ArrayList<int[]> ll = new ArrayList<>();
        ArrayList<int[]> ur = new ArrayList<>();
        ArrayList<int[]> lr = new ArrayList<>();
        while (!in.equals("e")) {
            ins = sc.nextLine().split(",");
            int[] t = {Integer.parseInt(ins[0]), Integer.parseInt(ins[1])};
            if (t[0] < n2) {
                if (t[1] < n2) {
                    ul.add(t);
                } else {
                    ur.add(t);
                }
            } else if (t[1] < n2) {
                ll.add(t);
            } else {
                lr.add(t);
            }
            s++;
            in=sc.nextLine();
        }
        System.out.println(s);
        long maxAr=0;
        for (int i = 0; i < ul.size(); i++) {
            for (int j = 0; j < lr.size(); j++) {
                long a= area(ul.get(i),lr.get(j));
                maxAr=Math.max(maxAr, a);
            }
        }
        for (int i = 0; i < ll.size(); i++) {
            for (int j = 0; j < ur.size(); j++) {
                long a= area(ll.get(i),ur.get(j));
                maxAr=Math.max(maxAr, a);
            }
        }
        System.out.println(maxAr);
    }

    public static long area(int[] p1, int[] p2) {
        return Long.valueOf(Math.abs(p2[0] - p1[0]) + 1) * Long.valueOf(1 + Math.abs(p2[1] - p1[1]));
    }

}
