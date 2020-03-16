package com.example.datastructurevisualisationapp.QueueClasses;

import java.util.ArrayList;

/**Class which represents a queue.**/
public class QueueStructure {
    private ArrayList<QueueElement> QueueElements = new ArrayList<QueueElement>();

    /**Method which returns QueueElements array list.**/
    public ArrayList<QueueElement> getQueueElements() {
        return QueueElements;
    }

    /**Method which enqueuees an element to the queue.**/
    public void enqueueElement(QueueElement QueueElement){
        if (QueueElements.size() <= 12){
            QueueElements.add(QueueElement);
        }
        else{
            return;
        }
    }

    /**Method which returns the size of the queue array list.**/
    public int getQueueSize(){
        return QueueElements.size();
    }

    /**Method which returns the index of the last element added to the queue array list.**/
    public int getLastQueueElementIndex(){
        return QueueElements.size()-1;
    }


    /**Method which dequeues the last element of the queue.**/
    public void dequeueElement(){
        if (QueueElements.size() > 0){
            QueueElements.remove(0);
        }
        else{
            return;
        }
    }

    /**Method which returns true if the queue is full i.e. has 12 elements.**/
    public boolean queueFull(){
        if (QueueElements.size() >= 12){
            return true;
        }
        else{
            return false;
        }
    }

    /**Method which clears the queue. **/
    public void clearqueue(){
        QueueElements.clear();
    }
}

