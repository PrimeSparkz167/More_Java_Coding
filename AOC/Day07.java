/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day07;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Simon
 */
public class Day07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<char[]> field = new ArrayList<>();
        String in = sc.nextLine();
        field.add(in.toCharArray());
        int S = findchars(field.get(0), "S".charAt(0)).get(0);
        field.add(sc.nextLine().toCharArray());
        field.get(1)[S] = "|".charAt(0);
        TreeSet<Integer> beams = new TreeSet<>();
        in = sc.nextLine();
        ArrayList<Integer> nbeam = new ArrayList<>();
        beams.add(S);
        int count = 0;
        while (!in.equals("e")) {
            char[] curr = in.toCharArray();
            beams.addAll(nbeam);
            nbeam = new ArrayList<>();
            for (int b : beams) {
                if (curr[b] == "^".charAt(0)) {
                    nbeam.add(b + 1);
                    nbeam.add(b - 1);
                    curr[b + 1] = "|".charAt(0);
                    curr[b - 1] = "|".charAt(0);
                    count++;
                }else{
                curr[b] = "|".charAt(0);
                nbeam.add(b);
                }
            }
            beams = new TreeSet<>();
            field.add(curr);
            in = sc.nextLine();
        }
        for (int i = 0; i < field.size(); i++) {
            System.out.println((field.get(i)));
        }
        System.out.println("" + count);
    }

    public static ArrayList<Integer> findchars(char[] s, char c) {
        ArrayList<Integer> fi = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == c) {
                fi.add(i);
            }
        }
        return fi;
    }

}
