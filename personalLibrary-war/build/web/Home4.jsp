 <%@page import="oracle.net.aso.s"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DataAccess"%>
<%-- 
    Document   : Home.jsp
    Created on : Nov 19, 2016, 3:38:10 PM
    Author     : samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body background="bg.jpg">
       
             <h1>The Book could not be added for some reason. Please try again.</h1>
                    
            <label><font color = "purple"><font size = "6">Name: </label>
            <font color = "black">
            <%
                DataAccess db = new DataAccess();
                String un = (String) session.getAttribute("username");
                 
                out.println(String.format("%s",un));
                session.setAttribute("username", un);
                 
            %>
           
        
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
 
       
         <br/> <br/>
        <a href="editProfile.jsp">Edit profile</a><br/>
         <br/> <br/>

          <form method="post" action="logOut.do">
             <input type="submit" value="Log Out">
         </form>
    </body>
</html>
