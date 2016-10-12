package parallel_programming_barrier;

import java.util.concurrent.Phaser;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月27日 下午4:49:44
 * @version 1.0
*/
public class Work {
	
	public static void main(String[] args) {
		//----------Thread2
//		Semaphore counter=new Semaphore(4);
//		Thread[] th=new Thread[20];
//		for( int i=0;i<20;i++ ){
//			th[i]=new Thread2(counter, i+1);
//			th[i].start();
//		}
		/*
		 * 银行有4个窗口可以办理业务，现在有20个顾客需要办理业务。使用信号量实现。
		 */
		//---------Producer && Customer
//		SynchronousQueue<Integer> queue=new SynchronousQueue<Integer>();
//		Thread producer=new Producer(queue);
//		Thread consumer=new Consumer(queue);
//		producer.start();
//		consumer.start();
		/**
		 * 生产者消费者问题。同步队列实现。
		 * 在同步队列上的操插入操作必须等待删除操作执行完之后才能执行，反之亦然。
		 */
		//---------CustomizedPhaser && Student
		int student_num=5;
		Phaser phaser=new CustomizedPhaser();
		Thread[] students=new Thread[student_num];
		for( int i=0;i<student_num;i++ ){
			students[i]=new Student(phaser);
			phaser.register();
			students[i].start();
		}
		for( int i=0;i<student_num;i++ ){
			try {
				students[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 模拟英语四六级考试。采用Phaser实现。
		 * 1、考生到考场。2、发试卷。3、答题。4、收答题一部分。5、答题。6、收答题二部分。7、考试结束。
		 */
	}

}
