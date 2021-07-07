package com.perschols.concurrency.sagari;

public class Example2Synchronized {
	
	int sum = 0;
	Integer lock =0;
	
	//SynchronizedThreadExample() {
	//	sum = 0;
        //        lock = new Integer( 0 );
	//}
	
	class PiThreadGood extends Thread {
		private int N;			// the total number of samples/iterations 

		public PiThreadGood( int Id, int N ) {
			super( "Thread-"+Id ); // give a name to the thread
			this.N 		= N;
		}
			
		@Override
		public void run() {
			for ( int i=0; i<N; i++ )
				synchronized( lock ) {
					sum++;
				}
		}
	}
	
	
	public void process( int N ) {
		long startTime = System.currentTimeMillis();

		PiThreadGood t1 = new PiThreadGood( 0, N );
		PiThreadGood t2 = new PiThreadGood( 1, N );
		
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
		Example2Synchronized U = new Example2Synchronized();
		U.process( N );

	}

}
