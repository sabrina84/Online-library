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
        <title>All Books</title>
    </head>
    <body background="bg.jpg">
        <form method="post" action="userHistory.do">
             <h1>Books</h1>
                
                    

        
        <HR COLOR="purple" WIDTH="100%">
        
        
        
           <% /*out.print( String.format("Subject------------------------------------------------------Question------------------------------------------------------------------a-------------------------b------------------------c------------------------d------------- answer  </br>"));
        out.print( String.format("_______________________________________________________________________________________________________________________________________________________________________________________</br>"));
          */ %>
        <font size = "5">
             
 <% 
    // out.print( String.format("Subject--"));
              DataAccess db = new DataAccess();
              String un = (String) session.getAttribute("gname");
         ArrayList<bookList> lst = (ArrayList<bookList>)db.getBookListG(un);
         // out.print( String.format("Subject--1"));
     //    if(lst.size() <10 ){
           for(bookList item: lst)
            {
               // out.print( String.format("Subject--"));
                out.print( String.format("<br/> <br/><font color=\"purple\"  ><input type=\"radio\" name=\"bookid\" value=\"%s\" /> %s <font color=\"black\" ><br/>",item.getId(),
                        item.getId()) );
               
                out.print( String.format("<font color=\"blue\"  >Name:<font color=\"black\" > %s<br/>",item.getName()) );
                 out.print( String.format("<font color=\"blue\" >Author:<font color=\"black\" > %s<br/>",item.getAuthor()) );
                 out.print( String.format("<font color=\"blue\" >Genre:<font color=\"black\" > %s<br/>",item.getGenre()) );
                  out.print( String.format("<font color=\"blue\" >Publications:<font color=\"black\" > %s<br/>",item.getPub()) );
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
            
            <input type="submit" value="Add">
          
           <br/><br/> <br/> <br/>
 <HR COLOR="purple" WIDTH="100%">
 </form>
           
      <br/><br/><a href="Home.jsp">Go Home</a><br/><br/>

    </body>
</html>
