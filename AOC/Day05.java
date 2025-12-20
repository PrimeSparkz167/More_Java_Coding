/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Day05 {

    public static ArrayList<Long> ranges;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ranges = new ArrayList<>();
        String in = sc.nextLine();
        long[] rin = rti(in);
        ranges.add(rin[0]);
        ranges.add(rin[1]);
        in = sc.nextLine();
        while (!in.equals("")) {
            rin = rti(in);
            int spot1 = binarySearch(rin[0], 0);
            int spot2 = binarySearch(rin[1], 0);
            if (spot1 % 2 == 0 || spot1 != spot2 || spot2 % 2 == 0) {
                for (int i = spot1; i < spot2; i++) {
                    ranges.remove(spot1);
                }
                if (spot1 % 2 == 0) {
                    ranges.add(rin[0]);
                }
                if (spot2% 2 == 0) {
                    ranges.add(rin[1]);
                }
                Collections.sort(ranges);
            }
            in = sc.nextLine();
        }
        int count = 0;
        int rc  =0 ;     
                in = sc.nextLine();
        long num;
        while (!in.equalsIgnoreCase("e")) {
            rc++;
            num = Long.parseLong(in);
            int spot = binarySearch(num, 1);
            if (spot % 2 == 1) {
                count++;
            }
            in = sc.nextLine();
        }
        System.out.println("r"+(rc-count));
        System.out.println(count);
    }

    public static long[] rti(String s) {
        String[] a = s.split("-");
        long[] b = {Long.parseLong(a[0]), Long.parseLong(a[1])};
        return b;
    }

    public static int binarySearch(long x, int cas) {
        //should reeturn betwwen 0 and size inclusive in case 0
        int left = 0, right = ranges.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if x is present at mid 
            if (ranges.get(mid) == x) {
                return (cas == 0) ? mid + (1 - mid % 2) : 1;
            }
            // If x greater, ignore left half 
            if (ranges.get(mid) < x) {
                left = mid + 1;
            } // If x is smaller, ignore right half 
            else {
                right = mid - 1;
            }
        }

        // if we reach here, then element was 
        // not present 
        return left;
    }

}
