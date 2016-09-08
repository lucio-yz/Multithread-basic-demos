package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午4:11:51
 * @version 1.0
*/
public class Thread4 extends Thread{
	@Override
	public void run(){
		int year=2000;
		System.out.println("闰年包括：");
		while( true ){
			if( year%4==0 && year%100!=0 || year%400==0 ){
				System.out.println(year);
			}
			if( this.isInterrupted() ){
				System.out.println("线程已经被中断");
				break;
			}
			year++;
		}
	}
}
