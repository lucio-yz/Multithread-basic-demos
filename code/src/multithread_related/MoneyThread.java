package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 下午6:46:48
 * @version 1.0
*/
public class MoneyThread extends Thread{
	private String name;
	private Bank bank;
	public MoneyThread(String name,Bank bank){
		this.name=name;
		this.bank=bank;
	}
	public void run(){
		System.out.println(name+" get "+bank.getMoney(80));
	}
}
