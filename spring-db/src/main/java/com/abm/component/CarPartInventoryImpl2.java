package com.abm.component;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("carPartInv2")
public class CarPartInventoryImpl2 implements CarPartInventory {

@Autowired
private DataSource datasource;

   public void addNewPart(CarPart carPart) {
       
        
        Connection conn=null;
       
        
        try {
            conn=datasource.getConnection();
           
            String sql="INSERT INTO tbl_carpart(part_name, car_model, price, quantity) VALUES (?,?,?,?)";
            




          PreparedStatement stmt=conn.prepareStatement(sql);
          stmt.setString(1, carPart.getPartName());
          stmt.setString(2,carPart.getCarModel());
          stmt.setDouble(3,carPart.getPrice());
          stmt.setInt(4,carPart.getQuantity());
          stmt.executeUpdate();
    
    }
        
        catch(SQLException e)
        
        {
            e.printStackTrace();
        }
        
        finally {
            try {
                
                conn.close();
                
            }
            
            catch(Exception e) {}
            
            
        }
        }
        
        



   public List<CarPart> getAvailableParts() {
	   Connection conn=null;
		PreparedStatement stmt=null;
		try {
			 conn=datasource.getConnection();
		String sql="select * from tbl_carpart ";
		
		stmt = conn.prepareStatement(sql);
		//stmt.setDouble(1, 5000);//subsituting
		ResultSet rs=stmt.executeQuery();
		List<CarPart>list=new ArrayList<>();
		while(rs.next()){
			CarPart cp=new CarPart();
			cp.setPartNo(rs.getInt("part_no"));
			cp.setPartName(rs.getString("part_name"));
			cp.setCarModel(rs.getString("car_model"));
			cp.setPrice(rs.getInt("price"));
			cp.setQuantity(rs.getInt("quantity"));
			list.add(cp);
         }
		
		
		 
		return list;
	}
	catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
	finally {
		try{conn.close();}catch(Exception e) {}
	}
		
	
        
       
    }








}