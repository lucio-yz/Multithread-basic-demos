package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月4日 下午6:28:37
 * @version 1.0
*/
public class Thread1 extends Thread{
	private String name;
	public Thread1(String name){
		this.name=name;
	}
	@Override
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(name+"运行："+i);
			try {
				sleep((int)Math.random()*10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
