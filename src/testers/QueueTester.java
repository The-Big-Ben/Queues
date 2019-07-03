
package testers;

import queues.LeftQueue;
import queues.*;
public class QueueTester {
	public static void main(String[] args) {
		int n=1000000;                  //choose a size n, choose a queue class
		//Queue q = new LeftQueue<Double>();
		Queue q = new WrapQueue();
		//Queue q = new LinkedQueue();
		for(int i=0;i<5;i++) q.enQ(i*i);
		for(int i=0;i<4;i++) q.deQ();
		System.out.println("size 1 =?= "+q.size());
		System.out.println("deQ 16 =?= "+q.deQ());
		
                long startTime = System.currentTimeMillis();
                
		for(int i=0;i<n;i++) q.enQ(7*i);
		System.out.println("size "+n+" =?= "+ q.size());
		System.out.println("is full false =?= "+q.isFull());
		
		for(int i=0;i<n/2;i++) q.deQ(); 
		int sz = n-n/2;
		System.out.println("size "+sz+" =?= "+q.size());
		System.out.println("deQ "+ (1.0*7*n/2) + " =?= "+q.deQ());
                
                long endTime = System.currentTimeMillis();
                
                System.out.println("That took " + (endTime-startTime) + " milliseconds");
	}	
}
