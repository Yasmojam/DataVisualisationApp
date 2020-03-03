package com.example.datastructurevisualisationapp.PrimsClasses;
/**Class which represents a vertex.**/
public class Vertex {
    private Integer id;
    private Integer x;
    private Integer y;

    /**Method which initialises Vertex with an id, x coordinate, and y coordinate.**/
    public Vertex(Integer id, Integer x, Integer y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**Method which returns the ID of the vertex.**/
    public Integer getId() {
        return id;
    }

    /**Method which returns the x coordinate of the vertex.**/
    public Integer getX() {
        return x;
    }

    /**Method which returns the y coordinate of the vertex.**/
    public Integer getY() {
        return y;
    }
}
