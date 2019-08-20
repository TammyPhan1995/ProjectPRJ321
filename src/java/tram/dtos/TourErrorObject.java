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
public class TourErrorObject implements Serializable {

    private String idError, titleError, descriptionError, img_urlError;
    private String capacityError, booked_quantityError;
    private String priceError;
    private String start_dateError, end_dateError;

    public TourErrorObject() {
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getImg_urlError() {
        return img_urlError;
    }

    public void setImg_urlError(String img_urlError) {
        this.img_urlError = img_urlError;
    }

    public String getCapacityError() {
        return capacityError;
    }

    public void setCapacityError(String capacityError) {
        this.capacityError = capacityError;
    }

    public String getBooked_quantityError() {
        return booked_quantityError;
    }

    public void setBooked_quantityError(String booked_quantityError) {
        this.booked_quantityError = booked_quantityError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getStart_dateError() {
        return start_dateError;
    }

    public void setStart_dateError(String start_dateError) {
        this.start_dateError = start_dateError;
    }

    public String getEnd_dateError() {
        return end_dateError;
    }

    public void setEnd_dateError(String end_dateError) {
        this.end_dateError = end_dateError;
    }

   
}
