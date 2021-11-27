<%@page import="com.oop.inventory.Senddata"%>
<%@page import="com.oop.inventory.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Inventory.css">
<title>Update Quantity</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	<% 
	int Prod_id = Integer.parseInt(request.getParameter("prod_id"));
	int Prod_qty = Integer.parseInt(request.getParameter("prod_qty"));
	
	com.oop.inventory.Senddata sd = new com.oop.inventory.Senddata();
	ArrayList<com.oop.inventory.Product> productList = sd.getProduct(Prod_id);

	for(com.oop.inventory.Product product : productList){
	%>
	<div class="box10">
	<div class="box9"></div>
	<div class="box7">
			<h3 class="pName"><%=product.getProdName() %></h3>
			<img src="<%=product.getProdImg() %>" width="300px" height="200px">
			<p class="pDetails"><%=product.getProdDetails() %></p>
			<h3 class="pPrice">Price: Rs.<%=(int)product.getProdPrice() %></h3>
	
			<form action="./UpdateQtyServlet" method="post">
				<input type="hidden" name="prod_id" value="<%=product.getProdID() %>" />
				<input type="hidden" name="prod_price" value="<%=(int)product.getProdPrice() %>"/>
				<label class="qtyLabel" for="qty">Quantity</label>
				<input type="text" id="qty" name="qty" value=<%=Prod_qty%>>
				<div><input type="submit" value="Update" class="btn10" /></div>
			</form>
	</div>
	<div class="box8"></div>
	</div>
	<%} %>	
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>