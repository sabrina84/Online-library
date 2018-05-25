<%-- 
    Document   : editProfile
    Created on : Dec 18, 2016, 7:38:37 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body background="bg.jpg">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <form method="post" action="editProfile.do">
             <h1>Edit</h1>
             <%
                
                String un = (String) session.getAttribute("username");
                 
                
                out.println(String.format("<br/><br/>Username : %s<br/><br/>",un));
                ;
            %>
             
           Change phone    :<input type="text" name="phone" required/><br/><br/>
            
          
            Change Password :<input type="password" name="password" required/> <br/><br/>
            Confirm Password : <input type="password" name="password1" required/> <br/><br/>
             <input type="submit" value="Done">
             <form/>
    </body>
</html>
