package parallel_programming_communication;

import java.util.Random;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月13日 下午11:39:47
 * @version 1.0
*/
public class Producer2 extends Thread{
	private int id;
	private CubbyHole2 cubbyHole2;
	public Producer2( CubbyHole2 c,int id ){
		this.cubbyHole2=c;
		this.id=id;
	}
	public void run(){
		for( int i=0;i<50;i++ ){
			cubbyHole2.put((int)(100*Math.random()), this.id);
		}
	}
}
