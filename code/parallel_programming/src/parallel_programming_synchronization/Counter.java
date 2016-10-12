package parallel_programming_synchronization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 下午1:42:47
 * @version 1.0
*/
public class Counter{
	private AtomicInteger ia=new AtomicInteger();
	public void increase(){
		ia.getAndAdd(1);
	}
	public int get(){
		return ia.get();
	}
}
