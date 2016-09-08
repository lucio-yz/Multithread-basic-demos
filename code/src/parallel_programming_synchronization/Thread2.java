package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午10:18:28
 * @version 1.0
*/
public class Thread2 extends Thread{
	private Data2 data;
	public Thread2( Data2 data ){
		this.data=data;
	}
	public void run(){
		while( true ){
			data.increase();
		}
	}
}
