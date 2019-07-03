
package queues;
import java.util.ArrayList;
import queues.Queue;

public class LeftQueue<T> implements Queue<T>  {

	ArrayList<T> a; //0..size-1 , with 0 the front

	public LeftQueue( ) {
        a = new ArrayList<T>();
    }
    public int size(){ return a.size(); }
    
    public boolean isFull(){ return false; }
    
    public void enQ(T v){ a.add(v); }  //pre: not full
    
    public T deQ(){ //pre: not empty
        T ans = a.get(0);
		a.remove(0);
        return ans;
    }	
}
