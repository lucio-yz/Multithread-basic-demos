package parallel_programming_pool;

import java.util.concurrent.Callable;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年10月12日 下午4:16:47
 * @version 1.0
*/
public class Student implements Callable<Long>{
	private String name;
	public Student( String name ){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@Override
	public Long call(){
		System.out.println(name+"开始考试。");
		long start=System.currentTimeMillis();
		int num=(int)(Math.random()*Integer.MAX_VALUE);
		for( int i=0;i<num;i++ ){//使用比较耗费时间的浮点运算
			double x=12345.1231442141;
			double y=1234535.124214124214141;
			x=x*y;
		}
		return System.currentTimeMillis()-start;
	}
}
