package parallel_programming_synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午9:38:19
 * @version 1.0
*/
public class Work {

	/**
	 * @param args
	 */
	public static final int THREADS=Runtime.getRuntime().availableProcessors();
	public static void main(String[] args) {
		//---------Data1 && Thread1
//		Data1 data=new Data1();
//		Thread1 th1=new Thread1(data);
//		Thread1 th2=new Thread1(data);
//		th1.start();
//		th2.start();
//		while( true ){
//			data.isEqual();
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		/*
		 * 同步锁之同步方法，对一个类的两个属性同时进行+1操作，并比较大小。
		 */
		//---------Data2 && Thread2
//		Data2 data=new Data2();
//		Thread2 th1=new Thread2(data);
//		Thread2 th2=new Thread2(data);
//		th1.start();
//		th2.start();
//		while( true ){
//			data.isEqual();
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		/*
		 * 同步锁之同步块，对一个类的两个属性同时进行+1操作，并比较大小。
		 */
		//-------------WriteThread && ReadThread && ReenTest
//		//计时开始
//		long startTime=System.currentTimeMillis();
//		int numThreads=50;
//		List<Integer> myList=new ArrayList<Integer>();
//		ReenTest test=new ReenTest(myList);
//		Thread[] rth=new ReadThread[numThreads/2];
//		Thread[] wth=new WriteThread[numThreads/2];
//
//		for( int i=0;i<numThreads/2;i++ ){
//			wth[i]=new WriteThread(test,i);
//			wth[i].start();
//		}
//		System.out.println("写线程启动");
//		for( int i=0;i<numThreads/2;i++ ){
//			rth[i]=new ReadThread(test);
//			rth[i].start();
//		}
//		System.out.println("读线程启动");
//
//		try {
//			for( int i=0;i<numThreads/2;i++ )
//				rth[i].join();
//			for( int i=0;i<numThreads/2;i++ )
//				wth[i].join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//计时结束
//		long endTime=System.currentTimeMillis();
//		System.out.println("程序花费时间为"+(endTime-startTime)+"ms");
		/*
		 * 可重入锁，实现线程安全的ArrayList的读写
		 */
		//---------ReadThread2 && WriteThread2 && ReWrTest
//		//计时开始
//		long startTime=System.currentTimeMillis();
//		int numThreads=50;
//		List<Integer> myList=new ArrayList<Integer>();
//		ReenTest test=new ReenTest(myList);
//		Thread[] rth=new ReadThread[numThreads/2];
//		Thread[] wth=new WriteThread[numThreads/2];
//
//		for( int i=0;i<numThreads/2;i++ ){
//			wth[i]=new WriteThread(test,i);
//			wth[i].start();
//		}
//		System.out.println("写线程启动");
//		for( int i=0;i<numThreads/2;i++ ){
//			rth[i]=new ReadThread(test);
//			rth[i].start();
//		}
//		System.out.println("读线程启动");
//
//		try {
//			for( int i=0;i<numThreads/2;i++ )
//				rth[i].join();
//			for( int i=0;i<numThreads/2;i++ )
//				wth[i].join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//计时结束
//		long endTime=System.currentTimeMillis();
//		System.out.println("程序花费时间为"+(endTime-startTime)+"ms");
		/*
		 * 读写锁，实现线程安全的ArrayList的读写
		 */
		//----------- Counter && Thread3
		Counter counter=new Counter();
		Thread th1=new Thread3(counter);
		Thread th2=new Thread3(counter);
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Counter.get()="+counter.get());
		/*
		 * 原子类。对一个变量进行原子更新。
		 */
	}

}
 