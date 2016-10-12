package parallel_programming_barrier;

import java.util.concurrent.SynchronousQueue;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月27日 下午5:09:20
 * @version 1.0
*/
public class Producer extends Thread{
	private SynchronousQueue<Integer> queue;
	public Producer(SynchronousQueue<Integer> queue) {
		this.queue=queue;
	}
	public void run(){
		for( int i=0;i<5;i++ ){
			int data=(int)(Math.random()*100);
			System.out.println("生产者生产了一个数据："+data);
			try {
				queue.put(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
