package com.perschols.concurrency.sagari;

public class Example1 implements Runnable{


	@Override
	public void run() {

		for (int i = 1; i < 2; i++)
        {
            System.out.println(Thread.currentThread().getName()
                                                   + "  " + "Hello World!");
            try
            {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            }
  
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

		
	}


	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Example1());
		Thread t2 = new Thread(new Example1());
		Thread t3 = new Thread(new Example1());
		Thread t4 = new Thread(new Example1());
		Thread t5 = new Thread(new Example1());

		// call run() function
		t1.start();
		try {
			t1.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}

		
		t2.start();
		
		t3.start();
		t4.start();
		t5.start();
	}



	}

