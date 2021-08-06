package casher;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohamed
 */
public class Product {
    private int code  ;
    private String name  ;
    private double price ;
    private int quantity ;
    private String description ;
    
    public Product(int code, String name, double price, int quantity, String description){
        this.code = code ;
        this.name = name ;
        this.price = price ;
        this.quantity = quantity ;
        this.description = description ;
    }
    
    public int getCode(){
        return this.code;        
    }
    public String getName(){
        return this.name ;       
    }
    public double getPrice(){
        return this.price ;       
    }
    public String getDescription(){
        return this.description ;       
    }
    public int getQuantity(){
        return this.quantity ;       
    }
        
    
}
