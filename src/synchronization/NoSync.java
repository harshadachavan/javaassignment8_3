package synchronization;
/*
 * The following code does the banking transactions without Synchronization
 * */
public class NoSync implements Runnable {
	private Account acct = new Account();  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			NoSync r = new NoSync();  
			//two threads and both thread trying to withdraw money from same account object in the loop
	        Thread one = new Thread(r);  
	        Thread two = new Thread(r);  
	        one.setName("Harshada");  
	        two.setName("Rishi");  
	        one.start();  
	        two.start();  

	}
	@Override  
    public void run() {  
        for (int x = 0; x < 5; x++) {  
            makeWithdrawal(10);  
           /*
            *  here we encounter a problem on the 5th time known as "race condition"
            *  A race condition occurs when a program or application malfunctions
            *  because of an unexpected ordering of events that produces 
            *  contention over the same resource.
            *  resource can produce corrupted data 
            *  if one thread "races in" too quickly before an 
            *  operation that should be "atomic" has completed.
            * */
            if (acct.getBalance() < 0) {  
                System.out.println("Excess Withdrawal !!");  
            }  
        }  
    } 
	
    private void makeWithdrawal(int amt) {  
        if (acct.getBalance() >= amt) {  
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");  
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException ex) {  
            }  
            acct.withdraw(amt);  
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");  
        } else {  
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + acct.getBalance());  
        }  
    }  

}
