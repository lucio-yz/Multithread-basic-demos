package parallel_programming_synchronization;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月8日 上午9:58:17
 * @version 1.0
*/
public class Data1 {
	int a=0;
	int b=0;
	public synchronized void increase(){
		a++;
		b++;
	}
	public synchronized void isEqual(){
		System.out.println("a="+a+"\tb="+b+"\t"+(a==b));
	}
}
