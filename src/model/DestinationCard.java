/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */
package model;

public class DestinationCard{
    private String routeA;
    private String routeB;
    private int pts;
    public DestinationCard(String routeA, String routeB, int pts){
        this.routeA = routeA;
        this.routeB = routeB;
        this.pts = pts;
    }
    public String getRouteB() { return this.routeA; }
    public String getRouteA() { return this.routeB; }
    public int getPts() { return this.pts; }

    @Override
    public String toString(){
        return this.routeA + "\nTO\n" + this.routeB + "\nPts: " + this.pts;
    }


}