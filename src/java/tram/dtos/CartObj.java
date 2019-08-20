/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Tammy Phan
 */
public class CartObj implements Serializable{
    private String customerName;
    private HashMap<String, ProductDTO> cart;
    private float promotion_value = 0;

    public CartObj() {
        this.cart = new HashMap<>();
    }

    public CartObj(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public float getPromotion_value() {
        return promotion_value;
    }

    public void setPromotion_value(float promotion_value) {
        this.promotion_value = promotion_value;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public void addToCart(ProductDTO dto) throws Exception{
        if(this.cart.containsKey(dto.getTour_id())){
            int newQuantity = this.cart.get(dto.getTour_id()).getQuantity() + 1;
            dto.setQuantity(newQuantity);
        }else{
             dto.setQuantity(1);
        }
        this.cart.put(dto.getTour_id(), dto);
    }
    
    
    public void delete(String tour_id) throws Exception{
        if(this.cart.containsKey(tour_id)){
            this.cart.remove(tour_id);
        }
    }
    
    public float getTotal() throws Exception{
        float total = 0;
        for(ProductDTO dto : this.cart.values()){
            total += (dto.getPrice()*dto.getQuantity());
        }
        return total;
    }
    
    public float  getTotalDue () throws Exception{
        return this.getTotal() - (this.getTotal() * promotion_value);
    }
    
    public void update(String tour_id, int quantity) throws Exception{
        if(this.cart.containsKey(tour_id)){
            this.cart.get(tour_id).setQuantity(quantity);
        }
    }
   
}
