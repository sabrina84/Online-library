<%-- 
    Document   : sendmail
    Created on : Dec 18, 2016, 9:28:20 PM
    Author     : Lenovo
--%>

<%@page import="db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Msg sent</title>
    </head>
   
    
    <body background="bg.jpg">
         <h1>A message is sent to you containing your password.</h1>
        <%
            String un = (String)session.getAttribute("un");
                DataAccess db = new DataAccess();
                String pass = db.getPass(un);
                String mail = db.getMail(un);
                out.println(String.format("<form action=\"mailto:%s\" enctype=\"text/plain\"onsubmit=\"%s\" >",mail,pass));
            %> 
            <br/><br/>
            <input type="submit" value="Done" /><br/>
             <a href="index.html">Log in</a>
    <form/>
    </body>
</html>
