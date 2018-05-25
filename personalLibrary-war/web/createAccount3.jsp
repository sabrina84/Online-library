<%-- 
    Document   : createAccount3
    Created on : Dec 19, 2016, 5:43:37 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <body background="bg.jpg">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
        
    </head>
    <body>
    <center>
        <h2>Invalid username. Please try again.</h2>
        <br/><br/>
        <form method="post" action="account.do">
            Username :<br/> <input type="text" name="username" maxlength="10" required /><br/><br/>
            Password :<br/> <input type="password" name="password" required /> <br/><br/>
            Confirm Password :<br/> <input type="password" name="password1" required /> <br/><br/>
             Phone    :<br/> <input type="text" name="phone" required /><br/><br/>
            
            <input type="submit" value="Create" />
           
        </form>
    <center/>
    </body>
</html>
