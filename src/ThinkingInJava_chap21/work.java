package ThinkingInJava_chap21;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月8日 下午9:16:58
 * @version 1.0
*/
public class work {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//----------ListOff
//		ExecutorService exec=Executors.newCachedThreadPool();
//		for( int i=0;i<5;i++ ){
//			exec.execute(new ListOff());
//		}
//		exec.shutdown();
		/*
		 * 利用executor管理thread
		 */
//		ExecutorService exec=Executors.newSingleThreadExecutor();
//		for( int i=0;i<5;i++ ){
//			exec.execute(new ListOff());
//		}
//		exec.shutdown();
		/**
		 * SingleThreadExecutor中的任务按照被提交的顺序排队执行。
		 */
		//----------TaskWithResult
		ExecutorService exec=Executors.newCachedThreadPool();
		ArrayList<Future<String>> results=new ArrayList<Future<String>>();
		for( int i=0;i<10;i++ ){
			results.add(exec.submit(new TaskWithReuslt(i)));
		}
		for( Future<String> fs:results ){
			try {
				System.out.println(fs.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 利用Callable接口，得到任务的返回值。
		 */
	}

}
