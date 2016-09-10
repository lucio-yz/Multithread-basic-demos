package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午11:28:41
 * @version 1.0
*/
public class WriteThread2 extends Thread{
	private ReWrTest test;
	private int newValue;
	public WriteThread2(ReWrTest test,int newValue){
		this.test=test;
		this.newValue=newValue;
	}
	public void run(){
		test.insert(newValue);
	}
}
