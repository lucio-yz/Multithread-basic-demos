package multithread_related;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年7月29日 下午3:13:22
 * @version 1.0
*/
public class work {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//---------ListNode
//		ListNode x=new ListNode(0);
//		int[] nums=new int[10];
//		int y=nums[0];
//		if( nums.length==1 ){
//			
//		}
//		int repeat;
		//---------Thread1
//		Thread1 th1=new Thread1("A");
//		Thread1 th2=new Thread1("B");
//		th1.start();
//		th2.start();
		/**
		 * 执行结果是顺序不固定的，start()方法的调用后并不是立即执行多线程代码，
		 * 而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的。
		 * Thread.sleep()方法挂起线程，尽量避免人工挂起，因为阻碍CPU调度
		 */
		//---------Thread2
//		new Thread(new Thread2("C")).start();
//		new Thread(new Thread2("D")).start();
		/**
		 * 实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。
		 * 不管是扩展Thread类还是实现Runnable接口来实现多线程，都是通过Thread的API。
		 */
		//---------Thread3
//		Thread3 th1=new Thread3("E");
//		Thread3 th2=new Thread3("F");
//		th1.start();
//		th2.start();
		/**
		 * 不同线程的变量是局部的。
		 */
		//---------Thread4
//		Thread4 th1=new Thread4();
//		new Thread(th1,"G").start();
//		new Thread(th1,"H").start();
//		new Thread(th1,"I").start();
		/**
		 * 每个线程都是用同一个实例化对象。
		 * 实现Runnable接口比继承Thread类所具有的优势：
		 * 1、适合多个相同的程序代码的线程去处理同一个资源
		 * 2、可以避免java中的单继承的限制
		 */
		//----------Thread5 无Join调用
//		System.out.println(Thread.currentThread().getName()+"主线程开始！");
//		Thread5 th1=new Thread5("J");
//		Thread5 th2=new Thread5("K");
//		th1.start();
//		th2.start();
//		System.out.println(Thread.currentThread().getName()+"主线程结束！");
		/**
		 * 主线程先于子线程结束。无Join方法。
		 */
//		//-----------Thread5 有Join调用
//		System.out.println(Thread.currentThread().getName()+"主线程开始！");
//		Thread5 th1=new Thread5("L");
//		Thread5 th2=new Thread5("M");
//		th1.start();
//		th2.start();
//		try {
//			//并发的执行两个线程
//			th1.join();
//			th2.join();
//		} catch (Exception e) {
//			e.printStackTrace();		
//		}
//		System.out.println(Thread.currentThread().getName()+"主线程结束！");
		/**
		 * 主线程等待子线程。有Join方法。
		 */
		//---------Thread6
//		Thread6 th1=new Thread6("N");
//		Thread6 th2=new Thread6("O");
//		th1.start();
//		th2.start();
		/**
		 * yield()让当前运行线程回到可运行状态。
		 * 有可能在进入到可执行状态后马上又被执行。
		 */
		//---------Thread6。有setPriority方法。
//		Thread6 th1=new Thread6("N");
//		Thread6 th2=new Thread6("O");
//		th1.setPriority(Thread.MAX_PRIORITY);
//		th2.setPriority(Thread.MIN_PRIORITY);
//		th1.start();
//		th2.start();
		/**
		 * 设置优先级。
		 * th1的优先级最高，即使th1被yield，由于优先级高，所以马上继续运行。
		 */
		//---------ThreadPrinter
//		Object a=new Object();
//		Object b=new Object();
//		Object c=new Object();
//		ThreadPrinter tp1=new ThreadPrinter("A", c, a);
//		ThreadPrinter tp2=new ThreadPrinter("B", a, b);
//		ThreadPrinter tp3=new ThreadPrinter("C", b, c);
//		try {
//			new Thread(tp1).start();
//			new Thread(tp2).start();
//			Thread.sleep(100);//main进程阻塞100ms，tp3的阻塞推迟，目的是为了防止tp3先拿到b，造成ACB的结果
//			new Thread(tp3).start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
		 * 三线程依次打印ABC多次。使用到了notify、wait、syncronized
		 * 当main中没有sleep的时候，tp2阻塞在了a,tp3拿到b、阻塞在c，那么tp1释放a、c时，tp3将先运行。
		 * 当main中tp2与tp3之间有sleep时，tp3的启动被延迟，这时已经完成了tp1的拿取和释放，b将不会被tp3抢占。
		 */
		//--------MoneyThread
        Bank bank = new Bank();
        Thread t1 = new MoneyThread("A",bank);// 从银行取钱
        Thread t2 = new MoneyThread("B",bank);// 从取款机取钱
        t1.start();
        t2.start();
        /**
         * syncronized作用于方法
         * t1、t2谁取到80顺序不定，但一定不会出现同时取到80
         */
	}

}
