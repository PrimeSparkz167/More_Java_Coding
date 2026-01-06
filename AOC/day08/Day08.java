/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Simon
 */
public class Day08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = 1000;
        ArrayList<point> points = new ArrayList<>();
        ArrayList<Link> links = new ArrayList<>();
        ArrayList<TreeSet<Integer>> loops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i%100==0) {
                System.err.println(i);
            }
            point p = new point(sc.nextLine());
            for (int j = 0; j < points.size(); j++) {//should maybe only add if small enough Done
                long d = p.dist(points.get(j));
                if (links.isEmpty()) {
                    links.add(new Link(d, i, j));
                } else if (links.size() <= n || d <= links.getLast().dist) {
                    links.add(new Link(d, i, j));
                    Collections.sort(links);
                    if (links.size()>n) {
                        links.removeLast();
                    }
                }
            }
            points.add(p);
        }
        System.err.println("input done");
        for (int i = 0; i < n; i++) {
            Link l = links.get(i);
            //System.err.println(l.toString());//clear
            int pi1 = -1, pi2 = -1;
            boolean match = false;
            for (int j = 0; j < loops.size() && (pi1 < 0 || pi2 < 0); j++) {
                //System.err.println("finding loopmatch"+j);
                if (loops.get(j).contains(l.p1)) {
                    //System.err.println("j matching p1");
                    pi1 = j;
                    match = true;
                }
                if (loops.get(j).contains(l.p2)) {
                    //System.err.println("j matching p2");
                    pi2 = j;
                    match = true;
                }
            }
            if (match) {
                int pi = Math.max(pi1, pi2),pim=Math.min(pi1, pi2);
                if (pim >= 0&&pim!=pi) {//merge
                    //System.err.println("merge loop "+pim+" and "+ pi);
                    loops.get(pim).addAll(loops.get(pi));
                    loops.remove(pi);
                } else {//single side join
                    loops.get(pi).add(l.p1);
                    loops.get(pi).add(l.p2);
                }
            } else {//new loop
                //System.err.println("new loop");
                loops.add(new TreeSet<>());
                loops.getLast().add(l.p1);
                loops.getLast().add(l.p2);
            }
            for (int j = 0; j < loops.size(); j++) {
                TreeSet<Integer> ab = loops.get(j);
                //System.err.println(ab.toString()); 
                
                }
            
        }
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < loops.size(); i++) {
            sizes.add(loops.get(i).size());
            //System.err.println("s"+loops.get(i).size());
        }
        Collections.sort(sizes);
        Collections.reverse(sizes);
        int ans = sizes.get(0)*sizes.get(1)*sizes.get(2);
        System.out.println(ans);
    }
}
