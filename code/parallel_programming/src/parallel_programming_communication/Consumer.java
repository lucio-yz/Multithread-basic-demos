package parallel_programming_communication;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午10:00:25
 * @version 1.0
*/
public class Consumer extends Thread{
	private CubbyHole cubbyHole;
	public Consumer(CubbyHole c){
		cubbyHole=c;
	}
	public void run(){
		for( int i=0;i<50;i++ ){
			cubbyHole.get();
		}
	}
}
