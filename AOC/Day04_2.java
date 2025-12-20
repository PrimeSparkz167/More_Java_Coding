/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Day04_2 {

    public static int x, y;
    public static ArrayList<String> in;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        in = new ArrayList<>();
        String s = sc.nextLine();
        int ans = 0;
        char a = '@';
        char o = '.';
        while (s.charAt(0) != 'e') {
            in.add(s);
            s = sc.nextLine();
        }
        int preans=-1;
        while (preans != ans) {
            
            ArrayList<int[]> fix = new ArrayList<>();
            int count = 0;
            x = in.size();
            y = in.get(0).length();
            for (int i = 0; i < in.size(); i++) {
                for (int j = 0; j < y; j++) {
                    if (in.get(i).charAt(j) == a) {
                        ArrayList<int[]> pos = positions(i, j);
                        int c = 0;//roll counter
                        for (int k = 0; k < pos.size() && c < 4; k++) {
                            if (a == in.get(pos.get(k)[0]).charAt(pos.get(k)[1])) {
                                c++;
                            }
                        }
                        if (c < 4) {
                            count++;
                            int[] temp = {i, j};
                            fix.add(temp);
                        }
                    }
                }
            }
            for (int[] xy:fix) {//update
                in.set(xy[0], in.get(xy[0]).substring(0, xy[1])+'x'+in.get(xy[0]).substring(xy[1]+1,y));
            }
            preans=ans;
            ans+=count;
            
        }
        System.out.println(ans);
    }

    public static ArrayList<int[]> positions(int i, int j) {
        ArrayList<int[]> pos = new ArrayList<>();
        if (i > 0) {
            int[] temp = {i - 1, j};
            pos.add(temp);
            if (j > 0) {
                int[] tempy = {i - 1, j - 1};
                pos.add(tempy);
            }
            if (j < y - 1) {
                int[] tempo = {i - 1, j + 1};
                pos.add(tempo);
            }
        }
        if (j > 0) {
            int[] tempy = {i, j - 1};
            pos.add(tempy);
        }
        if (j < y - 1) {
            int[] tempy = {i, j + 1};
            pos.add(tempy);
        }
        if (i < x - 1) {
            int[] tempy = {i + 1, j};
            pos.add(tempy);
            if (j > 0) {
                int[] temp = {i + 1, j - 1};
                pos.add(temp);
            }
            if (j < y - 1) {
                int[] tempo = {i + 1, j + 1};
                pos.add(tempo);
            }
        }

        return pos;
    }

}
