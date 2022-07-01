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

public class ItemDAO {
    private MyDBConnection connection;
    
    public ItemDAO(){
        connection=new MyDBConnection();
        connection.init();
    }
    
    public void saveRecord(Item item){
        String status=connection.insertRecord("insert into product(Name, Description, Price) values "
                + "('"+item.getName()+"','"+item.getDesc()+"','"+item.getprice()+"')");
        System.out.println(status);
    }
    public void updateRecord(Item item){
        connection.updateRecord("update product set Name='"+item.getName()+"', Description='"+item.getDesc()+"', "
                + "Price='"+item.getprice()+"' where Id='"+item.getId()+"'");
        
        
    }
    public void deleteProduct(Item item){
        connection.deleteRecord("delete from product where Id ="+item.getId());
    }
    public Item getRecord(int id){
        ResultSet rs= connection.getRecord("Select * from product where Id="+id);
        Item item=new Item();
         
        try{
            while(rs.next()){
               item.setId(rs.getInt("Id"));
               item.setName(rs.getString("Name"));
               item.setDesc(rs.getString("Description"));
               item.setPrice(Double.parseDouble(rs.getString("Price")));
               new DisplayForm(item.getId(),item.getName(),item.getDesc(),item.getprice()).setVisible(true);
               
            }
            return item;
           
           
        }
        catch(Exception ex){
            return null;
        }
        
    }


}
