package parallel_programming_barrier;

import java.util.concurrent.Phaser;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年10月11日 下午3:10:28
 * @version 1.0
*/
public class Student extends Thread{
	Phaser phaser;
	public Student(Phaser phaser){
		this.phaser=phaser;
	}
	public void run(){
		System.out.println(this.getName()+"已经到达考场。");
		phaser.arriveAndAwaitAdvance();
		System.out.println(this.getName()+"等待老师发卷。。。");
		phaser.arriveAndAwaitAdvance();
		System.out.println(this.getName()+"正在答试卷一。。。");
		phaser.arriveAndAwaitAdvance();
		System.out.println(this.getName()+"正在答试卷二。。。");
		phaser.arriveAndAwaitAdvance();
		System.out.println(this.getName()+"正在等待宣布考试结束。。。");
		phaser.arriveAndDeregister();
	}
}
