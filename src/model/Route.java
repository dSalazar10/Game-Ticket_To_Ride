/*
 * Route.java
 * Version 0.2.0    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/5/18
 * Last Modified    : 11/02/18 08:42
 */


import java.util.ArrayList;

public class Route {
    int id, n;
    String city;
    private final ArrayList<Route> children;
    // ArrayList<int> costs;

    // int trainPieces, points;
    // private DestinationTicketSet destinationCard;

    public Route(int id, int n, String city) {
        this.id = id;
        this.n = n;
        this.city = city;
        this.children = new ArrayList<>(n);

        /*
        switch (this.trainPieces = trains) {
            case 1: points = 1; break;
            case 2: points = 2; break;
            case 3: points = 4; break;
            case 4: points = 7; break;
            case 5: points = 10; break;
            case 6: points = 15; break;
        }
        this.destinationCard = destinationCard;
        */
    }

    private boolean addChild(Route node) {
        if (children.size() < n) {
            return children.add(node);
        }

        return false;
    }

    public boolean addChild(int id, String city) {
        return addChild(new Route(id, n, city));
    }

    public ArrayList<Route> getChildren() {
        return new ArrayList<>(children);
    }

    public Route getChild(int index) {
        if (index < children.size()) {
            return children.get(index);
        }

        return null;
    }

    public static void print(Route root) {
        printUtil(root, 0);
    }

    private static void printUtil(Route node, int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        System.out.println(node.city);

        for (Route child : node.getChildren()) {
            printUtil(child, depth + 1);
        }
    }
}
