package parallel_programming_communication;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午9:58:34
 * @version 1.0
*/
public class Producer extends Thread{
	private CubbyHole cubbyHole;
	public Producer(CubbyHole c){
		cubbyHole=c;
	}
	public void run(){
		for( int i=0;i<50;i++ ){
			cubbyHole.put((int)(100*Math.random()));
		}
	}
}
