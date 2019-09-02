package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bedroom;
import model.Conversor;
import model.DAO;

@WebServlet("/Update")
public class UpdateData extends HttpServlet {
	
	private static final long serialVersionUID = 4241592858891825576L;
	
	Bedroom bedrooms = new Bedroom();
	DAO dao = new DAO();
	Conversor conversor = new Conversor();
	
    public UpdateData() {
        super();
      
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
    	
    	String resultOwner = request.getParameter("owner");
		String numString = request.getParameter("number");
		String areaS = request.getParameter("area");
		String resultColor = request.getParameter("color");
		String resultSuite = request.getParameter("suite");
		
		float resultArea = conversor.toFloat(areaS);
		int resultNumber = conversor.toInt(numString);
		
		if (resultOwner == null && resultArea == 0 && resultNumber == 0 && resultColor == null && resultSuite == null)
			out.println("bitch wtf");
		else {
			bedrooms.setOwner(resultOwner);
			bedrooms.setArea(resultArea);
			bedrooms.setNumber(resultNumber); // tenho que tratar no java, no input ou front a entrada de numbers iguais
			bedrooms.setColor(resultColor);
			bedrooms.setSuite(resultSuite);
			
			try {
				dao.updateData(bedrooms);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rdrct = request.getRequestDispatcher("index.jsp");
			rdrct.forward(request, response);
			
		}	

	}
  
}
