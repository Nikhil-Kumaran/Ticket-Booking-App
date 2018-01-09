/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_table;

/**
 *
 * @author Nikhil Kumaran
 */
public class AdminTable {
    public String movie,theatre,date,name,total;
    public int seats; 
    
    public AdminTable(String theatre,String movie,String date,String name,int seats,String total){
        this.movie = movie;
        this.theatre = theatre;
        this.date = date;
        this.name = name;
        this.seats = seats;
        this.total = total;
    }
}
