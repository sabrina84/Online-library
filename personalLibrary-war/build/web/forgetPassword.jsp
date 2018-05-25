<%-- 
    Document   : forgetPassword
    Created on : Dec 18, 2016, 9:20:25 PM
    Author     : Lenovo
--%>

<%@page import="db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password</title>
    </head>
    <body background="bg.jpg">
         <form method="post" action="fp.do"> 
             <br/><br/>  <br/><br/>
       <label><b>Username: </b></label>
            <input type="text" placeholder="Enter Username" name="username" required><br/>
              <br/><br/>  <br/><br/>
             <input type="submit" value="Submit" /><br/>
         </form>
    </body>
</html>
