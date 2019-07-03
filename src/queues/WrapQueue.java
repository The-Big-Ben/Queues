
package queues;

import static java.lang.Integer.MAX_VALUE;

public class WrapQueue<T> implements Queue<T> {
	//Queue utilizes the "wrap-around" method?(not sure of name) The indexes of the first and the last element
    //are adjsuted and the all operations are order 1 

    /**
     * @param args the command line arguments
     */
    private int size =0;//current size of the queue
    private final int MAX = 10000000;
    private int leftIdx;//the index of the leftmost item of the queue
    private int rightIdx;//the index of rightmost item of the queue
    private T[] q;// array to hold our integers
    private boolean empty; // Is our queue empty or not?
    
    
    public WrapQueue(){
        q = (T[]) new Object[MAX];
        leftIdx = 0;
        rightIdx = 0;
        //size = 0;
        empty = true;
    }
    
    
    public void enQ(T item){//adds an item to the right of the queue
        if (size < MAX) {
          if (empty) {
           q[0] = item;
           leftIdx=0;
           rightIdx=0;
           empty = false;
           size +=1;
        }
          else if (size < MAX && rightIdx < MAX-2) {
                q[rightIdx+1] = item;
                rightIdx+=1;
                size+=1;
                empty = false;
            }
          else if (size < MAX && rightIdx > MAX-2) {
                rightIdx = (rightIdx+1) - MAX;
                q[rightIdx] = item;
                size+=1;
                empty=false;
            }
        }
    }
    
    public T deQ(){//removes the item at rightmost part of the queue and returns it
        //If queue is empty, returns System max int
        if (empty) {
            System.out.println("Queue is empty");
            return null;
        }
        else    {
            T b = q[leftIdx];
            if (leftIdx > MAX-2) {
                leftIdx = (leftIdx+1) - MAX;
                size-=1;
                if (size==0) {
                    empty=true;
                }
            }
            else  {
                leftIdx +=1;
                size-=1;
                if (size==0) {
                    empty=true;
                }
            }
            return b;
        }
    }
    
    
    public int size(){//returns the current size of the queue
        return size;
    }
    
    public boolean isFull(){
    
        if (size==MAX) {
            return true;
        }
        return false;
    }
    
    public void print(){//prints out the elements in this queue from left to right
        int iteratorNum= size+leftIdx;
        for (int i = leftIdx; i < iteratorNum; i++) {
            if (i == MAX) {
                iteratorNum = iteratorNum-MAX;
                i=0; 
            }
            System.out.println("item at index "+ i + ": " +q[i]);
        }
    }
}
