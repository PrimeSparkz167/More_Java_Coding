/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threepart1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Threepart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String n;
        n=sc.nextLine();
        int sum=0;
        while(!n.equals("e")){
            //System.err.println(n);
            ArrayList<Integer> bank = new ArrayList<>(n.length());
            int[] max=new int[2];
            for (int i = 0; i < n.length()-1; i++) {
                int d =Integer.parseInt(""+n.charAt(i));
                bank.add(d);
                if (d>max[0]) {
                    max[0]=d;
                    max[1]=i;
                }
            }
            int last =Integer.parseInt(""+n.charAt(n.length()-1));
            ArrayList<Integer> bank2 = new ArrayList<>();
            for (int i = max[1]+1; i < n.length()-1; i++) {
                bank2.add(bank.get(i));
            }
            bank2.add(last);
            Collections.sort(bank2);
            sum+= 10*max[0] + bank2.getLast();
            n=sc.next();
        }
        System.out.println("sum="+sum);
    }
    
}
