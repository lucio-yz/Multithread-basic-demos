package parallel_programming_communication;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午10:01:58
 * @version 1.0
*/
public class Work {


	public static void main(String[] args) {
		//----------CubbyHole && Producer && Consumer
//		CubbyHole cubbyHole=new CubbyHole();
//		Producer producer=new Producer(cubbyHole);
//		producer.start();
//		Consumer consumer=new Consumer(cubbyHole);
//		consumer.start();
		/*
		 * wait、notify方法。单缓冲区的生产者消费者问题。
		 */
		//---------CubbyHole2 && Producer2 && Consumer2
		int nbuf=10;//n buffer
		int nt=4;//n thread
		CubbyHole2 cubbyHole2=new CubbyHole2(nbuf);
		for( int i=0;i<nt;i++ ){
			try {
				Producer2 producer2=new Producer2(cubbyHole2, i+1);
				producer2.start();
				Consumer2 consumer2=new Consumer2(cubbyHole2, i+1);
				consumer2.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * wait、notifyAll方法。多缓冲区的生产者消费者问题。
		 */
	}

}
