<%-- 
    Document   : adminHistory
    Created on : Dec 17, 2016, 8:35:36 PM
    Author     : Lenovo
--%>

<%@page import="models.bookList"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body background="bg.jpg">
        <h1>Find a Book</h1>
      
         <br/> <br/>
        <form method="post" action="historyName.do">
         <fieldset>   
        <font size = "5" color = "green">
        Search By Name: <br/><br/>
        <font size = "4" color = "black">
             Type name    :<input type="text" name="sname" style=" width: 300px;" required/><br/>
             <input type="submit" value="Search">
         </fieldset>
        </form>
         
<br/> <br/>
        <form method="post" action="historyAuthor.do">
         <fieldset>   
        <font size = "5" color = "green">
        Search By Writer: <br/><br/>
        <font size = "4" color = "black">
             Type Author Name    :<input type="text" name="aname" style=" width: 300px;" required/><br/>
             <input type="submit" value="Search">
         </fieldset>
        </form>

<br/> <br/>
        <form method="post" action="historyGenre.do">
         <fieldset>   
        <font size = "5" color = "green">
        Search By type: <br/><br/>
        <font size = "4" color = "black">
             Type type    :<input type="text" name="gname" style=" width: 300px;" required/><br/>
             <input type="submit" value="Search">
         </fieldset>
        </form>
<br/><br/><a href="AdminHome.jsp">Go Home</a><br/><br/>
 <br/> <br/> <br/>
            
 
 
      

    </body>
</html>
