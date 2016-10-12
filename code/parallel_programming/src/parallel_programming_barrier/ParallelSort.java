package parallel_programming_barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年9月18日 上午8:40:28
 * @version 1.0
*/
public class ParallelSort {
	
	public static final int THREADS=Runtime.getRuntime().availableProcessors();//should be even number
	public static void main(String[] args) {
		//------------Thread1
		/*
		 * 数据排序的并行化实现。以障栅实现。
		 */
		int N=50000000;
		int[] array=new int[N];
		int[] arrayParallel=new int[N];
		for( int i=0;i<N;i++ ){
			array[i]=(int)(Math.random()*N);
		}
		System.out.println("数据初始化完成！");
		//开始计时
		System.out.println("并行计算开始...");
		long startTime1=System.currentTimeMillis();
		int[] range=new int[THREADS+1];
		int slice=N/THREADS;
		for( int i=0;i<=THREADS;i++ ){
			range[i]=slice*i;//确定划分范围
			if( range[i]>N )
				range[i]=N;
		}
		int[][] subArray=new int[THREADS][slice];
		for( int i=0;i<THREADS;i++ ){
			subArray[i]=Arrays.copyOfRange(array, range[i], range[i+1]);//按照范围拷贝数据,左闭右开
		}
		System.out.println("数据划分完成！");
		Thread[] t=new Thread[THREADS];
		CyclicBarrier barrier=new CyclicBarrier(THREADS+1);//子线程和main线程都在障栅上等待
		for( int i=0;i<THREADS;i++ ){
			t[i]=new Thread1(subArray[i], barrier);
			t[i].start();
		}
		System.out.println(THREADS+"个线程已经启动");
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		merge(subArray,arrayParallel,THREADS,slice);//归并
		//计时结束
		long endTime1=System.currentTimeMillis();
		System.out.println("并行排序耗时"+(endTime1-startTime1)+"ms");
		
		long startTime2=System.currentTimeMillis();
		System.out.println("串行计算开始...");
		Arrays.sort(array);
		long endTime2=System.currentTimeMillis();
		System.out.println("串行排序耗时"+(endTime2-startTime2)+"ms");
		
		System.out.println("并行结果正确性检验...");
		if( check(array,arrayParallel,N) )
			System.out.println("并行排序正确！");
		else
			System.out.println("并行排序错误！");
	}
	public static void merge( int[][] subArray,int[] arrayParallel,int num,int slice ){
		int count=0;
		//值拷贝
		for( int i=0;i<num;i++ ){
			for( int j=0;j<slice;j++ ){
				arrayParallel[count++]=subArray[i][j];
			}
		}
		count=num/2;
		for( int step=0;step<(int)(Math.log(num)/Math.log(2));step++ ){
			int interval=slice*(step+1);
			for( int i=0;i<count;i++ ){
				mergeTwo(arrayParallel,i*2*interval, i*2*interval+interval-1, (i+1)*2*interval-interval, (i+1)*2*interval-1);
			}
			count=count/2;
		}
	}
	public static void mergeTwo(int[] array,int left1,int right1,int left2,int right2){
		int[] piece1=new int[right1-left1+1];
		int[] piece2=new int[right2-left2+1];
		for( int i=left1;i<=right1;i++ ){
			piece1[i-left1]=array[i];
		}
		for( int i=left2;i<=right2;i++ ){
			piece2[i-left2]=array[i];
		}
		int pointer=left1,pointer1=0,pointer2=0;
		while( pointer1<=right1-left1 && pointer2<=right2-left2 ){
			if( piece1[pointer1]<piece2[pointer2] )
				array[pointer++]=piece1[pointer1++];
			else
				array[pointer++]=piece2[pointer2++];
		}
		while( pointer1<=right1-left1 )
			array[pointer++]=piece1[pointer1++];
		while( pointer2<=right2-left2 )
			array[pointer++]=piece2[pointer2++];
	}
	public static boolean check(int[] array,int[] arrayParallel,int n){
		for( int i=0;i<n;i++ ){
			if( array[i]!=arrayParallel[i] )
				return false;
		}
		return true;
	}
}
