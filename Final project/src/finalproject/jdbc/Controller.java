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
public class Controller {
    private Item item;
    
    public Controller(){
    
    }
    
    public void AddNewItem(String name,String Desc,double Price){
        item=new Item(name,Desc,Price);
        item.SaveRecord();
    }
    
    public void UpdateItem(int id,String name,String desc,double price){
        item=new Item(id,name,desc,price);
        item.UpdateRecord();
        
        
    }
    
    public void GetItem(int id){
        
        item=new Item(id);
         item.GetRecord(id);
    }
    
    public void RemoveItem(int id){
        item=new Item(id);
        item.DeletRecord();
    }
    
}