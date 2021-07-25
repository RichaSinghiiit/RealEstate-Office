<%@page import="java.io.PrintWriter" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        
        
    </head>
    <body>
    	
      	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");%> <%-- to prevent accessing the page after logout using back button --%>
    	
    	<form action="Logout">
            <input type="submit" value="Logout">
        </form>
        
        <div class="container">
                   
                    <div class="form-group">
                        <h2>BestProperty.com</h2>
                    </div>
                <br>
                <div class="form-group">
            <form method="get" action="result">     
                      <div class="form-group">
                          <h3>Search The Property</h3>
                          <input name="name" type="text" placeholder="enter agent name"></input>
                          
                          <input name="id" type="number" placeholder="enter agent id(optional)"></input>
                          <input type="submit"></input>         
                       </div>
                    
           
                    
   </form>  
   </div>
   </div>
   </body>
   </html>
        