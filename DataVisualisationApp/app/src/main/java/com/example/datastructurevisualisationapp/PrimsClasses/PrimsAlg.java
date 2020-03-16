package com.example.datastructurevisualisationapp.PrimsClasses;

import java.util.ArrayList;
import java.lang.Math;

/**Class which represents Prim's Algorithm.**/
public class PrimsAlg {
    private ArrayList<Vertex> unvisitedVertices = new ArrayList<Vertex>();
    private ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    /**Method which adds to array list of unvisited vertices.**/
    public void addUnvisited(Vertex unvisited){
        unvisitedVertices.add(unvisited);
    }


    /**Method which returns the size of the array list of unvisited vertices.**/
    public int getUnvisitedSize(){
        return unvisitedVertices.size();
    }

    /**Method which clears array list of unvisited vertices**/
    public void clearUnvisited(){
        unvisitedVertices.clear();
    }

    /**Method which clears array list of visited vertices.**/
    public void clearVisited(){
        visitedVertices.clear();
    }

    /**Method which returns array list of edges.**/
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**Method which returns array list of unvisited vertices.**/
    public ArrayList<Vertex> getUnvisitedVertices(){
        return unvisitedVertices;
    }

    /**Method which returns array list of visited vertices.**/
    public ArrayList<Vertex> getVisitedVertices(){
        return visitedVertices;
    }

    /**Method which clears array list of edges.**/
    public void clearEdges(){
        edges.clear();
    }


    /**Method which runs Prim's algorithm on array list of unvisited vertices.**/
    public void runPrims() {

        getVisitedVertices().add(getUnvisitedVertices().get(0));
        getUnvisitedVertices().remove(0);

        while (getUnvisitedSize() > 0){
            Double minDistance = null;
            Vertex chosenVisitedVertex = null;
            Vertex chosenUnvisitedVertex = null; //shortest distance vertex

            for (Vertex unvisited : getUnvisitedVertices()){
                for (Vertex visited : getVisitedVertices()){
                    int diffX = visited.getX() - unvisited.getX();
                    int diffY = visited.getY() - unvisited.getY();
                    double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
                    if (chosenVisitedVertex == null || distance < minDistance){
                        chosenVisitedVertex = visited;
                        chosenUnvisitedVertex = unvisited;
                        minDistance = distance;
                    }
                }
            }


            //new edge and add chosen unvisited to visited
            Edge edge = new Edge(chosenVisitedVertex, chosenUnvisitedVertex, minDistance);
            //add edge to list of edges
            getEdges().add(edge);
            getVisitedVertices().add(chosenUnvisitedVertex);

            // Iterate through unvisited vertices to remove chosen unvisited vertex
            for (int i = 0 ; i < getUnvisitedSize(); i++){
                if(getUnvisitedVertices().get(i).getId() == chosenUnvisitedVertex.getId()){
                    getUnvisitedVertices().remove(i);
                    break;
                }
            }
        }
        System.out.println(getEdges().size());
        System.out.println(String.valueOf(getEdges().get(0).getWeight()));
    }

}
