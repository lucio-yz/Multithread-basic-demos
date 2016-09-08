package parallel_programming_synchronization;

import javax.xml.crypto.Data;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午9:38:19
 * @version 1.0
*/
public class Work {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//---------Data1 && Thread1
//		Data1 data=new Data1();
//		Thread1 th1=new Thread1(data);
//		Thread1 th2=new Thread1(data);
//		th1.start();
//		th2.start();
//		while( true ){
//			data.isEqual();
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		/*
		 * 同步锁之同步方法，对一个类的两个属性同时进行+1操作，并比较大小。
		 */
		//---------Data2 && Thread1
		Data2 data=new Data2();
		Thread2 th1=new Thread2(data);
		Thread2 th2=new Thread2(data);
		th1.start();
		th2.start();
		while( true ){
			data.isEqual();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 同步锁之同步块
		 */
	}

}
