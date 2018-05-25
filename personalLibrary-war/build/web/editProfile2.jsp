<%-- 
    Document   : editProfile2
    Created on : Dec 18, 2016, 7:47:04 PM
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
             <h1>passwords do not match.</h1>
             
              
           Change phone    :<input type="text" name="phone" required/><br/><br/>
            
          
            Change Password :<input type="password" name="password" required/> <br/><br/>
            Confirm Password : <input type="password" name="password1"required /> <br/><br/>
             <input type="submit" value="Done">
             <form/>
    </body>
</html>
