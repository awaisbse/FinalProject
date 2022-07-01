/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.jdbc;

/**
 *
 * @author Awais
 */
import java.sql.*;

public class MyDBConnection {
    
    public Connection myConnection;
    public MyDBConnection() {    }
    public void init(){
       try{  
           Class.forName("com.mysql.jdbc.Driver");
        myConnection=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/storedb?serverTimezone=UTC","root",""); 
        }catch(Exception e)
        {
            System.out.println("Exception : "+e.getMessage());
            System.out.println(e);
            System.out.println("===================================");
        }  
    }
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    public String insertRecord(String query){
        try{
        Statement stmt=myConnection.createStatement();  
        int rows=stmt.executeUpdate(query);  
        return "Query executed successfully "+rows;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
    public String updateRecord(String query){
        try{
        Statement stmt=myConnection.createStatement();  
        int rows=stmt.executeUpdate(query);  
        return "record updated with effectoed rows "+rows;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
public ResultSet getRecord(String query){
        try{
        Statement stmt=myConnection.createStatement(); 
        ResultSet rs= stmt.executeQuery(query);
        return rs;
        }
        catch(Exception e){
            return null;
        }
    }
    public int deleteRecord(String query){
        try{
        Statement stmt=myConnection.createStatement();  
        int row=stmt.executeUpdate(query);  
        return row;
        }
        catch(Exception ex){
            return 0;
        }
    }
    
    public void close(){
        if(myConnection !=null){
            try{
               myConnection.close();
            }
            catch(Exception e){  }
        }
    }
    
}
