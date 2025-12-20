/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Day06_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<long[]> prob = new ArrayList<>();
        String[] in = new String[4];
        in[0] = sc.nextLine();
        in[1] = sc.nextLine();
        in[2] = sc.nextLine();
        in[3] = sc.nextLine();
        int k = 0, ind = 0;
        prob.add(new long[4]);
        //line length = 3724
        for (int i = 0; i < 3724; i++) {
            char[] cs = new char[4];
            cs[0] = in[0].charAt(i);
            cs[1] = in[1].charAt(i);
            cs[2] = in[2].charAt(i);
            cs[3] = in[3].charAt(i);
            String word = ""+cs[0]+cs[1]+cs[2]+cs[3];
            String strip =word.replace(" ", "");
            if (strip.equals("")) {
                k++;
                ind=0;
                prob.add(new long[4]);
            }else{
                prob.get(k)[ind] = Integer.parseInt(strip);
                ind++;
            }
        }
        int j = 0;
        BigInteger sum = BigInteger.ZERO;
        String[] signs = sc.nextLine().split(" ");
        for (int i = 0; i < signs.length; i++) {
            if (signs[i].contains("+")) {
                sum = sum.add(BigInteger.valueOf(prob.get(j)[0]));
                sum = sum.add(BigInteger.valueOf(prob.get(j)[1]));
                sum = sum.add(BigInteger.valueOf(prob.get(j)[2]));
                sum = sum.add(BigInteger.valueOf(prob.get(j)[3]));
                //sum = prob.get(j)[0] + prob.get(j)[1] + prob.get(j)[2]+prob.get(j)[3] ;
                j++;
            } else if (signs[i].contains("*")) {
                if (prob.get(j)[3]!=0) {
                sum = sum.add(BigInteger.valueOf(prob.get(j)[0] * prob.get(j)[1] * prob.get(j)[2] * prob.get(j)[3]));
                j++;
                }else if(prob.get(j)[2]!=0){
                    sum = sum.add(BigInteger.valueOf(prob.get(j)[0] * prob.get(j)[1] * prob.get(j)[2]));
                j++;
                }
                else if(prob.get(j)[1]!=0){
                    sum = sum.add(BigInteger.valueOf(prob.get(j)[0] * prob.get(j)[1]));
                j++;
                }
                else {
                    sum = sum.add(BigInteger.valueOf(prob.get(j)[0]));
                j++;
                }
            }
            //System.out.println(""+sum.toString());
        }
        System.out.println("su" + sum.toString());
    }

    public static int ctoi(char c) {
        String s = " ";
        return ((s.equals("" + c)) ? 0 : (Integer.parseInt("" + c)));
    }

}
