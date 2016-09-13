package parallel_programming_communication;

import java.util.Stack;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午10:52:46
 * @version 1.0
*/
public class CubbyHole2{
	private Stack<Integer> stack;
	private int count;//互斥量
	private int nbuf;//n个缓冲区
	public CubbyHole2(int nbuf){
		this.stack=new Stack<Integer>();
		this.count=0;
		this.nbuf=nbuf;
	}
	public synchronized int get(int id){
		while( count<=0 ){//栈内物品不足
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int goods=stack.pop();//物品出栈
		System.out.println("------消费者"+id+"消费了"+goods);
		count--;//拿出物品
		notifyAll();//唤醒线程，有多个线程等待
		return goods;
	}
	public synchronized void put(int value,int id){
		while( count>=nbuf ){//栈内物品超出缓冲区大小
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stack.push(value);//物品压入栈
		System.out.println("++++++生产者"+id+"生产了"+value);
		count++;//放入物品
		notifyAll();//唤醒线程，有多个线程等待
	}
}
