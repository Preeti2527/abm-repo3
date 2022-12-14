package com.abm.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carPartInv5")
public class CarPartInventoryImpl5 implements CarPartInventory {

	@PersistenceContext
	private EntityManager em;
	
	
	
    @Transactional
	public void addNewPart(CarPart carPart) {
		em.persist(carPart);

	}

	public List<CarPart> getAvailableParts() {
		Query q=em.createQuery("select c from CarPart c");
		List<CarPart> list=q.getResultList();
		return list;

	}

}