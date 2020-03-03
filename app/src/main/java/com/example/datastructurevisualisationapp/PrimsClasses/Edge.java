package com.example.datastructurevisualisationapp.PrimsClasses;

/**Class which represents an edge.**/
public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;
    private double weight;

    /**Method which initialises the Edge with a start and end vertices and a weight.**/
    public Edge(Vertex vertex1, Vertex vertex2, double weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    /**Method which returns the starting vertex.**/
    public Vertex getVertex1() {
        return vertex1;
    }

    /**Method which returns the ending vertex.**/
    public Vertex getVertex2() {
        return vertex2;
    }

    /**Method which returns the weight of the edge.**/
    public double getWeight() {
        return weight;
    }

    /**Method which returns the mid x coordinate of the start and end vertices.**/
    public float getMidX(){
        return (getVertex1().getX() + getVertex2().getX())/2;
    }

    /**Method which returns the mid y coordinate of the start and end vertices.**/
    public float getMidY(){
        return (getVertex1().getY() + getVertex2().getY())/2;
    }
}
