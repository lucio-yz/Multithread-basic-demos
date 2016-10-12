package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 上午10:34:04
 * @version 1.0
*/
public class ReadThread extends Thread{
	private ReenTest test;
	public ReadThread(ReenTest test){
		this.test=test;
	}
	public void run(){
		test.read();
	}
}
