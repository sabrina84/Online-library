/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import models.bookList;
import models.rentedList;

/**
 *
 * @author samsung
 */
public class DataAccess 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    //String dbURL = "jdbc:derby://localhost:1527/sample";
    String username = "hr";
    String password = "123";

      Connection conn = null;
   Statement stmt = null;
    //Connection conn = null;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
    }
   
    public int updateBook(String b, String n, String a,String g, String p){
     
             try{
                  String query = "update books set name = ? ,authorname = ?, genre= ?, publications= ? where bookid = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, n);
            stmt.setString(2, a);
            stmt.setString(3, g);
             stmt.setString(4, p);
              stmt.setString(5, b);
       
            int count = stmt.executeUpdate();
            return count;
             }
              catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        
        }
    }
  
     public int updateProfile(String username, 
            String password,String phone)//used
     {
     
             try{
                  String query = "update useroflibrary set password = ? ,phoneno = ? where userid = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            stmt.setString(1, password);
            stmt.setString(2, phone);
            stmt.setString(3, username);
    
            int count = stmt.executeUpdate();
            return count;
             }
              catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        
        }
    }
    
     public int deleteBook(String qid){
     
             try{
                  String query = "delete from books where bookid = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setString(1, qid);
       
            int count = stmt.executeUpdate();
            return count;
             }
              catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        
        }
    }
     
      public int deleteRentedBook(String qid){
     
             try{
                  String query = "delete from rentedbooks where bookid = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setString(1, qid);
       
            int count = stmt.executeUpdate();
            
            query = "update rentlist set rdate = sysdate where bookid = ? and rdate is null";
            stmt = conn.prepareStatement(query);
           
            stmt.setString(1, qid);
            int count1 = stmt.executeUpdate();
            return count & count1;
             }
              catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        
        }
    }
     
     public ArrayList<rentedList> getRentedList() throws SQLException //List<String>
    {
        ArrayList<rentedList> result= new ArrayList<rentedList>();
        String b="",n="",d="",bid="";
        
        String selectStatement = "select b1.name,r.userid, r.hdate from books b1 join rentlist r on (b1.bookid = r.bookid) where rdate is null";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
           
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                bid = rs.getString("b1.bookid");
                 b = rs.getString("b1.name");
                 n = rs.getString("r.userid");
                 d = rs.getString("r.hdate");
                
                rentedList rl = new rentedList(bid,b,n,d);
                result.add(rl);
                

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

        return result;
    }
  
     public ArrayList<bookList> getBookListG(String genre) throws SQLException //List<String>
    {
        ArrayList<bookList> result= new ArrayList<bookList>();
        String bid="",n="",a="",g="",p="";
        
        String g1 = "%"+genre+"%";
        g1 = g1.toLowerCase();
        
        String selectStatement = "select * from books where lower(genre) like ?";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
             stmt.setString(1, g1);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                 bid = rs.getString("bookid");
                 n = rs.getString("name");
                 a = rs.getString("authorname");
                 g = rs.getString("genre");
                 p = rs.getString("publications");
                bookList b = new bookList(bid,n,a,g,p);
                result.add(b);
                

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

        return result;
    }
      public ArrayList<bookList> getBookListN(String name) throws SQLException //List<String>
    {
        ArrayList<bookList> result= new ArrayList<bookList>();
        String bid="",n="",a="",g="",p="";
        String n1 = "%"+name+"%";
         n1 = n1.toLowerCase();
        
        String selectStatement = "select * from books where lower(name) like ?";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
             stmt.setString(1, n1);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                 bid = rs.getString("bookid");
                 n = rs.getString("name");
                 a = rs.getString("authorname");
                 g = rs.getString("genre");
                 p = rs.getString("publications");
                bookList b = new bookList(bid,n,a,g,p);
                result.add(b);
                

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

        return result;
    }
      public ArrayList<bookList> getBookListA(String name) throws SQLException //List<String>
    {
        ArrayList<bookList> result= new ArrayList<bookList>();
        String bid="",n="",a="",g="",p="";
        String n1 = "%"+name+"%";
        
        n1 = n1.toLowerCase();
        String selectStatement = "select * from books where lower(authorname) like ?";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
             stmt.setString(1, n1);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                 bid = rs.getString("bookid");
                 n = rs.getString("name");
                 a = rs.getString("authorname");
                 g = rs.getString("genre");
                 p = rs.getString("publications");
                bookList b = new bookList(bid,n,a,g,p);
                result.add(b);
                

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
    

        public int createAccount( String username, String password,String phone)
    {
        try
        {
            String insertCommand = "insert into useroflibrary (userid,password, phoneno) values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, phone);
           
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
  }
   
    public boolean existUser(String username,String password)//used
    {
        try
        {
            String query = "select * from useroflibrary where userId = ? and password = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
      

            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
   public boolean exist(String username)//used to match bookid before inserting
    {
        try
        {
            String query = "select * from useroflibrary where userId = ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            
          //  System.out.println(stmt);
          //   PreparedStatement stmt = conn.prepareStatement(query);
        //  System.out.println("after stmt");

            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

   public boolean existBook(String bid)//used
    {
        try
        {
            String query = "select * from books where bookId = ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, bid);
            
  
            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean existRentedBook(String bid)//used
    {
        try
        {
            String query = "select * from rentedbooks where bookId = ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, bid);
            
  
            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    
   public boolean existBookName(String n)//used
    {
       String p = "%"+n+"%";
       p = p.toLowerCase();
        try
        {
            String query = "select * from books where lower(name) like ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p);
            
  
            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
public boolean existBookAuthor(String n)//used
    {
       String p = "%"+n+"%";
       p = p.toLowerCase();
        try
        {
            String query = "select * from books where lower(authorname) like ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p);
            
  
            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
public boolean existBookGenre(String n)//used
    {
       String p = "%"+n+"%";
       p = p.toLowerCase();
        try
        {
            String query = "select * from books where lower(genre) like ? ";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, p);
            
  
            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
        public boolean existUserAd(String username,String password)//used
    {
        try
        {
            String query = "select * from adminforlibrary where username = ? and password = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
     

            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }  
    }
        
        public int addBook(String bid, String name, String author, String genre, String pub) {
        try
        {
            String insertCommand = "insert into books (bookid, name, authorname, genre, publications) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, bid);
            stmt.setString(2, name);
            stmt.setString(3, author);
            stmt.setString(4, genre);
            stmt.setString(5, pub);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        }
     
         public int addRentLinst(String bid, String name) throws SQLException {
              try
        {
            String query = "select * from rentlist where bookid = ? and userid = ?";
            //System.out.println(query);

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, bid);
            stmt.setString(2, name);
     

            ResultSet rs = stmt.executeQuery();// rs.next k execute korte hobe
            if(rs.next())
            {
                 try
                {
                    String insertCommand = "update rentlist set hdate = sysdate and rdate=null where bookid=? and userid = ?";
                    stmt = conn.prepareStatement(insertCommand);
                    stmt.setString(1, bid);
                    stmt.setString(2, name);

                    int count = stmt.executeUpdate();
                    return count;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                     return 0; 
                }
            }
        
            else{
                try
                {
                    String insertCommand = "insert into rentlist (bookid, userid, hdate) values(?,?,sysdate)";
                    stmt = conn.prepareStatement(insertCommand);
                    stmt.setString(1, bid);
                    stmt.setString(2, name);

                    int count = stmt.executeUpdate();
                    return count;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                     return 0; 
                }
         }
        }
            catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        
         }

        public int addRentedBook(String bid) {
        try
        {
            String insertCommand = "insert into rentedbooks  values(?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, bid);
            
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        }

}
