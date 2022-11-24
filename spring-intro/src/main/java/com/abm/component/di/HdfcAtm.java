package com.abm.component.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class HdfcAtm implements Atm {
	
	@Autowired
	private Bank bank;
    
	public void withdraw(int acno, double amount) {
		System.out.println("User at hdfc atm wanting to withdraw" +amount);
		bank.withdraw(121, acno, amount);
		
		
		
	}

}
