package parallel_programming_pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年10月12日 下午4:21:37
 * @version 1.0
*/
public class TestRoom {
	ThreadPoolExecutor testPool=(ThreadPoolExecutor)Executors.newCachedThreadPool();
	Map<Student, Future<Long>> stuToTimeMap;
	public TestRoom(){
		stuToTimeMap=new HashMap<Student, Future<Long>>();
	}
	public void test(Student student){
		Future<Long> result=testPool.submit(student);
		stuToTimeMap.put(student, result);
	}
	public Long getTime(Student student){
		Future<Long> result=stuToTimeMap.get(student);
		try {
			return result.get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void endTest(){
		testPool.shutdown();
	}
}
