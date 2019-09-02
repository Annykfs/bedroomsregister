package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;


@WebServlet("/DropData")
public class DropData extends HttpServlet {

	private static final long serialVersionUID = 1939232621736655456L;

	public DropData() {
        super();
        
    }
    
    Conversor conversor = new Conversor();
    DAO dao = new DAO();
    Validator validator = new Validator();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numString = request.getParameter("number");	
		int number = conversor.toInt(numString);
		
		boolean resultNum = validator.hasEqualKey(number);
		
		if(resultNum == false) {
			response.sendRedirect("index.jsp");	
		}else {
			try {
				dao.dropData(number);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
			response.sendRedirect("index.jsp");			
}


}
