package com.company;

/**
 * This class stores pointers for a specific node's next and previous node.
 * Node's use integers for their value/data.
 */
public class Node {

    public int Data;
    public Node Next;
    public Node Prev;

    Node(int val){
        Data = val;
    }

    public int getValue(){
        return Data;
    }
}
