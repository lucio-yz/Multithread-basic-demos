package parallel_programming_thread;

import java.util.LinkedList;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午2:32:35
 * @version 1.0
*/
public class Cleaner extends Thread{
	private LinkedList<Integer> list;
	public Cleaner(LinkedList<Integer> list){
		this.list=list;
		this.setDaemon(true);
	}
	@Override
	public void run(){
		while( true ){
			if( list.size()>10 ){
				for( int i=0;i<2;i++ )
					list.removeLast();
				System.out.println("两个数据已经被移除。");
			}
		}
	}
}
