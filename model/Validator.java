package model;

import java.util.List;

import model.Bedroom;
import model.DAO;

public class Validator {
	
	DAO dao = new DAO();
	
	public boolean hasEqualKey(int number) {
		
		List<Bedroom> theBedr;
		
		try {
			theBedr = dao.validateNum(number);
			if(theBedr.isEmpty())
				return false;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	
			return true;
		
		
	}
}
