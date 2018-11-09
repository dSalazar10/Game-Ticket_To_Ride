/*
 * Route.java
 * Version 0.2.1    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/5/18
 * Last Modified    : 11/02/18 23:00
 */

package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Route {

    // The Encoding Scheme, 1 - 36
    // Starts at Vancouver and end at Miami
    public static String routes[] = new String[] {"root", "Vancouver", "Calgary", "Seattle", "Winnipeg", "Helena", "Portland",
            "Sault Ste. Marie", "Duluth", "Omaha", "San Francisco", "Salt Lake City", "Montreal", "Toronto", "Chicago",
            "Kansas City", "Oklahoma City", "Santa Fe", "Los Angeles", "Denver", "New York", "Pittsburgh", "Saint Louis",
            "Little Rock", "Dallas", "El Paso", "Las Vegas", "Boston", "Phoenix", "Washington", "Raleigh", "Nashville",
            "New Orleans", "Houston", "Charleston", "Atlanta", "Miami"};

    /*
    * id is the element's position in the String array above
    * n is the max number of children in a Route node
    * city is the node's label
    * children is a list of the connecting Route nodes
    * */
    private int id, n;
    private final ArrayList<ArrayList<RouteCost>> costs;
    private final ArrayList<Route> children;
    public static Route root;

    public Route(int id, int n) {
        this.id = id;
        this.n = n;
        this.costs = new ArrayList<>(n);
        this.children = new ArrayList<>(n);
    }

    public int getId() {
        return this.id;
    }

    private Boolean addChild(Route node) {
        return (children.size() < n) && (children.add(node));
    }

    public ArrayList<RouteCost> getCost(int index) {
        return costs.get(index);
    }

    // Get the list of children nodes of this Route
    public ArrayList<Route> getChildren() {
        return new ArrayList<>(children);
    }

    public void setCost(int[][] routes) {
        ArrayList<ArrayList<RouteCost>> routesArray = new ArrayList<ArrayList<RouteCost>>();
        for(int[] route : routes) {
            ArrayList<RouteCost> routeArray = new ArrayList<>();
            for(int r : route) {
                // TODO: Add color to the RouteCost argument
                routeArray.add(new RouteCost(TrainColor.RAINBOW, r));
            }
            routesArray.add(routeArray);
        }
        this.costs.addAll(routesArray);
    }

    // Add all the given child nodes to this node
    private void setChildren(ArrayList<Route> nodes) {
        // If there is enough space for all the nodes, then iterate them,
        if(nodes.size() < n) for (Route node : nodes) {
            // adding each node
            addChild(node);
        }
    }

    // Given a list of ids, add some child nodes to this Route
    public void setChildren(int ids[]) {
        ArrayList<Route> nodes = new ArrayList<>();
        // Iterate the list of ids
        for(int id : ids) {
            // TODO: Debug
            // Search for a node based on the id
            // if found, then add that node to the list of nodes
            // If not found, then add a new node to the list of nodes
            nodes.add(getNode(id));
        }
        // Add all the child nodes to this Route
        setChildren(nodes);
    }

    // Depth First Search for a node based on the give id
    // If node not found, make a new one
    public Route getNode(int id) {
        Route node = getNode(id, Route.root, 0);
        if(node == null)
            return new Route(id, n);
        else
            return node;
    }
    private Route getNode(int id, Route node, int depth) {

        for (Route child : node.getChildren()) {
            Route n = getNode(id, child, depth + 1);
            if(n.getId() == id)
                return node;
        }
        return null;
    }

    // DFS print function
    public static void print(Route root) {
        printUtil(root, 1);
    }



    private static void printUtil(Route node, int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        // System.out.println(Route.routes[node.id] + node.getCost(0));
        System.out.println(Route.routes[node.id] + node);

        for (Route child : node.getChildren()) {
            printUtil(child, depth + 1);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                //", n=" + n +
                //", costs=" + costs +
                ", children=" + children.size() +
                '}';
    }
}
