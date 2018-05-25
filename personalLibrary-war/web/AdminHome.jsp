<%-- 
    Document   : AdminHome
    Created on : Dec 13, 2016, 7:05:06 PM
    Author     : Lenovo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 
        <title>Log in</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
    </head>
    <body background="bg.jpg">
        <form method="post" action="admin.do">
             <h1>Hi Admin!!</h1>
             <left>
                    <HR COLOR="purple" WIDTH="100%">
                    <label><b><font color = "purple"><font size = "6">Name: </b></label>
                    <font color = "black">
            <%          
              String name = (String)session.getAttribute("username");
               out.println(String.format("%s",name));
                session.setAttribute("username", name);
                // out.println(String.format("nowrin"));
            %>
            <font size = "4">
           
        </left> 
          
        </br> <br/> 

        </form>
       
       <a href="adminNotification.jsp">Notifications</a> </br> <br/> 
        <a href="updateLib.jsp">Add Books</a><br/><br/><br/>
         <a href="history.jsp">Book List</a><br/><br/>
         <form method="post" action="logOut.do">
             <input type="submit" value="Log Out">
         </form>
       
</
    </body>
</html>
