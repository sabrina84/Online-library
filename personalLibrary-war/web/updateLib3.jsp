<%-- 
    Document   : prepareExam2
    Created on : Dec 15, 2016, 5:00:11 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body background="bg.jpg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Book</title>
    </head>
    <body>
          <form method="post" action="prepareExam.do">
              <h1>The Book ID is invalid. Please try again.<h1/>
        <h2> Book Id: </h2><input type="text" name="bookid" required/><br/><br/>
        <h2> Name </h2><input type="text" name="name" style=" width: 500px;" required/><br/><br/>
         <h2>Author Name </h2><input type="text" name="author" style=" width: 500px;" required/><br/><br/>
         <h2> Genre </h2><input type="text" name="genre" style=" width: 500px;" required/><br/><br/>
         <h2> Publications </h2><input type="text" name="pub" style=" width: 500px;" required/><br/><br/>
        <input type="submit" value ="Add" /><br/><br/><br/>
        <a href="history.jsp">Show All</a>
            </form>
        <br/><br/><a href="AdminHome.jsp">Go Home</a><br/><br/>
    </body>
</html>
