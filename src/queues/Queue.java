package queues;

public interface Queue<E> {
    public int size();    
    public boolean isFull();    
    public void enQ(E v);   //pre: not full    
    public E deQ();         //pre: not empty
}

