package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 上午11:46:24
 * @version 1.0
*/
public class Thread5 extends Thread{
	private String name;
	public Thread5(String name){
		this.name=name;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"线程开始!");
		for(int i=0;i<5;i++){
			System.out.println("子线程"+name+"运行:"+i);
		}
		System.out.println(Thread.currentThread().getName()+"线程结束!");
	}
}
