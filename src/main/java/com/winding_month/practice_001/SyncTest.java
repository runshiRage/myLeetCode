package com.winding_month.practice_001;

public class SyncTest {

	volatile int vol = 0;
	
	Thread t1 = new Thread(new Runnable() {
		
		public void run() {
			synchronized (this) {
				vol++;
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int i = 1/0;
			}
			
		}
	});

	Thread t2 = new Thread(new Runnable() {
		
		public void run() {
			System.out.println("vol: " +vol);
		}
	});
	
	public static void main(String[] args) {
		
		SyncTest st = new SyncTest();
		st.t1.start();
		st.t2.start();
	}
	
	
}
