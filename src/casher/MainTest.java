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
public class MainTest {

    public static void main(String[] args) {
        
    }
    
    
    static void testProductObject(){
        Product p = new Product(12, "لبن", 13.5, 500, "") ;
        System.out.println(p.getCode());
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        System.out.println(p.getQuantity());
        System.out.println(p.getDescription());
    }
    
    static void testCreate(){
        CreateProduct cp = new CreateProduct();
        cp.create("product");
    }
    
    
    
    
}
