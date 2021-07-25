package com.example;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class display extends HttpServlet 
{
     int i;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            i++;
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            int agent_id=-1;
            if(!request.getParameter("id").isEmpty())
               agent_id= Integer.parseInt(request.getParameter("id"));
            String agent_name=request.getParameter("name");
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kxlfgqqgny", "root", "papa1602");;
            if(agent_id!=-1){
            pst = con.prepareStatement("select agent_id,name,address,email from agent where agent_id=? and name like ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, agent_id);
            pst.setString(2, "%" +agent_name+"%");
            
            
            }else{
            	pst = con.prepareStatement("select agent_id,name,address,email from agent where name like ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            	pst.setString(1, "%" +agent_name+"%");
            	
            	
            }
             rs = pst.executeQuery();
             out.println("<form action=\"Logout\">\r\n"
             		+ "   <input type=\"submit\" value=\"Logout\">\r\n"
             		+ "</form>");
             out.println("<table width=60% border= 1   >");
             out.println("<tr><td colspan=4 " );
             out.println("<center><h2>Result of Search Page</h2></center>");	
             out.println("</td></tr>");
             if(rs.next()) {
            	 rs.beforeFirst();
            	 out.println("<tr>");
            	 out.println("<th>Agent Id</th>");
            	 out.println("<th>Agent Name</th>");
            	 out.println("<th>email</th>");
            	 out.println("<th>address</th>");
            	 out.println("<th>Sales Report</th>");
            	 out.println("<th>Rent Report</th>");
             
            	 out.println("</tr>");
              
            	 while(rs.next())
            	 {
            		 out.println("<tr>");
            		 out.println("<td>" + rs.getString("agent_id") + "</td> ");
            		 out.println("<td>" + rs.getString("name") + "</td> ");
            		 out.println("<td>" + rs.getString("email") + "</td> ");
            		 out.println("<td>" + rs.getString("address") + "</td> ");
            		 out.println("<td><form action='SalesReport'  method='post'><input type='hidden' name='agentid' value='"+rs.getString("agent_id")+"'></input><input type='submit' value='Sales Report'></input></form></td> ");
            		 out.println("<td><form action='RentReport' method='post'><input type='hidden' name='agentid' value='"+rs.getString("agent_id")+"'></input><input type='submit' value='Rent Report'></input></form></input></td>");
                  
            		 out.println("</tr>");

                  
              }
              out.println("</table>");
             }
             else
             {
            	out.println("</table>");
            	out.println("<p> No results found! </p>");
             }
        } 
        catch (ClassNotFoundException ex) {
        	
        }
        catch (Exception e) 
        { throw new ServletException("error", e); }
    }
    
    

    
}

