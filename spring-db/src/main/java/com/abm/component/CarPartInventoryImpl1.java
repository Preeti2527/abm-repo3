package com.abm.component;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component("carPartInv1")
public class CarPartInventoryImpl1 implements CarPartInventory {



   public void addNewPart(CarPart carPart) {
        //USING JDBC WRITE CODE FOR INSERTING THE CAR PART DETAILS IN
        
        Connection conn=null;
        //PreparedStatement stmt=null;
        
        try {
            //Loading the jdbc Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Connecting the database
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527//training","derby","derby");
            String sql="INSERT INTO tbl_carpart(part_name, car_model, price, quantity) VALUES (?,?,?,?)";
            




          PreparedStatement stmt=conn.prepareStatement(sql);
          stmt.setString(1, carPart.getPartName());
          stmt.setString(2,carPart.getCarModel());
          stmt.setDouble(3,carPart.getPrice());
          stmt.setInt(4,carPart.getQuantity());
          stmt.executeUpdate();
    
    }
        
        catch(SQLException | ClassNotFoundException e)
        
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
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		//connecting the database
		conn=DriverManager.getConnection("jdbc:derby://localhost:1527/training", "derby", "derby");
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
	catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
		return null;
	}
	finally {
		try{conn.close();}catch(Exception e) {}
	}
		
	
        
       
    }








}