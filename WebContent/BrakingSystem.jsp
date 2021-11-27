<%@page import="com.oop.inventory.Product"%>
<%@page import="com.oop.inventory.Senddata"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Inventory.css">
<title>Car Inventory</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="box4">
<div class="topic"><h1>Braking System</h1></div>
<div class="box3">
<ul>
	<li><a href="Engine.jsp">Engine</a></li>
	<li><a href="Transmission.jsp">Transmission</a></li>
	<li><a href="BrakingSystem.jsp">Braking System</a></li>
	<li><a href="SuspensionSystem.jsp">Suspension System</a></li>
	<li><a href="Invoice.jsp">Shopping Cart</a></li>
</ul>
</div>


<div class="box2">
<%
try {
	
	HttpSession s1 = request.getSession();
	s1.setAttribute("cus_id", 01);
	s1.setAttribute("cus_name", "Geeth");
	s1.setAttribute("email", "Geeth@gmail.com");
	
	com.oop.inventory.Senddata sd = new com.oop.inventory.Senddata();
	ArrayList<com.oop.inventory.Product> productList = sd.getProducts("Break");

	for(com.oop.inventory.Product product : productList){
%>
			<div class="box1">
			
			<h3 class="pName"><%=product.getProdName() %></h3>
			<img src="<%=product.getProdImg() %>" width="300px" height="200px">
			<p class="pDetails"><%=product.getProdDetails() %></p>
			<h3 class="pPrice">Price: Rs.<%=(int)product.getProdPrice() %></h3>
			
			<form action="./ReceivedServlet" method="post">
				<input type="hidden" name="prod_id" value="<%=product.getProdID() %>" />
				<input type="hidden" name="prod_name" value="<%=product.getProdName() %>"/>
				<input type="hidden" name="prod_price" value="<%=(int)product.getProdPrice() %>"/>
				<label class="qtyLabel" for="qty">Quantity</label>
				<input type="text" id="qty" name="qty" value="01">
				<input type="hidden" name="cus_id" value="<%=(int)session.getAttribute("cus_id") %>"/>
				<input type="hidden" name="cus_name" value="<%=(String)session.getAttribute("cus_name") %>"/>
				<input type="hidden" name="email" value="<%=(String)session.getAttribute("email") %>"/>
				<div><input type="submit" value="Buy" class="btn1" /></div>
			</form>
			
			</div>
		<%	
		}
	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("Error"+e.getMessage());
}
%>


</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>