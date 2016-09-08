package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 下午3:05:51
 * @version 1.0
*/
public class Thread6 extends Thread{
	public Thread6(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println(this.getName()+"------"+i);
			if( i==30 ){
				Thread.yield();
			}
		}
	}
}
