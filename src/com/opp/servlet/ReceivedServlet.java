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
 * Servlet implementation class ReceivedServlet
 */
@WebServlet("/ReceivedServlet")
public class ReceivedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivedServlet() {
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
		
		Purchase p1 = new Purchase();
		
		int Prod_id = Integer.parseInt(request.getParameter("prod_id"));
		p1.setProd_id(Prod_id);
		
		p1.setProd_name(request.getParameter("prod_name"));
		
		int prod_price = Integer.parseInt(request.getParameter("prod_price"));
		p1.setUnitPrice(prod_price);
		
		int qty = Integer.parseInt(request.getParameter("qty"));
		p1.setQty(qty);
		
		int total = prod_price*qty;
		p1.setTotal(total);
		
		int cus_id = Integer.parseInt(request.getParameter("cus_id"));
		p1.setCustomer_id(cus_id);;
		
		p1.setCustomer_name(request.getParameter("cus_name"));
		
		p1.setEmail(request.getParameter("email"));
		
		Senddata s1 = new Senddata();
		s1.addPurchase(p1);
		
		response.sendRedirect("Invoice.jsp");

	}

}
