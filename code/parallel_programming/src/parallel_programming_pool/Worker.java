package parallel_programming_pool;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年10月11日 下午4:49:43
 * @version 1.0
*/
public class Worker implements Runnable{
	public Worker(String name){
		Thread.currentThread().setName(name);
	}
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()
				+"正在努力完成自己的工作。");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
