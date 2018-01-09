/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_db;
import home.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Nikhil Kumaran
 */
public class To_Db {
    public String movie,theatre,date,name;
    public int seats;
    public double total;
    Connection myConn;

    public To_Db() {
        try {
            this.myConn = DriverManager.getConnection("jdbc:mysql://localhost:3308/eticket?autoReconnect=true&useSSL=false","root","ritesh2005");
        } catch (SQLException ex) {
            Logger.getLogger(To_Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void postDb(){
        try {
                        //myState = myCon.createStatement();
                        PreparedStatement query=myConn.prepareStatement("insert into admin values(?,?,?,?,?,?)"); 
                        //String sqlQuery = "insert into e_book (name,email,pass) values('"+text1+"','"+text2+"','"+text3+"')";
                        query.setString(1,Home.db.theatre);
                        query.setString(2,Home.db.movie);
                        query.setString(3,Home.db.date);
                        query.setString(4,Home.db.name);
                        query.setInt(5,Home.db.seats);
                        query.setString(6,""+Home.db.total);
                        query.executeUpdate();
                        
                        query.close();
                        // for theatres table
                        
                        String query2 = "SELECT * FROM "+Home.db.theatre+" ORDER BY total_seats ASC LIMIT 1";
                        Statement st = myConn.createStatement();
                        ResultSet rs = st.executeQuery(query2);
                        rs.next();
                        int total1 = rs.getInt("total_seats");
                        st.close();
                        PreparedStatement query1=myConn.prepareStatement("insert into "+Home.db.theatre+" values(?,?,?,?,?)"); 
                        query1.setString(1,Home.db.movie);
                        query1.setString(2,Home.db.name);
                        query1.setString(3,Home.db.date);
                        query1.setInt(4,Home.db.seats);
                        query1.setInt(5,total1-Home.db.seats);
                        query1.executeUpdate();
                        query1.close();
                        
        }
                catch (SQLException e) {

                        System.out.println(e);
                }
    }
    
    public static void main(){
       
    }
    
}
