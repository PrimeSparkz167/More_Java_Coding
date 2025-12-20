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
public class Day06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<long[]> prob = new ArrayList<>();
        String[] in = sc.nextLine().split(" ");
        ArrayList<String> ins = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            if (!in[i].equals("")) {
                ins.add(in[i]);
            }
        }
        for (int i = 0; i < ins.size(); i++) {
            //System.out.println(in[i]);
            prob.add(new long[4]);
            prob.getLast()[0] = Integer.parseInt(ins.get(i));
        }
        ins = new ArrayList<>();
        for (int k = 1; k < 4; k++) {
            in = sc.nextLine().split(" ");
            for (int i = 0; i < in.length; i++) {
                if (!in[i].equals("")) {
                    ins.add(in[i]);
                }
            }
            for (int j = 0; j < ins.size(); j++) {
                prob.get(j)[k] = Integer.parseInt(ins.get(j));
            }
            ins = new ArrayList<>();
        }
        in = sc.nextLine().split(" ");
        BigInteger sum = BigInteger.ZERO;
        //long sum=0;
        int j=0;
        for (int i = 0; i < in.length; i++) {
            if (in[i].contains("+")) {
                sum=sum.add(BigInteger.valueOf(prob.get(j)[0]));
                sum=sum.add(BigInteger.valueOf(prob.get(j)[1]));
                sum=sum.add(BigInteger.valueOf(prob.get(j)[2]));
                sum=sum.add(BigInteger.valueOf(prob.get(j)[3]));
                //sum = prob.get(j)[0] + prob.get(j)[1] + prob.get(j)[2]+prob.get(j)[3] ;
                j++;
            } else if(in[i].contains("*")) {
                sum=sum.add(BigInteger.valueOf(prob.get(j)[0] * prob.get(j)[1] * prob.get(j)[2] * prob.get(j)[3]));
            j++;
            }
            
            System.out.println(""+sum.toString());
        }
        
        
        System.out.println("su" + sum.toString());
    }

}
