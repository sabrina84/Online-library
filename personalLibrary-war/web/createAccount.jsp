<%-- 
    Document   : createAccount.jsp
    Created on : Nov 19, 2016, 4:26:10 PM
    Author     : samsung
--%>

<%@page import="servlets.account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
        
    </head>
   <body background="bg.jpg">
    <center>
        <h1>Create your account!</h1>
        <br/><br/>
        <form method="post" action="account.do">
            
           
            
           Username :<br/> <input type="text" name="username" maxlength="10" required /><br/><br/>
            Password :<br/> <input type="password" name="password" required /> <br/><br/>
            Confirm Password :<br/> <input type="password" name="password1" required /> <br/><br/>
             Phone    :<br/> <input type="text" name="phone" required/><br/><br/>
            <input type="submit" value="Create" />
            <% 
                
                /*account ac = new account();
                String email= (String) session.getAttribute("email");
                String email1= (String) session.getAttribute("email1");
                 String password= (String) session.getAttribute("password");
                String password1= (String) session.getAttribute("password1");
               
               int i = ac.check(email,email1,password,password1);
               if(i==0)out.println(String.format("EMAIL OR PASSWORD DOES NOT MATCH."));
                        */
            %>
        </form>
    </center>
    </body>
</html>
