package queues;

public class LinkedQueue<T> implements Queue<T> {
    class Node{
        T v;
        Node next;
        Node prev;
    }
    private int size=0;
    private Node front;
    private Node rear;
    
    public int size(){
        return size;
    }    
    public boolean isFull(){
        return false;
    }    
    public void enQ(T v){//pre: not full  
        if (size == 0) {
            front = new Node();
            front.v = v;
            front.prev=null;
            front.next=null;
            rear = front;
            size+=1; 
        }
        else{
            Node NewN = new Node();
            NewN.v = v;
            NewN.next = null;
            NewN.prev = rear;
            rear.next = NewN;
            rear = NewN;
            size+=1;
        }
    }     
    public T deQ(){
        T b = front.v;
        front=front.next;
        size-=1;
        return b;
    } 

}
