package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 上午11:16:33
 * @version 1.0
*/
public class Thread3 extends Thread{
	private int count=5;
	private String name;
	public Thread3(String name){
		this.name=name;
	}
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  count= " + count--);
	    }
	}
}
