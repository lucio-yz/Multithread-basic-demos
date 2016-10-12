package parallel_programming_pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年10月12日 下午3:59:44
 * @version 1.0
*/
public class Work {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//-------------Employer && Worker
//		int workerNum=5;
//		Employer employer=new Employer();
//		for( int i=0;i<workerNum;i++ ){
//			Worker worker=new Worker("工人"+(i+1));
//			employer.dispatch(worker);
//		}
//		employer.endWork();
		/*
		 * 雇主雇佣工人工作。
		 * 使用线程执行器执行线程对象。使用类ThreadPoolExecutor和Executors实现
		 */
		//------------TestRoom && Student
		int stuNum=8;
		List<Student> stuList=new ArrayList<Student>();
		TestRoom testRoom=new TestRoom();
		for( int i=0;i<stuNum;i++ ){
			Student student=new Student("考生"+(i+1));
			testRoom.test(student);
			stuList.add(student);
		}
		for( Student stu:stuList ){
			System.out.println(stu.getName()+"考试用时为："
					+testRoom.getTime(stu)+"ms");
		}
		/*
		 * 某驾校有4辆考试用车。有8个学生要进行考试，要求分别获得考生的考试时间。
		 * 有返回值的线程。使用Callable接口实现。
		 */
	}

}
