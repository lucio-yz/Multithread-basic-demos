package parallel_programming_thread;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午3:42:34
 * @version 1.0
*/
public class Producer extends Thread{
	int[] arr;
	public Producer(int[] arr){
		this.arr=arr;
	}
	@Override
	public void run(){
		for( int i=0;i<arr.length;i++ ){
			arr[i]=(int)(Math.random()*100);
		}
	}
}
