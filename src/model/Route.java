/*
 * Route.java
 * Version 0.2.1    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/5/18
 * Last Modified    : 11/02/18 23:00
 */

package model;

import java.util.ArrayList;
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
    int id, n;
    String city;
    private final ArrayList<Route> children;

    public Route(int id, int n) {
        this.id = id;
        this.n = n;
        this.city = Route.routes[id];
        this.children = new ArrayList<>(n);
    }

    // If there is enough space, add the given Route to the list of children
    private Boolean addChild(Route node) {
        return (children.size() < n) && (children.add(node));
    }

    // Get the list of children nodes of this Route
    public ArrayList<Route> getChildren() {
        return new ArrayList<>(children);
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
    public void setchildren(int ids[]) {
        ArrayList<Route> nodes = new ArrayList<>();
        // Iterate the list of ids
        for(int id : ids) {
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
        // Don't use this function to search for this Route...but just in case
        if(this.id == id) return this;
        else {
            // Start the search at this Route
            Route r = this;
            Stack<Route> stack = new Stack<>();
            stack.push(r);

            // While there are child nodes to check
            while(!stack.empty())
            {
                // get the next node
                r = stack.peek();
                stack.pop();
                // return this Route if it is the node being searched for
                if(r.id == id) return r;
                // otherwise add all the children and keep searching
                for(Route node : r.getChildren()) stack.push(node);
            }
        }
        // If node isn't in the tree, just make a new one
        return new Route(id, n);
    }

    // DFS print function
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
