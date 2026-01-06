/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Simon
 */
public class Day07_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<char[]> field = new ArrayList<>();
        String in = sc.nextLine(); //line 0
        field.add(in.toCharArray());
        int S = findchars(field.get(0), "S".charAt(0)).get(0);
        field.add(sc.nextLine().toCharArray());
        field.get(1)[S] = "|".charAt(0);
        
        long[][] parts = new long[142][141];
        parts[0][S] = 1;
        BigInteger count = BigInteger.ONE;
        for (int i = 1; i < 141; i++) {
            in = sc.nextLine();//read line i
            char[] type = in.toCharArray();
            for (int j = 0; j < type.length; j++) {
                long a = parts[i-1][j];
                if (type[j]=="^".charAt(0)) {
                    parts[i][j-1] += a;
                    parts[i][j+1] += a;
                    count=count.add(BigInteger.valueOf(a));
                }else{
                    parts[i][j] += a;
                }
            }
        }
        for (int i = 0; i < 142; i++) {
            for (int j = 0; j < 141; j++) {
                System.out.print(parts[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        System.out.println(count);
        //System.out.println(nbeam.size());
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
