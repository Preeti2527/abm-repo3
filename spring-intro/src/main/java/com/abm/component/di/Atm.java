package com.abm.component.di;

import org.springframework.stereotype.Component;


public interface Atm {
	
	public void withdraw(int acno , double amount);

}
