package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 上午11:04:29
 * @version 1.0
*/
public class Thread2 implements Runnable{
	private String name;
	public Thread2(String name){
		this.name=name;
	}
	@Override
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(name+"运行："+i);
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
