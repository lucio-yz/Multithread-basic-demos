package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午10:15:59
 * @version 1.0
*/
public class Data2 {
	private int a=0;
	private int b=0;
	public void increase(){
		synchronized (this) {
			a++;
			b++;
		}
	}
	public void isEqual(){
		synchronized (this) {
			System.out.println("a="+a+"\tb="+b+"\t"+(a==b));
		}
	}
}
