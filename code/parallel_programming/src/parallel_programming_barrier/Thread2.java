package parallel_programming_barrier;

import java.util.concurrent.Semaphore;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月27日 下午4:50:24
 * @version 1.0
*/
public class Thread2 extends Thread{
	private Semaphore counter;
	private int id;
	private int times;
	public Thread2(Semaphore counter,int id){
		this.counter=counter;
		this.id=id;
		times=(int)(Math.random()*Integer.MAX_VALUE);
	}
	public void run(){
		try {
			counter.acquire();//获取锁
			System.out.println("第"+id+"位顾客开始办理业务...");
			for( int i=0;i<times;i++ );//do something
			counter.release();//释放锁
			System.out.println("第"+id+"位顾客已经办理完业务，准备离开...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
