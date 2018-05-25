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
public class bookList {
    String b,n,a,g,p;
     public bookList(String b,String n, String a, String g, String p){
       
        
        this.b = b;
        this.n = n;
        this.a = a;
        this.g = g;
        this.p = p;
       
    }
    public String getId() {
        return b;
    }
     public String getName() {
        return n;
    }
    public String getAuthor() {
        return a;
    }
    public String getGenre() {
        return g;
    }
    public String getPub() {
        return p;
    }
    
}
