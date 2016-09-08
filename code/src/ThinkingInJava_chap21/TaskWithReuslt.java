package ThinkingInJava_chap21;

import java.util.concurrent.Callable;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月8日 下午10:04:12
 * @version 1.0
*/
public class TaskWithReuslt implements Callable<String>{
	private int id;
	public TaskWithReuslt(int id){
		this.id=id;
	}
	public String call(){
		return "result of TaskWithResult "+id;
	}
}
