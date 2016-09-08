package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午3:42:41
 * @version 1.0
*/
public class Sumer extends Thread{
	int[] arr;
	Thread thread;
	public Sumer(int[] arr,Thread thread){
		this.arr=arr;
		this.thread=thread;
	}
	@Override
	public void run(){
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int sum=0;
		for( int i=0;i<arr.length;i++ ){
			sum+=arr[i];
		}
		Work.sum=sum;
	}
}
