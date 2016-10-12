package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午10:01:10
 * @version 1.0
*/
public class Thread1 extends Thread{
	private Data1 data;
	public Thread1(Data1 data){
		this.data=data;
	}
	public void run(){
		while( true ){
			data.increase();
		}
	}
}
