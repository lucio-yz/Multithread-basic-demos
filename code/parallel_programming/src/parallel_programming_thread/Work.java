package parallel_programming_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 上午10:18:33
 * @version 1.0
*/
public class Work {

	/**
	 * @param args
	 */
	static int sum;
	static final int N=10000000;
	public static final int THREADS=Runtime.getRuntime().availableProcessors();
	public static void main(String[] args) {
		//---------Thread1
//		Thread th1=new Thread1("线程1", Thread.MIN_PRIORITY);
//		Thread th2=new Thread1("线程2", Thread.MIN_PRIORITY);
//		Thread th3=new Thread1("线程3", Thread.MAX_PRIORITY);
//		Thread th4=new Thread1("线程4", Thread.MAX_PRIORITY);
//		th1.start();
//		th2.start();
//		th3.start();
//		th4.start();
		/*
		 * 线程优先级，及jvm的线程调度策略:基于优先级的时间片轮转。
		 */
		//---------Thread2
//		Thread th1=new Thread2("工人");
//		Thread th2=new Thread2("农民");
//		th1.start();
//		th2.start();
//		while(true){
//			if( th1.isAlive() )
//				System.out.println(th1.getName()+"正在运行....");
//			if( th1.getState()==State.TIMED_WAITING )
//				System.out.println(th1.getName()+"正在等待....");
//			if( th2.isAlive() )
//				System.out.println(th2.getName()+"正在运行....");
//			if( th2.getState()==State.TIMED_WAITING )
//				System.out.println(th2.getName()+"正在等待....");
//		}
		/*
		 * 线程状态监控
		 */
		//--------Thread3 && Cleaner
//		LinkedList<Integer> list=new LinkedList<Integer>();
//		Thread th1=new Thread3(list);
//		Thread th2=new Thread3(list);
//		Thread cleaner=new Cleaner(list);
//		th1.start();
//		th2.start();
//		cleaner.start();
		/*
		 * 使用守护线程完成数据维护任务，当数据总数超过10，删除队列尾的两个数据。
		 * 守护线程的优先级很低，只有在同时休眠时才被执行
		 */
		//---------Producer && Sumer && PrintTask
//		int[] arr=new int[10000];
//		Thread producer=new Producer(arr);
//		Thread sumer=new Sumer(arr, producer);
//		Thread printTask=new PrintTask(sumer);
//		producer.start();
//		sumer.start();
//		printTask.start();
//		try {
//			printTask.join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		int t=0;
//		for( int i=0;i<arr.length;i++ ){
//			t+=arr[i];
//		}
//		if( t==sum )
//			System.out.println("验证通过！");
//		else
//			System.out.println("验证失败，t="+t+",sum="+sum);
		/*
		 * 定义三个线程，线程A用来产生若干随机数，线程B用来计算这些数的和，线程C用来输出结果，具有先后顺序
		 */
		//---------Thread4
//		Thread th1=new Thread4();
//		th1.start();
//		try {
//			Thread.sleep(10);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		th1.interrupt();
		/*
		 * 进程终止
		 */
		//----------Thread5
//		final int threadNum=5;
//		ThreadGroup parentGroup=new ThreadGroup("父线程组");
//		ThreadGroup childGroup=new ThreadGroup(parentGroup,"子线程组");
//		Thread5 worker=new Thread5();
//		Thread[] threads=new Thread[threadNum*2];
//		for( int i=0;i<threadNum;i++ ){
//			threads[i]=new Thread(childGroup,worker);
//			threads[i].start();
//		}
//		System.out.println(threadNum+"个线程加入子线程组");
//		for( int i=0;i<threadNum;i++ ){
//			threads[threadNum+i]=new Thread(parentGroup,worker);
//			threads[threadNum+i].start();
//		}
//		System.out.println(threadNum+"个线程加入父线程组");
//		System.out.println("在"+parentGroup.getName()+"中活动的线程数是"+parentGroup.activeCount());
//		System.out.println("在"+childGroup.getName()+"中活动的线程数是"+childGroup.activeCount());
//		parentGroup.interrupt();
//		System.out.println("父线程组停止");
		/*
		 * 线程组
		 */
		//-----------Thread6
		//产生数据
		Integer[] array=new Integer[N];
		for( int i=0;i<N;i++ ){
			array[i]=(int)(Math.random()*N);
		}
		//统计时间开始
		long startTime=System.currentTimeMillis();
		//划分数据集
		int[] dataRange=new int[THREADS+1];
		for( int i=0;i<=THREADS;i++ ){
			dataRange[i]=i*N/THREADS;
			if( dataRange[i]>N )
				dataRange[i]=N;
		}
		//callable接口
		Thread6[] workers=new Thread6[THREADS];
		Thread[] workersTh=new Thread[THREADS];
		System.out.println(THREADS+"个线程被产生");
		//future接口列表
		List<FutureTask<Integer>> taskLists=new ArrayList<FutureTask<Integer>>();
		for( int i=0;i<THREADS;i++ ){
			workers[i]=new Thread6(array, dataRange[i], dataRange[i+1]);
			System.out.println("第"+i+"个线程将处理数据范围（"+dataRange[i]+","+dataRange[i+1]+")");
			//future接口
			FutureTask<Integer> task=new FutureTask<Integer>(workers[i]);
			taskLists.add(task);
			//线程启动
			Thread th=new Thread(task);
			th.start();
			workersTh[i]=th;
		}
		Integer max=-1;
		for(FutureTask<Integer> task:taskLists){
			Integer temp=null;
			try {
				temp=task.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if( max<temp )
				max=temp;
		}
		System.out.println("最大值是"+max);
		//统计时间结束
		long endTime=System.currentTimeMillis();
		System.out.println("程序耗费时间="+(endTime-startTime)+"ms");
		//暴力找最大值
		//统计时间开始
		long startTime2=System.currentTimeMillis();
		int max2=array[0];
		for( int i=0;i<N;i++ ){
			max2=(max2>array[i])?max:array[i];
		}
		System.out.println("最大值是"+max2);
		//统计时间结束
		long endTime2=System.currentTimeMillis();
		System.out.println("程序耗费时间="+(endTime2-startTime2)+"ms");
		/*
		 * 带返回值的线程，Callable和Future，求最大值，多线程方法和暴力方法对比
		 */
	}

}
