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
public class BookingDetailDTO implements Serializable{
    private String booking_id, status, promotion_code;
    private Date  booked_date;
    private int quantity ;
    private float price;

    public BookingDetailDTO() {
    }

    
    public BookingDetailDTO(String booking_id, String status, Date booked_date, int quantity, float price) {
        this.booking_id = booking_id;
        this.status = status;
        this.booked_date = booked_date;
        this.quantity = quantity;
        this.price = price;
    }

    public BookingDetailDTO(String booking_id, Date booked_date, int quantity, float price) {
        this.booking_id = booking_id;
        this.booked_date = booked_date;
        this.quantity = quantity;
        this.price = price;
    }

    public BookingDetailDTO(String booking_id, String status, String promotion_code, Date booked_date, int quantity, float price) {
        this.booking_id = booking_id;
        this.status = status;
        this.promotion_code = promotion_code;
        this.booked_date = booked_date;
        this.quantity = quantity;
        this.price = price;
    }
    
    

    public String getPromotion_code() {
        return promotion_code;
    }

    public void setPromotion_code(String promotion_code) {
        this.promotion_code = promotion_code;
    }

  
    
    

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(Date booked_date) {
        this.booked_date = booked_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

   
}
