package com.perschols.concurrency.sagari;

public class Example3 {

	int count;
	  public void incr()
	  {count++;
	  }
	public static void main(String[] args) throws InterruptedException {
		
		Example3 c = new Example3(); // instantiate Counter
	    // Instantiate a thread t1
	    Thread t1 = new Thread(new Runnable(){
	      public void run(){
	        for(int i=0; i<1000000; i++)
	          c.incr();
	      }
	    });
	    
	    Thread t2 = new Thread(new Runnable(){
	        public void run(){
	          System.out.println(c.count);
	        }
	      });
	    t1.start();
	    t2.start();
	    
	    t1.join();
	    t2.join();
//	    System.out.println("Count = " + c.count);
	  }



	}


