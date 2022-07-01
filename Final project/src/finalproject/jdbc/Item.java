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
public class Item {
    private ItemDAO itemDAO;
    private int id;
    private String name;
    private String desc;
    private double Price;
    
    public Item(){
        itemDAO=new ItemDAO();
    }

    public Item(String name, String desc, double price) {
        itemDAO=new ItemDAO();
        this.name = name;
        this.desc = desc;
        this.Price = price;
    }
    
    public Item(int id, String name, String desc, double price) {
        itemDAO=new ItemDAO();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.Price = price;
    }
    
     public Item(int id) {
        itemDAO=new ItemDAO();
        this.id = id;
        
    }
    
    
    public void SaveRecord(){
        itemDAO.saveRecord(this);
    }
    
    public void UpdateRecord(){
        
        itemDAO.updateRecord(this);
        System.out.println("Item");
          
    }
    public void DeletRecord(){
        itemDAO.deleteProduct(this);
    }
    public void GetRecord(int id){
        itemDAO.getRecord(id);
    }
    
     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getprice() {
        return Price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.Price = price;
    }
    
}