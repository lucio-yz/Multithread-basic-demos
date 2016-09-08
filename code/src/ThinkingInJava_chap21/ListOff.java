package ThinkingInJava_chap21;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月8日 下午9:21:51
 * @version 1.0
*/
public class ListOff implements Runnable{
	protected int countDown=10;//default
	private static int taskCount=0;
	private final int id=taskCount++;
	public ListOff(){
		
	}
	public ListOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return "#" + id + "(" +
				( countDown>0?countDown:"ListOff!" ) + "),";
	}
	public void run(){
		while( countDown-->0 ){
			System.out.println(status());
			Thread.yield();
		}
	}
}
