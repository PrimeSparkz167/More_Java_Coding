/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author Simon
 */
public class Graph {
    public int[] two = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096};
    PriorityQueue<Node> pq;
    HashSet<Integer> vis;//we will maybe fix this
    Node root;

    public Graph() {
        pq = new PriorityQueue<>();
        vis = new HashSet<>();
    }

    public int makeFind(String[] s) {
        root = new Node(parseBString(s[0]), 0);
        pq.add(root);
        ArrayList<int[]> buttons = buttons(s);
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            //System.err.println(curr.toString());
            if (!vis.contains(curr.state)) {
                vis.add(curr.state);
                for (int[] i : buttons) {
                    int nstate = curr.state;
                    for (int j:i) {
                        nstate = nstate ^ two[j];
                    }
                    if (nstate==0) {
                        //System.err.println("Path found at cost: "+(curr.cost+1));
                        return curr.cost + 1;
                    }
                    pq.add(new Node(nstate, curr.cost + 1));
                }
            } else {
            }

        }
        return 0;
    }

    public int parseBString(String s) {//not so cursed but could maybe should be an int be an int
        int b=0;
        int len = s.length() - 2;
        for (int i = len; i > 0; i--) {
            b += (s.charAt(i) == "#".charAt(0))?two[i-1]:0;
        }
        return b;

    }

    public ArrayList<int[]> buttons(String[] s) { //could be represented by singular intlistNope!
        ArrayList<int[]> but = new ArrayList<>();
        for (int i = 1; i < s.length - 1; i++) {//exclude bstate and joltage
            String[] nums = s[i].substring(1, s[i].length() - 1).split(",");
            int[] nu = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                nu[j] = Integer.parseInt(nums[j]);
            }
            but.add(nu);
        }
        return but;
    }

}
