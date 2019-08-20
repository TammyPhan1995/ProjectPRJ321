/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tram.dtos;

import java.io.Serializable;

/**
 *
 * @author Tammy Phan
 */
public class BookingDTO implements Serializable{
    private String booking_id, user_id, tour_id;

    public BookingDTO() {
    }

    public BookingDTO(String booking_id, String user_id, String tour_id) {
        this.booking_id = booking_id;
        this.user_id = user_id;
        this.tour_id = tour_id;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }
    
}
