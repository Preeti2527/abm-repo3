package com.abm.component.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface Bank {
	
	public void withdraw(int atmId ,int acno, double amount);
	

}
