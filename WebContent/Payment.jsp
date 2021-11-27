<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Inventory.css">

<title>Payment card</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<div class="pBox1">

<div class="pBox2">

</div>

<div class="pBox3">
<div class="card">
<form action="./PaymentServlet" method="post">
		<h1 id="title_p">Payment</h1>
		<label class="cname">Name on Card</label><br>
        <input type="text" id="cname" name="cardname" placeholder="John More Doe" pattern="[A-Za-z]{3,6}" title="Name on the card should contain between 3 to 6 characters" required>	
		<br><br>
		
		<label class="ccnum">Credit card number</label><br>
        <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}" title="sample:1234-1234-1234-1234" required>
		<br><br>
		
		<label class="exmonth">Exp Month</label>
		<label class="expyear">Exp Year</label>
		<label class="cvv">CVV</label><br>
		
		<input type="text" id="exmonth" name="exmonth" placeholder="MM" pattern="[0-1][0-9]"  title="01 for January" required>
		
        <input type="text" id="expyear" name="expyear" placeholder="2022" pattern="20[0-9]{2}" title="eg:2025" required>
		
        <input type="text" id="cvv" name="cvv" placeholder="352" pattern="[0-9]{3}" title="Should contain 3 digit" required>
		<br><br>
		<h4>Total Billed : Rs.<%=(int)session.getAttribute("total")%></h4>

		

		<input type="hidden" name="cus_ID" value="<%=(int)session.getAttribute("cus_id") %>">
		<input type="hidden" name="total" value="<%=(int)session.getAttribute("total") %>">
		<input type="submit" value="Confirm Payment">
</form>
<a href="Invoice.jsp"><button class="btn4">Previous</button></a>
</div>
</div>

<div class="pBox4">

</div>


</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>