package com.company;

/**
 * This class stores pointers for the head and tail of the linked list. The length is used for searching/insertion/deletion at a specific
 * location.
 *
 * This is a doubly reversed linked list. It's time complexity is O(N) time. It's actually O(N/2) for insertion and deletion
 * since it determines whether to iterate normally from the head or iterate backwards to find the position for insertion/deletion
 * However, the 1/2 constant is ignored
 */

public class LinkedList {

    private static Node mHead;
    private static Node mTail;
    private static int mLength;

    LinkedList(){

        //initialize length
        mLength = 0;
    }

    public void add(int lData){

        Node lNode = new Node(lData);


        //check if list has any nodes
        if (mLength == 0){

            //set new head and tail
            mHead = lNode;
            mTail = mHead;

            //create links
            mHead.Next = mTail;

            mHead.Prev = mTail;
        }

        //link two nodes
        else if (mLength == 1){

            //set tail to new node
            mTail = lNode;

            //change links
            mHead.Next = mTail;
            mTail.Prev = mHead;

            mHead.Prev = mTail;
            mTail.Next = mHead;

        }

        //if LL size > 2
        else {

            //change links
            mTail.Next = lNode;
            lNode.Next = mHead;

            mHead.Prev = lNode;
            lNode.Prev = mTail;

            mTail = lNode;

        }

        mLength++;
    }

    public void insert(int lPos, int lData){
        Node lNode = new Node(lData);

        //add new head in null LL
        if (lPos == 0 && mLength ==0){
            add(lData);
        }

        //insert at head with 1 node LL
        else if (lPos == 0 && mLength ==1){
            lNode.Next = mHead;
            mHead.Next = lNode;

            mHead.Prev = lNode;
            lNode.Prev = mHead;

            mHead = lNode;

            mLength ++;
        }

        //add new tail in 1 node LL
        else if (lPos == 1 && mLength == 1){
            add(lData);
        }

        //lPos > mLength = Out of bounds
        else if (lPos > mLength && lPos < 0){
            System.out.println("Out of bounds");
        }

        //add node to end
        else if (lPos == mLength){
            add(lData);
        }

        else {
            //see how close lHalf is to 1
            float lHalf = (float) lPos / (float) mLength;

            //iterate backwards from tail
            if (lHalf >= 0.5) {

                int i = mLength;

                Node lCurr = mTail;

                while (i != lPos) {
                    lCurr = lCurr.Prev;
                    i--;

                    if (i == lPos) {
                        insertBetween(lCurr, lCurr.Next, lNode);

                    }
                }
                mLength++;


            }

            else if (lHalf < 0.5) {

                int i = 0;

                Node lCurr = mHead;

                if (lPos == 0){
                    insertNewHead(lNode);
                }

                else{
                    while (i != lPos) {
                        i++;

                        if (i == lPos) {
                            insertBetween(lCurr, lCurr.Next, lNode);
                        }

                        lCurr = lCurr.Next;

                    }
                }
                mLength++;



            }
        }

    }

    //Note this method is only to be used if there are > 2 nodes
    private void insertNewHead(Node lNode){

        mTail.Next = lNode;
        lNode.Next = mHead;

        mHead.Prev = lNode;
        lNode.Prev = mTail;

        mHead = lNode;
    }


    //inserts lInsert between lNodeA and lNodeB
    private void insertBetween(Node lNodeA, Node lNodeB, Node lInsert){

        lNodeA.Next = lInsert;
        lInsert.Next = lNodeB;

        lNodeB.Prev = lInsert;
        lInsert.Prev = lNodeA;


    }


    public void print(){

        if (mLength == 0){
            System.out.println("No Nodes");
        }

        else if (mLength == 1){
            System.out.println("[" + mHead.Data + "]");
        }

        else if (mLength == 2){
            System.out.println("[" + mHead.Data + ", " + mTail.Data + "]");
        }

        Node lCurr = mHead;

        String Iter = "";

        Iter += "Iter through Next: [";

        if (mLength > 2){
            while (lCurr != mTail) {
                Iter += Integer.toString(lCurr.Data) + ", ";
                lCurr = lCurr.Next;

                if (lCurr == mTail) {
                    Iter += Integer.toString(lCurr.Data) + "]\n";
                }
            }


            String RIter = "";

            RIter += "Iter through Reverse: [";

            while (lCurr != mHead) {
                RIter += Integer.toString(lCurr.Data) + ", ";
                lCurr = lCurr.Prev;

                if (lCurr == mHead) {
                    RIter += Integer.toString(lCurr.Data) + "]";
                }
            }

            System.out.println(Iter + "\n" + RIter);
        }

    }

    public void remove(int lPos){

        if (lPos > mLength-1){
            System.out.println("Out of bounds");
        }

        else if (mLength == 0){
            System.out.println("There are no nodes to remove");
        }

        else if (mLength == 1){
            mHead = null;
            mLength-=1;
        }

        else if (mLength == 2){

            if (lPos == 0){
                mHead = mTail;
                mTail = null;
                mLength-=1;
            }

            else {
                mTail = null;
                mLength-=1;
            }
        }

        else if (mLength >= 3){
            Node lCurr = mHead;
            int i = 0;

            if (i == lPos){
                removeNode(lCurr.Prev, lCurr.Next, lCurr);
            }

            else{
                while (i != lPos){
                    i++;
                    lCurr = lCurr.Next;

                    if (i == lPos){
                        removeNode(lCurr.Prev, lCurr.Next, lCurr);
                    }


                }
            }

            mLength-=1;

        }
    }

    private void removeNode(Node lNodeA, Node lNodeB, Node lCurr){

        if (lCurr == mHead){
            mHead = mHead.Next;
        }

        else if (lCurr == mTail){
            mTail = mTail.Prev;
        }

        lNodeA.Next = lCurr.Next;
        lNodeB.Prev = lCurr.Prev;

        lCurr = null;

    }
}
