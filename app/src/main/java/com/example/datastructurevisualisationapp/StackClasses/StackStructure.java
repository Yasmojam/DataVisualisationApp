package com.example.datastructurevisualisationapp.StackClasses;

import java.util.ArrayList;

/**Class which represents a stack.**/
public class StackStructure {
    private ArrayList<StackElement> stackElements = new ArrayList<StackElement>();

    /**Method which returns stackElements array list.**/
    public ArrayList<StackElement> getStackElements() {
        return stackElements;
    }

    /**Method which pushes an element to the stack.**/
    public void pushElement(StackElement stackElement){
        if (stackElements.size() <= 12){
            stackElements.add(stackElement);
        }
        else{
            return;
        }
    }

    /**Method which returns the size of the stack array list.**/
    public int getStackSize(){
        return stackElements.size();
    }

    /**Method which returns the index of the last element added to the stack array list.**/
    public int getlastStackElementIndex(){
        return stackElements.size()-1;
    }

    /**Method which pops the last element of the stack.**/
    public void popElement(){
        if (stackElements.size() > 0){
            stackElements.remove(getlastStackElementIndex());
        }
        else{
            return;
        }
    }

    /**Method which returns true if the stack is full i.e. has 12 elements.**/
    public boolean stackFull(){
        if (stackElements.size() >= 12){
            return true;
        }
        else{
            return false;
        }
    }

    /**Method which clears the stack. **/
    public void clearStack(){
        stackElements.clear();
    }
}
