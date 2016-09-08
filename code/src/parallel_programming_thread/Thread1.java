package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 上午10:19:35
 * @version 1.0
*/
public class Thread1 extends Thread{
	private String name;
	public Thread1(String name,int priority){
		this.name=name;
		if( priority<=0 || priority>10 ){
			System.out.println("警告：优先级的取值应该在1-10之间");
			this.setPriority(Thread.NORM_PRIORITY);
		}else{
			this.setPriority(priority);
		}
	}
	@Override
	public void run(){
		System.out.println(name+"的优先级为"+this.getPriority());
		for( int i=0;i<10;i++ ){
			System.out.println(name+"正在打印"+i);
		}
	}
}
