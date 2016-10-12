package parallel_programming_barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月18日 上午8:42:42
 * @version 1.0
*/
public class Thread1 extends Thread{
	int[] arr;//需要排序的数组
	CyclicBarrier barrier;//障栅实例
	public Thread1( int[] arr,CyclicBarrier barrier ){
		this.arr=arr;
		this.barrier=barrier;
	}
	public void run(){
		Arrays.sort(arr);//数组排序
		try {
			barrier.await();//在障栅上等待
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
