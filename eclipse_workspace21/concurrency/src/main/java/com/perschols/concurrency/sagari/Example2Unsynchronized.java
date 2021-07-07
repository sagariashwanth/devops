package com.perschols.concurrency.sagari;

public class Example2Unsynchronized {

	

		 static int sum = 0;
	        
	        class PiThreadBad extends Thread {
	                private int N;                  // the total number of samples/iterations 

	                public PiThreadBad( int Id, int N ) {
	                        super( "Thread-"+Id ); // give a name to the thread
	                        this.N          = N;
	                }
	                        
	                @Override
	                public void run() {
	                        for ( int i=0; i<N; i++ )
	                                sum ++;
	                }
	        }

	        public void process( int N ) {
	            long startTime = System.currentTimeMillis();
	            PiThreadBad t1 = new PiThreadBad( 0, N );
	            PiThreadBad t2 = new PiThreadBad( 1, N );
	                
	            //--- start two threads ---
	            t1.start();
	            t2.start();
	                
	            //--- wait till they finish ---
	            try {
	                t1.join();
	                t2.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	                
	            System.out.println( "sum = " + sum );
	            System.out.println( "Execution time: " + (System.currentTimeMillis()-startTime) + " ms" );


	}
	        
	        public static void main(String[] args) {
	        	
	        	int N = 1000000;
	        	Example2Unsynchronized U = new Example2Unsynchronized();
	            U.process( N );

}
}
