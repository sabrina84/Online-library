<%-- 
    Document   : adminHistory
    Created on : Dec 17, 2016, 8:35:36 PM
    Author     : Lenovo
--%>

<%@page import="models.rentedList"%>
<%@page import="models.bookList"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifications</title>
    </head>
    <body background="bg.jpg">
        <form method="post" action="adminNotification.do">
             <h1>Notifications</h1>
                
  
        <font size = "5">
             
 <% 
    
              DataAccess db = new DataAccess();
         
         ArrayList<rentedList> lst = (ArrayList<rentedList>)db.getRentedList();
      
     //    if(lst.size() <10 ){
           for(rentedList item: lst)
            {
               out.print( String.format("<br/> <br/><font color=\"purple\"  ><input type=\"radio\" name=\"bookid\" value=\"%s\" /> %s <font color=\"black\" ><br/>",item.getId(),
                        item.getId()) );
                out.print( String.format("%s booked a book named \"%s\" on %s<br/>",item.getBook(),item.getName(), item.getDate()) );
               
            }
           /* }
        else {
             int i=0;
             for(bookList item: lst)
            {
               // out.print( String.format("Subject--"));
                out.print( String.format("<br/> <br/><font color=\"purple\"  ><input type=\"radio\" name=\"bookid\" value=\"%s\" /> %s <font color=\"black\" ><br/>",item.getId(),
                        item.getId()) );
               
                out.print( String.format("<font color=\"blue\"  >Name:<font color=\"black\" > %s<br/>",item.getName()) );
                 out.print( String.format("<font color=\"blue\" >Author:<font color=\"black\" > %s<br/>",item.getAuthor()) );
                 out.print( String.format("<font color=\"blue\" >Genre:<font color=\"black\" > %s<br/>",item.getGenre()) );
                  out.print( String.format("<font color=\"blue\" >Publications:<font color=\"black\" > %s<br/>",item.getPub()) );
                  i++;
                  if(i==10)break;
            }
         
         }*/
 %>
         <font size = "3">

 <br/> <br/> <br/>
            
            <input type="submit" value="Delete">
           <br/><br/> <br/> <br/>

 </form>
           
      <br/><br/><a href="AdminHome.jsp">Go Home</a><br/><br/>

    </body>
</html>
