<%-- 
    Document   : editExam
    Created on : Dec 17, 2016, 8:29:32 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failure</title>
    </head>
    <body background="bg.jpg">
          <h1> Update has Failed </h1>
          <form method="post" action="editExam.do">
              <font size = "6" color = "purple">
            
              <%
                  String qid =(String) session.getAttribute("bookid");
                   out.print( String.format("Book Id: %s<br/><br/>",qid) );
              %>
              <font size = "5" color = "black">
                <label> Name </label><input type="text" name="name" style=" width: 500px;" required/><br/><br/>
         <label>Author Name </label><input type="text" name="author" style=" width: 500px;" required/><br/><br/>
         <label> Genre </label><input type="text" name="genre" style=" width: 500px;" required/><br/><br/>
         <label> Publications </label><input type="text" name="pub" style=" width: 500px;" required/><br/><br/>
        <input type="submit" value ="Add" /><br/><br/><br/>
              </form>
                <br/><br/><a href="AdminHome.jsp">Go Home</a><br/><br/>
    </body>
</html>
