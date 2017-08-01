package synchronization;
/*
 * First we create a class with basic banking transactions for
 * 1. fetching account balance
 * 2. withdrawing money
 * 3. depositing money
 * */
public class Account {
	//we give some balance in the account
	private int balance = 50;  
	
	//Fetch the current balance in this function
    public int getBalance() {  
    return balance;  
    } 
    
    //function to withdraw money
    public void withdraw(int amount) {  
    balance = balance - amount;  
    } 
    
  //function to deposit money
    public void deposit(int amount) {  
        balance = balance + amount;  
        } 

}
