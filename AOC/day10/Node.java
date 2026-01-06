/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day10;

/**
 *
 * @author Simon
 */
public class Node implements Comparable<Node>{
    int state;
    int goalD, cost;

    public Node(int state, int p) {
        this.state = state;
        cost=p;
        goalD=Integer.bitCount(state);
    }

    @Override
    public int compareTo(Node o) {
        return (this.cost==o.cost) ?(Integer.compare(this.goalD, o.goalD)):(Integer.compare(this.cost, o.cost));
        }

    @Override
    public String toString() {
        return "Node{" + "State " + state + " State is also= "+Integer.toBinaryString(state)+" , goalD=" + goalD + ", cost=" + cost + '}';
        
    }
    
    }


    
    

