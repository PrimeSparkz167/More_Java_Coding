/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day08;

/**
 *
 * @author Simon
 */
public class point {
    int x,y,z;

    public point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public point(String in) {
        String[] s = in.split(",");
        x=Integer.parseInt(s[0]);
        y=Integer.parseInt(s[1]);
        z=Integer.parseInt(s[2]);
    }
    
    public long dist(point p){
        long dx = (p.x-this.x);
        long dy = (p.y-this.y);
        long dz = (p.z-this.z);
    return dx*dx+dy*dy+dz*dz;}
}
