package parallel_programming_synchronization;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午10:23:15
 * @version 1.0
*/
public class ReenTest {
	private List<Integer> myList;
	private Lock lock=new ReentrantLock();
	public ReenTest(List<Integer> myList){
		this.myList=myList;
	}
	public void printAll(){
		lock.lock();
		try {
			for( Integer num:myList ){
				System.out.println(num+",");
			}
		} finally {
			lock.unlock();
		}
	}
	public void insert(int newValue){
		lock.lock();
		try {
			System.out.println("写前表长="+myList.size());
			for( int i=0;i<5;i++ ){
				myList.add((Integer)newValue);
			}
			System.out.println("写5个新元素,写元素="+newValue);
			System.out.println("写后表长="+myList.size());
		} finally {
			lock.unlock();
		}
	}
	public void read(){
		lock.lock();
		try {
			System.out.println("读前表长="+myList.size());
			System.out.println("读末尾元素="+((myList.size()==0)?"没有":myList.get(myList.size()-1)));
			System.out.println("读后表长="+myList.size());
		} finally {
			lock.unlock();
		}
	}
}
