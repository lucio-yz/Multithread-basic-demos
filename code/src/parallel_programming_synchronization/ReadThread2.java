package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午11:28:30
 * @version 1.0
*/
public class ReadThread2 extends Thread{
	private ReWrTest test;
	public ReadThread2(ReWrTest test){
		this.test=test;
	}
	public void run(){
		test.read();
	}
}
