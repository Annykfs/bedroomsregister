package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet("/ReadDataFront")
public class ReadNCreateData extends HttpServlet {

	private static final long serialVersionUID = 2704865758162630764L;

	public ReadNCreateData() {

	}

	Bedroom bedrooms = new Bedroom();
	DAO dao = new DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String resultOwner = request.getParameter("owner");
		String areaS = request.getParameter("area");
		String numberS = request.getParameter("number");
		String resultColor = request.getParameter("color");
		String resultSuite = request.getParameter("suite");

		Conversor conversor = new Conversor();

		float resultArea = conversor.toFloat(areaS);
		int resultNumber = conversor.toInt(numberS);

		if (resultOwner == null && resultArea == 0 && resultNumber == 0 && resultColor == null && resultSuite == null)
			out.println(" wtf have you done?");
		else {
			bedrooms.setOwner(resultOwner);
			bedrooms.setArea(resultArea);
			bedrooms.setNumber(resultNumber);
			bedrooms.setColor(resultColor);
			bedrooms.setSuite(resultSuite);
			try {
				dao.insertData(bedrooms);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			RequestDispatcher rdrct = request.getRequestDispatcher("index.jsp");
			rdrct.forward(request, response);

		}

	}

}