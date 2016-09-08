package multithread_related;
/**
 * @author lucio.yz E-mail:lucio.yang@qq.com 
 * @date 2016年8月5日 下午6:44:17
 * @version 1.0
*/
public class Bank {
	private int money=100;
	
	public synchronized int getMoney(int number){
		if (number < 0)
            return -1;
        else if (number > money)
            return -2;
        else if (money < 0)
            return -3;
        else{
            money -= number;
            System.out.println("Left Money " + money);
            return number;
        }
	}
}
