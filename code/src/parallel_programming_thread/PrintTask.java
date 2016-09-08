package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午3:42:53
 * @version 1.0
*/
public class PrintTask extends Thread{
	Thread thread;
	public PrintTask(Thread thread){
		this.thread=thread;
	}
	@Override
	public void run(){
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sum="+Work.sum);
	}
}
