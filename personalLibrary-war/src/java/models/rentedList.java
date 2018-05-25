/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Lenovo
 */
public class rentedList {
    String b,n,d,bid;
     public rentedList(String bid,String b,String n, String d){
       
        this.bid = bid;
        this.b = b;
        this.n = n;
        this.d = d;
        
       
    }
     public String getId() {
        return bid;
    }
    public String getBook() {
        return b;
    }
     public String getName() {
        return n;
    }
    public String getDate() {
        return d;
    }
   
    
}
