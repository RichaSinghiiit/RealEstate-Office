<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "Models.AgentModel, Models.PropertyModel, Models.BookingModel, java.util.List" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Report</title>
</head>

<style>
.profileDetailBox {
  border: 5px outset grey;
  background-color: lightgrey;    
  
}

</style>

<body>
	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");%><%-- to prevent accessing the page after logout using back button --%>
	
	<form action="Logout">
            <input type="submit" value="Logout">
    </form>
        
	<h1 style="text-align:center"><b>Agent Sales Report</b></h1>
	<div class="profileDetailBox">
		<% AgentModel agent = (AgentModel)request.getAttribute("agent") ; 
		/*   
		AgentModel agent = new AgentModel();
		   agent.setName("AAYUSH MAURYA");
		   agent.setEmail("aayush.maurya@iiitg.ac.in");
		   agent.setContact_number(99129394);
		 */
		%>
			<p><b>&emsp;Name:&emsp; <%  out.println(agent.getName()); %><br><br>
			&emsp;Contact No:&emsp; <% out.println(agent.getContact_number()); %> <br><br>
			&emsp;Email ID:&emsp; <%  out.println(agent.getEmail()); %> </b></p>
	</div>
	
	<h2 style="background-color: #cce6ff; padding: 8px 10px;">Properties Sold</h2>
	<%List<PropertyModel> deals_in = agent.getDeals_in();
	if(deals_in.size() != 0)
	{%>
	<table class="properties" style="width: 80%; padding: 4px;">
		<tr>
			<th>Address &emsp;</th>
			<th>Type&emsp;</th>
			<th>Construction status&emsp;</th>
			<th>Bedroom(s)&emsp;</th>
			<th>Bathroom(s)&emsp;</th>
			<th>Transaction&emsp;</th>
			<th>Size&emsp;</th>
			<th>Furnishing&emsp;</th>
			<th>Parking&emsp;</th>
			<th>Sales Price&emsp;</th>
			<th>Sales Date&emsp;</th>
			
		</tr>
			
		<% for(PropertyModel property: deals_in){
				if(property.getBooking_status().equalsIgnoreCase("Booked") && property.getProperty_for().equalsIgnoreCase("Sale")) {
			
			%>		<tr>
					    <td><% out.print(property.getProperty_type()+" no- "+property.getHouse_number()+", "+ property.getLocality());%>&emsp;</td>
					    <td><%= property.getProperty_type() %>&emsp;</td>
					    <td><%= property.getConstruction_status() %>&emsp;</td>
					    <td><%= property.getNumber_of_bedrooms() %>&emsp;</td>
					    <td><%= property.getNumber_of_bathrooms() %>&emsp;</td>
					    <td><%= property.getNew_or_resale() %>&emsp;</td>
					    <td><%= property.getSize() %>&emsp;</td>
					    <td><%= property.getFurnishing() %>&emsp;</td>
					    <td><%= property.getParking() %>&emsp;</td>
					     <td><%= property.getBooking_price() %>&emsp;</td> 
					    <td><%= property.getFirst_date() %>&emsp;</td>
					   
					      
					</tr>
					
				<%
				}
    			}%>
    		
			
	</table><% 
		}
		else 
			out.println("<p> Agent has not sold any properties yet!<p>");%>
	

</body>
</html>