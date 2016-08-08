package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 上午11:29:20
 * @version 1.0
*/
public class Thread4 implements Runnable{
	private int count=15;
	@Override
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+"运行 count="+count--);
		}
	}
}
