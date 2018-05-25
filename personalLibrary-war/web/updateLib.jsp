<%-- 
    Document   : prepareExam
    Created on : Dec 13, 2016, 7:36:32 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new book</title>
    </head>
   <body background="bg.jpg">
          <form method="post" action="prepareExam.do">

        
        
        <h2> Book Id: </h2><input type="text" name="bookid" required/><br/><br/>
         <h2> Name </h2><input type="text" name="name" style=" width: 500px;" required/><br/><br/>
         <h2>Author Name </h2><input type="text" name="author" style=" width: 500px;" required/><br/><br/>
         <h2> Genre </h2><input type="text" name="genre" style=" width: 200px;" required/><br/><br/>
         <h2> Publications </h2><input type="text" name="pub" style=" width: 200px;" required/><br/><br/>
        
        <input type="submit" value ="Add" /><br/><br/><br/>
         <a href="history.jsp">Show All</a>
         <br/><br/><a href="AdminHome.jsp">Go Home</a><br/><br/>
            </form>
    </body>
</html>
