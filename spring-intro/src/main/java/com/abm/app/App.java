package com.abm.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abm.component.Calculator;
import com.abm.component.HelloWorld;
import com.abm.component.RevisingStep;
import com.abm.component.TextEditor;
import com.abm.component.di.Atm;
import com.abm.component.di.HdfcAtm;

public class App {

	public static void main(String[] args) {
		//loading Ioc container of spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("my-spring-config.xml");
		//accessing a bean
		for(int i=0;i<5;i++) {
		HelloWorld hw=(HelloWorld)ctx.getBean("hello");
		System.out.println(hw.sayHello("Preeti"));
		}
		
		RevisingStep h1=(RevisingStep)ctx.getBean("hi");
		System.out.println(h1.sayHi("Preeti"));
		
		Calculator c=(Calculator)ctx.getBean("calc");
		c.add(80,20);
		
		TextEditor te=(TextEditor)ctx.getBean("txtEdtr");
		te.loadDocument("abc.txt");
		
		Atm a=(Atm)ctx.getBean(HdfcAtm.class);
		a.withdraw(12, 1000);
				
				
	}

}
