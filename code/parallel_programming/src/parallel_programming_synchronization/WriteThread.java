package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午10:36:47
 * @version 1.0
*/
public class WriteThread extends Thread{
	private ReenTest test;
	private int newValue;
	public WriteThread(ReenTest test,int newValue){
		this.test=test;
		this.newValue=newValue;
	}
	public void run(){
		test.insert(newValue);
	}
}
