package com.cibt.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ideapad-520S
 */
public class program {
    public static void main(String[] args){
        String driverName="com.mysql.cj.jdbc.Driver";
        
        try{
            Class.forName(driverName);
            String url="jdbc:mysql://localhost/sje001";
            String user="root";
            String Password="";
            
            Connection conn=DriverManager
                    .getConnection(url, user, Password);
            
            
            String sql="insert into employees(first_name,"
                    + "last_name,email,contact_no,status)" 
                    + "values(?,?,?,?,?);";
            
                   PreparedStatement stmt=
                    conn.prepareStatement(sql);
                   stmt.setString(1,"Rushan");
                   stmt.setString(2, "Trmrakar");
                   stmt.setString(3, "rushant@gmail.com");
                   stmt.setString(4, "975566655578");
                   stmt.setBoolean(5, false);
                   int result =stmt.executeUpdate();
                   
                   System.out.println("Result:" + result);
                   
                   sql="select * from employees";
                   stmt=conn.prepareStatement(sql);
                   ResultSet rs=stmt.executeQuery();
                   while(rs.next()){
                       System.out.println("ID:"+rs.getInt("id"));
                       System.out.println("Name:"+rs.getString("first_name")
                               + rs.getString("last_name"));
                       System.out.println("Email:"+rs.getString("email"));
                       System.out.println("contact:"+rs.getString("contact_no"));
                       System.out.println("Added Date:"+rs.getDate("added_date"));
                       System.out.println("Modified:"+rs.getDate("modified_date")); 
                       System.out.println("Status:"+rs.getBoolean("status"));
                       System.out.println("------------------------------------");
                   }
                   
                   conn.close();
                   

        }catch(ClassNotFoundException ce){
            System.out.println(ce.getMessage()); 
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
    }
    
} 
 