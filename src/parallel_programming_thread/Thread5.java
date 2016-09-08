package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午5:16:07
 * @version 1.0
*/
public class Thread5 implements Runnable{
	int counter=0;
	@Override
	public void run(){
		for( int i=0;i<Integer.MAX_VALUE;i++ ){
			counter++;
			if( Thread.currentThread().isInterrupted() ){
				System.out.println("线程已经被中断");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName()+"停止执行");
	}
	
}
