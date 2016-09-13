package parallel_programming_communication;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午9:43:57
 * @version 1.0
*/
public class CubbyHole {
	private int goods;
	private boolean empty;//互斥信号量
	public CubbyHole(){
		empty=true;
	}
	public synchronized int get(){
		while( empty ){//缓冲区没有物品，需要等待
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("消费者拿走了物品"+goods);
		empty=true;//拿走之后，重新设置为空
		notify();//唤醒等待进程,只有一个线程阻塞
		return goods;
	}
	public synchronized void put(int value){
		while( !empty ){//缓冲区没有地方可以放，需要等待
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		goods=value;
		System.out.println("生产者生产了物品"+goods);
		empty=false;//放置物品，设置为非空
		notify();//唤醒等待进程，只有一个线程阻塞
	}
}
