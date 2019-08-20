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
public class PromotionDTO implements Serializable{
    private String promotion_code, content;
    private float   value;

    public PromotionDTO() {
    }

    public PromotionDTO(String promotion_code, String content, float value) {
        this.promotion_code = promotion_code;
        this.content = content;
        this.value = value;
    }

    public PromotionDTO(String promotion_code, float value) {
        this.promotion_code = promotion_code;
        this.value = value;
    }

    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    public String getPromotion_code() {
        return promotion_code;
    }

    public void setPromotion_code(String promotion_code) {
        this.promotion_code = promotion_code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
}
