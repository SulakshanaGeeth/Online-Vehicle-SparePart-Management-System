<%@page import="com.oop.inventory.Purchase"%>
<%@page import="com.oop.inventory.Senddata"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Inventory.css">

<style>
/* div {
  background-image: url('images/1000.jpg');
} */
</style>

<title>Invoice</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

 <div class="invoiceTab">
  <h1 id="iTitle">Shopping Cart</h1>
 	<table >
 		 <tr>
                <th >Item Name</th>
                <th >Unit Price</th>
                <th >Qty</th>
                <th >Price (Rs.)</th>
                <th >Remove Item</th>
         </tr>
         <%

int total=0;

HttpSession s1 = request.getSession();

try {
	
	com.oop.inventory.Senddata sd2 = new com.oop.inventory.Senddata();
	ArrayList<com.oop.inventory.Purchase> purchaselist = sd2.getCustomerPurchase((int)session.getAttribute("cus_id"));
	

	for(com.oop.inventory.Purchase purchase : purchaselist){
		%>
			 <tr>
			     <td><%=purchase.getProd_name() %></td>
			     <td><%=purchase.getUnitPrice() %></td>
			     
			      
			     <td>
			     	<form action="UpdateQty.jsp" method="post">
						<input type="hidden" name="prod_id" value="<%=purchase.getProd_id() %>" />
						<input type="hidden" name="prod_qty" value="<%=purchase.getQty() %>" />
			        	<input type="submit" value="<%=purchase.getQty() %>" class="btn2" />
					</form>
			     </td>
			     
			     <td><%=purchase.getTotal() %></td>
			     <%
			      	total=total+purchase.getTotal();
			     %>
			         		
				 <td>
					<form action="./DeleteServlet" method="post">
						<input type="hidden" name="prod_id" value="<%=purchase.getProd_id() %>" />
			        	<input type="submit" value="Remove Item" class="btn2" />
					</form>
			     </td> 
			        
			 </tr>
		<%	
		}
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("Error"+e.getMessage());
}
		%>
 		 <tr>
 		 <td></td>
 		 <td></td>
         <td ><b>Total Amount</b></td>     
         <td><%out.print(total);%></td>             
  </tr>
</table>    
    
<a href="Engine.jsp"><button class="btn3">Add More Items</button></a>  
       
<form action="Payment.jsp" method="post">
<div class="invoice_btn">
		
		<input type="hidden" name="total" value="<%out.print(total);%>">
		<input type="hidden" name="cus_ID" value="<%=(int)session.getAttribute("cus_id") %>">
		<% s1.setAttribute("total", total);%>
		
		<input type="submit" value="Proceed to Checkout">
 </div>	
</form>


 </div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>