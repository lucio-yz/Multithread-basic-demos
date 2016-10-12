package parallel_programming_synchronization;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午11:29:54
 * @version 1.0
*/
public class ReWrTest {
	private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();
	private Lock readLock=rwLock.readLock();
	private Lock writeLock=rwLock.readLock();
	private List<Integer> myList;
	public ReWrTest(List<Integer> myList){
		this.myList=myList;
	}
	public void printAll(){
		readLock.lock();
		try {
			for( Integer num:myList ){
				System.out.println(num+",");
			}
		} finally {
			readLock.unlock();
		}
	}
	public void insert(int newValue){
		writeLock.lock();
		try {
			System.out.println("写前表长="+myList.size());
			for( int i=0;i<5;i++ ){
				myList.add((Integer)newValue);
			}
			System.out.println("写5个新元素,写元素="+newValue);
			System.out.println("写后表长="+myList.size());
		} finally {
			writeLock.unlock();
		}
	}
	public void read(){
		readLock.lock();
		try {
			System.out.println("读前表长="+myList.size());
			System.out.println("读末尾元素="+((myList.size()==0)?"没有":myList.get(myList.size()-1)));
			System.out.println("读后表长="+myList.size());
		} finally {
			readLock.unlock();
		}
	}
}
