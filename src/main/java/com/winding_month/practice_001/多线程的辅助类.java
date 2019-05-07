package com.winding_month.practice_001;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class 多线程的辅助类 {

    public final static int MAX_THREAD = 30;

    public static Semaphore s = new Semaphore(5);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD);

    /**
     * Semaphare
     */
    public static void SemaphareTest() {

        for(int i=0; i<MAX_THREAD; i++) {
            threadPool.execute(new Runnable() {
                public void run() {

                    try {
                        s.acquire();   //获取许可
                        System.out.println("获取许可，执行操作...");
                        Integer d = (int)(Math.random() * 10);

                        Thread.sleep(d.longValue() * 1000);
                        s.release();   //释放许可
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                }
            });
        }
    }
    
    
    public static void blockingQueueTest() {
    	
    	
    	Thread thread = new Thread(new Runnable() {
			
			public void run() {
				for(int i=0; i<99; i++) {
					try {
						QueueCenter.queue.offer("eric" + i, 50000, TimeUnit.MILLISECONDS);
						System.out.println("生成了eric " + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
    	thread.start();
    	
    	Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				for(int i=0; i<99; i++) {
					try {
						Thread.sleep(1000);
						QueueCenter.queue.poll(50000, TimeUnit.MILLISECONDS);
						QueueCenter.queue.peek();
						QueueCenter.queue.element();
						System.out.println("消费了eric " + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
    	thread1.start();
    	
    }


    public static void executorServiceTest() {
    	
    	/** execute(Runnable) */
//    	ExecutorService executorService = Executors.newFixedThreadPool(10);
//    	executorService.execute(new Runnable() {
//    	    public void run() {
//    	        System.out.println("Asynchronous task");
//    	    }
//    	});
//    	executorService.shutdown();
    
    	/** submit(Runnable) */
//    	ExecutorService executorService = Executors.newSingleThreadExecutor();
//    	Future future = executorService.submit(new Runnable() {
//    	    public void run() {
//    	        System.out.println("Asynchronous task");
//    	    }
//    	});
//    	try {
//			System.out.println(future.get());   //return null 表示任务成功执行
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
    	
    	/** submit(Callable) */
    	ExecutorService executorService = Executors.newSingleThreadExecutor();
    	Future<Object> future = executorService.submit(new Callable<Object>() {

			public Object call() throws Exception {
				 System.out.println("Asynchronous Callable");
	    	     return "Callable Result";
			}
    		
    	});
    	try {
			System.out.println("future.get() = " + future.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

    }
    
    
    public static void main(String[] args) {
//        SemaphareTest();
//        blockingQueueTest();
    	executorServiceTest();
    }

}


class QueueCenter {
	
	public static BlockingQueue<String> queue = new ArrayBlockingQueue(10);
	
}