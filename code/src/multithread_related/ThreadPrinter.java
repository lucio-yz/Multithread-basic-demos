package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 下午3:25:29
 * @version 1.0
*/
public class ThreadPrinter implements Runnable{
	private String name;
	private Object prev;
	private Object self;
	
	public ThreadPrinter(String name,Object prev,Object self){
		this.name=name;
		this.prev=prev;
		this.self=self;
	}
	
	@Override
	public void run(){
		int count=10;
		while( count>0 ){
			synchronized (prev) {
				synchronized (self) {
					System.out.println(name);
					count--;
					self.notify();//唤醒等待self对象的线程
				}
				try {
					prev.wait();//使当前进程阻塞地等待持有prev的进程唤醒
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
