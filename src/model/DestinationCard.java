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

    String routes[] = new String[] {"Vancouver","Calgary","Winnipeg","Seattle","Portland","Helena","Salt Lake City",
            "Denver","San Francisco","Las Vegas","Santa Fe","Los Angeles","Phoenix","El Paso","Oklahoma City",
            "Duluth","Omaha","Kansas City","Dallas","Houston","Chicago","Saint Louis","Little Rock","New Orleans",
            "Nashville","Toronto","Pittsburgh","Atlanta","Miami","Charleston","Washington","Raleigh","New York",
            "Boston","Montreal","Sault Ste. Marie"};
}