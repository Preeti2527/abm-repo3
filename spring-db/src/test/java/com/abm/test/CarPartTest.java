package com.abm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abm.component.CarPart;
import com.abm.component.CarPartInventory;
import com.abm.component.CarPartInventoryImpl1;
import com.abm.component.CarPartInventoryImpl2;
import com.abm.component.CarPartInventoryImpl3;
import com.abm.component.CarPartInventoryImpl5;

public class CarPartTest {

	@Test
	public void test_adding_carpart() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("my-spring-config.xml");
		CarPartInventory cpInv=(CarPartInventory)ctx.getBean("carPartInv5");
		CarPart cp=new CarPart();
		cp.setPartName("sound box");
		cp.setCarModel("sony ");
		cp.setPrice(50050);
		cp.setQuantity(1);
		cpInv.addNewPart(cp);
		System.out.println("changing by training servlet");
		//entity or model classes are not instantiated using spring
		//object interface ka ni bana sakte
	}
	
	@Test
	public void test_getavailablePart() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("my-spring-config.xml");
		CarPartInventory cpInv=(CarPartInventory)ctx.getBean("carPartInv5");
		
		List<CarPart> list=cpInv.getAvailableParts();
		for(CarPart cp :list) {
			System.out.println(cp.getCarModel());
			System.out.println(cp.getCarModel());
			System.out.println(cp.getPrice());
			System.out.println(cp.getQuantity());
			System.out.println("***");
			
			
		}
		
		
		//entity or model classes are not instantiated using spring
		//object interface ka ni bana sakte
	}

}
