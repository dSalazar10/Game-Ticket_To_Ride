/*
 * Path.java
 * Version 0.0.1    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 11/17/18
 * Last Modified    : 11/18/18 11:00 PM
 *
 * This class represents a path between two cities.
 * Path hold a city name and a city distance
 */
package model;

import java.util.Objects;

public class Path {
    private String city;
    private int dist;
    
    Path(String c, int d){
        this.city = c;
        this.dist = d; 
    }
    // get the distance
    public int getDist(){
        return dist;
    }
    // get the city
    public String getCity(){
        return city;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Path)) return false;
        Path p = (Path)obj;
        return this.city == p.city;
    } 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.city);
        hash = 59 * hash + this.dist;
        return hash;
    }
    @Override
    public String toString(){
        return this.city+" "+this.dist+"\n";
    }
    
}
