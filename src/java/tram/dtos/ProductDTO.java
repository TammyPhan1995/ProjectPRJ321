/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Tammy Phan
 */
public class ProductDTO implements Serializable{
    private String tour_id, title;
    private float price;
    private int quantity, available;
    private Date start_date, end_date;
    public ProductDTO() {
    }

    public ProductDTO(String tour_id, String title, float price, int available, Date start_date, Date end_date) {
        this.tour_id = tour_id;
        this.title = title;
        this.price = price;
        this.available = available;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    

   
    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

   
    
}
