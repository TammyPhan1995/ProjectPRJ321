/*
  for updating tour for insert new booking
 */
package tram.dtos;

import java.io.Serializable;

/**
 *
 * @author Tammy Phan
 */
public class TourUpdatingObject implements Serializable{
    private String tour_id;
    private int quantity;

    public TourUpdatingObject() {
    }

    public TourUpdatingObject(String tour_id, int quantity) {
        this.tour_id = tour_id;
        this.quantity = quantity;
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
