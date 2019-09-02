package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	//CREATE -----------------
	public boolean insertData(Bedroom bedroom) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (bedroom == null) {
			throw new IllegalArgumentException();
		}
		String query = "INSERT INTO bedrooms (owner, area, number, color, suite) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = BedroomConnection.doConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setString(1, bedroom.getOwner());
			ps.setFloat(2, bedroom.getArea());
			ps.setInt(3, bedroom.getNumber());
			ps.setString(4, bedroom.getColor());
			ps.setString(5, bedroom.getSuite());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//READ -----------------
	public List<Bedroom> accessData() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String query = "SELECT * FROM bedrooms";
		ResultSet reSet = null;
		List<Bedroom> allBedroom = new ArrayList<>();
		try (Connection con = BedroomConnection.doConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			reSet = ps.executeQuery();
			
			while (reSet.next()) {
				
			    Bedroom bdr = new Bedroom();
			    
			    bdr.setOwner(reSet.getString("owner"));
			    bdr.setArea(reSet.getFloat("area"));
			    bdr.setNumber( reSet.getInt("number") );
			    bdr.setColor( reSet.getString("color"));
			    bdr.setSuite( reSet.getString("suite"));
                allBedroom.add(bdr);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BedroomConnection.closeConnection(reSet);
		}
		return allBedroom;
	}
	
	//DELETE ------------
	public boolean dropData(Integer number) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (number == null || number < 0) {
			throw new IllegalArgumentException();
		}
		String query = "DELETE FROM bedrooms WHERE bedrooms.number = ?";
		try 
                    (Connection con = BedroomConnection.doConnection();
                        PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, number);
			int resLine = ps.executeUpdate();
			if (resLine > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	//UPDATE -----------------
	public boolean updateData(Bedroom bedroom) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (bedroom == null || bedroom.getNumber() <= 0 || bedroom.getNumber() <= 0) {
			throw new IllegalArgumentException();
		}
		String query = "UPDATE bedrooms SET owner = ?, area = ?, color = ?, suite = ? WHERE number = ?";
		try (Connection con = BedroomConnection.doConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, bedroom.getOwner());
			ps.setFloat(2, bedroom.getArea());
			ps.setString(3, bedroom.getColor());
			ps.setString(4, bedroom.getSuite());
			ps.setInt(5, bedroom.getNumber());
			int resLine = ps.executeUpdate();
			if (resLine > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
public List<Bedroom> validateNum(int num) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String query = "SELECT * FROM bedrooms WHERE number = ?";
		ResultSet reSet = null;
		List<Bedroom> theBedroom = new ArrayList<>();
		try (Connection con = BedroomConnection.doConnection(); PreparedStatement ps = con.prepareStatement(query)) {
	
			ps.setInt(1, num);
			reSet = ps.executeQuery();
			
			while (reSet.next()) {
				
			    Bedroom bdr = new Bedroom();
			    
			    bdr.setOwner(reSet.getString("owner"));
			    bdr.setArea(reSet.getFloat("area"));
			    bdr.setNumber( reSet.getInt("number") );
			    bdr.setColor( reSet.getString("color"));
			    bdr.setSuite( reSet.getString("suite"));
			    
                theBedroom.add(bdr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BedroomConnection.closeConnection(reSet);
		}
		return theBedroom;
	}	
	
}
