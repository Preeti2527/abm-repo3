package com.abm.component;

import java.util.List;

public interface CarPartInventory {
	
	public void addNewPart(CarPart carpart);
	
	public List<CarPart>getAvailableParts();

}
