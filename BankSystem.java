package bankapp;
import java.util.Scanner;
public class BankSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ma,mb,mc;
		do {    menua();
				ma = sc.nextInt();
			switch(ma) {
			case 1: //Customer
					do{
				    menub();
					mb = sc.nextInt();
						switch(mb) {
						case 1:
						case 2://Savings/Credit
							  /* if(mb == 1) {
								   //set acctype to Savings
							   }
							   if(mb == 2) {
								   //set acctype to Credit
							   } */
								do {
									menuc();
									mc = sc.nextInt();
									switch(mc) {
									case 1:break;
									case 2:break;
									case 3:break;
									case 4:break;
									case 5:break;
									default:System.out.println("Invalid Choice");break;
									}
								}while(mc!=5);
								break;
						case 3:break;
						default:System.out.println("Invalid Choice");break;
						}
					}while(mb!=3);
					break;
			case 2://Bank Authority =>just displays account details
					break;
			case 3:break;
			default:System.out.println("Invalid Choice");break;
			}
		}while(ma!=3);
	}
	
	public static void menua() {
		System.out.println("1.Customer");
		System.out.println("2.Bank Authority");
		System.out.println("3.Exit");
		System.out.println("Enter ur choice:");
	}
	
	public static void menub() {
		System.out.println("Enter ur Account Type:");
		System.out.println("1.Savings Account");
		System.out.println("2.Credit Account");
		System.out.println("3.Exit");
		System.out.println("Enter ur choice:");
	}
	
	public static void menuc() {
		System.out.println("1.View My Account Details");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Create New Account");
		System.out.println("5.Exit");
		System.out.println("Enter ur choice:");
	}
}

class BankAccount{
	public long accNo;
	public String accName;
	private double balance;
	public String branch;
	int intRate;
	
	void deposit(double amount) {
		balance += amount;
	}
	
	void withdraw(double amount) {
		if(balance>amount)
		balance -= amount;
		else
		System.out.println("Insufficient funds");	
	}
	
	void setIntRate(int interest) {
		intRate = interest;
	}
	
	void addMonthlyInterest(int month) {
		for(int i=0; i<month; i++)
		balance = balance + ((balance*intRate)/100);
	}
	
	public String toString() {
		return(accNo+" "+accName+" "+branch+" "+balance);
	}
	
	void BankAccount(long ai,String an, String bran) {
		this.accName = an;
		this.accNo = ai;
		this.branch = bran;
	}
}

class SavingAcc extends BankAccount{
	String typeacc = new String("Savings");
	
	void setIR(int interest) {
	   setIntRate(interest);	
	}
	void addIR(int months) {
		addMonthlyInterest(months);
	}
	
	void SavingsAcc(long ai,String an, String bran, String type) {
		super.BankAccount(ai, an, bran);
		this.typeacc = type;	
	}
	
	public String toString() {
		return(super.toString()+" "+typeacc);
	}
	
	void displayacc(SavingAcc ab) {
		ab.toString();
	}
}

class CreditAcc extends BankAccount{
	String typeac = new String("Credit");
	void setIR(int interest) {
		   setIntRate(interest);	
		}
	void addIR(int months) {
		   addMonthlyInterest(months);
		}
	
	void CreditAcc(long ai, String an, String bran, String type) {
		super.BankAccount(ai, an, bran);
		this.typeac = type;	
	}
	
	public String toString() {
		return(super.toString()+" "+typeac);
	}
	void displayacc(CreditAcc ab) {
		ab.toString();
	}
}