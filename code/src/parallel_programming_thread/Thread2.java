package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 上午11:20:49
 * @version 1.0
*/
public class Thread2 extends Thread{
	public Thread2(String name){
		this.setName(name);
	}
	@Override
	public void run(){
		while(true){
			for( int i=0;i<100;i++ ){
				try {
					sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
