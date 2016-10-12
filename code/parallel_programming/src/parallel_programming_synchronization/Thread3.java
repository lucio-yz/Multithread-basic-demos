package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月10日 下午1:45:20
 * @version 1.0
*/
public class Thread3 extends Thread{
	private Counter counter;
	public Thread3(Counter counter){
		this.counter=counter;
	}
	public void run(){
		for( int i=0;i<100;i++ ){
			counter.increase();
		}
	}
}
