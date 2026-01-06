/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day08;

/**
 *
 * @author Simon
 */
public class Link implements Comparable<Link>{
    long dist;
    int p1, p2; //Could be changed to actual points

    public Link(long dist, int p1, int p2) {
        this.dist = dist;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public int compareTo(Link o) {
        return Double.compare(this.dist, o.dist);
    }

    @Override
    public String toString() {
        return "Link{" + "dist=" + dist + ", p1=" + p1 + ", p2=" + p2 + '}';
    }
    
}
