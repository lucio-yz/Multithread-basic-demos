package parallel_programming_barrier;

import java.util.concurrent.SynchronousQueue;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月27日 下午5:13:00
 * @version 1.0
*/
public class Consumer extends Thread{
	private SynchronousQueue<Integer> queue;
	public Consumer(SynchronousQueue<Integer> queue){
		this.queue=queue;
	}
	public void run(){
		for( int i=0;i<5;i++ ){
			try {
				System.out.println("消费者消费了一个数据："+queue.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
