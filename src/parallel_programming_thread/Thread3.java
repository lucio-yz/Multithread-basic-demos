package parallel_programming_thread;

import java.util.LinkedList;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午2:25:34
 * @version 1.0
*/
public class Thread3 extends Thread{
	private LinkedList<Integer> list;
	public Thread3(LinkedList<Integer> list){
		this.list=list;
	}
	@Override
	public void run(){
		int newData;
		for( int i=0;i<100;i++ ){
			newData=(int)(Math.random()*1000000);
			list.addFirst(newData);
			System.out.println("新的数据"+newData+"\t已经被加入链表中");
		}
	}
}
