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
public class TourDTO implements Serializable{
   private String id, title, description, img_url;
   private int capacity,  booked_quantity;
   private float price;
   private Date start_date, end_date;

    public TourDTO() {
    }

    public TourDTO(String id, String title, String description, String img_url, int capacity, int booked_quantity, float price, Date start_date, Date end_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img_url = img_url;
        this.capacity = capacity;
        this.booked_quantity = booked_quantity;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public TourDTO(String id, String title, String description, String img_url, int capacity, float price, Date start_date, Date end_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img_url = img_url;
        this.capacity = capacity;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public TourDTO(String id, String title, int capacity, int booked_quantity, float price, Date start_date, Date end_date) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
        this.booked_quantity = booked_quantity;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public TourDTO(String id, String title, int booked_quantity, Date start_date, Date end_date) {
        this.id = id;
        this.title = title;
        this.booked_quantity = booked_quantity;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBooked_quantity() {
        return booked_quantity;
    }

    public void setBooked_quantity(int booked_quantity) {
        this.booked_quantity = booked_quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    
}
