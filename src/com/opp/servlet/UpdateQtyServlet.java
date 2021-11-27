package com.opp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.inventory.Purchase;
import com.oop.inventory.Senddata;

/**
 * Servlet implementation class UpdateQtyServlet
 */
@WebServlet("/UpdateQtyServlet")
public class UpdateQtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQtyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
response.setContentType("text/html");
		
		Purchase p2 = new Purchase();
		
		int Prod_id = Integer.parseInt(request.getParameter("prod_id"));
		p2.setProd_id(Prod_id);
		
		int prod_price = Integer.parseInt(request.getParameter("prod_price"));
		
		int qty = Integer.parseInt(request.getParameter("qty"));
		p2.setQty(qty);
		
		int total = prod_price*qty;
		p2.setTotal(total);
		
		Senddata s2 = new Senddata();
		s2.UpdateProduct(p2);
		
		response.sendRedirect("Invoice.jsp");

	}

}
