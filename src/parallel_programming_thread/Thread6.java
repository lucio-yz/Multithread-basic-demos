package parallel_programming_thread;

import java.util.concurrent.Callable;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月6日 下午9:00:36
 * @version 1.0
*/
public class Thread6 implements Callable<Integer>{
	Integer[] arr;
	int begin;
	int end;
	public Thread6(Integer[] arr,int begin,int end){
		this.arr=arr;
		this.begin=begin;
		this.end=end;
	}
	public Integer call(){
		Integer max=arr[begin];
		for( int i=begin+1;i<end;i++ ){
			if( max<arr[i] )
				max=arr[i];
		}
		return max;
	}
}
